<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="userlogin_7.css">
<title>회원가입 페이지</title>
<script type="text/javascript" src="/userlogin_7/jquery/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#same").hide();
	$("#dif").hide();
	$("#pass2").keyup(function(){
		var pwd1 = $("#pass1").val();
		var pwd2 = $("#pass2").val();
		if(pwd1 != "" || pwd2 !=""){
			if(pwd1 == pwd2){
				$("#same").show();
				$("#dif").hide();
				$("#submitbtn").removeAttr("disabled");
			}else{
				$("#dif").show();
				$("#same").hide();
				$("#submitbtn").attr("disabled","disabled");
			}
		}
	});
	
	$('#submitbtn').click(function(){
		alert("가입완료");
		$('form#frm1').submit();
	});
	
	$('#cancel').click(function(){
		window.history.back();
	});
});

function idchk(){
	$.ajax({
		type: 'POST',
		url: './idchk',
		data:{id :  $('#id').val()},
		success: function(result){
			if(result == '1'){
				alert('사용가능');
			}else{
				alert('사용불가능');
			}
		}
	})
}
</script>
</head>
<body>
<form id = "frm1" action="http://localhost:8085/userlogin_7/JoinController" method="GET">
<fieldset>
<h1>회원가입</h1>
<table align = "center">
<tr>
<th>아이디</th>
<td><input type = "text"  name="id" placeholder = "아이디"> <input type = "button" onClick = "idchk()" value = "중복확인"></td>
</tr>
<tr>
<th>비밀번호</th>
<td><input type = "text"  id = "pass1" name="pass1" placeholder = "비밀번호" "></td>
</tr>
<tr>
<th>비밀번호 확인</th>
<td><input type = "text"  id ="pass2" name="pass2" placeholder = "비밀번호 확인"><span id = "same">일치</span><span id = "dif">불일치</span></td>
</tr>
<tr>
<th>이름</th>
<td><input type = "text"  name="name" placeholder = "이름"></td>
</tr>
<tr>
<th>휴대전화</th>
<td><input type = "text" name="phone_num" placeholder = "휴대전화"></td>
</tr>
<tr>
<th>주소</th>
<td><input type = "text" name="address" placeholder = "주소"></td>
</tr>
</table>
<br/>
<div align = "center"><input type = "button" id = "submitbtn"value = "가입" >   
<input type = "button" id = "cancel" value = "취소" ></div>
</fieldset>
</form>
</body>
</html>