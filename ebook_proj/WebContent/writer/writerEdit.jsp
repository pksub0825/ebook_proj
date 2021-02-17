<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Twenty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>작가 소개</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<article id="banner"></article>
<!-- Main -->
<article id="main">

	<body class="right-sidebar is-preload">

		<!-- One -->
		<section class="wrapper style4 container">

			<div class="row gtr-150">
				<div class="col-8 col-12-narrower">

					<!-- Content -->
					<form name="frmEdit" method="post"
						action="<c:url value='/writer/writerEdit_ok.do' />"
						enctype="multipart/form-data">
						<h3>작가 수정</h3>
						</header>
						<input type="hidden" name="no" id="no" value="${param.no}"/>
						<img
							src="<c:url value='/file_upload/writer/${vo.photoFileName}' />"
							width="400" height="400"><br> 
						<label>작가이름</label> 
						<input type="text" id="name" name="name" value="${vo.name}" /> <br>
					
						<label>작가소개</label> 
						<input type="text" id="intro" name="intro"	value="${vo.intro}" />

						<!-- 기존  첨부파일명 -->
						<input type="hidden" name="oldPhotoFileName"
							value="${vo.photoFileName}" /><br> 
						<label for="imgUpload">작가이미지 </label><br> 
						<input type="file" id="imgUpload" name="imgUpload" /><br>
						<c:if test="${!empty vo.photoFileName}">
							<span> - 기존 첨부파일 : </span>
							<span><img
								src='<c:url value="/assets/css/images/file.gif"/>'>
								${vo.photoOriginFileName}</span>
						</c:if>
						<br><br>
						<span style="color: red">※ 기존파일이 첨부된 채로 첨부파일을 새로
							업로드 할 시엔, 기존 파일이 삭제됩니다.</span> <br>
							
						<input type="submit" value="수정" /> 
						<input type="Button" value="작가목록"
							onclick="location.href	='<c:url value='/writer/writerList.do' />' " />
		</section>
		</div>

		</div>


		



		<!-- Scripts -->
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/jquery.dropotron.min.js"></script>
		<script src="../assets/js/jquery.scrolly.min.js"></script>
		<script src="../assets/js/jquery.scrollgress.min.js"></script>
		<script src="../assets/js/jquery.scrollex.min.js"></script>
		<script src="../assets/js/browser.min.js"></script>
		<script src="../assets/js/breakpoints.min.js"></script>
		<script src="../assets/js/util.js"></script>
		<script src="../assets/js/main.js"></script>
	</body>
</html>
<%@ include file="../inc/bottom.jsp"%>


