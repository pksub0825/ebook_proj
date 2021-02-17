<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article id="banner"></article>
<!-- Main -->
<article id="main">
	<header class="special container" style="margin-bottom: 0">
		<span class="icon solid"></span>
		<h2><strong>작가</strong>를 만나보다</h2>
	</header>

	<!-- One -->
	<section class="wrapper style4 container" style="width: 70%; max-width: 1000px">
		<div class="row gtr-150">
			<div class="col-12 col-12-narrower">
				<!-- Content -->
				<div class="content">
					<section>
						<div class="divList">
							<table class="default" border="1">
								<colgroup>
									<col style="width:20%;" />
									<col style="width:80%;" />
								</colgroup>
								<thead>
									<tr>
										<th>작가 이미지</th>
										<th>이름</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty writerList}">
										<tr>
											<td colspan="5">데이터가 존재하지 않습니다.</td>
										</tr>
									</c:if>
									<c:if test="${!empty writerList}">
										<c:set var="num" value="${pageVo.num}"/>
										<c:set var="curPos" value="${pageVo.curPos}"/>
										<c:forEach var="i" begin="1" end="${pageVo.pageSize}">
											<c:if test="${num>=1}">
												<c:set var="wrVo" value="${writerList[curPos]}"/>
										  		<c:set var="curPos" value="${curPos+1}"/>
										 		<c:set var="num" value="${num-1}"/>
												
												<tr>
													<td>
														<img alt="작가 이미지"
															src="<c:url value='/file_upload/${wrVo.photoFileName}'/>"
																width="100px" height="100px">
													</td>
													<td><a href="<c:url value='/writer/writerPage.do?no=${wrVo.no}'/>">
														${wrVo.name}</a></td>
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
								<a href="<c:url value='/writer/writerList.do?curPage=${pageVo.firstPage-1}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
									<img alt="이전 블럭으로" src="../images/first.JPG"></a>
							</c:if>
							
							<!-- 페이지 목록 -->
							<c:forEach var="i" begin="${pageVo.firstPage}"
										end="${pageVo.lastPage}">
								<c:if test="${i<=pageVo.totalPage}">
									<c:if test="${param.curPage==i}">
										<span style="color: #d1230a; font-weight: bold">${i}</span>
									</c:if>
									<c:if test="${param.curPage!=i}">
										<a href="<c:url value='/writer/writerList.do?curPage=${i}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
											[${i}]</a>
									</c:if>
								</c:if>
							</c:forEach>
							
							<!-- 다음 블럭 -->
							<c:if test="${pageVo.lastPage<pageVo.totalPage}">
								<a href="<c:url value='/writer/writerList.do?curPage=${pageVo.lastPage+1}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
									<img alt="이전 블럭으로" src="../images/first.JPG"></a>
							</c:if>
						</div>
						<div class="divSearch">
							<form name="frmSearch" action="<c:url value='/writer/writerList.do'/>" method="post">
								<select name="srchCondition">
									<option value="title" 
										<c:if test="${'title'==param.srchCondition}">
								            selected="selected"
								        </c:if>> 제목</option>
								    <option value="writer"
										<c:if test="${'writer'==param.srchCondition}">
								            selected="selected"
								        </c:if>> 작가명</option>
								    <option value="publisher"
										<c:if test="${'publisher'==param.srchCondition}">
								            selected="selected"
								        </c:if>> 출판사</option>
								</select>
								<input type="text" name="srchKeyword" value="${param.srchKeyword}">
								<input type="submit" value="검색">
							</form>
						
						</div>
						<hr>
						<div class="adminButton">
							<a class="button small" style="float: right"
								<c:if test="${nickname!='admin'}">
									hidden="hidden"
								</c:if>
								href="<c:url value='/writer/writerInsert.do'/>">작가 등록</a>
						</div>				
					</section>
				</div>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp" %>