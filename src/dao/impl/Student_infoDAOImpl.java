package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Student_info;

import com.google.gson.Gson;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import dao.IStudent_infoDAO;

public class Student_infoDAOImpl implements IStudent_infoDAO {
	private Connection conn = null; // 定义数据库的连接对象
	private NewProxyPreparedStatement pstmt = null; // 定义数据库操作对象
	private Gson gson=new Gson();//gson工具对象
	
	public Student_infoDAOImpl(Connection conn) { // 构造方法，设置数据库连接
		this.conn = conn;
	}
	
	//查看全部数据
	/* (non-Javadoc)
	 * @see dao.impl.Student_infoDAO#selectall()
	 */
	public String selectall()
	{
		ArrayList<Student_info>selectall_arrayList=new ArrayList<Student_info>();
		
		try {
			String sql = "select * from student_info";
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Student_info student_info=new Student_info();
				student_info.setStu_id(resultSet.getString("stu_id"));
				student_info.setStu_name(resultSet.getString("stu_name"));
				student_info.setPassword(resultSet.getString("password"));
				student_info.setBirthday(resultSet.getDate("birthday"));
				student_info.setMajor(resultSet.getString("major"));
				student_info.setGrade(resultSet.getString("grade"));
				
				selectall_arrayList.add(student_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectall_arrayList);
	}
	
	
//	按条件查看学生信息
	public String selectsingle(String classname,String major,String grade)throws Exception
	{
		ArrayList<Student_info>selectsingle_arrayList=new ArrayList<Student_info>();
		
		try {
			String sql = "select * from student_info where ";
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
			
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			System.out.println("这是条件查询的sql语句："+pstmt.toString());
			
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Student_info student_info=new Student_info();
				student_info.setStu_id(resultSet.getString("stu_id"));
				student_info.setStu_name(resultSet.getString("stu_name"));
				student_info.setPassword(resultSet.getString("password"));
				student_info.setBirthday(resultSet.getDate("birthday"));
				student_info.setMajor(resultSet.getString("major"));
				student_info.setGrade(resultSet.getString("grade"));
				
				selectsingle_arrayList.add(student_info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectsingle_arrayList);
	}
	// 删除学生的一条记录
	/* (non-Javadoc)
	 * @see dao.impl.Student_infoDAO#delete(java.lang.Integer)
	 */
	public boolean delete(Integer stu_id) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "delete from student_info where stu_id=?";

			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			this.pstmt.setInt(1, stu_id);

			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// 插入学生的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Student_infoDAO#insert(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String)
		 */
		public boolean insert(String stu_id,String stu_name,String password,Date birthday,String major,String grade) throws Exception {
			boolean flag = false;
			try {
				String sql = "insert into student_info(stu_id,stu_name,password,birthday,major,grade)values(?,?,?,?,?,?)";
				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setString(3, password);
				this.pstmt.setDate(4, birthday);
				this.pstmt.setString(5, major);
				this.pstmt.setString(6, grade);
				

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		// 更新学生的一条记录
		/* (non-Javadoc)
		 * @see dao.impl.Student_infoDAO#update(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String)
		 */
		public boolean update(String stu_id,String stu_name,String password,Date birthday,String major,String grade)
				throws Exception {
			boolean flag = false;
			try {
				String sql = "update student_info set stu_id,stu_name=?,password=?,birthday=?,major=?,grade=? where stu_id=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, stu_id);
				this.pstmt.setString(2, stu_name);
				this.pstmt.setString(3, password);
				this.pstmt.setDate(4, birthday);
				this.pstmt.setString(5, major);
				this.pstmt.setString(6, grade);
				this.pstmt.setString(7, stu_id);
				
				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}

//		更新密码
		public boolean change_password(String oldpassword,String newpassword,String stu_id) throws Exception
		{
			boolean flag = false;
			try {
				String sql = "update student_info set password=? where stu_id=? and password=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, newpassword);
				this.pstmt.setString(2, stu_id);
				this.pstmt.setString(3, oldpassword);

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
}
