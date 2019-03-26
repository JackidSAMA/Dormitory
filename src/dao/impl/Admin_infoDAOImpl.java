package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Admin_info;


import com.google.gson.Gson;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import dao.IAdmin_infoDAO;

public class Admin_infoDAOImpl implements IAdmin_infoDAO  {
	private Connection conn = null; // 定义数据库的连接对象
	private NewProxyPreparedStatement pstmt = null; // 定义数据库操作对象
	private Gson gson=new Gson();//gson工具对象
	
	public Admin_infoDAOImpl(Connection conn) { // 构造方法，设置数据库连接
		this.conn = conn;
	}
	
	//查看全部数据

	public String selectall()
	{
		ArrayList<Admin_info>selectall_arrayList=new ArrayList<Admin_info>();
		
		try {
			String sql = "select * from admin_info";
			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			ResultSet resultSet = this.pstmt.executeQuery();

			while (resultSet.next()) {
				Admin_info admin_info=new Admin_info();
				admin_info.setAdm_id(resultSet.getString("adm_id"));
				admin_info.setAdm_identity(resultSet.getString("adm_ identity"));
				admin_info.setAdm_name(resultSet.getString("adm_name"));
				admin_info.setPassword(resultSet.getString("password"));
				
				selectall_arrayList.add(admin_info);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.gson.toJson(selectall_arrayList);
	}
	

	// 删除管理员信息
	public boolean delete(String adm_id) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "delete from admin_info where adm_id=?";

			this.pstmt = (NewProxyPreparedStatement) this.conn
					.prepareStatement(sql);
			this.pstmt.setString(1, adm_id);

			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// 插入管理员信息

		public boolean insert(String adm_id,String adm_name,String adm_identity,String password) throws Exception {
			boolean flag = false;
			try {
				String sql = "insert into admin_info(adm_id,adm_name,adm_identity,password)values(?,?,?,?)";
				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, adm_id);
				this.pstmt.setString(2, adm_name);
				this.pstmt.setString(3, adm_identity);
				this.pstmt.setString(4, password);


				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		// 更新管理员信息
		public boolean update(String adm_id,String adm_name,String adm_identity,String password)
				throws Exception {
			boolean flag = false;
			try {
				String sql = "update admin_info set adm_id=?,adm_name=?,adm_identity=?,password=? where adm_id=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, adm_id);
				this.pstmt.setString(2, adm_name);
				this.pstmt.setString(3, adm_identity);
				this.pstmt.setString(4, password);
				this.pstmt.setString(5, adm_id);

				if (this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}

//		更新密码
		public boolean change_password(String oldpassword,String newpassword,String adm_id) throws Exception
		{
			boolean flag = false;
			try {
				String sql = "update admin_info set password=? where adm_id=? and password=?";

				this.pstmt = (NewProxyPreparedStatement) this.conn
						.prepareStatement(sql);
				this.pstmt.setString(1, newpassword);
				this.pstmt.setString(2, adm_id);
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
