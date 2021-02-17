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
</head>
<body>
<h2>별명 중복 검사</h2>
	<br>
	<form name="frmId" method="post" action="checkNickname_ok.do">
		<label for="email">별명 : </label> <input type="text" name="nickname"
			id="nickname" value="${nickname}" title="nickname 입력"> <input
			type="submit" id="submit" value="별명 확인">
	</form>
</body>
</html>