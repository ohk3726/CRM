<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function other_list_click(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=other","메일 작성", "width=650px,height=700px");
	}
	function user_update(){
		document.getElementById("user_detail_update").submit();
	}
</script>
<table style="width:100%">
	<tr>
		<td><h1 style="text-align:left;">고객 상세 정보</h1>
		<td style="text-align:right">
			<c:forEach var="item" items="${list}">
				<button onclick="javascript:other_list_click('${item.user_id}');">메일 작성</button>
			</c:forEach>
			<button onclick="javascript:user_update();">수정하기</button>
	<tr>
		<td colspan="2">
			<form action="user_detail_update" method="post" id="user_detail_update">
				<table style="width:100%;" id="basic">
						<c:forEach var="item" items="${list}">
							<th>고객ID<td><input type="text" name="user_id" value="${item.user_id}" readonly>
							<tr>
							<th>고객PW<td><input type="text" name="user_pw" value="${item.user_pw}" maxlength="10">
							<tr>
							<th>고객명<td><input type="text" name="user_name" value="${item.user_name}" maxlength="20">
							<tr>
							<th>고객주소<td><input type="text" name="user_adress" value="${item.user_adress}" maxlength="100">
							<tr>
							<th>고객휴대폰번호<td><input type="text" name="user_phone" value="${item.user_phone}" maxlength="20" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
							<tr>
							<th>고객직업<td><input type="text" name="user_job" value="${item.user_job}" maxlength="30">
							<tr>
							<th>고객생년월일<td><input type="date" name="user_ssn" value="${item.user_ssn}">
							<tr>
							<th>고객등급
							<td><select name="level_id" id="level_id">
									<c:forEach var="item2" items="${list2}">
										<option value='${item2.level_id}'>${item2.level_name}</option>
									</c:forEach>
								</select>
							<tr>
							<th>고객블랙리스트유무
							<td><select name="black_list_yn" id="black_list_yn">
								<c:forEach var="item3" items="${list3}">
									<option value='${item3.black_list_yn}'>${item3.black_list_yn}</option>
								</c:forEach>
							</select>
							<tr>
							<th>고객이메일<td><input type="text" name="email" value="${item.email}" maxlength="30">
							<tr>
							<th>총 구매 가격<td><input type="text" name="order_price" value="${item.order_price}" readonly>
							<tr>
						</c:forEach>
				</table>	
				
			</form>
</table>
<script>
	$("#level_id > option[value='${level_id}']").attr("selected",true);
	$("#black_list_yn > option[value='${black_list_yn}']").attr("selected",true);
</script>