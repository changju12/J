<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/userlogin_7.css">
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
<th>수정</th>
</tr>
<c:forEach var="searchResultItem" items="${searchResultList}">
<tr><!-- 첫번째 줄 시작 -->
<td>${searchResultItem.user_id}</td>
<td>${searchResultItem.user_pass}</td>
<td>${searchResultItem.user_name}</td>
<td>${searchResultItem.phone_num}</td>
<td>${searchResultItem.address}</td>
<td>${searchResultItem.user_lvl}</td>
<td>
<form action="update" method="GET">
<input type = "submit" value = "수정" style = "width: 88pt; float: left"/>
</form></td>
</tr><!-- 첫번째 줄 끝 -->
</c:forEach>
<table align="center">
<tr>
<td><a href="login.jsp">로그아웃</a></td>
</tr>
</table>
</fieldset>
</body>
</html>