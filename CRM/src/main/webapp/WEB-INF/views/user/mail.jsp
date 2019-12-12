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
	function mail(){
		document.getElementById("mail_send").submit();
	}
</script>
<title>유신사</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain" style="height:600px;">
			<form action="mail_send" method="post" id="mail_send">
				<input type="hidden" name="user_id" value="${user_id}">
				<input type="hidden" name="mail_category" value="${mail_category}">
				<input type="hidden" name="order_id" value="${order_id}">
				<table id="basic">
					<tr>
						<th>받는 메일
						<td>
							<c:forEach var="item" items="${list}">
								<input type="text" name="email" value="${item.email}" readonly>
							</c:forEach>
					<tr>
						<th>제목
						<td><input type="text" name="title" maxlength="30">
					<tr>
						<th colspan=2>내용
					<tr>	
						<td colspan=2>
							<textarea name="content" style="width:450px;height:300px;resize: none;" maxlength="150"></textarea>
				</table>
			</form>
			<button onclick="javascript:mail();">보내기</button>
		</div>
	</div>
</body>
</html>