<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function level_click(){
		var sel = document.getElementById("level");
		var level_id = sel.options[sel.selectedIndex].value;
		$.ajax({
			url:"Level_order?level_id="+level_id,
			type:"post",
			dataType:"text",
			success:function(result){
				console.log(result);
				$('.level_list').empty();
				$('.level_list').html(result);
			},
			 error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td><div id="main_contain" style="width:500px;height:700px;overflow:auto"><jsp:include page="level_high.jsp"></jsp:include></div>
			<td><div id="main_contain" style="width:500px;height:700px;overflow:auto"><jsp:include page="level_down.jsp"></jsp:include></div>
			<td><div id="main_contain" style="width:500px;height:700px;overflow:auto"><jsp:include page="level_down_expected.jsp"></jsp:include></div>
	</table>

</body>
</html>