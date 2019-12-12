<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function user_detail(user_id){
		location.href="/crm/user_detail?user_id="+user_id;
	}
</script>
<table>
	<tr>
		<td>
			<select name="level" id="level" onChange="javascript:level_click();">
				<c:forEach var="item3" items="${list3}">
					<option value='${item3.level_id}'>${item3.level_name}</option>
				</c:forEach>
			</select>
		<td><h1>상위 10위</h1>
	<tr>
		<td colspan=2>
			<table id="basic" class="level_list" cellspacing="0" cellpadding="0">
				<tr>
					<th>이름
					<th>달성금액
					<c:forEach var="item" items="${list}">
						<tr onclick="javascript:user_detail('${item.user_id}');">
							<td>${item.user_name}
							<td>${item.order_price}
					</c:forEach>
			</table>
</table>