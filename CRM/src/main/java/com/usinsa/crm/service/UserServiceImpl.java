package com.usinsa.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usinsa.crm.dao.UserDAO;
import com.usinsa.crm.vo.AnniversaryVO;
import com.usinsa.crm.vo.ConsultingVO;
import com.usinsa.crm.vo.MailVO;
import com.usinsa.crm.vo.OrderVO;
import com.usinsa.crm.vo.SizeVO;
import com.usinsa.crm.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userMapper;
	
	@Override
	@Transactional
	public List selectuser() throws Exception{
		return userMapper.selectuser();
	}
	
	@Override
	@Transactional
	public List searchusername(UserVO vo) throws Exception{
		return userMapper.searchusername(vo);
	}
	
	@Override
	@Transactional
	public List searchuserphone(UserVO vo) throws Exception{
		return userMapper.searchuserphone(vo);
	}
	
	@Override
	@Transactional
	public List userdetail(UserVO vo) throws Exception{
		return userMapper.userdetail(vo);
	}
	
	@Override
	@Transactional
	public List level() throws Exception{
		return userMapper.level();
	}
	
	@Override
	@Transactional
	public List blacklist() throws Exception{
		return userMapper.blacklist();
	}
	
	@Override
	@Transactional
	public String userlevel(UserVO vo) throws Exception{
		return userMapper.userlevel(vo);
	}
	
	@Override
	@Transactional
	public String blacklistyn(UserVO vo) throws Exception{
		return userMapper.blacklistyn(vo);
	}
	
	@Override
	@Transactional
	public int userupdate(UserVO vo) throws Exception{
		return userMapper.userupdate(vo);
	}
	
	@Override
	@Transactional
	public List selectanniversary(UserVO vo) throws Exception{
		return userMapper.selectanniversary(vo);
	}
	
	@Override
	@Transactional
	public int anniversaryupdate(AnniversaryVO vo) throws Exception{
		return userMapper.anniversaryupdate(vo);
	}
	
	@Override
	@Transactional
	public List selectconsulting(UserVO vo) throws Exception{
		return userMapper.selectconsulting(vo);
	}
	
	@Override
	@Transactional
	public int consultingupdate(ConsultingVO vo) throws Exception{
		return userMapper.consultingupdate(vo);
	}
	
	@Override
	@Transactional
	public List selectconsultingid(String consulting_id) throws Exception{
		return userMapper.selectconsultingid(consulting_id);
	}
	
	@Override
	@Transactional
	public List selectorderlist(UserVO vo) throws Exception{
		return userMapper.selectorderlist(vo);
	}
	
	@Override
	@Transactional
	public List orderdetail(OrderVO vo) throws Exception{
		return userMapper.orderdetail(vo);
	}
	
	@Override
	@Transactional
	public List usercouponlist(UserVO vo) throws Exception{
		return userMapper.usercouponlist(vo);
	}
	
	@Override
	@Transactional
	public int anniversaryinsert(AnniversaryVO vo) throws Exception{
		return userMapper.anniversaryinsert(vo);
	}
	
	@Override
	@Transactional
	public List anniversarylist(AnniversaryVO vo) throws Exception{
		return userMapper.anniversarylist(vo);
	}
	
	@Override
	@Transactional
	public int consultingidcheck() throws Exception{
		return userMapper.consultingidcheck();
	}
	
	@Override
	@Transactional
	public int consultinginsert(ConsultingVO vo) throws Exception{
		return userMapper.consultinginsert(vo);
	}
	
	@Override
	@Transactional
	public int orderupdate(OrderVO vo) throws Exception{
		return userMapper.orderupdate(vo);
	}
	
	@Override
	@Transactional
	public List new_user_list() throws Exception{
		return userMapper.new_user_list();
	}
	
	@Override
	@Transactional
	public List basket_user_list() throws Exception{
		return userMapper.basket_user_list();
	}
	
	@Override
	@Transactional
	public List product_category_list() throws Exception{
		return userMapper.product_category_list();
	}
	
	@Override
	@Transactional
	public List size_issued(SizeVO vo) throws Exception{
		return userMapper.size_issued(vo);
	}
	
	@Override
	@Transactional
	public List anniversary_issued_list() throws Exception{
		return userMapper.anniversary_issued_list();
	}
	
	@Override
	@Transactional
	public List search_user(UserVO vo) throws Exception{
		return userMapper.search_user(vo);
	}
	
	@Override
	@Transactional
	public List job_list() throws Exception{
		return userMapper.job_list();
	}
	
	@Override
	@Transactional
	public int mail_insert(MailVO vo) throws Exception{
		return userMapper.mail_insert(vo);
	}
	
	@Override
	@Transactional
	public int user_check(UserVO vo) throws Exception{
		return userMapper.user_check(vo);
	}
	
	@Override
	@Transactional
	public int new_user_insert(UserVO vo) throws Exception{
		return userMapper.new_user_insert(vo);
	}
	
	@Override
	@Transactional
	public String anniversary_id() throws Exception{
		return userMapper.anniversary_id();
	}
	
	@Override
	@Transactional
	public List issued_blacklist() throws Exception{
		return userMapper.issued_blacklist();
	}
	
	@Override
	@Transactional
	public List mail_list(UserVO vo) throws Exception{
		return userMapper.mail_list(vo);
	}
}
