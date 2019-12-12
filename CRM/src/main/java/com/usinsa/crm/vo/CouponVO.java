package com.usinsa.crm.vo;

public class CouponVO {
	private String coupon_issued_id;
	private String coupon_id;
	private String coupon_name;
	private String reg_date;
	private String user_id;
	private String coupon_yn;
	
	public String getCoupon_issued_id() {
		return coupon_issued_id;
	}
	public void setCoupon_issued_id(String coupon_issued_id) {
		this.coupon_issued_id = coupon_issued_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCoupon_yn() {
		return coupon_yn;
	}
	public void setCoupon_yn(String coupon_yn) {
		this.coupon_yn = coupon_yn;
	}
	@Override
	public String toString() {
		return "CouponVO [coupon_issued_id=" + coupon_issued_id + ", coupon_id=" + coupon_id + ", coupon_name="
				+ coupon_name + ", reg_date=" + reg_date + ", user_id=" + user_id + ", coupon_yn=" + coupon_yn + "]";
	}
	
	
}
