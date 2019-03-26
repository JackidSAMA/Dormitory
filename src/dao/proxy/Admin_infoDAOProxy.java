package dao.proxy;

import dao.IAdmin_infoDAO;
import dao.impl.Admin_infoDAOImpl;
import dbc.DatabaseConnection;

public class Admin_infoDAOProxy implements IAdmin_infoDAO {
	private DatabaseConnection dbc = null;
	private IAdmin_infoDAO dao = null;

	public Admin_infoDAOProxy() { // 构造方法，实例化连接，同时实例化dao对象
		try {
			this.dbc = new DatabaseConnection(); // 连接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new Admin_infoDAOImpl(this.dbc.getConnection()); // 实例化真实主题类
	}

	// 查看全部数据
	public String selectall() throws Exception {
		String all_json = "";
		try {
			all_json = this.dao.selectall();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all_json;
	}

	// 删除管理员信息
	public boolean delete(String adm_id) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.delete(adm_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean insert(String adm_id, String adm_name, String adm_identity,
			String password) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.insert(adm_id, adm_name, adm_identity, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	// 更新管理员信息
	public boolean update(String adm_id, String adm_name, String adm_identity,
			String password) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.update(adm_id, adm_name, adm_identity, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

//	更新密码
	public boolean change_password(String oldpassword,String newpassword,String adm_id) throws Exception
	{
		boolean flag = false;
		try {
			flag = this.dao.change_password(oldpassword, newpassword,adm_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
}
