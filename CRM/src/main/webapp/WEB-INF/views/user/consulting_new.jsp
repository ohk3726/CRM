<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<title>USINSA</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain">
			<form action="consulting_new_insert" method="post">
				<input type="hidden" name="user_id" value="${user_id}">
				<table id="basic">
					<tr>
						<th colspan="2">상담내용
					</th>
					<tr>
						<td colspan="2"><textarea name="content" maxlength="150" style="resize:none;width:400px;height:200px;"></textarea>
					</tr>
					<tr>
						<th>상담원
						<td><input type="text" name="consultant" maxlength="10">
					</tr>
				</table>
				<input type="submit" value="저장하기">
			</form>
		</div>
	</div>
</body>
</html>