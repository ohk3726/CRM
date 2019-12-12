<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<script>
	function insert(){
		document.getElementById("anniversary_new_insert").submit();
	}
</script>
<title>USINSA</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain">
			<form action="anniversary_new_insert" method="post" id="anniversary_new_insert">
				<input type="hidden" name="user_id" value="${user_id}">
				<table id="basic">
					<tr>
						<th>기념일명
						<td><input type="text" name="anniversary_name">
					</tr>
					<tr>
						<th>관계
						<td><input type="text" name="anniversary_relation">
					</tr>
					<tr>
						<th>기념일날짜
						<td><input type="date" name="anniversary_date" id="anniversary_date">
					</tr>
					<tr>
						<th>주기
						<td><input type="number" name="anniversary_cycle">
					</tr>
				</table>
				
			</form>
			<button onclick="javascript:insert();">저장하기</button>
		</div>
	</div>
	<script>
		document.getElementById("anniversary_date").valueAsDate = new Date();
	</script>
</body>

</html>