<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>이벤트 - 책킷아웃</title>
<%@ include file="../inc/top.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/assets/css/eventAll.css'/>" />

<style>
#btWrite {
	visibility: hidden;
}

#btEdit {
	visibility: hidden;
}

#btDel {
	visibility: hidden;
}

div.eventDiv p.content{ margin-left: 60px;}
</style>

<script type="text/javascript">
	$(function() {
		$('#btEdit')
				.click(
						function() {
							location.href = "<c:url value='/eventBoard/eventEdit.do?no=${param.no}'/>";
						});
		$('#btDel')
				.click(
						function() {
							if (confirm('삭제하시겠습니까?')) {
								location.href = "<c:url value='/eventBoard/eventDelete_ok.do?no=${param.no}'/>";
							} else {
								event.preventDefault();
							}
						});
		$('#btList').click(function() {
			location.href = "<c:url value='/eventBoard/eventList.do'/>";
		});
	});
</script>
<article id="banner"></article>
<!-- Main -->
<article id="main">
	<header class="special container">
		<span class="icon solid"></span>
		<h2>
			<strong>ALL ABOUT EVENT</strong>
		</h2>
	</header>
	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-9 col-12-narrower">
				<div class="eventAllDiv">
					<div class="eventDiv">
						<span class="sp1">제목</span> <span>${eventVo.title }</span>
					</div>
					<div class="eventDiv">
						<span class="sp1">등록일</span> <span> <fmt:formatDate
								value="${eventVo.regdate }" pattern="yyyy-MM-dd" />
						</span>
					</div>
					<div class="eventDiv">
						<span class="sp1">첨부파일</span>
						<c:if test="${!empty eventVo.imgFileName }">
							<img src='<c:url value="/images/file.gif"/>' alt='파일 이미지'>
							<span><a
								href="<c:url value='/eventBoard/eventDownCount.do?no=${param.no }&imgFileName=${eventVo.imgOriginFileName }'/>">
									${eventVo.imgOriginFileName }</a> 다운: ${eventVo.downCount}</span>
						</c:if>
					</div>
					<div class="eventDiv">
						<p class="content">${eventVo.content }</p>
					</div>
					<div class="center">
						<form>
							<c:if test="${nickname eq 'admin' }">
								<input type="button" id="btEdit" style="visibility: visible;"
									value="수정">
								<input type="button" id="btDel" style="visibility: visible;"
									value="삭제">
							</c:if>
								<input type="button" id="btList" style="visibility: visible;"
									value="목록">
							
						</form>
					</div>
				</div>
			</div>
			<div class="col-3 col-12-narrower">
				<!-- Sidebar -->
				<div class="sidebar">
					<section>
						<header>
							<h5>
								<img src="<c:url value='/images/pd_190.png'/>" /> EVENT
							</h5>
						</header>
						<div>
							<!-- 이벤트 -->
							<table summary="최근 이벤트 3건을 보여주는 표입니다.">
								<caption>공지사항</caption>
								<tbody>
									<!-- 반복시작 -->
									<c:if test="${empty eList }">
										<tr>
											<td colspan="3">데이터가 존재하지 않습니다.</td>
										</tr>
									</c:if>
									<c:if test="${!empty eList }">
										<c:forEach var="eVo" items="${eList}">
											<tr>
												<td style="padding-top: 10px"><img src="<c:url value='/images/dot.JPG'/>" /> <a
													href="<c:url value='/eventBoard/eventDetail.do?no=${eVo.no}'/>">
														${eVo.title } </a>
												</td>
											</tr>
										</c:forEach>
									</c:if>
									<!-- 반복 끝 -->
								</tbody>
							</table>
						</div>
						<footer>
							<ul class="buttons">
								<li><a href="<c:url value='/eventBoard/eventList.do'/>"
									class="button small">More</a></li>
							</ul>
						</footer>
					</section>
				</div>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp"%>