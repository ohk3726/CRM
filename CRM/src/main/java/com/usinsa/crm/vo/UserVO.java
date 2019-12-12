package com.usinsa.crm.vo;

public class UserVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_adress;
	private String user_phone;
	private String user_job;
	private String user_ssn;
	private String level_id;
	private String black_list_yn;
	private String email;
	private String reg_date;
	private String order_cnt;
	private String user_order;
	private String mail_reg_date;
	private String user_check;
	private String order_price;
	
	
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public String getUser_check() {
		return user_check;
	}
	public void setUser_check(String user_check) {
		this.user_check = user_check;
	}
	public String getMail_reg_date() {
		return mail_reg_date;
	}
	public void setMail_reg_date(String mail_reg_date) {
		this.mail_reg_date = mail_reg_date;
	}
	public String getUser_order() {
		return user_order;
	}
	public void setUser_order(String user_order) {
		this.user_order = user_order;
	}
	public String getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(String order_cnt) {
		this.order_cnt = order_cnt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_adress() {
		return user_adress;
	}
	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}
	public String getUser_ssn() {
		return user_ssn;
	}
	public void setUser_ssn(String user_ssn) {
		this.user_ssn = user_ssn;
	}
	public String getLevel_id() {
		return level_id;
	}
	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	public String getBlack_list_yn() {
		return black_list_yn;
	}
	public void setBlack_list_yn(String black_list_yn) {
		this.black_list_yn = black_list_yn;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_adress="
				+ user_adress + ", user_phone=" + user_phone + ", user_job=" + user_job + ", user_ssn=" + user_ssn
				+ ", level_id=" + level_id + ", black_list_yn=" + black_list_yn + ", email=" + email + ", reg_date="
				+ reg_date + ", order_cnt=" + order_cnt + "]";
	}
	
	
	
}
