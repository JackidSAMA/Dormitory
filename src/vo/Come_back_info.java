package vo;

import java.io.Serializable;
import java.sql.Date;

public class Come_back_info implements Serializable {

	private int id;
	private String stu_id;
	private String stu_name;
	private int situation;
	private Date come_back_datetime;
	public Come_back_info() {
	}
	public Come_back_info(int id, String stu_id, String stu_name,
			int situation, Date come_back_datetime) {
		this.id = id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.situation = situation;
		this.come_back_datetime = come_back_datetime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public int getSituation() {
		return situation;
	}
	public void setSituation(int situation) {
		this.situation = situation;
	}
	public Date getCome_back_datetime() {
		return come_back_datetime;
	}
	public void setCome_back_datetime(Date come_back_datetime) {
		this.come_back_datetime = come_back_datetime;
	}
	
}
