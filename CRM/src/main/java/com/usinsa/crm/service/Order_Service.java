package com.usinsa.crm.service;

import java.util.List;

import com.usinsa.crm.vo.LEVEL_TB_VO;
import com.usinsa.crm.vo.ORDER_TB_VO;

public interface Order_Service {
	List<ORDER_TB_VO> product_order(ORDER_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> option_check(ORDER_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> option_date(ORDER_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> product_order_customer(ORDER_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> option_date_customer(ORDER_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> option_state_name(ORDER_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> product_category() throws Exception;
	List<ORDER_TB_VO> option_product_name() throws Exception;
	List<ORDER_TB_VO> option_product_cnt() throws Exception;
	List<ORDER_TB_VO> option_product_price() throws Exception;
	List<ORDER_TB_VO> selet_gold(LEVEL_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> selet_dia(LEVEL_TB_VO vo) throws Exception;
	List<ORDER_TB_VO> selet_platinum(LEVEL_TB_VO vo) throws Exception;
	
	


}
