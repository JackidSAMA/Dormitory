package dao.proxy;

import java.sql.Date;

import dao.INight_back_infoDAO;
import dao.impl.Night_back_infoDAOImpl;
import dbc.DatabaseConnection;

public class Night_back_infoDAOProxy implements INight_back_infoDAO {
	private DatabaseConnection dbc = null;
	private INight_back_infoDAO dao = null;

	public Night_back_infoDAOProxy() { // 构造方法，实例化连接，同时实例化dao对象
		try {
			this.dbc = new DatabaseConnection(); // 连接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new Night_back_infoDAOImpl(this.dbc.getConnection()); // 实例化真实主题类
	}
	
	//查看全部数据
	public String selectall()throws Exception
	{
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

	// 删除夜归的一条记录
	public boolean delete(Integer id) throws Exception
	{
		boolean flag = false;
		try {
			flag = this.dao.delete(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	// 插入夜归的一条记录
	public boolean insert(String stu_id, String stu_name,
			Date night_back_datetime) throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.insert(stu_id, stu_name, night_back_datetime);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}

	// 更新夜归的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			Date night_back_datetime) throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.update(id, stu_id, stu_name, night_back_datetime);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}
}
