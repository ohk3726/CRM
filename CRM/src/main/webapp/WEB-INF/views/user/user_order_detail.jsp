<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function order_detail_update(){
		document.getElementById("order_detail_update").submit();
	}
</script>
<table style="width:100%;">
	<tr>
		<td><h1 style="text-align:left;">구매 제품 상세 내역</h1>
		<td style="text-align:right"><button onclick="javascript:order_detail_update();" id="order_detail_update_button" style="display:none">수정하기</button>
	<tr>
		<td colspan=2>
		<form action='order_detail_update' method="post" id="order_detail_update">
			<table id="basic" class="order_detail" style="width:100%">
				
			</table>
		</form>
</table>