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
		document.getElementById("consulting_update").submit();
	}
</script>
<title>USINSA</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain">
			<form action="consulting_update" method="post" id="consulting_update">
			<table id="basic">
				<c:forEach var="item" items="${list}">
				<input type="hidden" name="user_id" value="${item.user_id}">
				<input type="hidden" name="consulting_id" value="${item.consulting_id}">
					<tr>
						<th>상태
						<td>
							<select name="state">
								<option value="처리중">처리중</option>
								<option value="처리완료">처리완료</option>
							</select>
					</tr>
					<tr>
						<th colspan="2">상담내용
					</th>
					<tr>
						<td colspan="2"><textarea name="content" maxlength="150" style="resize:none;width:400px;height:200px;">${item.content}</textarea>
					</tr>
					<tr>
						<th>상담원
						<td><input type="text" name="consultant" value="${item.consultant}">
					</tr>
				</c:forEach>
				</table>
				
			</form>
			<button onclick="javascript:update();">저장하기</button>
		</div>
	</div>
</body>
</html>