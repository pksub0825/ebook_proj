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
	$('#btEdit')
			.click(
					function() {
						location.href = "<c:url value='/comments/comments_edit.do?no=${param.no}'/>";
					});
			});
			function  del_cmt(num)  {
				if (confirm('작성하신 한 줄 리뷰를 삭제하시겠습니까?')) {
					location.href = "<c:url value='/comments/comments_delete.do?no='/>"+num+"&bookNo="+${param.no};
				} else {
					event.preventDefault();
				}
			}
			
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
												${loginNick}
												님<br /> 한 줄 리뷰를 작성해보세요
											</p>
												 <i class="fas fa-user-circle fa-4x solid lightgray" style="color: #757575"></i>
										</div>
									
									<div class="register">
									<form method="post" name="cmtFrm"
										action="<c:url value='/comments/comments_write_ok.do'/>">
											<!-- post로 전송할 것들 -->
											<!-- hidden으로 변경하기 -->
											<input type="hidden" name="bookNo" id="bookNo"
												value="${param.no}"> 
												<input type="hidden" name="nickname" id="nickname" value="${loginNick}" /> 
										<textarea placeholder="한 줄 리뷰를 남겨주세요" maxlength="50"
											class="textarea" id="content" name="content" style="height: 82px; border-color:gray"></textarea>
										<!-- 글자수 체크 -->
										<div class="text-number">
											<p>
												<span id="counter"></span>
											</p>
										</div>
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
										<c:forEach var="i" begin="0" end="${fn:length(commList)-1}">
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
												 <pre class="cont">${commVo.content }</pre>
												<div class="review-setting">
													<p>이 리뷰가 마음에 드시나요?</p>
													<button type="submit" class="like-button gtm-review-like">
														<i class="far fa-heart"></i> <span>${95-i*7 }</span>
													</button>
												</div>
												<!--  닉네임 일치시, admin 삭제 버튼  -->
												<c:if test="${nickname eq commVo.nickname || nickname eq 'admin'}" >
												<div class="more-area">
													<!-- hidden으로 변경 -->
													<c:set var="num" value="${commVo.no}"/>
													<!-- 댓글 번호 확인용 -->
													<input type="hidden" value="${commVo.no}"
														name="no" id="no"> 
															<a href="#" class="btDel" onclick="del_cmt(${commVo.no})" >삭제하기</a>
														<input type="button" id="btEdit" value="수정하기">
												</div> 
												</c:if>
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