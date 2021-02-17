	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="../inc/top.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/Map.css'/>" />
<article id="banner"></article>
	<!-- Main -->
	<article id="main">
		<!-- One -->
		<section class="wrapper style4 container">
			<div class="row gtr-150">
				<div class="col-12 col-12-narrower">
					<!-- Content -->
					<div class="content">
								<section>
								<h2> 찾아오시는 길</h2>
		<div id="map" style="width: 100%; height: 350px">
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b9d71171c0f73b7fc048f620acf5c061"></script>
		<script type="text/javascript">
          var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
              center: new kakao.maps.LatLng(
                37.498911100975185,
                127.03195344212064
              ), // 지도의 중심좌표
              level: 3, // 지도의 확대 레벨
            };

          var map = new kakao.maps.Map(mapContainer, mapOption);

          // 마커가 표시될 위치입니다
          var markerPosition = new kakao.maps.LatLng(
            37.498911100975185,
            127.03195344212064
          );

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            position: markerPosition,
          });

          // 마커가 지도 위에 표시되도록 설정합니다
          marker.setMap(map);

          var iwContent =
              '<div style="padding:5px;">첵킷아웃<br><a href="#" style="color:blue" target="_blank" class="">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            iwPosition = new kakao.maps.LatLng(
              37.498911100975185,
              127.03195344212064
            ); //인포윈도우 표시 위치입니다

          // 인포윈도우를 생성합니다
          var infowindow = new kakao.maps.InfoWindow({
            position: iwPosition,
            content: iwContent,
          });

          // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
          infowindow.open(map, marker);
        </script>
		</div>
		<br />

			
			
			
<div class="container">
<section class="section app-guide">
    <h3>책 이용 방법</h3>
    <ul class="app-list">
      <li class="app-item">
        <a class="app-item-link img-responsive" href="/hc/ko/articles/115011518868-%EC%B1%85%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%9D%BD%EB%82%98%EC%9A%94-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%B5%9C%EC%8B%A0%EB%B2%84%EC%A0%84-8-1%EC%9D%B4%EC%83%81-%EC%95%B1%EC%9D%B4%EC%9A%A9%EB%B0%A9%EB%B2%95">
          <div class="app-item-link-innerwrapper">
            <img class="img_android" src="//theme.zdassets.com/theme_assets/1696093/4d2aa67c1eff4169bda73f85885492a73f0c8fd1.png">
            <h4 class="app-title">Android</h4>
          </div>
        </a>
      </li>
      <li class="app-item">
        <a class="app-item-link" href="/hc/ko/articles/115011518888-%EC%B1%85%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%9D%BD%EB%82%98%EC%9A%94-iOS-%EC%95%B1-%EC%9D%B4%EC%9A%A9%EB%B0%A9%EB%B2%95">
          <div class="app-item-link-innerwrapper">
            <img class="img_ios img-responsive" src="//theme.zdassets.com/theme_assets/1696093/615450a863c56cadb9cdb8e0f2e688c6d64e5f5e.png">
            <h4 class="app-title">iOS</h4>
          </div>
        </a>
      </li>
    </ul>
    <div><br></div>
    <ul class="app-list">
      <li class="app-item">
        <a class="app-item-link" href="/hc/ko/articles/360041443553">
          <div class="app-item-link-innerwrapper">
            <img class="img_pc" src="//theme.zdassets.com/theme_assets/1696093/7b2ce309d9412b9445145af9dd85eabb73d92e09.png">
            <h4 class="app-title">PC</h4>
          </div>
        </a>
      </li>
      <li class="app-item">
        <a class="app-item-link" href="/hc/ko/articles/115011518828-%EC%B1%85%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%9D%BD%EB%82%98%EC%9A%94-%ED%8E%98%EC%9D%B4%ED%8D%BC-%EC%9D%B4%EC%9A%A9%EB%B0%A9%EB%B2%95">
          <div class="app-item-link-innerwrapper">
            <img class="img_paper" src="//theme.zdassets.com/theme_assets/1696093/607f6dc5052add330bf732d8113c32ba989567df.png">
            <h4 class="app-title">PAPER</h4>
          </div>
        </a>
   	  </li>
   </ul>
   </section>
  
   
        <section class="section contact">
  <section class="section contact-guide">
    <h3>고객 문의</h3>
    <ul class="contact-list">
    	<li class="contact-item">
    		<a class="contact-item-link" href="/hc/ko/requests/new">
          <div class="contact-item-link-innerwrapper">
            <img class="img_contact" src="//theme.zdassets.com/theme_assets/1696093/3b864dc10546e00d06426adf9539e5fb863d3eaa.png">
            <h4 class="contact-title">1:1 문의</h4>
          </div>
    		</a>
        <a class="contact-item-link" href="mailto:help@ridi.com">
          <div class="contact-item-link-innerwrapper">
            <img class="img_contact" src="//theme.zdassets.com/theme_assets/1696093/1b8da1044f963cc5c4aa4e647cee8327e0e92e01.png">
            <h4 class="contact-title">이메일 문의</h4>
          </div>
        </a>
        <a class="contact-item-link" href="/hc/ko/articles/360050748094">
          <div class="contact-item-link-innerwrapper">
            <img class="img_contact" src="//theme.zdassets.com/theme_assets/1696093/5765ed48513a06d495fd00fb1945c103a8e6b016.png">
            <h4 class="contact-title">채팅 상담</h4>
          </div>
        </a>
      </li>
    </ul>
  </section>
  </section>
    <section class="section contact-guide">
    <h3>제휴 문의</h3>
    <ul class="contact-list">
    	<li class="contact-item">
        <a class="contact-item-link" href="/hc/ko/sections/360008282913">
          <div class="contact-item-link-innerwrapper">
            <img class="img_contact" src="//theme.zdassets.com/theme_assets/1696093/7ac17f3947b4cea7352716d451037513b1f31f00.png">
            <h4 class="contact-title">콘텐츠 제휴</h4>
          </div>
        </a>
        <a class="contact-item-link" href="/hc/ko/articles/360058140713">
          <div class="contact-item-link-innerwrapper">
            <img class="img_contact" src="//theme.zdassets.com/theme_assets/1696093/c82176b215bea625427df39a2281368d2de03348.png">
            <h4 class="contact-title">리디셀렉트 <br>법인/단체</h4>
          </div>
    		</a>
        <a class="contact-item-link" href="/hc/ko/articles/360058140713">
          <div class="contact-item-link-innerwrapper">
            <img class="img_contact" src="//theme.zdassets.com/theme_assets/1696093/794ca08dd690703d482397ed9ce955a0ff0f68eb.png">
            <h4 class="contact-title">페이퍼<br>대량구매</h4>
          </div>
    		</a>
      </li>
    </ul>
  </section>
         </div>

		<div class="customerDiv">
			<div class="white_box"
				style="margin-top: 20px; border-top: 1px solid #ddd">
				<h3>그 외에 궁금하신 점은 아래로 문의해 주세요</h3>
				<!-- <div class="flex-area">
					<a href="./qna_entry.html" class="btn_btype">1:1 문의하기</a> <a
						href="mailto:business@millie.town" target="_blank"
						class="btn_btype">마케팅/제휴 문의</a>
				</div>
				<div class="flex-area">
					<a href="mailto:beiron@millie.town" target="_blank"
						class="btn_btype">콘텐츠 공급 문의</a> <a
						href="/customer/qna_write.html?common_code_seq=903"
						class="btn_btype">B2B 관련 문의</a>
				</div> -->
			</div>

			<div>
				<a class="white_box openBrowser" href="tel:070-7510-5415">
					<h3 class="font-weight-bold">고객센터 070-7510-5415</h3>
					<p>
						평일 10:00 ~ 18:00 (점심시간 13:00 ~ 14:00)<br /> 토/일/공휴일 Day off
					</p>
				</a>
			</div>
			<div class="white_box" style="padding: 0 0 20px">
				<p>
					※코로나19로 인해 고객센터 운영을 최소화 하고 있습니다.<br /> 통화 연결이 어려우니 <b>1:1 문의하기</b>를
					이용해주세요.
				</p>
			</div>
</div>
</section>
</div>
</div>
</div>
</section>
</article>
	
<%@ include file="../inc/bottom.jsp"%>