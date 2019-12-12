<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<script>
	function insert(){
		var sel1 = document.getElementById("sel_category");
		document.getElementById("product_main_category").value = sel1.options[sel1.selectedIndex].value;
		
		if(document.getElementById("discount").value >= 1 && document.getElementById("discount").value < 100){
			document.getElementById("coupon_insert").submit();
		}
		else{
			alert("올바른 할인율이 아닙니다.");
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain">
			<form action="coupon_insert1" method="post" id="coupon_insert">
				<input type="hidden" name="product_main_category" id="product_main_category">
				<table id="basic">
					<tr>
						<th>쿠폰명
						<td><input type="text" name="coupon_name" >
					<tr>
						<th>할인품목
						<td>
							<select id="sel_category">
								<c:forEach var="item" items="${list}">
									<option value="${item.product_main_category}">${item.product_main_category}</option>
								</c:forEach>
							</select>
					<tr>
						<th>할인율
						<td><input type="text" name="discount" id="discount" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="2">
				</table>
			</form>
		<button onclick="javascript:insert();">저장</button>
		</div>
	</div>
</body>
</html>