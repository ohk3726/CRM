<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/header.jsp"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/css/jquery.tablesorter.min.js"/>"></script>
<script>
	function search_1() {
		var sel1 = document.getElementById("user_search");
		document.getElementById("search_select").value = sel1.options[sel1.selectedIndex].value;
		
		var sel2 = document.getElementById("job");
		document.getElementById("user_job").value = sel2.options[sel2.selectedIndex].value;
		
		$("#search_1").submit();
	}
	function detail(user_id){
		location.href="/crm/user_detail?user_id="+user_id;
	}
	function new_user(){
		window.open('/crm/new_user','유신사','width=650px,height=630px',true);
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
<title>USINSA</title>
</head>
<body>
	<div style="width:100%;text-align:right;">
		<button onclick="javascript:new_user();" id="insert">간편등록</button>
		<br>
		<form method="post" action="user_search" id="search_1">
			직업 : 
			<select id="job">
				<option selected="selected" value="">선택하세요</option>
				<c:forEach var="item1" items="${list1}">
					<option value="${item1.user_job}">${item1.user_job}</option>
				</c:forEach>
			</select>
			<input type="hidden" id="user_job" name="user_job">
			검색 : 
			<select id="user_search">
				<option value="user_name" selected="selected">고객명</option>
				<option value="user_phone">휴대폰번호</option>
			</select>
			<input type="hidden" id="search_select" name="search_select">
			<input type="text" name="keyword" onkeypress="if(event.keyCode==13){javascript:search_1();}">
			<button type="button" onclick="javascript:search_1();">검색</button>
		</form>
	</div>
	<div id="essential_contain" style="height:100%;height:700px">
		<div id="main_contain" style="height:100%;overflow:auto">
			<table style="width:100%;" id="basic" cellspacing="0" cellpadding="0" class="tablesorter">
				<thead>
					<tr>
						<th>고객ID
						<th>고객명
						<th>휴대폰번호
						<th>생년월일
						<th>직업
						<th>주소
					</tr>
				</thead>
					<c:forEach var="item" items="${list}">
						<tr onclick="javascript:detail('${item.user_id}');">
							<td>${item.user_id}
							<td>${item.user_name}
							<td>${item.user_phone}
							<td>${item.user_ssn}
							<td>${item.user_job}
							<td>${item.user_adress}
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>