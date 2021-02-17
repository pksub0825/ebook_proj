<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../inc/top.jsp" %>

<link rel="stylesheet"
	href="<c:url value='/assets/css/realcmt_detail.css'/>" />
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="<c:url value='/js/jquery-3.5.1.min.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$('#content').keyup(function(e) {
			var content = $(this).val();
			$(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
			$('#counter').html(content.length + '/50');
		});
		$('#content').keyup();
	});
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
								<div class="sub-content">
									<div class="sub-inner review-profile line">
										<div class="profile">
											<p class="nickname">
												${nickname}
												님<br /> 한 줄 리뷰를 작성해보세요
											</p>
												 <i class="fas fa-user-circle fa-4x solid lightgray" style="color: #757575"></i>
										</div>
									
									<div class="register">
									<form method="post" name="cmtFrm"
										action="<c:url value='/comments/comments_write_ok.do'/>">
											<!-- hidden으로 변경하기 -->
											<input type="hidden" name="bookNo" id="bookNo"
												value="${bookNo}"> 
												<input type="hidden"	name="nickname" id="nickname" value="${nickname}" /> 
										<textarea placeholder="한 줄 리뷰를 남겨주세요" maxlength="50"
											class="textarea" id="content" name="content"></textarea>
										<input type="submit" class="gtm-review-register disabled"
											value="리뷰 등록하기" name="button" id="button">
									</form>
										<!-- 글자수 체크 -->
									<div class="text-number">
										<p>
											<span id="counter"></span>
										</p>
									</div>
									</div>
								</div>
							</div>
							<div class="sub-inner p0 review-detail">
								<p class="review-count">
									총
									${fn:length(commList) }개
								</p>
								</div>
								<!-- 댓글 반복문시작 -->
								<c:if test="${empty commList}">
									<p>등록된 리뷰가 없습니다.</p>
								</c:if>
								<c:if test="${!empty commList}">
										<c:forEach var="i" begin="1" end="${fn:length(commList)}">
										<c:set var="commVo" value="${commList[i] }" />
									<ul class="review-list">
										<li>
											<div class="">
												<i class="fas fa-user-circle fa-2x solid lightgray"
													style="color: #757575"></i> 
											</div>
											<div class="info">
												<p class="nickname">
													<a href="#" class="gtm-review-lib">${commVo.nickname}</a>
													<!--1등이면-->
													<c:if test="${i==1}">
													<strong class="rank">1등</strong>
													</c:if>
														<c:if test="${i <= 2}">
													<strong class="best">Best</strong>
														</c:if>
												</p>
												<span class="date"><fmt:formatDate value="${commVo.regdate}" 
													pattern="yyyy-MM-dd hh:mm:ss "/></span>
													
												
												<!--  닉네임 일치시 삭제 버튼  -->
												<c:if test="${nickname eq commVo.nickname || nickname eq 'admin'}" />
												<div class="more-area">
													<!-- hidden으로 변경 -->
													<form name="cmtFrm" method="post"
						action="<c:url value='/comments/comments_edit_ok.do'/>">
													<input type="hidden" value="${commVo.no}"
														name="no" id="no"> 
														<input type="hidden" value="${commVo.bookNo}"
														name="bookNo" id="bookNo"> 
														<div class="edit">
														<textarea  maxlength="50"
											class="textarea" id="content" name="content">${commVo.content }</textarea>
											<input type="submit" id="btEdit" value="수정하기">
											</div>
												</form>
												</div> 
												<div class="review-setting">
													<p>이 리뷰가 마음에 드시나요?</p>
													<button type="submit" class="like-button gtm-review-like">
														<i class="far fa-heart"></i> <span>${95-i*7 }</span>
													</button>
												</div>
											</div>
										</li>
									</ul>
									</c:forEach>
								</c:if>
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
							<a href="#" class="image featured">
								<!-- img -->
							</a>
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
		<!-- Two -->
		<section class="wrapper style1 container special">
			<div class="row">
				<div class="col-4 col-12-narrower">
					<section>
						<header>
							<h3>This is Something</h3>
						</header>
						<p>Sed tristique purus vitae volutpat ultrices. Aliquam eu
							elit eget arcu commodo suscipit dolor nec nibh. Proin a
							ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
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
						<p>Sed tristique purus vitae volutpat ultrices. Aliquam eu
							elit eget arcu commodo suscipit dolor nec nibh. Proin a
							ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
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
						<p>Sed tristique purus vitae volutpat ultrices. Aliquam eu
							elit eget arcu commodo suscipit dolor nec nibh. Proin a
							ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
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