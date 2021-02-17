<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>이벤트 - 책킷아웃</title>
<%@ include file="../inc/top.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/eventAll.css'/>" />

<script type="text/javascript"
	src="<c:url value='/ckeditor/ckeditor.js'/>"></script>

<article id="banner"></article>
<!-- Main -->
<article id="main">
	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-12 col-12-narrower">
				<div class="eventAllDiv">
					<form name="frmEventEdit" method="post"
						action="<c:url value='/eventBoard/eventEdit_ok.do'/>"
						enctype="multipart/form-data">
						<!-- 수정 시 필요한 no을 hidden으로 넣는다 -->
						<input type="hidden" name="no" value="${param.no }">
						<!-- 기존 첨부파일을 삭제해야 하므로, 기존파일 정보를 넘기기 위해 hidden 처리 -->
						<input type="hidden" name="oldFileName"
							value="${eventVo.imgFileName }">
						<fieldset>
							<legend>EVENT EDIT</legend>
							<div class="eventDiv">
								<label for="title">제목</label> <input type="text" id="title"
									name="title" value="${eventVo.title }" />
							</div>
							<div class="eventDiv">
								<label for="upfile">첨부파일</label> <input type="file" id="upfile"
									name="upfile" />
							</div>
							<div class="eventDiv">
								<span class="sp1">첨부파일 목록</span>
								<c:if test="${!empty eventVo.imgFileName }">
									<img src="<c:url value='/images/file.gif'/>" alt='파일 이미지'>
									<span>${eventVo.imgOriginFileName }</span>
									<br>
									<span style="color: red; font-weight: bold;"> 첨부파일을 새로
										지정할 경우 기존 파일은 삭제됩니다.</span>
								</c:if>
							</div>
							<div class="eventDiv">
								<label for="content">내용</label>
								<textarea id="content" name="content" class="ckeditor" rows="12"
									cols="40">${eventVo.content }</textarea>
							</div>
							<div class="center">
								<input type="submit" value="수정" /> <input type="Button"
									value="글목록"
									onclick="location.href='<c:url value="/eventBoard/eventList.do"/>'" />
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp"%>