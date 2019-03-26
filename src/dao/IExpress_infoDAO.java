package dao;

import java.sql.Date;

public interface IExpress_infoDAO {

	//查看快件全部数据
	public String selectall()throws Exception;

//	按条件查看学生信息
	public String selectsingle(String classname,String major,String grade)throws Exception;
	
	// 删除快件的一条记录
	public boolean delete(Integer id) throws Exception;

	// 插入快件的一条记录
	public boolean insert(String stu_id, String stu_name, String phone_number,
			Date arrival_datetime, int is_get) throws Exception;

	// 更新快件的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			String phone_number, Date arrival_datetime, int is_get)
			throws Exception;
	
//	按照id查找快件
	public String selectbyid(Integer id)throws Exception;

//	按名字模糊查询快件信息
	public String selectbyname(String stu_name)throws Exception;
}