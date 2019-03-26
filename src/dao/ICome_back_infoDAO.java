package dao;

import java.sql.Date;

public interface ICome_back_infoDAO {

	//查看返校全部数据
	public String selectall()throws Exception;

	// 删除返校的一条记录
	public boolean delete(Integer id) throws Exception;

	// 插入返校的一条记录
	public boolean insert(String stu_id, String stu_name, int situation,
			Date come_back_datetime) throws Exception;

	// 更新返校的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			int situation, Date come_back_datetime) throws Exception;

}