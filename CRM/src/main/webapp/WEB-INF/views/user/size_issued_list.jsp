<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function size_issued(){
		var select = document.getElementById("product_main_category");
		var product_main_category = select.options[select.selectedIndex].value;
		
		$.ajax({
			url:"size_issued?product_main_category="+product_main_category,
			type:"post",
			dataType:"text",
			success:function(result){
				console.log(result);
				$('.size_issued').empty();
				$('.size_issued').html(result);
			},
			 error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }
		});
	}
	function size_user_list_click(user_id, order_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=size"+"&order_id="+order_id,"메일 작성", "width=650px,height=700px");
	}
</script>


<table style="width:100%">
	<tr>
		<td><h1 style="text-align:left;">사이즈 변동 고객</h1>
		<td>
			<select onchange="javascript:size_issued();" id="product_main_category">
				<option selected=selected>카테고리를 선택하세요.</option>
				<c:forEach var="item0" items="${list0}">
					<option value="${item0.product_main_category}">${item0.product_main_category}</option>
				</c:forEach>
			</select>
	<tr>
		<td colspan=2>	
			<form action="#" method="post">
				<div style="height:300px;overflow:auto;">
				<table style="width:100%;" id="basic" class="size_issued">
					<tr>
						<th>이름
						<th>카테고리
						<th>기존사이즈
						<th>변경사이즈
						<th>메일발송
				</table>
				</div>
			</form>
</table>