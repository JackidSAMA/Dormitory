package vo;

import java.io.Serializable;
import java.sql.Date;

public class Student_info implements Serializable{
	private String stu_id;
	private String stu_name;
	private String password;
	private Date birthday;
	private String major;
	private String grade;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Student_info() {
	}
	public Student_info(String stu_id, String stu_name, String password,
			Date birthday, String major, String grade) {
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.password = password;
		this.birthday = birthday;
		this.major = major;
		this.grade = grade;
	}
	
}
