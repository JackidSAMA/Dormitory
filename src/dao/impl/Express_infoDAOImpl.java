package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Express_info;
import vo.Student_info;


import com.google.gson.Gson;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import dao.IExpress_infoDAO;

public class Express_infoDAOImpl implements IExpress_infoDAO {
	private Connection conn = null; // 定义数据库的连接对象
	private NewProxyPreparedStatement pstmt = null; // 定义数据库操作对象
	private Gson gson=new Gson();//gson工具对象
	
	public Express_infoDAOImpl(Connection conn) { // 构造方法，设置数据库连接
		this.conn = conn;
	}
	
	//查看快件全部数据
	/* (non-Javadoc)
	 * @see dao.impl.Express_infoDAO#selectall()
	 */
	public String selectall()
	{
		ArrayList<Express_info>selectall_arrayList=new ArrayList<Express_info>();
		
		try {
			String sql = "select * from express_info";
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Express_info express_info=new Express_info();
				express_info.setId(resultSet.getInt("id"));
				express_info.setStu_id(resultSet.getString("stu_id"));
				express_info.setStu_name(resultSet.getString("stu_name"));
				express_info.setPhone_number(resultSet.getString("phone_number"));
				express_info.setArrival_datetime(resultSet.getDate("arrival_datetime"));
				express_info.setIs_get(resultSet.getInt("is_get"));
				
				selectall_arrayList.add(express_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectall_arrayList);
	}
	
//	按条件查看快件信息
	public String selectsingle(String classname,String major,String grade)throws Exception
	{
		ArrayList<Express_info>selectsingle_arrayList=new ArrayList<Express_info>();
		
		try {
			String sql0="select * from express_info where stu_id in(";
			
			String sql = "select stu_id from student_info where ";
			if (classname.equals("stu_id")) {
				sql+="stu_id=stu_id";
			}else {
				sql+="stu_id like '____"+classname+"%'";
			}
			
			if (major.equals("major")) {
				sql+=" and "+"major=major";
			}else {
				sql+=" and "+"major='"+major+"'";
			}
			
			if (grade.equals("grade")) {
				sql+=" and "+"grade=grade";
			}else {
				sql+=" and "+"grade='"+grade+"'";
			}
			sql0+=(sql+")");
			
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql0);
			System.out.println("这是express条件查询的sql语句："+pstmt.toString());
			
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Express_info express_info=new Express_info();
				express_info.setId(resultSet.getInt("id"));
				express_info.setStu_id(resultSet.getString("stu_id"));
				express_info.setStu_name(resultSet.getString("stu_name"));
				express_info.setPhone_number(resultSet.getString("phone_number"));
				express_info.setArrival_datetime(resultSet.getDate("arrival_datetime"));
				express_info.setIs_get(resultSet.getInt("is_get"));
				
				selectsingle_arrayList.add(express_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectsingle_arrayList);
	}
	
//	按名字模糊查询快件信息
	public String selectbyname(String stu_name)throws Exception
	{
		ArrayList<Express_info>selectbyname_arrayList=new ArrayList<Express_info>();
		
		try {
			String sql = "select * from express_info where stu_name like ?";
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			
			this.pstmt.setString(1, "%"+stu_name+"%");
			System.out.println("按名字模糊查询快件信息的sql语句为："+this.pstmt.toString());
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Express_info express_info=new Express_info();
				express_info.setId(resultSet.getInt("id"));
				express_info.setStu_id(resultSet.getString("stu_id"));
				express_info.setStu_name(resultSet.getString("stu_name"));
				express_info.setPhone_number(resultSet.getString("phone_number"));
				express_info.setArrival_datetime(resultSet.getDate("arrival_datetime"));
				express_info.setIs_get(resultSet.getInt("is_get"));
				
				selectbyname_arrayList.add(express_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectbyname_arrayList);
	}
//	按id查询快件讯息
	public String selectbyid(Integer id)throws Exception
	{
		ArrayList<Express_info>selectbyid_arrayList=new ArrayList<Express_info>();
		
		try {
			String sql = "select * from express_info where id=?";
			
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Express_info express_info=new Express_info();
				express_info.setId(resultSet.getInt("id"));
				express_info.setStu_id(resultSet.getString("stu_id"));
				express_info.setStu_name(resultSet.getString("stu_name"));
				express_info.setPhone_number(resultSet.getString("phone_number"));
				express_info.setArrival_datetime(resultSet.getDate("arrival_datetime"));
				express_info.setIs_get(resultSet.getInt("is_get"));
				
				selectbyid_arrayList.add(express_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectbyid_arrayList);
	}
	
	// 删除快件的一条记录
	/* (non-Javadoc)
	 * @see dao.impl.Express_infoDAO#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "delete from express_info where id=?";

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
	
	// 插入快件的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Express_infoDAO#insert(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, int)
		 */
		public boolean insert(String stu_id,String stu_name,String phone_number,Date arrival_datetime,int is_get) throws Exception {
			boolean flag = false;
			try {
				String sql = "insert into express_info(stu_id,stu_name,phone_number,arrival_datetime,is_get)values(?,?,?,?,?)";
				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setString(3, phone_number);
				this.pstmt.setDate(4, arrival_datetime);
				this.pstmt.setInt(5, is_get);
				
					System.out.println("快件的插入语句为："+pstmt.toString());
				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		// 更新快件的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Express_infoDAO#update(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.sql.Date, int)
		 */
		public boolean update(Integer id,String stu_id,String stu_name,String phone_number,Date arrival_datetime,int is_get)
				throws Exception {
			boolean flag = false;
			try {
				String sql = "update express_info set stu_id=?,stu_name=?,phone_number=?,arrival_datetime=?,is_get=? where id=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setString(3, phone_number);
				this.pstmt.setDate(4, arrival_datetime);
				this.pstmt.setInt(5, is_get);
				this.pstmt.setInt(6, id);

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
}
