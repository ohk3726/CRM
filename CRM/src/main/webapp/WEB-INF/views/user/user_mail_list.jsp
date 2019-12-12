<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function mail_insert(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=other","메일 작성", "width=650px,height=700px");
	}
</script>
<table style="width:100%;">
	<tr>
		<td>
			<h1 style="text-align:left;">고객 메일 발송 내역</h1>
		<td style="text-align:right;">
			<c:forEach var="item" items="${list}">
				<button onclick="javascript:mail_insert('${item.user_id}');">메일 작성</button>
			</c:forEach>
	<tr>
		<td colspan="2">
			<div style="height:300px;overflow:auto;">
			<table style="width:100%;" id="basic">
				<tr>
					<th>분류
					<th>메일제목
					<th>발송날짜
				</tr>
				<c:forEach var="item8" items="${list8}">
					<tr>
						<td>${item8.mail_category}
						<td>${item8.title}
						<td>${item8.reg_date}
					</tr>
				</c:forEach>
			</table>
			</div>
</table>