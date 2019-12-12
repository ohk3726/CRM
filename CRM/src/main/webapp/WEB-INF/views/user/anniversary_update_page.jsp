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
	function update(){
		document.getElementById("anniversary_update").submit();
	}
</script>
<title>USINSA</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain">
			<form action="anniversary_update" method="post" id="anniversary_update">
			<table id="basic">
				<c:forEach var="item" items="${list}">
				<input type="hidden" name="anniversary_id" value="${item.anniversary_id}">
				<input type="hidden" name="user_id" value="${item.user_id}">
				
					<tr>
						<th>기념일명
						<td><input type="text" name="anniversary_name" value="${item.anniversary_name}">
					</tr>
					<tr>
						<th>관계
						<td><input type="text" name="anniversary_relation" value="${item.anniversary_relation}">
					</tr>
					<tr>
						<th>기념일날짜
						<td><input type="date" name="anniversary_date" id="anniversary_date" value="${item.anniversary_date}">
					</tr>
					<tr>
						<th>주기
						<td><input type="number" name="anniversary_cycle" value="${item.anniversary_cycle}">
					</tr>
				</c:forEach>
				</table>
				
			</form>
			<button onclick="javascript:update();">저장하기</button>
		</div>
	</div>
</body>
</html>