<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.semiproj.member.model.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="memService" class="com.semiproj.member.model.MemberService" scope="session"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
   
</script>
</head>
<body>
	<h2>이메일 중복 검사</h2>
	<br>
	<form name="frmId" method="post" action="checkEmail_ok.do">
		<label for="email">email : </label>
		<input type="text" name="email" id="email"
			value="${email}" title="email 입력">
		<input type="submit" id="submit" value="이메일 확인">
	</form>
</body>
</html>