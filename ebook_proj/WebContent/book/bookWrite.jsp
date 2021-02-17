<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp" %>
<script type="text/javascript">
	$(function(){
		$('#bookWr_submit').click(function(){
			if($('#title').val().length<1){
				alert('책 제목을 입력하세요');
				$('#title').focus();
				event.preventDefault();
			}else if($('#price').val().length<1){
				alert('가격을 입력하세요');
				$('#price').focus();
				event.preventDefault();
			}else if(!validate_phone($('#price').val())){//핸드폰 숫자체크 재사용
				alert("가격은 숫자만 입력 가능합니다.");
				$('#price').focus();
				event.preventDefault();
			}else if($('#publisher').val().length<1){
				alert('출판사를 입력하세요');
				$('#publisher').focus();
				event.preventDefault();
			}else if($('#chkWrNo').val()!='Y'){
				alert('작가명을 확인하세요');
				$('#btnWriter').focus();
				event.preventDefault();
			}
		});
		
		$('#btnWriter').click(function(){
			open("<c:url value='/book/findWriter.do?writer='/>"+$('#writer').val(), "findWriter",
			"width=500, height=550, left=0, top=0, location=yes, resizable=yes");
		});
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
						<div class="divbookWrite">
						<h2>책 등록</h2><br><br><br>
							<form name="frmWrite" action="<c:url value='/book/bookWrite_ok.do'/>"
									method="post" enctype="multipart/form-data">
								<label for="title">책 제목</label>
								<input type="text" name="title" id="title"><br>
								<label for="price">가격</label>
								<input type="text" name="price" id="price"><br>
								<label for="publisher">출판사</label>
								<input type="text" name="publisher" id="publisher"><br><br>
								
								<label for="wrNo">작가명</label>
								<input type="hidden" name="wrNo" id="wrNo"><br>
								<input type="text" name="writer" id="writer"><br>
								<input type="Button" value="작가 번호 확인" id="btnWriter" title="새창열림"><br>
								<br><br>
								<label for="content">책 소개</label>
								<textarea rows="5" name="content"></textarea>
								<br><br>
								
           						<label for="txtUpload">텍스트 첨부파일 : </label>
           						<input type="file" id="txtUpload" name="txtUpload" /><br>
								<label for="coverUpload">책표지 첨부파일 : </label>
           						<input type="file" id="coverUpload" name="coverUpload" /><br>
           						<br><br><br>
           						
								<input type="submit" id="bookWr_submit" value="책 등록">
								<input type ="hidden" name="chkWrNo" id="chkWrNo">
							</form>
						
						</div>
							<hr>
							<a class="button small"
								href="<c:url value='/book/bookList.do'/>">책 목록</a>
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

</body>
</html>