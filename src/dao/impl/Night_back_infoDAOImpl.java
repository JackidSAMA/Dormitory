package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Night_back_info;



import com.google.gson.Gson;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import dao.INight_back_infoDAO;

public class Night_back_infoDAOImpl implements INight_back_infoDAO {
	private Connection conn = null; // 定义数据库的连接对象
	private NewProxyPreparedStatement pstmt = null; // 定义数据库操作对象
	private Gson gson=new Gson();//gson工具对象
	
	public Night_back_infoDAOImpl(Connection conn) { // 构造方法，设置数据库连接
		this.conn = conn;
	}
	
	//查看全部数据
	/* (non-Javadoc)
	 * @see dao.impl.Night_back_infoDAO#selectall()
	 */
	public String selectall()
	{
		ArrayList<Night_back_info>selectall_arrayList=new ArrayList<Night_back_info>();
		
		try {
			String sql = "select * from night_back_info";
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Night_back_info night_back_info=new Night_back_info();
				night_back_info.setId(resultSet.getInt("id"));
				night_back_info.setStu_id(resultSet.getString("stu_id"));
				night_back_info.setStu_name(resultSet.getString("stu_name"));
				night_back_info.setNight_back_datetime(resultSet.getDate("night_back_datetime"));
				
				selectall_arrayList.add(night_back_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectall_arrayList);
	}
	

	// 删除夜归的一条记录
	/* (non-Javadoc)
	 * @see dao.impl.Night_back_infoDAO#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "delete from night_back_info where id=?";

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
	
	// 插入夜归的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Night_back_infoDAO#insert(java.lang.String, java.lang.String, java.sql.Date)
		 */
		public boolean insert(String stu_id,String stu_name,Date night_back_datetime) throws Exception {
			boolean flag = false;
			try {
				String sql = "insert into night_back_info(stu_id,stu_name,night_back_datetime)values(?,?,?)";
				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setDate(3, night_back_datetime);
				

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		// 更新夜归的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Night_back_infoDAO#update(java.lang.Integer, java.lang.String, java.lang.String, java.sql.Date)
		 */
		public boolean update(Integer id,String stu_id,String stu_name,Date night_back_datetime)
				throws Exception {
			boolean flag = false;
			try {
				String sql = "update night_back_info set stu_id=?,stu_name=?,night_back_datetime=? where id=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setDate(3, night_back_datetime);
				this.pstmt.setInt(4, id);

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
}
