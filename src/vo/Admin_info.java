package vo;

import java.io.Serializable;

public class Admin_info implements Serializable {
private String adm_id;
private String adm_name;
private String adm_identity;
private String password;
public Admin_info() {
}
public Admin_info(String adm_id, String adm_name, String adm_identity,
		String password) {
	this.adm_id = adm_id;
	this.adm_name = adm_name;
	this.adm_identity = adm_identity;
	this.password = password;
}
public String getAdm_id() {
	return adm_id;
}
public void setAdm_id(String adm_id) {
	this.adm_id = adm_id;
}
public String getAdm_name() {
	return adm_name;
}
public void setAdm_name(String adm_name) {
	this.adm_name = adm_name;
}
public String getAdm_identity() {
	return adm_identity;
}
public void setAdm_identity(String adm_identity) {
	this.adm_identity = adm_identity;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
