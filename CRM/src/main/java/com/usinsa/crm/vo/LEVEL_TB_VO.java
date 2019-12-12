package com.usinsa.crm.vo;

public class LEVEL_TB_VO {
	private String LEVEL_ID;
	private String LEVEL_NAME;
	private String LEVEL_PRICE;
	private String LEVEL_DATE;
	public String getLEVEL_ID() {
		return LEVEL_ID;
	}
	public void setLEVEL_ID(String lEVEL_ID) {
		LEVEL_ID = lEVEL_ID;
	}
	public String getLEVEL_NAME() {
		return LEVEL_NAME;
	}
	public void setLEVEL_NAME(String lEVEL_NAME) {
		LEVEL_NAME = lEVEL_NAME;
	}
	public String getLEVEL_PRICE() {
		return LEVEL_PRICE;
	}
	public void setLEVEL_PRICE(String lEVEL_PRICE) {
		LEVEL_PRICE = lEVEL_PRICE;
	}
	public String getLEVEL_DATE() {
		return LEVEL_DATE;
	}
	public void setLEVEL_DATE(String lEVEL_DATE) {
		LEVEL_DATE = lEVEL_DATE;
	}
	@Override
	public String toString() {
		return "LEVEL_TB [LEVEL_ID=" + LEVEL_ID + ", LEVEL_NAME=" + LEVEL_NAME + ", LEVEL_PRICE=" + LEVEL_PRICE
				+ ", LEVEL_DATE=" + LEVEL_DATE + "]";
	}
	
	
	
	
}
