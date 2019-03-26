package vo;

import java.io.Serializable;
import java.sql.Date;

public class Express_info implements Serializable{

	private int id;
	private String stu_id;
	private String stu_name;
	private String phone_number;
	private Date arrival_datetime;
	private int is_get;
	public Express_info() {
	}
	public Express_info(int id, String stu_id, String stu_name,
			String phone_number, Date arrival_datetime, int is_get) {
		this.id = id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.phone_number = phone_number;
		this.arrival_datetime = arrival_datetime;
		this.is_get = is_get;
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getArrival_datetime() {
		return arrival_datetime;
	}
	public void setArrival_datetime(Date arrival_datetime) {
		this.arrival_datetime = arrival_datetime;
	}
	public int getIs_get() {
		return is_get;
	}
	public void setIs_get(int is_get) {
		this.is_get = is_get;
	}
	
}
