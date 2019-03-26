package dao;

import java.sql.Date;

public interface IStudent_infoDAO {

	//查看学生全部数据
	public String selectall()throws Exception;

//	按条件查看学生信息
	public String selectsingle(String classname,String major,String grade)throws Exception;
	
	// 删除学生的一条记录
	public boolean delete(Integer stu_id) throws Exception;

	// 插入学生的一条记录
	public boolean insert(String stu_id, String stu_name, String password,
			Date birthday, String major, String grade) throws Exception;

	// 更新学生的一条记录
	public boolean update(String stu_id, String stu_name, String password,
			Date birthday, String major, String grade) throws Exception;

//	更新密码
	public boolean change_password(String oldpassword,String newpassword,String stu_id) throws Exception;
}