package dao.proxy;

import java.sql.Date;

import dao.IRepairs_infoDAO;
import dao.impl.Repairs_infoDAOImpl;
import dbc.DatabaseConnection;

public class Repairs_infoDAOProxy implements IRepairs_infoDAO {
	private DatabaseConnection dbc = null;
	private IRepairs_infoDAO dao = null;

	public Repairs_infoDAOProxy() { // 构造方法，实例化连接，同时实例化dao对象
		try {
			this.dbc = new DatabaseConnection(); // 连接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new Repairs_infoDAOImpl(this.dbc.getConnection()); // 实例化真实主题类
	}
	
	
	//查看报修全部数据
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

	// 删除报修的一条记录
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

	// 插入报修的一条记录
	public boolean insert(String stu_id, String stu_name, String dormitory_num,
			String phone_number, Date report_datetime, String reason)
			throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.insert(stu_id, stu_name, dormitory_num, phone_number, report_datetime, reason);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}

	// 更新报修的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			String dormitory_num, String phone_number, Date report_datetime,
			String reason) throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.update(id, stu_id, stu_name, dormitory_num, phone_number, report_datetime, reason);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}
}
