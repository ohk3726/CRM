package com.usinsa.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usinsa.crm.dao.OrderDAO;
import com.usinsa.crm.vo.LEVEL_TB_VO;
import com.usinsa.crm.vo.ORDER_TB_VO;
import com.usinsa.crm.vo.PRODUCT_TB_VO;

@Service("Order_Service")
public class Order_ServiceImpl implements Order_Service {

	@Autowired
	private OrderDAO Order_mapper;
	

	@Override
	@Transactional
	public List product_order(ORDER_TB_VO vo) throws Exception {

		return Order_mapper.product_order(vo);
	}
	
	@Override
	@Transactional
	public List option_check(ORDER_TB_VO vo) throws Exception {

		return Order_mapper.option_check(vo);
	}
	
	@Override
	@Transactional
	public List option_date(ORDER_TB_VO vo) throws Exception {

		return Order_mapper.option_date(vo);
	}
	
	
	@Override
	@Transactional
	public List product_order_customer(ORDER_TB_VO vo) throws Exception {

		return Order_mapper.product_order_customer(vo);
	}
	
	@Override
	@Transactional
	public List option_date_customer(ORDER_TB_VO vo) throws Exception {

		return Order_mapper.option_date_customer(vo);
	}
	@Override
	@Transactional
	public List option_state_name(ORDER_TB_VO vo) throws Exception {

		return Order_mapper.option_state_name(vo);
	}

	@Override
	@Transactional
	public List product_category() throws Exception {

		return Order_mapper.product_category();
	}
	
	@Override
	@Transactional
	public List option_product_name() throws Exception {

		return Order_mapper.option_product_name();
	}
	@Override
	@Transactional
	public List option_product_cnt() throws Exception {

		return Order_mapper.option_product_cnt();
	}
	@Override
	@Transactional
	public List option_product_price() throws Exception {

		return Order_mapper.option_product_price();
	}
	@Override
	@Transactional
	public List selet_gold(LEVEL_TB_VO vo) throws Exception {

		return Order_mapper.selet_gold(vo);
	}
	
	
	@Override
	@Transactional
	public List selet_dia(LEVEL_TB_VO vo) throws Exception {

		return Order_mapper.selet_dia(vo);
	}
	
	@Override
	@Transactional
	public List selet_platinum(LEVEL_TB_VO vo) throws Exception {

		return Order_mapper.selet_platinum(vo);
	}
	
}
