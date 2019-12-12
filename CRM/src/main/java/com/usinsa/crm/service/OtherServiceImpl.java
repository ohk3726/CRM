package com.usinsa.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usinsa.crm.dao.OtherDAO;
import com.usinsa.crm.vo.CouponVO;
import com.usinsa.crm.vo.MailVO;
import com.usinsa.crm.vo.OtherVO;
import com.usinsa.crm.vo.UserVO;

@Service("OtherService")
public class OtherServiceImpl implements OtherService{
	@Autowired
	private OtherDAO otherMapper;
	
	@Override
	@Transactional
	public List other_coupon_list() throws Exception{
		return otherMapper.other_coupon_list();
	}
	
	@Override
	@Transactional
	public List other_coupon_category() throws Exception{
		return otherMapper.other_coupon_category();
	}
	
	@Override
	@Transactional
	public List other_select_coupon(OtherVO vo) throws Exception{
		return otherMapper.other_select_coupon(vo);
	}
	
	@Override
	@Transactional
	public List coupon_max() throws Exception{
		return otherMapper.coupon_max();
	}
	
	@Override
	@Transactional
	public int coupon_insert(OtherVO vo) throws Exception{
		return otherMapper.coupon_insert(vo);
	}
	
	@Override
	@Transactional
	public int coupon_update(OtherVO vo) throws Exception{
		return otherMapper.coupon_update(vo);
	}
	
	@Override
	@Transactional
	public List other_user(UserVO vo) throws Exception{
		return otherMapper.other_user(vo);
	}
	
	@Override
	@Transactional
	public List user_job() throws Exception{
		return otherMapper.user_job();
	}
	
	@Override
	@Transactional
	public List level() throws Exception{
		return otherMapper.level();
	}
	
	@Override
	@Transactional
	public String[] user_email(String[] user_id) throws Exception{
		return otherMapper.user_email(user_id);
	}
	
	@Override
	@Transactional
	public String coupon_issued_id() throws Exception{
		return otherMapper.coupon_issued_id();
	}
	
	@Override
	@Transactional
	public int coupon_mail_insert(MailVO vo) throws Exception{
		return otherMapper.coupon_mail_insert(vo);
	}
	
	@Override
	@Transactional
	public int coupon_issued_insert(CouponVO vo) throws Exception{
		return otherMapper.coupon_issued_insert(vo);
	}
	
	@Override
	@Transactional
	public String[] coupon_name(String[] coupon_id) throws Exception{
		return otherMapper.coupon_name(coupon_id);
	}
}
