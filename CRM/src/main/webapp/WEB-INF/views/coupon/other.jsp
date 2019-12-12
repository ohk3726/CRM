<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<form action="coupon_mail_send" method="post" id="coupon_mail_send" name="coupon_mail_send">
	<table>
		<tr>
			<td><div id="main_contain" style="width:600px;height:700px;"><jsp:include page="coupon_list.jsp"></jsp:include></div>
			<td><div id="main_contain" style="width:550px;height:700px;"><jsp:include page="coupon_user.jsp"></jsp:include></div>
			<td><div id="main_contain" style="width:350px;height:700px;"><jsp:include page="coupon_mail.jsp"></jsp:include></div>
	</table>
	</form>
</body>
</html>