package dao;

import java.sql.Date;

public interface IRepairs_infoDAO {

	//查看报修全部数据
	public String selectall()throws Exception;

	// 删除报修的一条记录
	public boolean delete(Integer id) throws Exception;

	// 插入报修的一条记录
	public boolean insert(String stu_id, String stu_name, String dormitory_num,
			String phone_number, Date report_datetime, String reason)
			throws Exception;

	// 更新报修的一条记录
	public boolean update(Integer id, String stu_id, String stu_name,
			String dormitory_num, String phone_number, Date report_datetime,
			String reason) throws Exception;

}