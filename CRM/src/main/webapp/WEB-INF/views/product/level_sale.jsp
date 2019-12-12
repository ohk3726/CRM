<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>등급별 판매 현황</h2>
<form id="select_option_level" method="POST" action="select_option_level">
	<select name="selectLevel" id="selectLevel" onchange="javascript:changeLevel()">
		<option>정렬 선택하기</option>
		<c:forEach var="list_3" items="${list_3}">
			<option value="${list_3.LEVEL_ID}" id="${list_3.LEVEL_ID}" <c:if test="${selectLevel_hi==list_3.LEVEL_ID}"> selected </c:if>>${list_3.LEVEL_NAME}</option>
		</c:forEach>
	</select> <input type="hidden" id="selectLevel_hi" name="selectLevel_hi">
</form>
<form id="product_category_level_" method="POST" action="Linked_Products">
	<table id="basic" cellspacing="0" cellpadding="0">
		<tr>
			<input type="hidden" id="product_nam" name="product_nam">
			<th>제품ID	
			<th>제품명
			<th>매출 
		<c:forEach var="item" items="${list_2}">
			<tr onclick="javascript:category_click('${item.PRODUCT_ID}')">
				<td>${item.PRODUCT_ID}
				<td>${item.PRODUCT_NAME}
				<td>${item.ORDER_PRICE}
		</c:forEach>
	</table>
</form>