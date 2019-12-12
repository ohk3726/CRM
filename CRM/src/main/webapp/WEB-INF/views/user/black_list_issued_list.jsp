<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<h1 style="text-align:left;">블랙리스트 고객</h1>
	<form action="#" method="post">
	<div style="height:313px;overflow:auto;">
		<table style="width:100%;" id="basic">
			<tr>
				<th>고객ID
				<th>고객명
			</tr>
				<c:forEach var="item5" items="${list5}">
					<tr>
						<td>${item5.user_id}
						<td>${item5.user_name}
					</tr>
				</c:forEach>
		</table>
	</div>
	</form>