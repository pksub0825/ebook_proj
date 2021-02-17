<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp" %>
<script type="text/javascript">
	$(function(){
		$('#cfDel').click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="<c:url value='/book/bookDel.do?no=${param.no}&txtFileName=${bookVo.txtFileName}&coverFileName=${bookVo.coverFileName}'/>";
			}
		});
	});
	
	function getText() {
		open("<c:url value='/book/readBook.do?no=${param.no}'/>", "readBook",
		"width=730, height=480, top=120, left=400, location=no, resizable=no");
	}
</script>
<article id="banner"></article>
<!-- Main -->
<article id="main">
	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-10 col-12-narrower">
				<!-- Content -->
				<div class="content">
					<section>
						<h1>책 상세정보</h1>
						<div>
							<img alt="책 표지 이미지" width="250px"
								src="<c:url value='/file_upload/${bookVo.coverFileName}'/>">
						</div><br><br>
						<p><b>책 제목</b> : ${bookVo.title}</p>
						<p><b>작가</b> :
							<a href="<c:url value='/writer/writerPage.do?no=${bookVo.wrNo}'/>">
								${writerVo.name}</a>
						<p><b>가격</b> : <fmt:formatNumber value="${bookVo.price}"
									pattern="#,###"/>원</p>
						<p><b>출판사</b> : ${bookVo.publisher}</p>
						<p><b>등록일</b> : <fmt:formatDate value="${bookVo.regdate}"
									pattern="yyyy-MM-dd"/></p>
						<br><br>
						
						<b>책 소개</b><br>
						<p class="bookContent">${bookVo.content}</p>
									
									
						<a class="button small"
							 href="<c:url value='/book/bookList.do'/>">책 목록</a>
						<div class="adminButton">
							<a class="button small"
								<c:if test="${nickname!='admin'}">
									hidden="hidden"
								</c:if>
								href="<c:url value='/book/bookEdit.do?no=${param.no}'/>">정보 수정</a>
							<a class="button small"
								<c:set var="nickname" value="세션닉네임"/>
								<c:if test="${nickname!='admin'}">
									hidden="hidden"
								</c:if>
								href="#" id="cfDel">삭제</a>
							<a class="button small" href="#" id="viewTxt"
								onclick="getText()">읽기</a>
							<div id="txtContent"></div>
						</div><br><br>
						
						<jsp:include page="../comments/comments_write.jsp"></jsp:include>			
						<jsp:include page="../comments/comments_List.jsp"></jsp:include>			
		
					</section>
				</div>
			</div>
			<div class="col-2 col-12-narrower">
				<!-- Sidebar -->
				<div class="sidebar">
					<section>
						<header>
							<h3>Magna Feugiat</h3>
						</header>
						<p>Sed tristique purus vitae volutpat commodo suscipit amet sed nibh. Proin a ullamcorper sed blandit. Sed tristique purus vitae volutpat commodo suscipit ullamcorper commodo suscipit amet sed nibh. Proin a ullamcorper sed blandit..</p>
						<footer>
							<ul class="buttons">
								<li><a href="#" class="button small">Learn More</a></li>
							</ul>
						</footer>
					</section>
					<section>
						<a href="#" class="image featured"><!-- img --></a>
						<header>
							<h3>Amet Lorem Tempus</h3>
						</header>
						<p>Sed tristique purus vitae volutpat commodo suscipit amet sed nibh. Proin a ullamcorper sed blandit. Sed tristique purus vitae volutpat commodo suscipit ullamcorper sed blandit lorem ipsum dolore.</p>
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

	<!-- Two -->
	<section class="wrapper style1 container special">
		<div class="row">
			<div class="col-4 col-12-narrower">
				<section>
					<header>
						<h3>This is Something</h3>
					</header>
					<p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
					<footer>
						<ul class="buttons">
							<li><a href="#" class="button small">Learn More</a></li>
						</ul>
					</footer>
				</section>
			</div>
			<div class="col-4 col-12-narrower">
				<section>
					<header>
						<h3>Also Something</h3>
					</header>
					<p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
					<footer>
						<ul class="buttons">
							<li><a href="#" class="button small">Learn More</a></li>
						</ul>
					</footer>
				</section>
			</div>
			<div class="col-4 col-12-narrower">
				<section>
					<header>
						<h3>Probably Something</h3>
					</header>
					<p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
					<footer>
						<ul class="buttons">
							<li><a href="#" class="button small">Learn More</a></li>
						</ul>
					</footer>
				</section>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp" %>