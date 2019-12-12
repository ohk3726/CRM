<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function anniversary_user_list_click(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=anniversary","메일 작성", "width=650px,height=700px");
	}
</script>
<h1 style="text-align:left;">D-day 고객</h1>
	<form action="#" method="post">
	<div style="height:775px;overflow:auto;">
		<table style="width:100%;" id="basic">
			<tr>
				<th>이름
				<th>기념일명
				<th>관계
				<th>기념일
				<th>D-day
				<th>메일발송
			</tr>
				<c:forEach var="item4" items="${list4}">
					<tr onclick="javascript:anniversary_user_list_click('${item4.user_id}');">
						<td>${item4.user_name}
						<td>${item4.anniversary_name}
						<td>${item4.anniversary_relation}
						<td>${item4.anniversary_date}
						<td>${item4.d_day}
						<td>${item4.mail_reg_date}
					</tr>
				</c:forEach>
		</table>
	</div>
	</form>