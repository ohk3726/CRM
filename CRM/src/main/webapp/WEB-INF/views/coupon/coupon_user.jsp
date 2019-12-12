<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function checkallselect(chk){
		for (i = 0; i < chk.length; i++){
			if( chk[i].checked == true){
				chk[i].checked = false ;
			}else{
				chk[i].checked = true ;
			}
		}
	}
	
	function user_search(){
		var sel1 = document.getElementById("level");
		document.getElementById("level_sel").value = sel1.options[sel1.selectedIndex].value;
		
		var sel2 = document.getElementById("job");
		document.getElementById("job_sel").value = sel2.options[sel2.selectedIndex].value;
		
		
		var level_id = document.getElementById("level_sel").value;
		var user_job = document.getElementById("job_sel").value;
		var user_name = document.getElementById("search_name").value;
		$.ajax({
			url:"coupon_user?level_id="+level_id+"&user_job="+user_job+"&user_name="+user_name,
			type:"post",
			dataType:"text",
			success:function(result){
				console.log(result);
				$('.coupon_user').empty();
				$('.coupon_user').html(result);
			},
			 error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }
		});
	}
</script>
<table style="width:100%">
	<tr>
		<td colspan=3><h1>대상 선택</h1>
	<tr>
		<td colspan=2><select id="level" style="display:inline-block;">
				<option value="all" selected="selected">전체등급</option>
				<c:forEach var="item" items="${list2}">
					<option value="${item.level_id}">${item.level_name}</option>
				</c:forEach>
			</select>
			<select id="job" style="display:inline-block;">
				<option value="all" selected="selected">전체직업</option>
				<c:forEach var="item" items="${list3}">
					<option value="${item.user_job}">${item.user_job}</option>
				</c:forEach>
			</select>
			<input type="hidden" name="level_sel" id="level_sel">
			<input type="hidden" name="job_sel" id="job_sel">
		<td rowspan=2>
			<button type="button" onclick="javascript:user_search();" style="display:inline-block;">검색</button>
	<tr>
		<td>이름
		<td><input type="text" name="search_name" id="search_name" onkeypress="if(event.keyCode==13){javascript:user_search();}" style="display:inline-block;" maxlength="10">
	<tr>
		<td colspan=3>
			<div style="height:550px;overflow:auto;">
				<form action="coupon_mail_send" method="post" id="coupon_mail_send" name="coupon_mail_send">
					<input type="hidden" name="title" id="title">
					<textarea style="display:none;" name="content" id="content"></textarea>
					<table id="basic" class="coupon_user" style="width:100%">
						<tr>
							<th><input type="checkbox" name="check_all" id="check_all" onclick="javascript:checkallselect(document.coupon_mail_send.user_id);">
							<th>고객ID
							<th>고객명
					</table>
				</form>
			</div>
</table>
