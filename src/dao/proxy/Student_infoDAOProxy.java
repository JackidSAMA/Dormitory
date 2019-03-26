package dao.proxy;

import java.sql.Date;

import dao.IStudent_infoDAO;
import dao.impl.Student_infoDAOImpl;
import dbc.DatabaseConnection;

public class Student_infoDAOProxy implements IStudent_infoDAO{
	private DatabaseConnection dbc = null;
	private IStudent_infoDAO dao = null;

	public Student_infoDAOProxy() { // 构造方法，实例化连接，同时实例化dao对象
		try {
			this.dbc = new DatabaseConnection(); // 连接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new Student_infoDAOImpl(this.dbc.getConnection()); // 实例化真实主题类
	}
	
	//查看学生全部数据
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
	// 删除学生的一条记录
	public boolean delete(Integer stu_id) throws Exception
	{
		boolean flag = false;
		try {
			flag = this.dao.delete(stu_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	// 插入学生的一条记录
	public boolean insert(String stu_id, String stu_name, String password,
			Date birthday, String major, String grade) throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.insert(stu_id, stu_name, password, birthday, major, grade);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}

	// 更新学生的一条记录
	public boolean update(String stu_id, String stu_name, String password,
			Date birthday, String major, String grade) throws Exception
			{
		boolean flag = false;
		try {
			flag = this.dao.update(stu_id, stu_name, password, birthday, major, grade);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
			}
	
//	更新密码
	public boolean change_password(String oldpassword,String newpassword,String stu_id) throws Exception
	{
		boolean flag = false;
		try {
			flag = this.dao.change_password(oldpassword, newpassword,stu_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
