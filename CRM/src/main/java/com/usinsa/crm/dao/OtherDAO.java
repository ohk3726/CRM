package com.usinsa.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.usinsa.crm.vo.CouponVO;
import com.usinsa.crm.vo.LevelVO;
import com.usinsa.crm.vo.MailVO;
import com.usinsa.crm.vo.OtherVO;
import com.usinsa.crm.vo.UserVO;

public interface OtherDAO {
	List<OtherVO> other_coupon_list() throws Exception;
	List<OtherVO> other_coupon_category() throws Exception;
	List<OtherVO> other_select_coupon(OtherVO vo) throws Exception;
	List<OtherVO> coupon_max() throws Exception;
	int coupon_insert(OtherVO vo) throws Exception;
	int coupon_update(OtherVO vo) throws Exception;
	List<UserVO> other_user(UserVO vo) throws Exception;
	List<UserVO> user_job() throws Exception;
	List<LevelVO> level() throws Exception;
	String[] user_email(@Param("user_id") String[] user_id) throws Exception;
	String coupon_issued_id() throws Exception;
	int coupon_mail_insert(MailVO vo) throws Exception;
	int coupon_issued_insert(CouponVO vo) throws Exception;
	String[] coupon_name(@Param("coupon_id") String[] coupon_id) throws Exception;
}
