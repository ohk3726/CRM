package com.usinsa.crm.vo;

public class ConsultingVO {
	private String user_id;
	private String content;
	private String reg_date;
	private String state;
	private String consultant;
	private String consulting_id;
	
	
	public String getConsulting_id() {
		return consulting_id;
	}
	public void setConsulting_id(String consulting_id) {
		this.consulting_id = consulting_id;
	}
	public String getConsultant() {
		return consultant;
	}
	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "ConsultingVO [user_id=" + user_id + ", content=" + content + ", reg_date=" + reg_date + ", state="
				+ state + ", consultant=" + consultant + ", consulting_id=" + consulting_id + "]";
	}
	
}
