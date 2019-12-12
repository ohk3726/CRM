<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function basket_user_list_click(user_id){
		window.open("/crm/mail?user_id="+user_id+"&mail_category=basket","메일 작성", "width=650px,height=700px");
	}
</script>
<h1 style="text-align:left;">장바구니 보류 고객</h1>
	<form action="#" method="post">
	<div style="height:300px;overflow:auto;">
		<table style="width:100%;" id="basic">
			<tr>
				<th>이름
				<th>등급
				<th>상품수량
				<th>가격
				<th>기간
				<th>메일발송
			</tr>
				<c:forEach var="item2" items="${list2}">
					<tr onclick="javascript:basket_user_list_click('${item2.user_id}');">
						<td>${item2.user_name}
						<td>${item2.level_name}
						<td>${item2.basket_product_cnt}
						<td>${item2.basket_price}
						<td>${item2.reg_date}
						<td>${item2.mail_reg_date}
					</tr>
				</c:forEach>
		</table>
	</div>
	</form>