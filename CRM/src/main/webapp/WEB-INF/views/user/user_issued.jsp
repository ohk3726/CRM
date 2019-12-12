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
	<div style="float:left;width:55%;height:100%;">
		<div id="essential_contain" style="width:100%;height:100%;">
			<div id="main_contain" style="height:100%;">
				<jsp:include page="new_user_list.jsp"></jsp:include>
			</div>
			<div id="main_contain" style="height:100%;">
				<jsp:include page="basket_user_list.jsp"></jsp:include>
			</div>
			<div id="main_contain" style="height:100%;">
				<jsp:include page="size_issued_list.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<div id="essential_contain" style="width:35%;height:100%;display:inline-block;">
		<div id="main_contain" style="height:100%;">
			<jsp:include page="anniversary_issued_list.jsp"></jsp:include>
		</div>
		<div id="main_contain" style="height:100%;">
			<jsp:include page="black_list_issued_list.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>