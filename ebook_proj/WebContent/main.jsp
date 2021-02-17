<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="inc/top.jsp" %>
<style type="text/css">
.wrapper style1 container special .carousel slide .carousel-inner {
	width: 70%;
	height: 200px;
	overflow: hidden;
}

.carousel-inner div img{
	max-width: 100%;
	height: auto;
	display: block;
}
</style>
<!-- Banner -->
<section id="banner">
	<div class="inner">
		<header>
			<h2>책킷아웃</h2>
		</header>
		<p>
			책킷아웃에서 <b>새로운 이야기</b>가<br /> 당신을 기다립니다.
		</p>
		<footer>
			<ul class="buttons stacked">
				<li><a href="#main" class="button fit scrolly">Tell Me More</a></li>
			</ul>
		</footer>
	</div>
</section>
<!-- Main -->
<article id="main">
	<header class="special container">
		<h2>
			수많은 이야기들을 <strong>누구보다도 먼저</strong> 읽어보세요<br>
		</h2>
		<p>
			책킷아웃에서는 <strong>신간 소개</strong>와 <strong>인기 작가</strong>들의 작품을<br>
			가장 먼저 만나보실 수 있습니다.<br /> 간편하게 온라인에서도, 오프라인에서도 언제든 책을 읽을 수 있는 환경을
			지향합니다.<br />
		</p>
	</header>

	<section class="wrapper style1 container special">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-bs-ride="carousel">
			<ol class="carousel-indicators">
				<li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
					class="active"></li>
				<li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
				<li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<c:url value='/eventBoard/eventDetail.do?no=239'/>"><img src="<c:url value='/images/internationalday.jpg'/>"
						class="d-block w-100" alt="세계문해의날 이미지"></a>
				</div>
				<div class="carousel-item">
					<a href="<c:url value='/eventBoard/eventDetail.do?no=1'/>"> <img
						src="<c:url value='/images/merry_christmas.jpg'/>"
						class="d-block w-100" alt="크리스마스 이미지"></a>
				</div>
				<div class="carousel-item">
					<a href="<c:url value='/eventBoard/eventDetail.do?no=224'/>">
						<img src="<c:url value='/images/newyear.jpg'/>"
						class="d-block w-100" alt="새해 이미지"></a>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-bs-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span></a> <a
				class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-bs-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span></a>
		</div>
	</section>
	<!-- 베스트 셀러 -->
	<section class="wrapper style3 container special">
		<header class="major">
			<h2>
				<strong>베스트셀러</strong> Top3
			</h2>
		</header>
		<div class="row">
			<div class="col-12 col-12-narrower">
				<section class="bestSeller">
					<c:forEach var="bookVo" items="${bookList}">
						<div></div>
						<div class="imgBlock">
							<a href="<c:url value='/book/bookDetail.do?no=${bookVo.no}'/>" class="image featured">
								<img src="<c:url value='/file_upload/${bookVo.coverFileName}'/>" alt="" />
							</a>
						</div>
						<header>
							<h3>${bookVo.title}</h3>
						</header>
						<p class="bsContent">${bookVo.content}</p>
					</c:forEach>
				</section>
			</div>
		</div>
		<footer class="major">
			<ul class="buttons">
				<li>
					<a href="<c:url value='/book/bookList.do'/>" class="button">
						See More</a>
				</li>
			</ul>
		</footer>
	</section>
</article>
<!-- CTA -->
<section id="cta">
	<header>
		<h2>(주) 책킷아웃</h2>
		<p></p>
	</header>
	<footer>
		<ul class="buttons">
			<li><a href="<c:url value='/comments/Map.jsp'/>" class="button primary">찾아오시는 길</a></li>
			<li><a href="#main" class="button">맨 위로</a></li>
		</ul>
	</footer>
</section>
<%@ include file="inc/bottom.jsp" %>
