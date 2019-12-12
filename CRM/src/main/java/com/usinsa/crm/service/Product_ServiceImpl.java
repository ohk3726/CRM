package com.usinsa.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usinsa.crm.dao.ProductDAO;
import com.usinsa.crm.vo.PRODUCT_TB_VO;

@Service("Product_Service")
public class Product_ServiceImpl implements Product_Service {

	@Autowired
	private ProductDAO productMapper;

	@Override
	@Transactional
	public List ProductList() throws Exception {

		return productMapper.ProductList();
	}

	@Override
	@Transactional
	public List ProductInfo(PRODUCT_TB_VO vo) throws Exception {

		return productMapper.ProductInfo(vo);
	}

	@Override
	@Transactional
	public int Product_SameId(PRODUCT_TB_VO vo) throws Exception {

		return productMapper.Product_SameId(vo);
	}
	
	@Override
	@Transactional
	public int Product_Insert(PRODUCT_TB_VO vo) throws Exception{
		return productMapper.Product_Insert(vo);
	}
	
	@Override
	@Transactional
	public int Product_Update(PRODUCT_TB_VO vo) throws Exception{
		return productMapper.Product_Update(vo);
	}
	
	
	@Override
	@Transactional
	public List Product_Search_Name(PRODUCT_TB_VO vo) throws Exception{
		return productMapper.Product_Search_Name(vo);
		}
	
	@Override
	@Transactional
	public List Product_Search_Size(PRODUCT_TB_VO vo) throws Exception{
		return productMapper.Product_Search_Size(vo);
		}
	
	@Override
	@Transactional
	public List Product_Search_Id(PRODUCT_TB_VO vo) throws Exception{
		return productMapper.Product_Search_Id(vo);
		}
	
	@Override
	@Transactional
	public List Linked_Products(PRODUCT_TB_VO vo) throws Exception{
		return productMapper.Linked_Products(vo);
		}
	
	
	// ���� ī�װ� ã��
	@Override
	@Transactional
	public String product_sub_category(PRODUCT_TB_VO vo)throws Exception{
		return productMapper.product_sub_category(vo);
	}

}
