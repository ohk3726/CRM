<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function coupon_insert(){
		window.open("/crm/coupon_insert","쿠폰 등록", "width=650px,height=630px");
	}
	
	function coupon_update(coupon_id){
    	window.open("/crm/coupon_update?coupon_id="+coupon_id,"쿠폰 수정", "width=650px,height=630px");
	}
</script>
<table style="width:100%">
	<tr>
		<td><h1>쿠폰 관리</h1>
		<td style="text-align:right"><button type="button" onclick="javasctip:coupon_insert();" style="display:inline-block;">쿠폰등록</button>
	<tr>
		<td colspan=2>
		<div style="height:600px;overflow:auto;">
			<table id="basic" style="width:100%;">
				<tr>
					<th>선택
					<th>쿠폰명
					<th>할인율
					<th>수정
				<c:forEach var="item" items="${list}">
					<tr>
						<td><input type="checkbox" name="coupon_id" id="coupon_id" value="${item.coupon_id}">
						<td>${item.coupon_name}
						<td>${item.discount}%
						<td><button type="button" onclick="javasctip:coupon_update('${item.coupon_id}');" style="display:inline-block;">쿠폰수정</button>
				</c:forEach>
			</table>
		</div>		
</table>