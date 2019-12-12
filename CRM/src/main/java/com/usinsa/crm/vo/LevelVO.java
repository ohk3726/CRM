package com.usinsa.crm.vo;

public class LevelVO {
	private String level_id;
	private String level_name;
	private String level_price;
	private String reg_date;
	private String order_price;
	private String coupon_id;
	private String user_id;
	private String user_name;
	private String old_level_id;
	private String old_level_name;
	
	public String getOld_level_name() {
		return old_level_name;
	}
	public void setOld_level_name(String old_level_name) {
		this.old_level_name = old_level_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getOld_level_id() {
		return old_level_id;
	}
	public void setOld_level_id(String old_level_id) {
		this.old_level_id = old_level_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getLevel_id() {
		return level_id;
	}
	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public String getLevel_price() {
		return level_price;
	}
	public void setLevel_price(String level_price) {
		this.level_price = level_price;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "LevelVO [level_id=" + level_id + ", level_name=" + level_name + ", level_price=" + level_price
				+ ", reg_date=" + reg_date + "]";
	}
	
	
}
