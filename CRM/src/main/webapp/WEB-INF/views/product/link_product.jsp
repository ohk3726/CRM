<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>연계 제품</h2>
<div class="listReply">
	<form id="Linked_Products" method="POST" action="Linked_Products">
		<table id="basic" cellspacing="0" cellpadding="0">
			<tr>
				<th>제품ID
				<th>제품명
				<th>매출 
			<c:forEach var="item" items="${Linked_Products}">
				<tr>
					<td>${item.PRODUCT_ID}
					<td>${item.PRODUCT_NAME}
					<td>${item.ORDER_PRICE}
			</c:forEach>
		</table>
	</form>
</div>
	
    