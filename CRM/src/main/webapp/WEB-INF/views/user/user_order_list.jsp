<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function order_click(order_id){
		$.ajax({
			url:"user_order_detail?order_id="+order_id,
			type:"post",
			dataType:"text",
			success:function(result){
				console.log(result);
				$('.order_detail').empty();
				$('.order_detail').html(result);
				if($('#order_detail_update_button').css('display')=="none"){
					$('#order_detail_update_button').show();
				};
			},
			 error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }
		});
	}
</script>
<h1 style="text-align:left;">구매 제품 내역</h1>
<div style="height:300px;overflow:auto;">
	<table style="width:100%;" id="basic">
		<tr>
			<th>제품명
			<th>수량
			<th>금액
			<th>날짜
			<th>반품유무
			<th>상태
		</tr>
		<c:forEach var="item6" items="${list6}">
			<tr onclick="javascript:order_click(${item6.order_id});">
				<td>${item6.product_name}
				<td>${item6.order_product_cnt}
				<td>${item6.order_price}
				<td>${item6.reg_date}
				<td>${item6.order_return_yn}
				<td>${item6.order_check}
			</tr>
		</c:forEach>
	</table>
</div>