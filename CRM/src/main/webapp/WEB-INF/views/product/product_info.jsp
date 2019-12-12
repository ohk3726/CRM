<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<script>
	function inNumber(){
	  if(event.keyCode<48 || event.keyCode>57){
	     event.returnValue=false;
	  }
	}
</script>
</head>
<body id="home">
<div id="main_contain" style="width:650px;height:100%;align:center;">
	<h2>제품상세</h2>
	<form id="modify" method="POST" action="modify">
		<table class="table" id="basic" style="width:100%">
			<c:forEach var="productInfo" items="${list}">
				<tr>
					<th>제품ID : <td><input type="text" name="PRODUCT_ID" id="PRODUCT_ID" value="${productInfo.PRODUCT_ID}" readonly>
				<tr>
					<th>제품이름 : <td><input type="text" name="PRODUCT_NAME" id="PRODUCT_NAME" value="${productInfo.PRODUCT_NAME}" maxlength="30">
				<tr>
					<th>제품Size : <td><input type="text" name="PRODUCT_SIZE" id="PRODUCT_SIZE" value="${productInfo.PRODUCT_SIZE}" maxlength="10">
				<tr>
					<th>제품개수 : <td><input type="text" name="PRODUCT_CNT" id="PRODUCT_CNT" value="${productInfo.PRODUCT_CNT}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<tr>
					<th>입고가 : <td><input type="text" name="PRODUCT_WEARING_PRICE" id="PRODUCT_WEARING_PRICE" value="${productInfo.PRODUCT_WEARING_PRICE}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<tr>
					<th>판매가 : <td><input type="text" name="PRODUCT_PRICE" id="PRODUCT_PRICE" value="${productInfo.PRODUCT_PRICE}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<tr>
					<th>대분류 : <td><input type="text" name="PRODUCT_MAIN_CATEGORY" id="PRODUCT_MAIN_CATEGORY" value="${productInfo.PRODUCT_MAIN_CATEGORY}" maxlength="30">
				<tr>
					<th>중분류 : <td><input type="text" name="PRODUCT_SUB_CATEGORY" id="PRODUCT_SUB_CATEGORY" value="${productInfo.PRODUCT_SUB_CATEGORY}" maxlength="30">
				<tr>
					<th>소분류 : <td><input type="text" name="PRODUCT_SSUB_CATEGORY" id="PRODUCT_SSUB_CATEGORY" value="${productInfo.PRODUCT_SSUB_CATEGORY}" maxlength="30">
				
	
			</c:forEach>
		</table>
		<button id="btn_insert" name="btn_insert">저장</button>
	</form>
</div>
	
<div id="main_contain" style="width:650px;height:100%;align:center;">
	<H2>제품 판매 내역</H2> 	
	<form id="Select" method="POST" action="order_list_Sort">
		<select name="select_search_option" id="select_search_option" onchange="javascript:changeSelect()">
			<option value="option_date" id="option_date"  <c:if test="${sort=='option_date'}"> selected </c:if>> 날짜</option>
			<option value="option_state" id="option_state" <c:if test="${sort=='option_state'}"> selected </c:if>>배송 상태</option>
		</select>
		<input type="hidden" id="selectCompany" name="selectCompany">
		<input type="hidden" id="sort_product_id" name="sort_product_id">		
	</form>	
	<form id="product_order" method="POST" action="product_order">
		<table id="basic" style="width:100%">
			<tr>
				<th>고객 성함
				<th>제품수량
				<th>금액
				<th>날짜
				<th>상태
			<c:forEach var="list_2" items="${list_2}">
				<tr>
					<td>${list_2.USER_NAME}
					<td>${list_2.ORDER_PRODUCT_CNT}
					<td>${list_2.ORDER_PRICE}
					<td>${list_2.REG_DATE}
					<td>${list_2.ORDER_CHECK}
			</c:forEach>
		</table>
	</form>
</div>

<div id="main_contain" style="width:650px;height:100%;align:center;">
	<h2> 구매 회원내역</h2>
	<form id="order_list_Sort_customer" method="POST" action="order_list_Sort_customer">
		<select name="select_search_option_customer" id="select_search_option_customer" onchange="javascript:changeSelect_customer()">
			<option value="option_date_customer" id="option_date_customer" <c:if test="${sort_customer=='option_date_customer'}"> selected </c:if>>날짜</option>
			<option value="option_state_name" id="option_state_name" <c:if test="${sort_customer=='option_state_name'}"> selected </c:if>>이름순</option>
		</select>
		<input type="hidden" id="selectCustomer" name="selectCustomer">
		<input type="hidden" id="sort_product_id_cus" name="sort_product_id_cus">	
	</form>
	<form id="product_order_customer" method="POST" action="product_order_customer">
		<table id="basic" style="width:100%">
			<tr>
				<th>구매자
				<th>제품수량
				<th>구매일자
			<c:forEach var="list_3" items="${list_3}">
				<tr>
					<td>${list_3.USER_NAME}
					<td>${list_3.ORDER_PRODUCT_CNT}
					<td>${list_3.REG_DATE}
			</c:forEach>
		</table>
	</form>
</div>
<script>
	function changeSelect() {
		var sel = document.getElementById("select_search_option");
		document.getElementById("selectCompany").value = sel.options[sel.selectedIndex].value;
		document.getElementById("sort_product_id").value =document.getElementById("PRODUCT_ID").value
		document.getElementById("Select").submit();
	}

	function changeSelect_customer() {
		var sel_customer = document.getElementById("select_search_option_customer");
		document.getElementById("selectCustomer").value = sel_customer.options[sel_customer.selectedIndex].value;
		document.getElementById("sort_product_id_cus").value =document.getElementById("PRODUCT_ID").value
		document.getElementById("order_list_Sort_customer").submit();
	}
</script>
</body>
</html>