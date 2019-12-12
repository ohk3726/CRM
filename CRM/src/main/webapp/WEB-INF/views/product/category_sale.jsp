<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>카테고리별 매출 순위</h2>
<form id=product_category_sort method="POST" action="product_category_sort">
	<select name="select_category" id="select_category" onchange="javascript:changeSelect()">
		<option value="all">정렬 선택하기</option>
		<option value="option_product_name" id="option_product_name" <c:if test="${sort=='option_product_name'}"> selected </c:if>>제품명</option>
		<option value="option_product_cnt" id="option_product_cnt" <c:if test="${sort=='option_product_cnt'}"> selected </c:if>>제품 수량</option>
		<option value="option_product_price" id="option_product_price" <c:if test="${sort=='option_product_price'}"> selected </c:if>>매출</option>
	</select> 
	<input type="hidden" name="select_cate" id="select_cate">
</form>
<form id="product_category" method="POST" action="product_category">
	<table id="basic" cellspacing="0" cellpadding="0">
		<tr>
			<th>제품명
			<th>제품 수량
			<th>매출
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.PRODUCT_NAME}
				<td>${item.ORDER_PRODUCT_CNT}
				<td>${item.ORDER_PRICE}		
		</c:forEach>
	</table>
</form>