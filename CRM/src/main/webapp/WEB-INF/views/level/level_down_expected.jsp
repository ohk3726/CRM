<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function level_down_expected(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=level_down_expected","메일 작성", "width=650px,height=700px");
	}
</script>
<h1>등급 하락 예정 고객</h1>
			<table id="basic" cellspacing="0" cellpadding="0">
				<tr>
					<th>이름
					<th>현재 등급
				<c:forEach var="item" items="${list2}">
					<tr onclick="javascript:level_down_expected('${item.user_id}');">
						<input type="hidden" name="user_id" value="${item.user_id}">
						<td>${item.user_name}
						<td>${item.level_name}
				</c:forEach>
			</table>