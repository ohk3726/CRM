package com.usinsa.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.usinsa.crm.vo.LEVEL_TB_VO;
import com.usinsa.crm.vo.AnniversaryVO;
import com.usinsa.crm.vo.BasketVO;
import com.usinsa.crm.vo.ConsultingVO;
import com.usinsa.crm.vo.CouponVO;
import com.usinsa.crm.vo.LevelVO;
import com.usinsa.crm.vo.MailVO;
import com.usinsa.crm.vo.OrderVO;
import com.usinsa.crm.vo.SizeVO;
import com.usinsa.crm.vo.UserVO;

public interface UserDAO {
	List<UserVO> selectuser() throws Exception;
	List<UserVO> searchusername(UserVO vo) throws Exception;
	List<UserVO> searchuserphone(UserVO vo) throws Exception;
	List<UserVO> userdetail(UserVO vo) throws Exception;
	List<LevelVO> level() throws Exception;
	List<UserVO> blacklist() throws Exception;
	String userlevel(UserVO vo) throws Exception;
	String blacklistyn(UserVO vo) throws Exception;
	int userupdate(UserVO vo) throws Exception;
	List<AnniversaryVO> selectanniversary(UserVO vo) throws Exception;
	int anniversaryupdate(AnniversaryVO vo) throws Exception;
	List<ConsultingVO> selectconsulting(UserVO vo) throws Exception;
	int consultingupdate(ConsultingVO vo) throws Exception;
	List<ConsultingVO> selectconsultingid(String consulting_id) throws Exception;
	
	List<OrderVO> selectorderlist(UserVO vo)throws Exception;
	List<OrderVO> orderdetail(OrderVO vo)throws Exception;
	List<CouponVO> usercouponlist(UserVO vo)throws Exception;
	
	int anniversaryinsert(AnniversaryVO vo) throws Exception;
	List<AnniversaryVO> anniversarylist(AnniversaryVO vo) throws Exception;
	
	int consultingidcheck() throws Exception;
	int consultinginsert(ConsultingVO vo) throws Exception;
	
	int orderupdate(OrderVO vo) throws Exception;
	
	List<UserVO> new_user_list() throws Exception;
	List<BasketVO> basket_user_list() throws Exception;
	List<SizeVO> product_category_list() throws Exception;
	List<SizeVO> size_issued(SizeVO vo) throws Exception;
	List<AnniversaryVO> anniversary_issued_list() throws Exception;
	
	List<UserVO> search_user(UserVO vo) throws Exception;
	List<UserVO> job_list() throws Exception;
	
	int mail_insert(MailVO vo) throws Exception;
	
	int user_check(UserVO vo) throws Exception;
	int new_user_insert(UserVO vo) throws Exception;
	
	List<LEVEL_TB_VO> Level_List() throws Exception;
	
	String anniversary_id() throws Exception;
	
	List<UserVO> issued_blacklist() throws Exception;
	List<MailVO> mail_list(UserVO vo) throws Exception;
}
