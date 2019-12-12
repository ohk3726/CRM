<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>USINSA</title>
</head>
<body>
	<div id="essential_contain" style="width:44%;height:100%;float:left;">
		<div id="main_contain" style="height:100%;">
			<jsp:include page="user_detail_list.jsp"></jsp:include>
			<jsp:include page="user_order_list.jsp"></jsp:include>
			<jsp:include page="user_order_detail.jsp"></jsp:include>
		</div>
	</div>
	<div id="essential_contain" style="width:44%;height:100%;display:inline-block;">
		<div id="main_contain" style="height:100%;">
			<jsp:include page="anniversary.jsp"></jsp:include>
			<jsp:include page="consulting.jsp"></jsp:include>
			<jsp:include page="user_coupon.jsp"></jsp:include>
			<jsp:include page="user_mail_list.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>