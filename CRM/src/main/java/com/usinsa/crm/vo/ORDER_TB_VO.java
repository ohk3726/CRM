package com.usinsa.crm.vo;

public class ORDER_TB_VO {

		private String ORDER_ID;
		private String PRODUCT_ID;
		private int ORDER_PRODUCT_CNT;
		private String USER_ID;
		private String ORDER_ADRESS;
		private String ORDER_CHECK;
		private String ORDER_RETURN_YN;
		private String ORDER_PHONE;
		private	String ORDER_MEMO;
		private String ORDER_RECIPIENT;
		private String REG_DATE;
		
		private String ORDER_PRICE_2;
		private String ORDER_PRICE;
		private String USER_NAME;
		private String PRODUCT_NAME;
		
		
		
	
		public String getORDER_PRICE_2() {
			return ORDER_PRICE_2;
		}
		public void setORDER_PRICE_2(String oRDER_PRICE_2) {
			ORDER_PRICE_2 = oRDER_PRICE_2;
		}
		public String getPRODUCT_NAME() {
			return PRODUCT_NAME;
		}
		public void setPRODUCT_NAME(String pRODUCT_NAME) {
			PRODUCT_NAME = pRODUCT_NAME;
		}
		public String getUSER_NAME() {
			return USER_NAME;
		}
		public void setUSER_NAME(String uSER_NAME) {
			USER_NAME = uSER_NAME;
		}
		public String getORDER_PRICE() {
			return ORDER_PRICE;
		}
		public void setORDER_PRICE(String oRDER_PRICE) {
			ORDER_PRICE = oRDER_PRICE;
		}
		public String getORDER_ID() {
			return ORDER_ID;
		}
		public void setORDER_ID(String oRDER_ID) {
			ORDER_ID = oRDER_ID;
		}
		public String getPRODUCT_ID() {
			return PRODUCT_ID;
		}
		public void setPRODUCT_ID(String pRODUCT_ID) {
			PRODUCT_ID = pRODUCT_ID;
		}
		public int getORDER_PRODUCT_CNT() {
			return ORDER_PRODUCT_CNT;
		}
		public void setORDER_PRODUCT_CNT(int oRDER_PRODUCT_CNT) {
			ORDER_PRODUCT_CNT = oRDER_PRODUCT_CNT;
		}
		public String getUSER_ID() {
			return USER_ID;
		}
		public void setUSER_ID(String uSER_ID) {
			USER_ID = uSER_ID;
		}
		public String getORDER_ADRESS() {
			return ORDER_ADRESS;
		}
		public void setORDER_ADRESS(String oRDER_ADRESS) {
			ORDER_ADRESS = oRDER_ADRESS;
		}
		public String getORDER_CHECK() {
			return ORDER_CHECK;
		}
		public void setORDER_CHECK(String oRDER_CHECK) {
			ORDER_CHECK = oRDER_CHECK;
		}
		public String getORDER_RETURN_YN() {
			return ORDER_RETURN_YN;
		}
		public void setORDER_RETURN_YN(String oRDER_RETURN_YN) {
			ORDER_RETURN_YN = oRDER_RETURN_YN;
		}
		public String getORDER_PHONE() {
			return ORDER_PHONE;
		}
		public void setORDER_PHONE(String oRDER_PHONE) {
			ORDER_PHONE = oRDER_PHONE;
		}
		public String getORDER_MEMO() {
			return ORDER_MEMO;
		}
		public void setORDER_MEMO(String oRDER_MEMO) {
			ORDER_MEMO = oRDER_MEMO;
		}
		public String getORDER_RECIPIENT() {
			return ORDER_RECIPIENT;
		}
		public void setORDER_RECIPIENT(String oRDER_RECIPIENT) {
			ORDER_RECIPIENT = oRDER_RECIPIENT;
		}
		public String getREG_DATE() {
			return REG_DATE;
		}
		public void setREG_DATE(String rEG_DATE) {
			REG_DATE = rEG_DATE;
		}
		@Override
		public String toString() {
			return "ORDER_TB_VO [ORDER_ID=" + ORDER_ID + ", PRODUCT_ID=" + PRODUCT_ID + ", ORDER_PRODUCT_CNT="
					+ ORDER_PRODUCT_CNT + ", USER_ID=" + USER_ID + ", ORDER_ADRESS=" + ORDER_ADRESS + ", ORDER_CHECK="
					+ ORDER_CHECK + ", ORDER_RETURN_YN=" + ORDER_RETURN_YN + ", ORDER_PHONE=" + ORDER_PHONE
					+ ", ORDER_MEMO=" + ORDER_MEMO + ", ORDER_RECIPIENT=" + ORDER_RECIPIENT + ", REG_DATE=" + REG_DATE
					+ ", ORDER_PRICE=" + ORDER_PRICE + ", USER_NAME=" + USER_NAME + ", PRODUCT_NAME=" + PRODUCT_NAME
					+ "]";
		}
		
		
		
		

		
		
}
