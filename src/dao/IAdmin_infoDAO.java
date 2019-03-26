package dao;

public interface IAdmin_infoDAO {

	//查看全部数据
	public String selectall()throws Exception;

	// 删除管理员信息
	public boolean delete(String adm_id) throws Exception;

	public boolean insert(String adm_id, String adm_name, String adm_identity,
			String password) throws Exception;

	// 更新管理员信息
	public boolean update(String adm_id, String adm_name, String adm_identity,
			String password) throws Exception;

//	更新密码
	public boolean change_password(String oldpassword,String newpassword,String adm_id) throws Exception;
}