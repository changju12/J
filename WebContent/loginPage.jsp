<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="userlogin_7.css">
</head>
<body>
<form action="http://localhost:8085/userlogin_7/LoginController" method="GET">
<fieldset>
<h1>로그인 페이지</h1>
<table align = "center">
<tr>
<th>아이디 :</th>
<td><input type = "text" name="id" placeholder = "아이디"/></td>
</tr>
<tr>
<th>비밀번호 : </th>
<td><input type = "text" name="pass" placeholder = "비밀번호"/></td>
</tr>
<tr>
<td colspan = "2">
<input type = "submit" value = "로그인"  style = "width: 88pt; float: left"/>
</form>
<form action="http://localhost:8085/userlogin_7/joinPage.jsp" method="GET">
<input type = "submit" value = "회원가입" style = "width:88pt; float: right"/>
</form>
</td>
</tr>
</table>

<br/>


</fieldset>
</body>
</html>