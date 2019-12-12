<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function level_down(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=level_down","메일 작성", "width=650px,height=700px");
	}
</script>
<h1>등급하락고객</h1>
			<table id="basic" cellspacing="0" cellpadding="0">
				<tr>
					<th>이름
					<th>지난달 등급
					<th>이번달 등급
				<c:forEach var="item" items="${list1}">
					<tr onclick="javascript:level_down('${item.user_id}');">
						<input type="hidden" name="user_id" value="${item.user_id}">
						<td>${item.user_name}
						<td>${item.old_level_name}
						<td>${item.level_name}
				</c:forEach>
			</table>