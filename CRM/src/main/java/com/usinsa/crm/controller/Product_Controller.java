package com.usinsa.crm.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usinsa.crm.service.Order_Service;
import com.usinsa.crm.service.Product_Service;
import com.usinsa.crm.service.User_Service;
import com.usinsa.crm.vo.LEVEL_TB_VO;
import com.usinsa.crm.vo.ORDER_TB_VO;
import com.usinsa.crm.vo.PRODUCT_TB_VO;

@Controller
public class Product_Controller {

	String product_list_level;
	@Resource(name = "Product_Service")
	private Product_Service productservice;

	@Resource(name = "Order_Service")
	private Order_Service orderservice;

	@Resource(name = "User_Service")
	private User_Service userservice;

	@RequestMapping(value = "Product_List")
	public String Productlist(Model model) throws Exception {
		List<PRODUCT_TB_VO> list = productservice.ProductList();
		model.addAttribute("list", list);

		return "product/Product_List";
	}

	@RequestMapping(value = "product_info", method = RequestMethod.GET)
	public String Product_info(Model model, HttpServletRequest request) throws Exception {

		PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
		vo.setPRODUCT_ID(request.getParameter("product_id"));
		List<PRODUCT_TB_VO> list = productservice.ProductInfo(vo);
		model.addAttribute("list", list);

		ORDER_TB_VO vo_order = new ORDER_TB_VO();
		vo_order.setPRODUCT_ID(request.getParameter("product_id"));
		List<ORDER_TB_VO> list_2 = orderservice.product_order(vo_order);
		model.addAttribute("list_2", list_2);

		ORDER_TB_VO vo_customer = new ORDER_TB_VO();
		vo_customer.setPRODUCT_ID(request.getParameter("product_id"));
		List<ORDER_TB_VO> list_3 = orderservice.product_order_customer(vo_order);
		model.addAttribute("list_3", list_3);

		return "product/product_info";

	}

	@RequestMapping(value = "order_list_Sort_customer")
	public String order_list_Sort_customer(Model model, HttpServletRequest request) throws Exception {

		String sort = request.getParameter("selectCustomer");
		String product_id = request.getParameter("sort_product_id_cus");

		model.addAttribute("sort_customer", sort);
		ORDER_TB_VO vo_order = new ORDER_TB_VO();
		vo_order.setPRODUCT_ID(product_id);

		if (sort.equals("option_date_customer")) {
			List<ORDER_TB_VO> list_3 = orderservice.option_date_customer(vo_order);
			model.addAttribute("list_3", list_3);

			List<ORDER_TB_VO> list_2 = orderservice.product_order(vo_order);
			model.addAttribute("list_2", list_2);

			PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
			vo.setPRODUCT_ID(product_id);
			List<PRODUCT_TB_VO> list = productservice.ProductInfo(vo);
			model.addAttribute("list", list);

		} else if (sort.equals("option_state_name")) {
			List<ORDER_TB_VO> list_3 = orderservice.option_state_name(vo_order);
			model.addAttribute("list_3", list_3);

			List<ORDER_TB_VO> list_2 = orderservice.product_order(vo_order);
			model.addAttribute("list_2", list_2);

			PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
			vo.setPRODUCT_ID(product_id);
			List<PRODUCT_TB_VO> list = productservice.ProductInfo(vo);
			model.addAttribute("list", list);
		}

		return "product/product_info";
	}

	@RequestMapping(value = "order_list_Sort")
	public String order_list_Sort(Model model, HttpServletRequest request) throws Exception {
		String sort = request.getParameter("selectCompany");
		String product_id = request.getParameter("sort_product_id");

		model.addAttribute("sort", sort);
		ORDER_TB_VO vo_order = new ORDER_TB_VO();
		vo_order.setPRODUCT_ID(product_id);

		if (sort.equals("option_date")) {
			List<ORDER_TB_VO> list_2 = orderservice.option_date(vo_order);
			model.addAttribute("list_2", list_2);

			PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
			vo.setPRODUCT_ID(product_id);
			List<PRODUCT_TB_VO> list = productservice.ProductInfo(vo);
			model.addAttribute("list", list);

			List<ORDER_TB_VO> list_3 = orderservice.option_date_customer(vo_order);
			model.addAttribute("list_3", list_3);

		} else if (sort.equals("option_state")) {
			List<ORDER_TB_VO> list_2 = orderservice.option_check(vo_order);
			model.addAttribute("list_2", list_2);

			PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
			vo.setPRODUCT_ID(product_id);
			List<PRODUCT_TB_VO> list = productservice.ProductInfo(vo);
			model.addAttribute("list", list);

			List<ORDER_TB_VO> list_3 = orderservice.option_date_customer(vo_order);
			model.addAttribute("list_3", list_3);
		}

		return "product/product_info";
	}

	@RequestMapping(value = "product_info_insert")
	public String Product_Info_Insert() throws Exception {

		return "product/product_info_insert";
	}

	@RequestMapping(value = "product_layer")
	public String product_layer(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<ORDER_TB_VO> list = orderservice.product_category();
		model.addAttribute("list", list);

		List<LEVEL_TB_VO> list_3 = userservice.Level_List();
		model.addAttribute("list_3", list_3);

		return "product/product_layer";
	}

	@RequestMapping(value = "select_option_level")
	public String select_option_level(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		product_list_level = request.getParameter("selectLevel_hi");
		String sort = request.getParameter("selectLevel_hi");
		model.addAttribute("selectLevel_hi", sort);
		List<ORDER_TB_VO> list = orderservice.product_category();
		model.addAttribute("list", list);

		List<LEVEL_TB_VO> list_3 = userservice.Level_List();
		model.addAttribute("list_3", list_3);

		LEVEL_TB_VO vo = new LEVEL_TB_VO();
		vo.setLEVEL_ID(sort);
		if (sort.equals("dia")) {

			List<ORDER_TB_VO> list_dia = orderservice.selet_dia(vo);
			model.addAttribute("list_2", list_dia);

		} else if (sort.equals("gold")) {
			List<ORDER_TB_VO> list_gold = orderservice.selet_dia(vo);
			model.addAttribute("list_2", list_gold);

		} else if (sort.equals("platinum")) {
			List<ORDER_TB_VO> list_platinum = orderservice.selet_dia(vo);
			model.addAttribute("list_2", list_platinum);
		}

		return "product/product_layer";
	}

	@RequestMapping(value = "product_category_sort")
	public String product_category(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String sort = request.getParameter("select_cate");
		model.addAttribute("sort", sort);
		List<LEVEL_TB_VO> list_3 = userservice.Level_List();
		model.addAttribute("list_3", list_3);

		if (sort.equals("option_product_name")) {
			List<ORDER_TB_VO> list = orderservice.option_product_name();
			model.addAttribute("list", list);

		} else if (sort.equals("option_product_cnt")) {
			List<ORDER_TB_VO> list = orderservice.option_product_cnt();
			model.addAttribute("list", list);

		} else if (sort.equals("option_product_price")) {
			List<ORDER_TB_VO> list = orderservice.option_product_price();
			model.addAttribute("list", list);
		}

		return "product/product_layer";
	}

	@RequestMapping(value = "modify")
	public String Product_Modify(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String PRODUCT_ID = new String(request.getParameter("PRODUCT_ID").getBytes("ISO-8859-1"),"UTF-8");
		String PRODUCT_NAME = new String(request.getParameter("PRODUCT_NAME").getBytes("ISO-8859-1"),"UTF-8");
		String PRODUCT_SIZE = new String(request.getParameter("PRODUCT_SIZE").getBytes("ISO-8859-1"),"UTF-8");
		String PRODUCT_CNT = new String(request.getParameter("PRODUCT_CNT").getBytes("ISO-8859-1"),"UTF-8");
		PRODUCT_CNT = PRODUCT_CNT.replaceAll(",", "");
		String PRODUCT_WEARING_PRICE = new String(request.getParameter("PRODUCT_WEARING_PRICE").getBytes("ISO-8859-1"),"UTF-8");
		PRODUCT_WEARING_PRICE = PRODUCT_WEARING_PRICE.replaceAll(",", "");
		String PRODUCT_PRICE = new String(request.getParameter("PRODUCT_PRICE").getBytes("ISO-8859-1"),"UTF-8");
		PRODUCT_PRICE = PRODUCT_PRICE.replaceAll(",", "");
		String PRODUCT_MAIN_CATEGORY = new String(request.getParameter("PRODUCT_MAIN_CATEGORY").getBytes("ISO-8859-1"),"UTF-8");
		String PRODUCT_SUB_CATEGORY = new String(request.getParameter("PRODUCT_SUB_CATEGORY").getBytes("ISO-8859-1"),"UTF-8");
		String PRODUCT_SSUB_CATEGORY = new String(request.getParameter("PRODUCT_SSUB_CATEGORY").getBytes("ISO-8859-1"),"UTF-8");

		PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
		vo.setPRODUCT_ID(PRODUCT_ID);
		vo.setPRODUCT_NAME(PRODUCT_NAME);
		vo.setPRODUCT_SIZE(PRODUCT_SIZE);
		vo.setPRODUCT_CNT(PRODUCT_CNT);
		vo.setPRODUCT_PRICE(PRODUCT_PRICE);
		vo.setPRODUCT_WEARING_PRICE(PRODUCT_WEARING_PRICE);
		vo.setPRODUCT_MAIN_CATEGORY(PRODUCT_MAIN_CATEGORY);
		vo.setPRODUCT_SUB_CATEGORY(PRODUCT_SUB_CATEGORY);
		vo.setPRODUCT_SSUB_CATEGORY(PRODUCT_SSUB_CATEGORY);

		int PRODUCT_MODY = productservice.Product_Update(vo);

		if (PRODUCT_MODY == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('수정이 완료되었습니다.');opener.location.reload();window.close();</script>");
			out.flush();
		}

		return "product/product_info";
	}

	@RequestMapping(value = "product_search")
	public String Product_search(HttpServletRequest request, Model model) throws Exception {
		String option = new String(request.getParameter("selectCompany").getBytes("ISO-8859-1"),"UTF-8");
		String search_text = new String(request.getParameter("product_search_text").getBytes("ISO-8859-1"),"UTF-8");

		model.addAttribute("option", option);
		PRODUCT_TB_VO vo = new PRODUCT_TB_VO();

		if (option.equals("option_product_name")) {
			vo.setPRODUCT_NAME(search_text);
			List<PRODUCT_TB_VO> list = productservice.Product_Search_Name(vo);
			model.addAttribute("list", list);

		} else if (option.equals("option_product_id")) {
			vo.setPRODUCT_ID(search_text);
			List<PRODUCT_TB_VO> list = productservice.Product_Search_Id(vo);
			model.addAttribute("list", list);

		} else if (option.equals("option_product_size")) {
			vo.setPRODUCT_SIZE(search_text);
			List<PRODUCT_TB_VO> list = productservice.Product_Search_Size(vo);

			model.addAttribute("list", list);
		}

		return "product/Product_List";
	}
	
	@RequestMapping(value = "product_search_1")
	public String Product_search_1(HttpServletRequest request, Model model) throws Exception {
		String option = new String(request.getParameter("selectCompany_1").getBytes("ISO-8859-1"),"UTF-8");
		String search_text = new String(request.getParameter("product_search_text").getBytes("ISO-8859-1"),"UTF-8");

		model.addAttribute("option", option);
		PRODUCT_TB_VO vo = new PRODUCT_TB_VO();

		if (option.equals("option_product_name")) {
			vo.setPRODUCT_NAME(search_text);
			List<PRODUCT_TB_VO> list = productservice.Product_Search_Name(vo);
			model.addAttribute("list", list);

		} else if (option.equals("option_product_id")) {
			vo.setPRODUCT_ID(search_text);
			List<PRODUCT_TB_VO> list = productservice.Product_Search_Id(vo);
			model.addAttribute("list", list);

		} else if (option.equals("option_product_size")) {
			vo.setPRODUCT_SIZE(search_text);
			List<PRODUCT_TB_VO> list = productservice.Product_Search_Size(vo);

			model.addAttribute("list", list);
		}

		return "product/Product_List";
	}

	@RequestMapping(value = "product_insert")
	public String Product_Insert(HttpServletRequest request, Model mdoel, HttpServletResponse response)
			throws Exception {
		try {
			String PRODUCT_ID = new String(request.getParameter("PRODUCT_ID_").getBytes("ISO-8859-1"),"UTF-8");

			PRODUCT_TB_VO vo_1 = new PRODUCT_TB_VO();
			vo_1.setPRODUCT_ID(PRODUCT_ID);
			int result = productservice.Product_SameId(vo_1);
			if (result != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('중복된 제품ID입니다.');</script>");
				out.flush();
			}

			String PRODUCT_NAME = new String(request.getParameter("PRODUCT_NAME").getBytes("ISO-8859-1"),"UTF-8");
			String PRODUCT_SIZE = new String(request.getParameter("PRODUCT_SIZE").getBytes("ISO-8859-1"),"UTF-8");
			String PRODUCT_CNT = new String(request.getParameter("PRODUCT_CNT").getBytes("ISO-8859-1"),"UTF-8");
			PRODUCT_CNT = PRODUCT_CNT.replaceAll(",", "");
			String PRODUCT_WEARING_PRICE = new String(request.getParameter("PRODUCT_WEARING_PRICE").getBytes("ISO-8859-1"),"UTF-8");
			PRODUCT_WEARING_PRICE = PRODUCT_WEARING_PRICE.replaceAll(",", "");
			String PRODUCT_PRICE = new String(request.getParameter("PRODUCT_PRICE").getBytes("ISO-8859-1"),"UTF-8");
			PRODUCT_PRICE = PRODUCT_PRICE.replaceAll(",", "");
			String PRODUCT_MAIN_CATEGORY = new String(request.getParameter("PRODUCT_MAIN_CATEGORY").getBytes("ISO-8859-1"),"UTF-8");
			String PRODUCT_SUB_CATEGORY = new String(request.getParameter("PRODUCT_SUB_CATEGORY").getBytes("ISO-8859-1"),"UTF-8");
			String PRODUCT_SSUB_CATEGORY = new String(request.getParameter("PRODUCT_SSUB_CATEGORY").getBytes("ISO-8859-1"),"UTF-8");

			PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
			vo.setPRODUCT_ID(PRODUCT_ID);

			vo.setPRODUCT_NAME(PRODUCT_NAME);
			vo.setPRODUCT_SIZE(PRODUCT_SIZE);
			vo.setPRODUCT_CNT(PRODUCT_CNT);
			vo.setPRODUCT_PRICE(PRODUCT_PRICE);
			vo.setPRODUCT_WEARING_PRICE(PRODUCT_WEARING_PRICE);
			vo.setPRODUCT_MAIN_CATEGORY(PRODUCT_MAIN_CATEGORY);
			vo.setPRODUCT_SUB_CATEGORY(PRODUCT_SUB_CATEGORY);
			vo.setPRODUCT_SSUB_CATEGORY(PRODUCT_SSUB_CATEGORY);

			int PRODUCT_MODY = productservice.Product_Insert(vo);

			if (PRODUCT_MODY == 1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('제품이 등록되었습니다.');opener.location.reload();window.close();</script>");
				out.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('제품 등록의 문제가 발생하여 등록되지 않았습니다.');</script>");
			out.flush();
		}
		return "product/product_info_insert";

	}

	@RequestMapping(value = "product_sameid/{product_id}")
	@ResponseBody
	public int Product_sameid(@PathVariable String product_id, HttpServletRequest request) throws Exception {

		PRODUCT_TB_VO vo = new PRODUCT_TB_VO();
		vo.setPRODUCT_ID(product_id);
		int result = productservice.Product_SameId(vo);

		return result;
	}

	// ���� ��ǰ
	@RequestMapping(value = "Linked_Products")
	public String Linked_Products(HttpServletRequest request, Model model, HttpServletResponse response)
			throws Exception {

		String PRODUCT_ID = request.getParameter("product_nam");

		PRODUCT_TB_VO vo_ = new PRODUCT_TB_VO();
		vo_.setPRODUCT_ID(PRODUCT_ID);
		String Product_sub_category = productservice.product_sub_category(vo_);

		vo_.setPRODUCT_SUB_CATEGORY(Product_sub_category);

		List<PRODUCT_TB_VO> list = productservice.Linked_Products(vo_);
		model.addAttribute("Linked_Products", list);
//========================================

		String sort = product_list_level;
		model.addAttribute("selectLevel_hi", sort);
		List<ORDER_TB_VO> list_2 = orderservice.product_category();
		model.addAttribute("list", list_2);

		List<LEVEL_TB_VO> list_3 = userservice.Level_List();
		model.addAttribute("list_3", list_3);

		LEVEL_TB_VO vo = new LEVEL_TB_VO();
		vo.setLEVEL_ID(sort);
		if (sort.equals("dia")) {

			List<ORDER_TB_VO> list_dia = orderservice.selet_dia(vo);
			model.addAttribute("list_2", list_dia);

		} else if (sort.equals("gold")) {
			List<ORDER_TB_VO> list_gold = orderservice.selet_dia(vo);
			model.addAttribute("list_2", list_gold);

		} else if (sort.equals("platinum")) {
			List<ORDER_TB_VO> list_platinum = orderservice.selet_dia(vo);
			model.addAttribute("list_2", list_platinum);
		}

		return "product/product_layer";

	}

}