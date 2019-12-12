<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<script>
	function user_id_check(){
		var user_id = document.getElementById("user_id").value;
		$.ajax({
			url:"new_user_check?user_id="+user_id,
			type:"post",
			dataType:"text",
			success:function(result){
				if(user_id!=''){
					if(result=="0"){
						alert("사용 가능한 ID입니다.");
						document.getElementById("user_check").value=result;
					}
					else{
						alert("중복 ID입니다.");
						document.getElementById("user_check").value=result;
					}
				}
				else{
					alert("ID를 입력하세요.");
				}
			}
		});
	}
	
	function user_check(){
		var user_id = document.getElementById("user_id").value;
		var user_pw = document.getElementById("user_pw").value;
		var user_name = document.getElementById("user_name").value;
		var user_adress = document.getElementById("user_adress").value;
		if(user_id != ""){
			if(user_pw != ""){
				if(user_name != ""){
					if(user_adress != ""){
						document.getElementById("new_insert").submit();
						return true;
					}
					else{
						alert("입력되지 않은 항목이 있습니다.");
					}
				}
				else{
					alert("입력되지 않은 항목이 있습니다.");
				}
			}
			else{
				alert("입력되지 않은 항목이 있습니다.");
			}
		}
		else{
			alert("입력되지 않은 항목이 있습니다.");
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="essential_contain" style="width:500px;">
		<div id="main_contain">
			
			<form action="new_user_insert" method="post" id="new_insert">
				<input type="hidden" name="user_check" id="user_check" value="">
				<table id="basic">
					<tr>
						<th>아이디
						<td><input type="text" name="user_id" id="user_id" value="" maxlength="20">
					<tr>
						<th>패스워드
						<td><input type="text" name="user_pw" id="user_pw" value="" maxlength="30">
					<tr>
						<th>이름
						<td><input type="text" name="user_name" id="user_name" maxlength="20">
					<tr>
						<th>주소
						<td><input type="text" name="user_adress" id="user_adress" maxlength="30">
				</table>
			</form>
			<button onclick="javascript:user_id_check();">아이디확인</button>
			<button onclick="javascript:user_check();">저장</button>
		</div>
	</div>
</body>
</html>