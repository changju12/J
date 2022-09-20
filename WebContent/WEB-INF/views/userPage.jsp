<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table{
	border : 2px solid;
	border-color : skyblue;
	padding : 1px;
}
th{
	border : 2px solid;
	border-color : skyblue;
	background-color : skyblue;
	text-align : left;
}
td{
	border : 1px solid;
}
h1{
	text-align : center;
	margin-top : 10px;
}
</style>
<title>Insert title here</title>
</head>
<title>Hello JSP</title>
</head>
<body>
<fieldset>
<table align="center" border=1px>
<tr>
<th>아이디</th>
<th>패스워드</th>
<th>이름</th>
<th>전화번호</th>
<th>주소</th>
<th>회원등급</th>
<th>회원정보 수정</th>
</tr>
<tr><!-- 첫번째 줄 시작 -->
<td>${userInfo.user_id}</td>
<td>${userInfo.user_pass}</td>
<td>${userInfo.user_name}</td>
<td>${userInfo.phone_num}</td>
<td>${userInfo.address}</td>
<td>${userInfo.user_lvl}</td>
<td><form>
<input type="button" name="update" value="수정" onclick="location.href='update_infoPage.jsp'" ></input>
</form></td>
</tr><!-- 첫번째 줄 끝 -->
<table align="center">
<tr>
<td><a href="login.jsp">로그아웃</a></td>
</tr>
</table>
</fieldset>
</body>
</html>