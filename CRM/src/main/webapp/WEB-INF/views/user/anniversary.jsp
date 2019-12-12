<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function newanniversary(){
		var user_id = document.getElementById("user_id").value;
		window.open("/crm/anniversary_new?user_id="+user_id,"기념일 등록", "width=650px,height=630px");
	}

	function anniversary_update_click(user_id,anniversary_id){
		window.open("/crm/anniversary_update_page?user_id="+user_id+"&anniversary_id="+anniversary_id,"기념일 수정", "width=650px,height=630px");
	}
</script>
<table style="width:100%">
	<tr>
		<td><h1 style="text-align:left;">기념일</h1>
		<td style="text-align:right;"><button onclick="javascript:newanniversary();">기념일 추가</button>
	<tr>
		<td colspan=2>
		<div style="height:300px;overflow:auto;">
			<table style="width:100%;" id="basic">
				<tr>
					<th>기념일명
					<th>관계
					<th>기념일날짜
					<th>기념일주기
				</tr>
				<c:forEach var="item4" items="${list4}">
					<tr onclick="javascript:anniversary_update_click('${item4.user_id}','${item4.anniversary_id}');">
						<td>${item4.anniversary_name}
						<td>${item4.anniversary_relation}
						<td>${item4.anniversary_date}
						<td>${item4.anniversary_cycle}
					</tr>
				</c:forEach>
			</table>
		</div>
</table>