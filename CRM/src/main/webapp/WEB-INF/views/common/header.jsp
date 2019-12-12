<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<script>
	function search_2(){
		var sel1 = document.getElementById("search");
		var search_sel = sel1.options[sel1.selectedIndex].value;
		document.getElementById("search_select_1").value = sel1.options[sel1.selectedIndex].value;
		document.getElementById("selectCompany_1").value = sel1.options[sel1.selectedIndex].value;
		document.getElementById("keyword_1").value = document.getElementById("keyword1").value;
		document.getElementById("product_search_text").value = document.getElementById("keyword1").value;
		if(search_sel == 'user_name'){
			document.search_com.action="user_search_1";
			document.search_com.submit();
		}
		else{
			document.search_com.action="product_search_1";
			document.search_com.submit();
		}
	}
</script>
<title>::: 유신사 - You Sin Sa CRM PAGE :::</title>
</head>
<body>
	<div id="header_contain">
		<div id="header_main">
			<table>
				<tr>
					<td style="padding-left: 50px;"><a href="user_issued"><img src="resources/images/logo.png" style="width: 300px; height: 100px;" alt="YouSinSa" /></a></td>
					<td style="padding-left: 50px;">
						<ul class="myMenu">
							<li class="menu1"><a href="#" class="menu"><strong>고객관리</strong></a>
								<ul class="menu1_s submenu">
									<li><a href="user"><strong>고객검색</strong></a></li>
									<li><a href="user_issued"><strong>이슈고객</strong></a></li>
								</ul></li>
							<li class="menu2"><a href="level_issued" class="menu"><strong>등급관리</strong></a></li>
							<li class="menu3"><a href="#" class="menu"><strong>제품관리</strong></a>
								<ul class="menu3_s submenu">
									<li><a href="Product_List"><strong>제품검색</strong></a></li>
									<li><a href="product_layer"><strong>연계제품</strong></a></li>
								</ul></li>
							<li class="menu4"><a href="other" class="menu"><strong>기타관리</strong></a></li>
						</ul>
					<td style="padding-left:350px;"><select id="search">
							<option value="user_name">고객명</option>
							<option value="option_product_name">제품명</option>					
						</select>
						<input type="hidden" name="search_sel" id="search_sel">
					<input type="text" name="keyword1" id="keyword1" onkeypress="if(event.keyCode==13){javascript:search_2();}"  maxlength="30">
					<button name="btnSearch" id="btnSearch" onclick="javascript:search_2();">통합검색</button></td>
				</tr>
			</table>
			<form action="" method="post" name="search_com">
				<input type="hidden" name="keyword_1" id="keyword_1">
				<input type="hidden" name="search_select_1" id="search_select_1">
				<input type="hidden" name="selectCompany_1" id="selectCompany_1">
				<input type="hidden" name="product_search_text" id="product_search_text">
			</form>
		</div>
	</div>
</body>
</html>