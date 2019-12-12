package com.usinsa.crm.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usinsa.crm.service.UserService;
import com.usinsa.crm.vo.AnniversaryVO;
import com.usinsa.crm.vo.BasketVO;
import com.usinsa.crm.vo.ConsultingVO;
import com.usinsa.crm.vo.CouponVO;
import com.usinsa.crm.vo.LevelVO;
import com.usinsa.crm.vo.MailVO;
import com.usinsa.crm.vo.OrderVO;
import com.usinsa.crm.vo.SizeVO;
import com.usinsa.crm.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Resource(name = "UserService")
	private UserService userservice;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/user")
	public String user(HttpServletRequest request, Model model) throws Exception{
		String result = "user/user";
		
		List<UserVO> list = userservice.selectuser();
		List<UserVO> list1 = userservice.job_list();
		model.addAttribute("list",list);
		model.addAttribute("list1",list1);
		
		return result;
	}
	
	@RequestMapping(value="/user_search")
	public String user_search(HttpServletRequest request, Model model) throws Exception{
		String result = "user/user_search";
		String keyword = new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"UTF-8");
		String search_select = new String(request.getParameter("search_select").getBytes("ISO-8859-1"),"UTF-8");
		UserVO vo = new UserVO();
		
		String user_job = new String(request.getParameter("user_job").getBytes("ISO-8859-1"),"UTF-8"); 
		vo.setUser_job(user_job);
		
		if(!keyword.equals("")) {
			if(search_select.equals("user_name")) {
				vo.setUser_name(keyword);
				//List<UserVO> list = userservice.searchusername(vo);
				List<UserVO> list = userservice.search_user(vo);
				logger.info(list.toString());
				model.addAttribute("list",list);
			}
			else if(search_select.equals("user_phone")) {
				vo.setUser_phone(keyword);
				//List<UserVO> list = userservice.searchuserphone(vo);
				List<UserVO> list = userservice.search_user(vo);
				logger.info(list.toString());
				model.addAttribute("list",list);
			}
		}
		else {
			vo.setUser_job(user_job);
			List<UserVO> list = userservice.search_user(vo);
			model.addAttribute("list",list);
		}
		List<UserVO> list1 = userservice.job_list();
		model.addAttribute("list1",list1);
		model.addAttribute("keyword",keyword);
		model.addAttribute("search_select",search_select);
		model.addAttribute("user_job",user_job);
		
		return result;
	}
	
	@RequestMapping(value="/user_search_1",produces = "application/text; charset=utf8")
	public String user_search_1(HttpServletRequest request, Model model) throws Exception{
		String result = "user/user_search";
		String keyword = new String(request.getParameter("keyword_1").getBytes("ISO-8859-1"),"UTF-8");
		String search_select = new String(request.getParameter("search_select_1").getBytes("ISO-8859-1"),"UTF-8");
		UserVO vo = new UserVO();
		System.out.println(keyword);
		System.out.println(search_select);
		
		if(!keyword.equals("")) {
			if(search_select.equals("user_name")) {
				vo.setUser_name(keyword);
				//List<UserVO> list = userservice.searchusername(vo);
				List<UserVO> list = userservice.search_user(vo);
				logger.info(list.toString());
				model.addAttribute("list",list);
			}
			else if(search_select.equals("user_phone")) {
				vo.setUser_phone(keyword);
				//List<UserVO> list = userservice.searchuserphone(vo);
				List<UserVO> list = userservice.search_user(vo);
				logger.info(list.toString());
				model.addAttribute("list",list);
			}
		}
		else {
			List<UserVO> list = userservice.search_user(vo);
			model.addAttribute("list",list);
		}
		List<UserVO> list1 = userservice.job_list();
		model.addAttribute("list1",list1);
		model.addAttribute("keyword",keyword);
		model.addAttribute("search_select",search_select);
		
		return result;
	}
	
	@RequestMapping(value="/user_detail")
	public String user_detail(HttpServletRequest request, Model model) throws Exception{
		String result = "user/user_detail";
		
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);

		List<UserVO> list = userservice.userdetail(vo);
		List<LevelVO> list2 = userservice.level();
		List<UserVO> list3 = userservice.blacklist();
		String level_id = userservice.userlevel(vo);
		String black_list_yn = userservice.blacklistyn(vo);
		
		List<AnniversaryVO> list4 = userservice.selectanniversary(vo);
		
		List<ConsultingVO> list5 = userservice.selectconsulting(vo);
		
		List<OrderVO> list6 = userservice.selectorderlist(vo);
		List<CouponVO> list7 = userservice.usercouponlist(vo);
		List<MailVO> list8 = userservice.mail_list(vo);
		
		
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		model.addAttribute("level_id",level_id);
		model.addAttribute("black_list_yn",black_list_yn);
		model.addAttribute("list4",list4);
		model.addAttribute("list5",list5);
		model.addAttribute("list6",list6);
		model.addAttribute("list7",list7);
		model.addAttribute("list8",list8);
		
		return result;
	}
	
	@RequestMapping(value="/user_detail_update")
	public void user_detail_update(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		String user_pw = new String(request.getParameter("user_pw").getBytes("ISO-8859-1"),"UTF-8");
		String user_name = new String(request.getParameter("user_name").getBytes("ISO-8859-1"),"UTF-8");
		String user_adress = new String(request.getParameter("user_adress").getBytes("ISO-8859-1"),"UTF-8");
		String user_phone = new String(request.getParameter("user_phone").getBytes("ISO-8859-1"),"UTF-8");
		String user_job = new String(request.getParameter("user_job").getBytes("ISO-8859-1"),"UTF-8");
		String user_ssn = new String(request.getParameter("user_ssn").getBytes("ISO-8859-1"),"UTF-8");
		String level_id = new String(request.getParameter("level_id").getBytes("ISO-8859-1"),"UTF-8");
		String black_list_yn = new String(request.getParameter("black_list_yn").getBytes("ISO-8859-1"),"UTF-8");
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		vo.setUser_pw(user_pw);
		vo.setUser_name(user_name);
		vo.setUser_adress(user_adress);
		vo.setUser_phone(user_phone);
		vo.setUser_job(user_job);
		vo.setUser_ssn(user_ssn);
		vo.setLevel_id(level_id);
		vo.setBlack_list_yn(black_list_yn);
		vo.setEmail(email);
		
		int update = userservice.userupdate(vo);
		
		String result = "/crm/user_detail?user_id="+user_id;
		
		if(update==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('고객정보가 수정되었습니다.');window.location.href='"+result+"';</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('고객정보가 수정되지 않았습니다.');window.location.href='"+result+"';</script>");
			out.flush();
		}
		
	}
	
	@RequestMapping(value="/anniversary_update")
	public void anniversary_update(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_id = new String(request.getParameter("anniversary_id").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_name = new String(request.getParameter("anniversary_name").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_cycle = new String(request.getParameter("anniversary_cycle").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_date = new String(request.getParameter("anniversary_date").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_relation = new String(request.getParameter("anniversary_relation").getBytes("ISO-8859-1"),"UTF-8");

		AnniversaryVO vo = new AnniversaryVO();
		vo.setAnniversary_id(anniversary_id);
		vo.setUser_id(user_id);
		vo.setAnniversary_name(anniversary_name);
		vo.setAnniversary_cycle(anniversary_cycle);
		vo.setAnniversary_date(anniversary_date);
		vo.setAnniversary_relation(anniversary_relation);
		

		
		int update = userservice.anniversaryupdate(vo);
		
		if(update==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('기념일정보가 수정되었습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('기념일정보가 수정되지 않았습니다.');</script>");
			out.flush();
		}
		
	}
	
	@RequestMapping(value="/anniversary_new")
	public String anniversary_new(HttpServletRequest request, Model model) throws Exception{
		String result = "user/anniversary_new";
		String user_id = request.getParameter("user_id");
		
		model.addAttribute("user_id",user_id);
		return result;
	}
	
	@RequestMapping(value="/anniversary_new_insert")
	public void anniversary_new_insert(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_name = new String(request.getParameter("anniversary_name").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_cycle = new String(request.getParameter("anniversary_cycle").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_date = new String(request.getParameter("anniversary_date").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_relation = new String(request.getParameter("anniversary_relation").getBytes("ISO-8859-1"),"UTF-8");
		
		AnniversaryVO vo = new AnniversaryVO();
		vo.setUser_id(user_id);
		vo.setAnniversary_name(anniversary_name);
		vo.setAnniversary_cycle(anniversary_cycle);
		vo.setAnniversary_date(anniversary_date);
		vo.setAnniversary_relation(anniversary_relation);
		
		String anniversary_id = userservice.anniversary_id();
		vo.setAnniversary_id(anniversary_id);
		
		int insert = userservice.anniversaryinsert(vo);
		if(insert==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('기념일정보가 등록되었습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('기념일정보가 등록되지 않았습니다.');</script>");
			out.flush();
		}
	}
	
	@RequestMapping(value="/anniversary_update_page")
	public String anniversary_update_page(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String result = "user/anniversary_update_page";
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		String anniversary_id = request.getParameter("anniversary_id");
		
		AnniversaryVO vo = new AnniversaryVO();
		vo.setUser_id(user_id);
		vo.setAnniversary_id(anniversary_id);
		
		List<AnniversaryVO> list = userservice.anniversarylist(vo);
		model.addAttribute("list", list);
		
		return result;
	}
	
	@RequestMapping(value="/consulting_new")
	public String consulting_new(HttpServletRequest request, Model model) throws Exception{
		String result = "user/consulting_new";
		String user_id = request.getParameter("user_id");
		model.addAttribute("user_id", user_id);
		
		return result;
	}
	
	@RequestMapping(value="/consulting_new_insert")
	public void consulting_new_insert(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		String consultant = new String(request.getParameter("consultant").getBytes("ISO-8859-1"),"UTF-8");
		
		ConsultingVO vo = new ConsultingVO();
		vo.setUser_id(user_id);
		
		int consulting_id = userservice.consultingidcheck();
	
		vo.setConsulting_id(Integer.toString(consulting_id));
		vo.setContent(content);
		vo.setConsultant(consultant);

		
		int insert = userservice.consultinginsert(vo);
		if(insert==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상담내용이 등록되었습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상담내용이 등록되지 않았습니다.');</script>");
			out.flush();
		}
	}
	
	@RequestMapping(value="/consulting_update_page")
	public String consulting_update(HttpServletRequest request, Model model) throws Exception{
		String result = "user/consulting_update_page";
		
		String consulting_id = request.getParameter("consulting_id");
		List<ConsultingVO> list = userservice.selectconsultingid(consulting_id);
		
		model.addAttribute("list",list);
		
		return result;
	}
	
	@RequestMapping(value="/consulting_update")
	public void consulting_update(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		String consultant = new String(request.getParameter("consultant").getBytes("ISO-8859-1"),"UTF-8");
		String consulting_id = new String(request.getParameter("consulting_id").getBytes("ISO-8859-1"),"UTF-8");
		String state = new String(request.getParameter("state").getBytes("ISO-8859-1"),"UTF-8");
		
		ConsultingVO vo = new ConsultingVO();
		vo.setUser_id(user_id);
		vo.setContent(content);
		vo.setConsultant(consultant);
		vo.setConsulting_id(consulting_id);
		vo.setState(state);

		
		int update = userservice.consultingupdate(vo);
		
		if(update==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상담내용이 수정되었습니다.');opener.location.reload();window.close();;</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상담내용이 수정되지 않았습니다.');</script>");
			out.flush();
		}
		
	}
	
	@RequestMapping(value="/user_order_detail",produces = "application/text; charset=utf8")
	@ResponseBody
	public String user_order_detail(HttpServletRequest request, Model model) throws Exception{
		String result = "";
		String order_id = request.getParameter("order_id");
		
		OrderVO vo = new OrderVO();
		vo.setOrder_id(order_id);
		List<OrderVO> list = userservice.orderdetail(vo);
		
		result += "<tr>";
		result += "<th>주문ID";
		result += "<td><input type='text' name='order_id' value='"+list.get(0).getOrder_id()+"' readonly>";
		result += "<tr>";
		result += "<th>배송지";
		result += "<td><input type='text' name='order_adress' value='"+list.get(0).getOrder_adress()+"' maxlength='150'>";
		result += "<tr>";
		result += "<th>상태";
		result += "<td><input type='text' name='order_check' value='"+list.get(0).getOrder_check()+"' readonly>";
		result += "<tr>";
		result += "<th>반품유무";
		
		if(list.get(0).getOrder_return_yn().equals("y")) {
			result += "<td><select name='order_return_yn'><option value='y' selected='selected'>Y</option><option value='n'>N</option></select>";
		}
		else {
			result += "<td><select name='order_return_yn'><option value='y'>Y</option><option value='n' selected='selected'>N</option></select>";
		}
		result += "<tr>";
		result += "<th>수취인";
		result += "<td><input type='text' name='order_recipient' value='"+list.get(0).getOrder_recipient()+"' maxlength='10'>";
		result += "<tr>";
		result += "<th>연락처";
		result += "<td><input type='text' name='order_phone' value='"+list.get(0).getOrder_phone()+"' maxlength='20' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\">";
		result += "<tr>";
		result += "<th>배송메모";
		result += "<td><textarea name='order_memo' maxlength=\"150\" style=\"resize:none;width:400px;height:200px;\">"+list.get(0).getOrder_memo()+"</textarea>";
		return result;
	}
	
	@RequestMapping(value="/order_detail_update")
	public void order_detail_update(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String order_id = new String(request.getParameter("order_id").getBytes("ISO-8859-1"),"UTF-8");
		String order_adress = new String(request.getParameter("order_adress").getBytes("ISO-8859-1"),"UTF-8");
		String order_check = new String(request.getParameter("order_check").getBytes("ISO-8859-1"),"UTF-8");
		String order_phone = new String(request.getParameter("order_phone").getBytes("ISO-8859-1"),"UTF-8");
		String order_memo = new String(request.getParameter("order_memo").getBytes("ISO-8859-1"),"UTF-8");
		String order_return_yn = new String(request.getParameter("order_return_yn").getBytes("ISO-8859-1"),"UTF-8");
		String order_recipient = new String(request.getParameter("order_recipient").getBytes("ISO-8859-1"),"UTF-8");
		
		OrderVO vo = new OrderVO();
		vo.setOrder_id(order_id);
		vo.setOrder_adress(order_adress);
		vo.setOrder_check(order_check);
		vo.setOrder_phone(order_phone);
		vo.setOrder_memo(order_memo);
		vo.setOrder_recipient(order_recipient);
		vo.setOrder_return_yn(order_return_yn);
		
		List<OrderVO> list = userservice.orderdetail(vo);

		
		int update = userservice.orderupdate(vo);
		
		if(update==1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('구매제품내용이 수정되었습니다.');window.location.href='/crm/user_detail?user_id="+list.get(0).getUser_id()+"';</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('구매제품내용이 수정되지 않았습니다.');</script>");
			out.flush();
		}
		
	}
	
	@RequestMapping(value="/user_issued")
	public String user_issued(HttpServletRequest request, Model model) throws Exception{
		String result = "user/user_issued";
		List<UserVO> list = userservice.new_user_list();
		List<BasketVO>list2 = userservice.basket_user_list();
		List<SizeVO>list0 = userservice.product_category_list();
		List<AnniversaryVO> list4 = userservice.anniversary_issued_list();
		List<UserVO> list5 = userservice.issued_blacklist();
		
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		model.addAttribute("list0",list0);
		model.addAttribute("list4",list4);
		model.addAttribute("list5",list5);
		
		return result;
	}
	
	@RequestMapping(value="/size_issued",produces = "application/text; charset=utf8")
	@ResponseBody
	public String size_issued(HttpServletRequest request, Model model) throws Exception{
		String result = "";
		String product_main_category = request.getParameter("product_main_category");
		
		SizeVO vo = new SizeVO();
		vo.setProduct_main_category(product_main_category);
		
		List<SizeVO> list3 = userservice.size_issued(vo);		
		
		result += "<tr>";
		result += "<th>이름";
		result += "<th>카테고리";
		result += "<th>기존사이즈";
		result += "<th>변경사이즈";
		result += "<th>메일발송";
		result += "</tr>";
		for(int i=0;i<list3.size();i++) {
			result += "<tr onclick=\"javascript:size_user_list_click('"+list3.get(i).getUser_id()+"','"+list3.get(i).getOrder_id()+"');\">";
			result += "<td>";
			result += list3.get(i).getUser_name();
			result += "<td>";
			result += list3.get(i).getProduct_main_category();
			result += "<td>";
			result += list3.get(i).getOrder_size_before();
			result += "<td>";
			result += list3.get(i).getOrder_size_after();
			result += "<td>";
			result += list3.get(i).getMail_reg_date();
		}
		
		return result;
	}
	
	@RequestMapping(value="/mail")
	public String mail(HttpServletRequest request, Model model) throws Exception{
		String result = "user/mail";
		String mail_category = request.getParameter("mail_category");
		String user_id = request.getParameter("user_id");
		String order_id = request.getParameter("order_id");
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		
		List<UserVO> list = userservice.userdetail(vo);
		model.addAttribute("list",list);
		model.addAttribute("mail_category",mail_category);
		model.addAttribute("user_id",user_id);
		model.addAttribute("order_id",order_id);
		return result;
	}
	
	@RequestMapping(value="/mail_send")
	public void mail_send(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		String order_id = request.getParameter("order_id");
		String user_id = request.getParameter("user_id");
		String mail_category = request.getParameter("mail_category");
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom("ohk3726@gmail.com");
			messageHelper.setTo(email);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			
			mailSender.send(message);
			
			MailVO vo = new MailVO();
			vo.setOrder_id(order_id);
			vo.setUser_id(user_id);
			vo.setContent(content);
			vo.setTitle(title);
			vo.setMail_category(mail_category);
			
			int mail_insert = userservice.mail_insert(vo);
			if(mail_insert == 1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('성공적으로 메일을 보냈습니다.');opener.location.reload();window.close();</script>");
				out.flush();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			
		}
		
	}
	@RequestMapping(value="/new_user")
	public String new_user(HttpServletRequest request, Model model) throws Exception{
		String result = "user/new_user";
		
		return result;
	}
	
	@RequestMapping(value="/new_user_check")
	@ResponseBody
	public String new_user_check(HttpServletRequest request, Model model) throws Exception{
		String result = "";
		String user_id = new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8");
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		int check = userservice.user_check(vo);
		result = Integer.toString(check);
		return result;
	}
	
	@RequestMapping(value="/new_user_insert")
	public void new_user_insert(HttpServletRequest request, Model model, HttpServletResponse response) throws Exception{
		String user_id = request.getParameter("user_id");
		String user_adress = new String(request.getParameter("user_adress").getBytes("ISO-8859-1"),"UTF-8");
		String user_check = request.getParameter("user_check");
		String user_pw = new String(request.getParameter("user_pw").getBytes("ISO-8859-1"),"UTF-8");
		String user_name = new String(request.getParameter("user_name").getBytes("ISO-8859-1"),"UTF-8");
		
		UserVO vo = new UserVO();
		vo.setUser_pw(user_pw);
		vo.setUser_id(user_id);
		vo.setUser_name(user_name);
		vo.setUser_adress(user_adress);
		vo.setUser_check(user_check);
		
		int insert = userservice.new_user_insert(vo);
		
		if(insert == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('간편등록을 완료하였습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('간편 등록이 되지 않았습니다.');</script>");
			out.flush();
		}
	}
}
