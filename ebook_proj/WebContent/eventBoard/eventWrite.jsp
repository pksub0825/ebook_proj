<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>이벤트 - 책킷아웃</title>
<%@ include file="../inc/top.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/eventAll.css'/>" />

<script type="text/javascript"
	src="<c:url value='/ckeditor/ckeditor.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$('#title').focus(); //제목에 포커스 맞추기

		$('form[name=frmEventWrite]').find('input[type=button]').click(function() {
			location.href = '<c:url value="/eventBoard/eventList.do"/>';
		});

		//null체크
		$('.eventAllDiv').submit(function() {
			if ($('#title').val().length < 1) {
				alert('제목을 입력하세요.');
				$('#title').focus();
				event.preventDefault();
			} else if ($('#content').val().length < 1) {
				alert('내용을 입력하세요.');
				$('#content').focus();
				event.preventDefault();
			}
		});
	});
</script>
<article id="banner"></article>
<!-- Main -->
<article id="main">
	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-12 col-12-narrower">
				<div class="eventAllDiv">
					<form name="frmEventWrite" method="post"
						action="<c:url value='/eventBoard/eventWrite_ok.do'/>"
						enctype="multipart/form-data">
						<fieldset>
							<legend>EVENT WRITE</legend>
							<div class="eventDiv">
								<label for="title">제목</label> <input type="text" id="title"
									name="title" />
							</div>
							<div class="eventDiv">
								<label for="upfile">첨부파일</label> <input type="file" id="upfile"
									name="upfile" />
							</div>
							<div>
								<label for="content">내용</label>
								<textarea name="content" class="ckeditor" id="content"></textarea>
							</div>
							<div class="center">
								<input type="submit" value="등록" /> <input type="Button"
									value="글목록" />
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</section>
</article>
<%@ include file="../inc/bottom.jsp"%>