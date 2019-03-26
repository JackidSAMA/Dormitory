package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Come_back_info;


import com.google.gson.Gson;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import dao.ICome_back_infoDAO;

public class Come_back_infoDAOImpl implements ICome_back_infoDAO {
	private Connection conn = null; // 定义数据库的连接对象
	private NewProxyPreparedStatement pstmt = null; // 定义数据库操作对象
	private Gson gson=new Gson();//gson工具对象
	
	public Come_back_infoDAOImpl(Connection conn) { // 构造方法，设置数据库连接
		this.conn = conn;
	}
	
	//查看返校全部数据
	/* (non-Javadoc)
	 * @see dao.impl.Come_back_infoDAO#selectall()
	 */
	public String selectall()
	{
		ArrayList<Come_back_info>selectall_arrayList=new ArrayList<Come_back_info>();
		
		try {
			String sql = "select * from come_back_info";
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Come_back_info come_back_info=new Come_back_info();
				come_back_info.setId(resultSet.getInt("id"));
				come_back_info.setStu_id(resultSet.getString("stu_id"));
				come_back_info.setStu_name(resultSet.getString("stu_name"));
				come_back_info.setSituation(resultSet.getInt("situation"));
				come_back_info.setCome_back_datetime(resultSet.getDate("come_back_datetime"));
				
				
				selectall_arrayList.add(come_back_info);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectall_arrayList);
	}
	

	// 删除返校的一条记录
	/* (non-Javadoc)
	 * @see dao.impl.Come_back_infoDAO#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "delete from come_back_info where id=?";

			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			this.pstmt.setInt(1, id);

			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// 插入返校的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Come_back_infoDAO#insert(java.lang.String, java.lang.String, int, java.sql.Date)
		 */
		public boolean insert(String stu_id,String stu_name,int situation,Date come_back_datetime) throws Exception {
			boolean flag = false;
			try {
				String sql = "insert into come_back_info(stu_id,stu_name,situation,come_back_datetime)values(?,?,?,?)";
				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setInt(3, situation);
				this.pstmt.setDate(4, come_back_datetime);


				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		// 更新返校的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Come_back_infoDAO#update(java.lang.Integer, java.lang.String, java.lang.String, int, java.sql.Date)
		 */
		public boolean update(Integer id,String stu_id,String stu_name,int situation,Date come_back_datetime)
				throws Exception {
			boolean flag = false;
			try {
				String sql = "update come_back_info set stu_id=?,stu_name=?,situation=?,come_back_datetime=? where id=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setInt(3, situation);
				this.pstmt.setDate(4, come_back_datetime);
				this.pstmt.setInt(5, id);

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
}
