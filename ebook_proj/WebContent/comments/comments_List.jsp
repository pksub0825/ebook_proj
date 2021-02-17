<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<title>댓글리스트 보여주기</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/assets/css/realcmt_2.css'/>" />
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<meta charset="utf-8">
<script type="text/javascript"></script>
</head>
<body>
	<form method="post" name="cmtFrm"
		action="<c:url value='/comments/comments_detail.do?no=${bookNo}'/>">
		<div id="anchorReview" class="review-container thin-line">
			<input type="hidden" name="bookNo" id="bookNo" value="${bookNo}">
			<input type="hidden"	name="nickname" id="nickname" value="${nickname}" /> 
			<div class="review-bt">
			<h3 class="book-info-title link">
				<button type="submit" class="gtm-review-2depth" style="min-width: 200px">
					한 줄 리뷰 <span class="number">${fn:length(commList)}</span><i class="fas fa-chevron-right"></i>
			</button>
			</h3>
			</div>
			<c:if test="${empty commList}">
				<p>등록된 리뷰가 없습니다.</p>
			</c:if>
			<!-- 리스트 진짜 -->
		 	<c:if test="${!empty commList}">
				<c:forEach var="i" begin="0" end="${fn:length(commList)-1}">
					<c:if test="${i<3}">
					<c:set var="commVo" value="${commList[i] }" />
					<ul class="review-list">
					<li>
						<div class="" >
							<i class="fas fa-user-circle fa-2x" style="color: #757575"></i> <a
								href="#" class="gtm-review-lib"></a>
						</div>
						<div class="info">
							<p class="nickname">
								<a href="#" class="gtm-review-lib"> &nbsp; ${commVo.nickname}</a>
							</p>
							<span class="date"><fmt:formatDate value="${commVo.regdate}" 
													pattern="yyyy-MM-dd hh:mm:ss "/></span>
							<a
								href="<c:url value='/comments/comments_detail.do?no=${session.bookNo}'/>"
								class="gtm-review-textclick" id="textclick"> 
								<pre class="cont">${commVo.content}</pre>
							</a> 
							<div class="review-setting" style="float: right">
								<p style="margin-bottom: 5px; margin-right: 15px; font-size: 12px">이 리뷰가 마음에 드시나요?</p>
								<button type="submit" class="like-button gtm-review-like" style="min-width: 60px">
									<i class="far fa-heart"></i> <span>${95-i*7}</span>
								</button>
							</div>
						</div>
					</li>
				</ul>
				</c:if>
				</c:forEach>
			</c:if>
		</div>
	</form>
</body>
</html>