<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<script>
	function inNumber(){
	  if(event.keyCode<48 || event.keyCode>57){
	     event.returnValue=false;
	  }
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main_contain" style="width:650px;height:100%;">
	<h2>제품 등록</h2>
	<table id="basic" style="width:100%">
		<tr>
			<form id=product_sameid method="POST" action="product_sameid">
				<th>제품ID <td><input type="text" name="PRODUCT_ID" id="PRODUCT_ID" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<td><button type="button" id="btn_search" name="btn_search">중복검색</button>
			</form>
			<form id="product_insert" method="post" action="product_insert">
				<input type="hidden" name="PRODUCT_ID_" id="PRODUCT_ID_" >
				<tr>
					<th>제품이름 <td colspan=2><input type="text" name="PRODUCT_NAME" id="PRODUCT_NAME" maxlength="30">
				<tr>
					<th>제품Size <td colspan=2><input type="text" name="PRODUCT_SIZE" id="PRODUCT_SIZE" maxlength="30">
				<tr>
					<th>제품개수 <td colspan=2><input type="text" name="PRODUCT_CNT" id="PRODUCT_CNT" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<tr>
					<th>입고가 <td colspan=2><input type="text" name="PRODUCT_WEARING_PRICE" id="PRODUCT_WEARING_PRICE" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<tr>
					<th>판매가 <td colspan=2><input type="text" name="PRODUCT_PRICE" id="PRODUCT_PRICE" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="30">
				<tr>
					<th>대분류 <td colspan=2><input type="text" name="PRODUCT_MAIN_CATEGORY" id="PRODUCT_MAIN_CATEGORY" maxlength="30">
				<tr>
					<th>중분류 <td colspan=2><input type="text" name="PRODUCT_SUB_CATEGORY" id="PRODUCT_SUB_CATEGORY" maxlength="30">
				<tr>
					<th>소분류 <td colspan=2><input type="text" name="PRODUCT_SSUB_CATEGORY" id="PRODUCT_SSUB_CATEGORY" maxlength="30">
			</form>
	</table>
	<button onclick="javascript:changeSelect()">등록</button>
</div>
<script>
	function changeSelect() {
		func();
		document.getElementById("product_insert").submit();
		
	}
	
	var func_all = function(){
		 var PRODUCT_ID = document.getElementById('PRODUCT_ID').value;
		 
		 if(!PRODUCT_ID){
			   alert('ID를 입력하세요')
			   document.getElementById('PRODUCT_ID').focus();
			   return;
		   }
	}
   var func = function(){
	   var PRODUCT_ID = document.getElementById('PRODUCT_ID').value;
	   var PRODUCT_NAME = document.getElementById('PRODUCT_NAME').value;
	   var PRODUCT_SIZE = document.getElementById('PRODUCT_SIZE').value;
	   var PRODUCT_CNT = document.getElementById('PRODUCT_CNT').value;
	   var PRODUCT_WEARING_PRICE = document.getElementById('PRODUCT_WEARING_PRICE').value;
	   var PRODUCT_PRICE = document.getElementById('PRODUCT_PRICE').value;
	   var PRODUCT_MAIN_CATEGORY = document.getElementById('PRODUCT_MAIN_CATEGORY').value;
	   var PRODUCT_SUB_CATEGORY = document.getElementById('PRODUCT_SUB_CATEGORY').value;
	   var PRODUCT_SSUB_CATEGORY = document.getElementById('PRODUCT_SSUB_CATEGORY').value;
	   
	   if(!PRODUCT_ID){
		   alert('ID를 입력하세요');
		   document.getElementById('PRODUCT_ID').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_NAME){
		   alert('이름을 입력하세요');
		   document.getElementById('PRODUCT_NAME').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_SIZE){
		   alert('사이즈을 입력하세요');
		   document.getElementById('PRODUCT_SIZE').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_CNT){
		   alert('개수을 입력하세요');
		   document.getElementById('PRODUCT_CNT').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_WEARING_PRICE){
		   alert('원가을 입력하세요');
		   document.getElementById('PRODUCT_WEARING_PRICE').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_PRICE){
		   alert('판매가격을 입력하세요');
		   document.getElementById('PRODUCT_PRICE').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_MAIN_CATEGORY){
		   alert('대분류를 입력하세요');
		   document.getElementById('PRODUCT_MAIN_CATEGORY').focus();
		   return product_info_insert;
	   }
	   
	   if(!PRODUCT_SUB_CATEGORY){
		   alert('중분류을 입력하세요');
		   document.getElementById('PRODUCT_SUB_CATEGORY').focus();
		   return product_info_insert;
	   }
	   if(!PRODUCT_SSUB_CATEGORY){
		   alert('소분류을 입력하세요');
		   document.getElementById('PRODUCT_SSUB_CATEGORY').focus();
		   return product_info_insert;
	   }
	   
   }

   $(document).ready(function(){     
      $("#btn_search").click(function(){
    	  func_all();
       var product_id = document.getElementById("PRODUCT_ID").value;
       $('#PRODUCT_ID_').val(document.getElementById("PRODUCT_ID").value);
       
      $.ajax({
         type: "post",
         url : 'product_sameid/'+product_id,
         async: false,
         success : function(result){
        	
        	 if(result == 0){
        		 alert("아이디가 사용 가능합니다.")
        	 }else{
        		 alert("아이디가 중복되었습니다.")
        	 }
            
         },
      });
   });   
});
</script>
</body>
</html>