<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="text-align:left;">쿠폰 내역</h1>
<div style="height:300px;overflow:auto;">
	<table style="width:100%;" id="basic">
		<tr>
			<th>발급ID
			<th>쿠폰명
			<th>사용유무
			<th>날짜
		</tr>
		<c:forEach var="item7" items="${list7}">
			<tr>
				<input type="hidden" name="user_id" value="${item7.user_id}">		
				<td>${item7.coupon_issued_id}
				<td>${item7.coupon_name}
				<td>${item7.coupon_yn}
				<td>${item7.reg_date}
			</tr>
		</c:forEach>
	</table>
</div>