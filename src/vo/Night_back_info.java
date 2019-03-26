package vo;

import java.io.Serializable;
import java.sql.Date;

public class Night_back_info implements Serializable{
private int id;
private String stu_id;
private String stu_name;
private Date night_back_datetime;
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
public Date getNight_back_datetime() {
	return night_back_datetime;
}
public void setNight_back_datetime(Date night_back_datetime) {
	this.night_back_datetime = night_back_datetime;
}
public Night_back_info(int id, String stu_id, String stu_name,
		Date night_back_datetime) {
	this.id = id;
	this.stu_id = stu_id;
	this.stu_name = stu_name;
	this.night_back_datetime = night_back_datetime;
}
public Night_back_info() {
}

}
