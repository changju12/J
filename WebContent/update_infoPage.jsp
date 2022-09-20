<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="userlogin_7.css">
<title>회원 정보 수정</title>

</head>
<body>
<fieldset>
<h1>회원 정보 수정</h1>

<table align = "center">
<tr>
<th>비밀번호 변경</th>
<td><input type = "text" placeholder = "비밀번호">
</tr>
<tr>
<th>비밀번호 확인</th>
<td><input type = "text" placeholder = "비밀번호 확인">
</tr>
<tr>
<th>휴대전화</th>
<td><input type = "text" placeholder = "휴대전화">
</tr>
<tr>
<th>주소</th>
<td><input type = "text" placeholder = "주소">
</tr>
</table>
<br/>
<div align = "center"><input type = "button" value = "수정 완료" onClick = "update()">   
<input type = "button" value = "취소" onCLick = "history.back();"></div>
</fieldset>
</body>
</html>