<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
<script>	
	 function changeSelect() {
		var sel = document.getElementById("select_category");
		document.getElementById("select_cate").value = sel.options[sel.selectedIndex].value;
		if(document.getElementById("select_cate").value!='all'){		
			document.getElementById("product_category_sort").submit();
		}
	}
	 
	function changeLevel() {
		var sel_2 = document.getElementById("selectLevel");
		document.getElementById("selectLevel_hi").value = sel_2.options[sel_2.selectedIndex].value;
		document.getElementById("select_option_level").submit();
	}
	
	 function category_click(PRODUCT_ID) {
		var sel_2 = PRODUCT_ID;
		document.getElementById("product_nam").value = sel_2;
		document.getElementById("product_category_level_").submit();
	} 	
</script>
</head>
<body>
	<table>
		<tr>
			<td><div id="main_contain" style="width:500px;height:700px;overflow:auto"><jsp:include page="category_sale.jsp"></jsp:include></div>
			<td><div id="main_contain" style="width:500px;height:700px;overflow:auto"><jsp:include page="level_sale.jsp"></jsp:include></div>
			<td><div id="main_contain" style="width:500px;height:700px;overflow:auto"><jsp:include page="link_product.jsp"></jsp:include></div>
	</table>
</body>
</html>