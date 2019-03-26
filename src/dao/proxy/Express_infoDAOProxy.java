package dao.proxy;

import java.sql.Date;

import dao.IExpress_infoDAO;
import dao.impl.Express_infoDAOImpl;
import dbc.DatabaseConnection;

public class Express_infoDAOProxy implements IExpress_infoDAO {
	private DatabaseConnection dbc = null;
	private IExpress_infoDAO dao = null;

	public Express_infoDAOProxy() { // 构造方法，实例化连接，同时实例化dao对象
		try {
			this.dbc = new DatabaseConnection(); // 连接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new Express_infoDAOImpl(this.dbc.getConnection()); // 实例化真实主题类
	}
	
	//查看快件全部数据
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

//	按条件查看学生信息
	public String selectsingle(String classname,String major,String grade)throws Exception
	{
		String all_json = "";
		try {
			all_json = this.dao.selectsingle(classname, major, grade);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all_json;
	}
	// 删除快件的一条记录
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

	// 插入快件的一条记录
	public boolean insert(String stu_id, String stu_name, String phone_number,
			Date arrival_datetime, int is_get) throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.insert(stu_id, stu_name, phone_number, arrival_datetime, is_get);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}

//	按照id查找快件
	public String selectbyid(Integer id)throws Exception
	{
		String all_json = "";
		try {
			all_json = this.dao.selectbyid(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all_json;
	}
	
	// 更新快件的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			String phone_number, Date arrival_datetime, int is_get)
			throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.update(id, stu_id, stu_name, phone_number, arrival_datetime, is_get);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}

//	按名字模糊查询快件信息
	public String selectbyname(String stu_name)throws Exception
	{
		String all_json = "";
		try {
			all_json = this.dao.selectbyname(stu_name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all_json;
	}
}
