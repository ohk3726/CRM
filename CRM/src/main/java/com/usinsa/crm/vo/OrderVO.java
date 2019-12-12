package com.usinsa.crm.vo;

public class OrderVO {
	private String order_id;
	private String product_id;
	private String order_product_cnt;
	private String user_id;
	private String order_adress;
	private String order_check;
	private String order_return_yn;
	private String order_phone;
	private String order_memo;
	private String order_recipient;
	private String reg_date;
	private String product_name;
	private String order_price;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getOrder_product_cnt() {
		return order_product_cnt;
	}
	public void setOrder_product_cnt(String order_product_cnt) {
		this.order_product_cnt = order_product_cnt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_adress() {
		return order_adress;
	}
	public void setOrder_adress(String order_adress) {
		this.order_adress = order_adress;
	}
	public String getOrder_check() {
		return order_check;
	}
	public void setOrder_check(String order_check) {
		this.order_check = order_check;
	}
	public String getOrder_return_yn() {
		return order_return_yn;
	}
	public void setOrder_return_yn(String order_return_yn) {
		this.order_return_yn = order_return_yn;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getOrder_memo() {
		return order_memo;
	}
	public void setOrder_memo(String order_memo) {
		this.order_memo = order_memo;
	}
	public String getOrder_recipient() {
		return order_recipient;
	}
	public void setOrder_recipient(String order_recipient) {
		this.order_recipient = order_recipient;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", product_id=" + product_id + ", order_product_cnt="
				+ order_product_cnt + ", user_id=" + user_id + ", order_adress=" + order_adress + ", order_check="
				+ order_check + ", order_return_yn=" + order_return_yn + ", order_phone=" + order_phone
				+ ", order_memo=" + order_memo + ", order_recipient=" + order_recipient + ", reg_date=" + reg_date
				+ ", product_name=" + product_name + ", order_price=" + order_price + "]";
	}
	
	
}
