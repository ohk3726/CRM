package com.usinsa.crm.vo;

public class USER_TB_VO {

	
	private String USER_ID;
	private String USER_PW;
	private String USER_NAME;
	private String USER_ADRESS;
	private String USER_PHONE;
	private String USER_JOB;
	private String USER_SSN;
	private String LEVEL_ID;
	private String BLACK_LIST_YN;
	private String CONSULTING;
	private String REG_DATE;
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PW() {
		return USER_PW;
	}
	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_ADRESS() {
		return USER_ADRESS;
	}
	public void setUSER_ADRESS(String uSER_ADRESS) {
		USER_ADRESS = uSER_ADRESS;
	}
	public String getUSER_PHONE() {
		return USER_PHONE;
	}
	public void setUSER_PHONE(String uSER_PHONE) {
		USER_PHONE = uSER_PHONE;
	}
	public String getUSER_JOB() {
		return USER_JOB;
	}
	public void setUSER_JOB(String uSER_JOB) {
		USER_JOB = uSER_JOB;
	}
	public String getUSER_SSN() {
		return USER_SSN;
	}
	public void setUSER_SSN(String uSER_SSN) {
		USER_SSN = uSER_SSN;
	}
	public String getLEVEL_ID() {
		return LEVEL_ID;
	}
	public void setLEVEL_ID(String lEVEL_ID) {
		LEVEL_ID = lEVEL_ID;
	}
	public String getBLACK_LIST_YN() {
		return BLACK_LIST_YN;
	}
	public void setBLACK_LIST_YN(String bLACK_LIST_YN) {
		BLACK_LIST_YN = bLACK_LIST_YN;
	}
	public String getCONSULTING() {
		return CONSULTING;
	}
	public void setCONSULTING(String cONSULTING) {
		CONSULTING = cONSULTING;
	}
	public String getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	
	@Override
	public String toString() {
		return "USER_TB_VO [USER_ID=" + USER_ID + ", USER_PW=" + USER_PW + ", USER_NAME=" + USER_NAME + ", USER_ADRESS="
				+ USER_ADRESS + ", USER_PHONE=" + USER_PHONE + ", USER_JOB=" + USER_JOB + ", USER_SSN=" + USER_SSN
				+ ", LEVEL_ID=" + LEVEL_ID + ", BLACK_LIST_YN=" + BLACK_LIST_YN + ", CONSULTING=" + CONSULTING
				+ ", REG_DATE=" + REG_DATE + "]";
	}
	
	
	
}
