package com.usinsa.crm.vo;

public class BasketVO {
	private String product_id;
	private String user_id;
	private String basket_product_cnt;
	private String basket_price;
	private String reg_date;
	private String user_name;
	private String level_name;
	private String mail_reg_date;
	
	
	public String getMail_reg_date() {
		return mail_reg_date;
	}
	public void setMail_reg_date(String mail_reg_date) {
		this.mail_reg_date = mail_reg_date;
	}
	public String getBasket_price() {
		return basket_price;
	}
	public void setBasket_price(String basket_price) {
		this.basket_price = basket_price;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBasket_product_cnt() {
		return basket_product_cnt;
	}
	public void setBasket_product_cnt(String basket_product_cnt) {
		this.basket_product_cnt = basket_product_cnt;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "BasketVO [product_id=" + product_id + ", user_id=" + user_id + ", basket_product_cnt="
				+ basket_product_cnt + ", reg_date=" + reg_date + ", user_name=" + user_name + "]";
	}
	
}
