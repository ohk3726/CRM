<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function mail_send(){
		var title = document.getElementById("title1").value;
		var content = document.getElementById("content1").value;
		document.getElementById("title").value = title;
		document.getElementById("content").value = content;
		
		var chkbox1 = document.getElementsByName("user_id"); 
		var chkbox2 = document.getElementsByName("coupon_id"); 
		
		var chk1 = false;
		var chk2 = false;
		
		for(var i=0 ; i<chkbox1.length ; i++) { 
			if(chkbox1[i].checked==true) { 
				chk1 = true; 
				break;
			} 
			else { 
				chk1 = false; 
			} 
		}
		
		for(var i=0 ; i<chkbox2.length ; i++) { 
			if(chkbox2[i].checked==true) { 
				chk2 = true; 
				break;
			} 
			else { 
				chk2 = false; 
			} 
		}
		
		if(chk2){	
			if(chk1){				
				document.getElementById("coupon_mail_send").submit();
			}
			else{
				alert("대상을 선택하지 않았습니다.");
			}
		}
		else{
			alert("쿠폰을 선택하지 않았습니다.");
		} 
	}
</script>
<h1>쿠폰 발송</h1>
	<br>
		제목 : <input type="text" name="title1" id="title1" maxlength="30">
	<br>
	<br>
		내용 : <br><textarea name="content1" id="content1" style="width:350px;height:300px;resize: none;" maxlength="150"></textarea>
	<br>
<button type="button" onclick="javascript:mail_send();">보내기</button>