package com.usinsa.crm.vo;

import java.util.Date;

public class AnniversaryVO {
	private String user_id;
	private String anniversary_name;
	private String anniversary_cycle;
	private String anniversary_date;
	private String anniversary_relation;
	private String reg_dete;
	private String user_name;
	private String d_day;
	private String mail_reg_date;
	private String anniversary_id;
	
	
	public String getAnniversary_id() {
		return anniversary_id;
	}
	public void setAnniversary_id(String anniversary_id) {
		this.anniversary_id = anniversary_id;
	}
	public String getMail_reg_date() {
		return mail_reg_date;
	}
	public void setMail_reg_date(String mail_reg_date) {
		this.mail_reg_date = mail_reg_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getD_day() {
		return d_day;
	}
	public void setD_day(String d_day) {
		this.d_day = d_day;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAnniversary_name() {
		return anniversary_name;
	}
	public void setAnniversary_name(String anniversary_name) {
		this.anniversary_name = anniversary_name;
	}
	public String getAnniversary_cycle() {
		return anniversary_cycle;
	}
	public void setAnniversary_cycle(String anniversary_cycle) {
		this.anniversary_cycle = anniversary_cycle;
	}
	public String getAnniversary_date() {
		return anniversary_date;
	}
	public void setAnniversary_date(String anniversary_date) {
		this.anniversary_date = anniversary_date;
	}
	public String getAnniversary_relation() {
		return anniversary_relation;
	}
	public void setAnniversary_relation(String anniversary_relation) {
		this.anniversary_relation = anniversary_relation;
	}
	public String getReg_dete() {
		return reg_dete;
	}
	public void setReg_dete(String reg_dete) {
		this.reg_dete = reg_dete;
	}
	@Override
	public String toString() {
		return "AnniversaryVO [user_id=" + user_id + ", anniversary_name=" + anniversary_name + ", anniversary_cycle="
				+ anniversary_cycle + ", anniversary_date=" + anniversary_date + ", anniversary_relation="
				+ anniversary_relation + ", reg_dete=" + reg_dete + "]";
	}

	
}
