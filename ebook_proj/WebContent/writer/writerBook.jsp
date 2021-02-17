<%@page import="com.semiproj.bookinfo.model.BookInfoVO"%>
<%@page import="com.semiproj.writer.model.WriterVO"%>
<%@page import="java.util.List"%>
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
<title>작가 대표작품</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="../assets/css/noscript.css" />
</noscript>
<article id="banner"></article>
<!-- Main -->
<article id="main">

<%
	//view 페이지
	List<BookInfoVO> list=(List<BookInfoVO>)request.getAttribute("list");
	WriterVO vo=(WriterVO)request.getAttribute("vo");		
	
	//3
%>
<body class="right-sidebar is-preload">
	<div id="page-wrapper">

		<!-- One -->
		<section class="wrapper style4 container">

			<div class="row gtr-150">
				<div class="col-8 col-12-narrower">

					<!-- Content -->
					<a href="<c:url value='/writer/writerPage.do?no=${param.wrno }' />">
						<button type="button" class="btn btn-primary btn-lg">
							작가소개</button>
					</a> <a
						href="<c:url value='/writer/writerBook.do?wrno=${param.wrno }' />">
						<button type="button" class="btn btn-secondary btn-lg">
							대표작품</button>
					</a>
					<div class="content">
						<section>
							<a href="#" class="image featured"><img
								src="images/pic03.jpg" alt="" /></a>
							<header>
								<h3>작가 소개</h3>
							</header>
							<c:if test="${empty list}">
								<tr>
									<td colspan="5" class="align_center">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<%for(int i=0; i<list.size(); i++){
									BookInfoVO bvo=list.get(i);%>
							<img src="../images/<%=bvo.getTxtFileName()%>" width="100" height="200"><br> 
							<span><%=bvo.getTitle() %></span><br>
							<span><%=bvo.getPrice() %></span><br>
							<%} %>
						</section>
					</div>

				</div>
				<div class="col-4 col-12-narrower">

					<!-- Sidebar -->
					<div class="sidebar">
						<section>
							<header>
								<h3>Magna Feugiat</h3>
							</header>
							<p>Sed tristique purus vitae volutpat commodo suscipit amet
								sed nibh. Proin a ullamcorper sed blandit. Sed tristique purus
								vitae volutpat commodo suscipit ullamcorper commodo suscipit
								amet sed nibh. Proin a ullamcorper sed blandit..</p>
							<footer>
								<ul class="buttons">
									<li><a href="#" class="button small">Learn More</a></li>
								</ul>
							</footer>
						</section>

						<section>
							<a href="#" class="image featured"><img
								src="images/pic04.jpg" alt="" /></a>
							<header>
								<h3>Amet Lorem Tempus</h3>
							</header>
							<p>Sed tristique purus vitae volutpat commodo suscipit amet
								sed nibh. Proin a ullamcorper sed blandit. Sed tristique purus
								vitae volutpat commodo suscipit ullamcorper sed blandit lorem
								ipsum dolore.</p>
							<footer>
								<ul class="buttons">
									<li><a href="#" class="button small">Learn More</a></li>
								</ul>
							</footer>
						</section>
					</div>

				</div>
			</div>
		</section>
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


