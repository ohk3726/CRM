package com.usinsa.crm.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usinsa.crm.service.OtherService;
import com.usinsa.crm.service.UserService;
import com.usinsa.crm.vo.CouponVO;
import com.usinsa.crm.vo.LevelVO;
import com.usinsa.crm.vo.MailVO;
import com.usinsa.crm.vo.OtherVO;
import com.usinsa.crm.vo.UserVO;

@Controller
public class OtherController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Resource(name="OtherService")
	private OtherService otherservice;
	
	@Resource(name = "UserService")
	private UserService userservice;
	
	@RequestMapping(value="/other")
	public String other(HttpServletRequest request, Model model) throws Exception{
		String result = "coupon/other";
		
		List<OtherVO> list = otherservice.other_coupon_list();
		List<LevelVO> list2 = otherservice.level();
		List<UserVO> list3 = otherservice.user_job();
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		
		return result;
	}
	
	@RequestMapping(value="/coupon_insert")
	public String coupon_insert(HttpServletRequest request, Model model) throws Exception{
		String result = "coupon/coupon_insert";
		
		List<OtherVO> list = otherservice.other_coupon_category();
		model.addAttribute("list",list);
		
		return result;
	}
	
	@RequestMapping(value="/coupon_insert1")
	public void coupon_insert1(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String coupon_name = new String(request.getParameter("coupon_name").getBytes("ISO-8859-1"),"UTF-8");
		String product_main_category = new String(request.getParameter("product_main_category").getBytes("ISO-8859-1"),"UTF-8");
		String discount = new String(request.getParameter("discount").getBytes("ISO-8859-1"),"UTF-8");
		
		List<OtherVO> list = otherservice.coupon_max();
		
		OtherVO vo = new OtherVO();
		vo.setCoupon_id(list.get(0).getCoupon_id());
		vo.setCoupon_name(coupon_name);
		vo.setProduct_main_category(product_main_category);
		vo.setDiscount(discount);
		
		int insert = otherservice.coupon_insert(vo);
		if(insert==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('쿠폰이 등록되었습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('쿠폰이 등록되지 않았습니다.');</script>");
			out.flush();
		}
	}
	
	@RequestMapping(value="/coupon_update1")
	public void coupon_update1(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String coupon_id = new String(request.getParameter("coupon_id").getBytes("ISO-8859-1"),"UTF-8");
		String coupon_name = new String(request.getParameter("coupon_name").getBytes("ISO-8859-1"),"UTF-8");
		String product_main_category = new String(request.getParameter("product_main_category").getBytes("ISO-8859-1"),"UTF-8");
		String discount = new String(request.getParameter("discount").getBytes("ISO-8859-1"),"UTF-8");
		
		OtherVO vo = new OtherVO();
		vo.setCoupon_id(coupon_id);
		vo.setCoupon_name(coupon_name);
		vo.setProduct_main_category(product_main_category);
		vo.setDiscount(discount);
		
		int update = otherservice.coupon_update(vo);
		if(update==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('쿠폰이 수정되었습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('쿠폰이 수정되지 않았습니다.');</script>");
			out.flush();
		}
	}
	
	@RequestMapping(value="/coupon_update")
	public String coupon_update(HttpServletRequest request, Model model) throws Exception{
		String result = "coupon/coupon_update";
		String coupon_id = request.getParameter("coupon_id");
		OtherVO vo = new OtherVO();
		vo.setCoupon_id(coupon_id);
		List<OtherVO> list1 = otherservice.other_select_coupon(vo);
		List<OtherVO> list = otherservice.other_coupon_category();
		model.addAttribute("list",list);
		model.addAttribute("list1",list1);
		model.addAttribute("sel_category",list1.get(0).getProduct_main_category());
		return result;
	}
	
	@RequestMapping(value="/coupon_user",produces = "application/text; charset=utf8")
	@ResponseBody
	public String coupon_user(HttpServletRequest request, Model model) throws Exception{
		String result = "";
		String level_id = request.getParameter("level_id");
		String user_job = request.getParameter("user_job");
		String user_name = request.getParameter("user_name");
		UserVO vo = new UserVO();
		
		vo.setLevel_id(level_id);
		vo.setUser_job(user_job);
		vo.setUser_name(user_name);
		
		List<UserVO> list = otherservice.other_user(vo);
		result += "<tr>";
		result += "<th><input type=\"checkbox\" name=\"check_all\" id=\"checkall\" onclick=\"javascript:checkallselect(document.coupon_mail_send.user_id);\">";
		result += "<th>고객ID";
		result += "<th>고객명";
		for(int i=0; i<list.size();i++) {
			result += "<tr>";
			result += "<td><input type=\"checkbox\" name=\"user_id\" value="+list.get(i).getUser_id()+">";
			result += "<td>"+list.get(i).getUser_id();
			result += "<td>"+list.get(i).getUser_name();
		}
		
		return result;
	}
	
	@RequestMapping(value="/coupon_mail_send")
	public void coupon_mail_send(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		String[] coupon_id = request.getParameterValues("coupon_id");
		String mail_category = "coupon";
		String[] user_id = request.getParameterValues("user_id");
		String[] coupon_name = otherservice.coupon_name(coupon_id);
		String[] user_email = otherservice.user_email(user_id);
		
		int mail_insert=0;
		
		try {
			for(int i=0;i<user_email.length;i++) {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("ohk3726@gmail.com");
				messageHelper.setTo(user_email[i]);
				messageHelper.setSubject(title);
				String coupon_temp="";
				for(int j=0;j<coupon_name.length;j++) {					
					coupon_temp += coupon_name[j]+"\n";
				}
				messageHelper.setText(content + "\n발급 쿠폰 : \n"+coupon_temp);
				
				
				mailSender.send(message);
				
				MailVO vo = new MailVO();
				vo.setUser_id(user_id[i]);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setMail_category(mail_category);
				
				mail_insert += otherservice.coupon_mail_insert(vo);
				
				for(int j=0;j<coupon_id.length;j++) {
					String coupon_issued_id = otherservice.coupon_issued_id();
					CouponVO vo1 = new CouponVO();
					vo1.setCoupon_id(coupon_id[j]);
					vo1.setUser_id(user_id[i]);
					vo1.setCoupon_issued_id(coupon_issued_id);
					
					otherservice.coupon_issued_insert(vo1);
				}
				
			}
			
			if(mail_insert == user_email.length) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('성공적으로 메일을 보냈습니다.');window.location.href='/crm/other'</script>");
				out.flush();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		
	}
}
