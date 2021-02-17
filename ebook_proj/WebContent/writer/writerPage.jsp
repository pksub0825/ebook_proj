<%@page import="com.semiproj.bookinfo.model.BookInfoVO"%>
<%@page import="com.semiproj.writer.model.WriterVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
	$(function(){
		$('#del').click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="<c:url value='/writer/writerDel.do?no=${param.no }&photoFileName=${vo.photoFileName }' />";
			}
		});
	});

</script>
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
				<div class="col-12 col-12-narrower">

					<!-- Content -->
					<nav>
						<div class="nav nav-tabs" id="nav-tab" role="tablist">
							<a class="nav-link active" id="nav-home-tab" data-bs-toggle="tab"
								href="#nav-home" role="tab" aria-controls="nav-home"
								aria-selected="true">작가정보</a> <a class="nav-link"
								id="nav-profile-tab" data-bs-toggle="tab" href="#nav-profile"
								role="tab" aria-controls="nav-profile" aria-selected="false">대표작품</a>
						</div>
					</nav>
					<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="nav-home"
							role="tabpanel" aria-labelledby="nav-home-tab">
							<div class="content">
								<section>
									<a href="#" class="image featured"> <img
										src="<c:url value='images/pic03.jpg'/>" alt="" /></a> 
										
									<img src="<c:url value='/file_upload/${vo.photoFileName}' /> "  width="400" height="400"><br>
									<br><br>
									<span><b>이름 : </b>${vo.name}</span><br>
									<div style="border-top: 3px solid #c18282; padding: 10px">
										<span>${vo.intro}</span>
									</div><br><br> 
									<hr>
									<a href="<c:url value='/writer/writerInsert.do' /> "
										<c:if test="${nickname!='admin'}">
											hidden="hidden"
										</c:if>
										>작가 등록</a><br> 
									<a href="<c:url value='/writer/writerEdit.do?no=${param.no }' /> "
										<c:if test="${nickname!='admin'}">
											hidden="hidden"
										</c:if>
										>작가	수정</a><br> 
									<a href="#" id="del"
										<c:if test="${nickname!='admin'}">
											hidden="hidden"
										</c:if>
										>작가	삭제</a><br>
									<a href="<c:url value='/writer/writerList.do' /> ">
										작가	목록</a><br>
								</section>
							</div>
						</div>
						<div class="tab-pane fade" id="nav-profile" role="tabpanel"
							aria-labelledby="nav-profile-tab">
							
										<!-- Content -->
										<div class="content">
											<section>
												<div class="divList">
													<table class="default" border="1">
														<colgroup>
															<col style="width: 20%;" />
															<col style="width: 50%;" />
															<col style="width: 30%;" />
															<col style="width: 40%;" />
														</colgroup>
														<thead>
															<tr>
																<th>이미지</th>
																<th>책 제목</th>
																<th>출판사</th>
																<th>등록일</th>
															</tr>
														</thead>
														<tbody>
															<c:if test="${empty bookList}">
																<tr>
																	<td colspan="5">데이터가 존재하지 않습니다.</td>
																</tr>
															</c:if>
															<c:if test="${!empty bookList}">
																<c:set var="num" value="${pageVo.num}" />
																<c:set var="curPos" value="${pageVo.curPos}" />
																<c:forEach var="i" begin="1" end="${pageVo.pageSize}">
																	<c:if test="${num>=1}">
																		<c:set var="bookVo" value="${bookList[curPos]}" />
																		<c:set var="curPos" value="${curPos+1}" />
																		<c:set var="num" value="${num-1}" />

																		<tr>
																			<td><img alt="책이미지"
																				src="<c:url value='/file_upload/${bookVo.coverFileName}'/>"
																				width="100px"></td>
																			<td><a
																				href="<c:url value='/book/bookDetail.do?no=${bookVo.no}'/>">
																					${bookVo.title}</a></td>
																			<td>${bookVo.publisher}</td>
																			<td><fmt:formatDate value="${bookVo.regdate}"
																					pattern="yyyy-MM-dd" /></td>
																		</tr>
																	</c:if>
																</c:forEach>
															</c:if>
														</tbody>
													</table>
												</div>
												<div class="divPage">
													<!-- 이전 블럭 -->
													<c:if test="${pageVo.firstPage>1}">
														<a
															href="<c:url value='/book/bookList.do?curPage=${pageVo.firstPage-1}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
															<img alt="이전 블럭으로" src="../images/first.JPG">
														</a>
													</c:if>

													<!-- 페이지 목록 -->
													<c:forEach var="i" begin="${pageVo.firstPage}"
														end="${pageVo.lastPage}">
														<c:if test="${i<=pageVo.totalPage}">
															<c:if test="${param.curPage==i}">
																<span style="color: #d1230a; font-weight: bold">${i}</span>
															</c:if>
															<c:if test="${param.curPage!=i}">
																<a
																	href="<c:url value='/book/bookList.do?curPage=${i}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
																	[${i}]</a>
															</c:if>
														</c:if>
													</c:forEach>

													<!-- 다음 블럭 -->
													<c:if test="${pageVo.lastPage<pageVo.totalPage}">
														<a
															href="<c:url value='/book/bookList.do?curPage=${pageVo.lastPage+1}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
															<img alt="이전 블럭으로" src="../images/first.JPG">
														</a>
													</c:if>
												</div>
												<div class="divSearch">
													<form name="frmSearch"
														action="<c:url value='/book/bookList.do'/>" method="post">
														<select name="srchCondition">
															<option value="title"
																<c:if test="${'title'==param.srchCondition}">
								            selected="selected"
								        </c:if>>
																제목</option>
															<option value="writer"
																<c:if test="${'writer'==param.srchCondition}">
								            selected="selected"
								        </c:if>>
																작가명</option>
															<option value="publisher"
																<c:if test="${'publisher'==param.srchCondition}">
								            selected="selected"
								        </c:if>>
																출판사</option>
														</select> <input type="text" name="srchKeyword"
															value="${param.srchKeyword}"> <input
															type="submit" value="검색">
													</form>

												</div>
												<hr>
												<div class="adminButton">
													<a class="button small" style="float: right"
														<c:if test="${nickname!='admin'}">
															hidden="hidden"
														</c:if>
														href="<c:url value='/book/bookWrite.do'/>">책
														등록</a>
												</div>
											</section>
										</div>
									</div>
								</div>
						</div>
					</div>



</section></body></article>
<div>
		<!-- Scripts -->
		<script src="../assets/js/jquery.scrollgress.min.js"></script>
<%@ include file="../inc/bottom.jsp"%>
