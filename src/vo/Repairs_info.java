package vo;

import java.io.Serializable;
import java.sql.Date;

public class Repairs_info implements Serializable{

	private int id;
	private String stu_id;
	private String stu_name;
	private String dormitory_num;
	private String phone_number;
	private Date report_datetime;
	private String reason;
	public Repairs_info() {
	}
	public Repairs_info(int id, String stu_id, String stu_name,
			String dormitory_num, String phone_number, Date report_datetime,
			String reason) {
		this.id = id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.dormitory_num = dormitory_num;
		this.phone_number = phone_number;
		this.report_datetime = report_datetime;
		this.reason = reason;
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
	public String getDormitory_num() {
		return dormitory_num;
	}
	public void setDormitory_num(String dormitory_num) {
		this.dormitory_num = dormitory_num;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getReport_datetime() {
		return report_datetime;
	}
	public void setReport_datetime(Date report_datetime) {
		this.report_datetime = report_datetime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
