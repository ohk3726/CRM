<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function new_user_list_click(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=new","메일 작성", "width=650px,height=700px");
	}
</script>
<h1 style="text-align:left;">신규 고객</h1>
	<form action="#" method="post">
	<div style="height:300px;overflow:auto;">
		<table style="width:100%;" id="basic">
			<tr>
				<th>이름
				<th>생년월일
				<th>직업
				<th>가입일
				<th>최초구매
				<th>메일발송
			</tr>
				<c:forEach var="item" items="${list}">
					<tr onclick="javascript:new_user_list_click('${item.user_id}');">
						<td>${item.user_name}
						<td>${item.user_ssn}
						<td>${item.user_job}
						<td>${item.reg_date}
						<td>${item.order_cnt}
						<td>${item.mail_reg_date}
					</tr>
				</c:forEach>
		</table>
	</div>
	</form>