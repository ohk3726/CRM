package com.usinsa.crm.dao;

import java.util.List;

import com.usinsa.crm.vo.PRODUCT_TB_VO;

public interface ProductDAO {
	List<PRODUCT_TB_VO> ProductList() throws Exception;
	List<PRODUCT_TB_VO> ProductInfo(PRODUCT_TB_VO vo) throws Exception;
	int Product_SameId(PRODUCT_TB_VO vo) throws Exception;
	int Product_Insert(PRODUCT_TB_VO vo) throws Exception;
	int Product_Update(PRODUCT_TB_VO vo) throws Exception;
	List<PRODUCT_TB_VO> Product_Search_Name(PRODUCT_TB_VO vo) throws Exception;
	List<PRODUCT_TB_VO> Product_Search_Id(PRODUCT_TB_VO vo) throws Exception;
	List<PRODUCT_TB_VO> Product_Search_Size(PRODUCT_TB_VO vo) throws Exception;
	List<PRODUCT_TB_VO> Linked_Products(PRODUCT_TB_VO vo) throws Exception;
	String product_sub_category(PRODUCT_TB_VO vo)throws Exception;
}
