package com.usinsa.crm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usinsa.crm.service.LevelService;
import com.usinsa.crm.service.UserService;
import com.usinsa.crm.vo.LevelVO;

@Controller
public class LevelController {
	@Resource(name="LevelService") 
	private LevelService levelservice;
	
	@Resource(name = "UserService")
	private UserService userservice;
	
	@RequestMapping(value="/level_issued")
	public String level_issued(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
		String result = "level/level_issued";
		
		String level_id = "dia";
		LevelVO vo =  new LevelVO();
		vo.setLevel_id(level_id);
		
		List<LevelVO> list = levelservice.level_order(vo);
		List<LevelVO> list1 = levelservice.level_down_list();
		List<LevelVO> list2 = levelservice.level_down_expected_list();
		List<LevelVO> list3 = userservice.level();
		model.addAttribute("list",list);
		model.addAttribute("list1",list1);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		
		return result;
	}
	
	@RequestMapping(value="Level_order",produces = "application/text; charset=utf8")
	@ResponseBody
	public String Level_order(HttpServletRequest request, Model model) throws Exception{
		String result="level/Level_order";
		String level_id=request.getParameter("level_id");
		LevelVO vo =  new LevelVO();
		vo.setLevel_id(level_id);
		
		List<LevelVO> list = levelservice.level_order(vo);
		result +="<tr>";
		result +="<th>이름";
		result +="<th>달성금액";
		for(int i=0; i<list.size();i++) {
			result += "<tr onclick=\"javascript:user_detail('"+list.get(i).getUser_id()+"');\">";
			result += "<td>"+list.get(i).getUser_name();
			result += "<td>"+list.get(i).getOrder_price();
		}
		
		return result;
	}
}
