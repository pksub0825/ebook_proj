<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>이벤트 - 책킷아웃</title>
<%@ include file="../inc/top.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/assets/css/eventList.css'/>">
<style type="text/css">
#btWrite {
	visibility: hidden;
}

</style>

<script type="text/javascript">
$(function(){
	$('#btWrite').click(function(){
		location.href="<c:url value='/eventBoard/eventWrite.do'/>";
	});
});

function pageFunc(curPage){
	$('input[name=currentPage]').val(curPage);
	$('form[name=frmPage]').submit();
}
</script>

<form name="frmPage" action="<c:url value='/eventBoard/eventList.do'/>"
	method="post">
	<input type="hidden" name="currentPage"> <input type="hidden"
		name="searchKeyword" value="${param.keyword }"> <input
		type="hidden" name="searchCondition" value="${param.condition }">
</form>

<article id="banner"></article>
<!-- Main -->
<article id="main">
	<header class="special container">
		<span class="icon solid"></span>
		<h2>
			<strong>EVENT</strong>
		</h2>
	</header>
	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-12 col-12-narrower">
				<c:if test="${!empty param.searchKeyword}">
					<p>검색어 : ${param.searchKeyword }, ${pageVo.totalRecord } 건
						검색되었습니다.</p>
				</c:if>
				<!-- Content -->
				<div class="content">
					<section>
						<div class="divList">
							<table class="default" border="1"
								summary="기본 게시판에 관한 표로써, 번호, 제목, 등록일에 대한 정보를 제공합니다.">
								<caption>기본 게시판</caption>
								<colgroup>
									<col style="width: 20%;" />
									<col style="width: 60%;" />
									<col style="width: 20%;" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col">제목</th>
										<th scope="col">등록일</th>
									</tr>
								</thead>
								<tbody>
									<!-- 게시판 내용 반복문 시작 -->
									<c:if test="${empty eventList }">
										<tr>
											<td colspan="5" style="text-align: center">게시물이 없습니다.</td>
										</tr>
									</c:if>
									<!-- 게시물이 있으면 for문 돌리기 -->
									<c:if test="${!empty eventList }">
										<c:set var="num" value="${pageVo.num }"></c:set>
										<c:set var="curPos" value="${pageVo.curPos }"></c:set>

										<c:forEach var="i" begin="1" end="${pageVo.pageSize }">
											<c:if test="${num>=1 }">
												<c:set var="vo" value="${eventList[curPos] }" />
												<c:set var="num" value="${num-1 }" />
												<c:set var="curPos" value="${curPos+1}" />
												<tr>
													<td>${vo.no }</td>
													<td><a href="eventDetail.do?no=${vo.no }"> <!-- 파일이 업로드된 경우 파일 이미지 보여주기 -->
															<c:if test="${!empty vo.imgFileName }">
																<img src="<c:url value='/images/file.gif'/>"
																	alt='파일 이미지'>
															</c:if> <!-- 제목이 30자 이상인 경우, 30자리만 보여주고 나머지 생략하기 --> <c:if
																test="${fn:length(vo.title)>=30}">
																${fn:substring(vo.title,0,30) }....
															</c:if> <c:if test="${fn:length(vo.title)<30}">
																${vo.title }
															</c:if>
													</a></td>
													<td><fmt:formatDate value="${vo.regdate }"
															pattern="yyyy-MM-dd" /></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:if>
									<!-- 게시판 내용 반복문 종료 -->
								</tbody>
							</table>
						</div>
						<div class="divPage">
							<!-- 페이지 번호 추가 -->
							<!-- 이전 블럭으로 이동 -->
							<c:if test="${pageVo.firstPage>1 }">
								<a href="#" onclick="pageFunc(${pageVo.firstPage-1})"> <img
									src="<c:url value='/images/first.JPG'/>" alt="이전블럭으로 이동">
								</a>
							</c:if>
							<!-- [1][2][3][4][5][6][7][8][9][10] -->
							<c:forEach var="i" begin="${pageVo.firstPage }"
								end="${pageVo.lastPage }">
								<c:if test="${i <= pageVo.totalPage }">
									<c:if test="${i==pageVo.currentPage }">
										<span style="color: red; font-weight: bold">${i }</span>
									</c:if>
									<c:if test="${i!=pageVo.currentPage }">
										<a href="#" onclick="pageFunc(${i})">[${i }]</a>
									</c:if>
								</c:if>
							</c:forEach>
							<!-- 다음 블럭으로 이동 -->
							<c:if test="${pageVo.lastPage < pageVo.totalPage }">
								<a href="#" onclick="pageFunc(${pageVo.lastPage+1})"> <img
									src="<c:url value='/images/last.JPG'/>">
								</a>
							</c:if>
							<!--  페이지 번호 끝 -->
						</div>
						<div class="divSearch">
							<form class="frmSearch" method="post"
								action="<c:url value='/eventBoard/eventList.do'/>">
								<select name="searchCondition" style="margin-left: 10%">
									<option value="title"
										<c:if test="${title eq param.searchCondition }">
											selected="selected"
										</c:if>>제목
									</option>
								</select>
								<input type="text" name="searchKeyword" title="검색어 입력"
									value="${param.searchKeyword }">
								<input type="submit" value="검색">
							</form>
						</div>
						<div class="divBtn">
							<c:if test="${nickname eq 'admin'}">
								<input type="button" id="btWrite" value="글쓰기"
									style="visibility: visible;">
							</c:if>
						</div>
					</section>
				</div>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp"%>