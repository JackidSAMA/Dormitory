package dao;

import java.sql.Date;

public interface INight_back_infoDAO {

	//查看全部数据
	public String selectall()throws Exception;

	// 删除夜归的一条记录
	public boolean delete(Integer id) throws Exception;

	// 插入夜归的一条记录
	public boolean insert(String stu_id, String stu_name,
			Date night_back_datetime) throws Exception;

	// 更新夜归的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			Date night_back_datetime) throws Exception;

}