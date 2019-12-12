<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/css/jquery.tablesorter.min.js"/>"></script>
<script>
function click_productid(product_id) {
	var sal = product_id;
	var link = "product_info?product_id="+sal;
	window.open(link,'window','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=800,height=800,left=0, top=0, scrollbars=yes');return false	
}

function click_product_insert(){
	window.open("product_info_insert",'window','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=800,height=800,left=0, top=0, scrollbars=yes');return false
}

function changeSelect() {
	var sel = document.getElementById("selectCompany1");
	document.getElementById("selectCompany").value = sel.options[sel.selectedIndex].value;
	document.getElementById("product_search").submit();
}
$(document).ready(function(){ 
	$("#basic").tablesorter();
});
</script>
<style>
	#insert{
		position:absolute;
		top:120px;
		left:50px;
	}
</style>
</head>
<body>
	<div style="width:100%;text-align:right;">
		<button onclick="javascript:click_product_insert();" id="insert">제품등록</button>
		<br>
		<form id=product_search method="POST" action="product_search">
				<select name="selectCompany1" id="selectCompany1">
					<option value="option_product_name" id ="option_product_name" <c:if test="${option=='option_product_name'}"> selected </c:if>>제품명</option>
					<option value="option_product_id" id ="option_product_id" <c:if test="${option=='option_product_id'}"> selected </c:if>>제품ID</option>
					<option value="option_product_size" id ="option_product_size" <c:if test="${option=='option_product_size'}"> selected </c:if>>Size</option>		
				</select>
				<input type="hidden" name ="selectCompany" id="selectCompany">
				<input type="text" name="product_search_text" id="product_search_text" value=""/> 
				<input type="submit" value="검색" onclick="javascript:changeSelect()"><br>
			</form>
	</div>
	<div id="essential_contain" style="height:100%;height:700px">
		<div id="main_contain" style="height:100%;overflow:auto">
			<form id=productInfo method="POST" action="productInfo">
				<table id="basic" style="width:100%;" cellspacing="0" cellpadding="0" class="tablesorter">
					<thead>
						<tr>
							<th>제품ID
							<th>제품명
							<th>제품Size
							<th>제품수량
							<th>입고가격
							<th>제품 판매 가격
							<th>대분류
							<th>중분류
							<th>소분류
							<th>등록일
					</thead>
					<c:forEach var="item" items="${list}">
						<tr onclick="javascript:click_productid('${item.PRODUCT_ID}');">
							<input type="hidden" id="product_id" name="product_id" value="${item.PRODUCT_ID}"> 
							<td>${item.PRODUCT_ID}
							<td>${item.PRODUCT_NAME}
							<td>${item.PRODUCT_SIZE}
							<td>${item.PRODUCT_CNT}
							<td>${item.PRODUCT_WEARING_PRICE}
							<td>${item.PRODUCT_PRICE}
							<td>${item.PRODUCT_MAIN_CATEGORY}
							<td>${item.PRODUCT_SUB_CATEGORY}
							<td>${item.PRODUCT_SSUB_CATEGORY}
							<td>${item.REG_DATE}
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>