<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function newconsulting(){
		var user_id = document.getElementById("user_id").value;
		window.open("/crm/consulting_new?user_id="+user_id,"상담내용 등록", "width=650px,height=630px");
	}
	
	function modconsulting(consulting_id){
		window.open("/crm/consulting_update_page?consulting_id="+consulting_id,"상담내용 수정", "width=650px,height=630px");
	}
</script>
<table style="width:100%;">
	<tr>
		<td>
			<h1 style="text-align:left;">상담내역</h1>
		<td style="text-align:right;">
			<button onclick="javascript:newconsulting();">상담 추가</button>
	<tr>
		<td colspan="2">
			<div style="height:300px;overflow:auto;">
			<table style="width:100%;" id="basic">
				<tr>
					<th>처리상태
					<th>상담내용
					<th>상담원
					<th>상담일자
				</tr>
				<c:forEach var="item5" items="${list5}">
					<tr onclick="javascript:modconsulting(${item5.consulting_id});">
						<input type="hidden" name="user_id" id="user_id" value="${item5.user_id}">
						<td>${item5.state}
						<td>${item5.content}
						<td>${item5.consultant}
						<td>${item5.reg_date}
					</tr>
				</c:forEach>
			</table>
			</div>
</table>