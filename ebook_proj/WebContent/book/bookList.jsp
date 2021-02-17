<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp" %>
<style type="text/css">
	div#underMenuBoard section{
		border-radius: 10%;
		padding: 20px;
		color: white;
		height: 280px;
	}
</style>
<article id="banner"></article>
<!-- Main -->
<article id="main">
	<header class="special container">
		<span class="icon solid"></span>
		<h2><strong>BOOK</strong></h2>
		<p>수 많은 독자들이 선택한 화제의 인기작 !!</p>
	</header>

	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-12 col-12-narrower">
				<!-- Content -->
				<div class="content">
					<section>
						<div class="divList">
							<table class="default" border="1">
								<colgroup>
									<col style="width:5%;" />
									<col style="width:40%;" />
									<col style="width:20%;" />
									<col style="width:10%;" />
									<col style="width:5%;" />
									
								</colgroup>
								<thead>
									<tr>
										<th>표지</th>
										<th>책 제목</th>
										<th>출판사</th>
										<th>등록일</th>
										<th>조회</th>
										
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty bookList}">
										<tr>
											<td colspan="5">데이터가 존재하지 않습니다.</td>
										</tr>
									</c:if>
									<c:if test="${!empty bookList}">
										<c:set var="num" value="${pageVo.num}"/>
										<c:set var="curPos" value="${pageVo.curPos}"/>
										<c:forEach var="i" begin="1" end="${pageVo.pageSize}">
											<c:if test="${num>=1}">
												<c:set var="bookVo" value="${bookList[curPos]}"/>
										  		<c:set var="curPos" value="${curPos+1}"/>
										 		<c:set var="num" value="${num-1}"/>
												
												<tr>
													<td>
														<img alt="표지 이미지"
															src="<c:url value='/file_upload/${bookVo.coverFileName}'/>"
																width="100px">
													</td>
													<td><a href="<c:url value='/book/readCount.do?no=${bookVo.no}'/>">
														${bookVo.title}</a></td>
													<td>${bookVo.publisher}</td>
													<td><fmt:formatDate value="${bookVo.regdate}"
														pattern="yyyy-MM-dd"/></td>
													<td>${bookVo.readCount}</td>
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
								<a href="<c:url value='/book/bookList.do?curPage=${pageVo.firstPage-1}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
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
										<a href="<c:url value='/book/bookList.do?curPage=${i}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
											[${i}]</a>
									</c:if>
								</c:if>
							</c:forEach>
							
							<!-- 다음 블럭 -->
							<c:if test="${pageVo.lastPage<pageVo.totalPage}">
								<a href="<c:url value='/book/bookList.do?curPage=${pageVo.lastPage+1}&srchCondition=${param.srchCondition}&srchKeyword=${param.srchKeyword}'/>">
									<img alt="이전 블럭으로" src="../images/first.JPG"></a>
							</c:if>
						</div>
						<div class="divSearch">
							<form name="frmSearch" action="<c:url value='/book/bookList.do'/>" method="post">
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
								href="<c:url value='/book/bookWrite.do'/>">책 등록</a>
						</div>				
					</section>
				</div>
			</div>
		</div>
	</section>

	<!-- Two -->
	<section class="wrapper style1 container special">
		<div class="row">
			<div class="col-4 col-12-narrower" id="underMenuBoard">
				<section style="background-image: url('<c:url value="/images/eventBoardBg.png"/>')">
					<header>
						<h3>Event<br>게시판</h3>
					</header>
					<br>
					<p>다양한 이벤트들과 크나큰 혜택들을 지금 바로 확인해보세요 </p>
					<footer>
						<ul class="buttons">
							<li><a href="<c:url value='/eventBoard/eventList.do'/>" class="button small">Event 알아보기</a></li>
						</ul>
					</footer>
				</section>
			</div>
			<div class="col-4 col-12-narrower" id="underMenuBoard">
				<section style="background-image: url('<c:url value="/images/WriterBoardBg.png"/>')">
					<header>
						<h3>작가 게시판</h3>
					</header>
					
					<p>즐겨 보던 책들의</p>
					<p>작가들을 만나보세요</p>
					<footer>
						<ul class="buttons">
							<li><a href="<c:url value='/writer/writerList.do'/>" class="button small">작가 게시판으로</a></li>
						</ul>
					</footer>
				</section>
			</div><div class="col-4 col-12-narrower" id="underMenuBoard">
				<section style="background-image: url('<c:url value="/images/bestSellBg.png"/>')">
					<header>
						<h3>BestSeller</h3>
					</header>
					<p>베스트셀러 Top3를</p>
					<p>지금 바로 확인할 수 있습니다!</p>
					<footer>
						<ul class="buttons">
							<li><a href="<c:url value='/main.do'/>" class="button small">메인 화면으로</a></li>
						</ul>
					</footer>
				</section>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp" %>