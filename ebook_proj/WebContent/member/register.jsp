<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp" %>

<script type="text/javascript">
	$(function() {
		$('#wr_submit').click(function() {
			if ($('#email1').val().length < 1) {
				alert('이메일을 입력하세요');
				$('#email1').focus();
				event.preventDefault();
			} else if (!validate_email($('#email1').val())) {
				alert('이메일는 영문,숫자,_만 가능합니다.');
				$('#email1').focus();
				event.preventDefault();
			} else if ($('#pwd').val().length < 1) {
				alert('비밀번호를 입력하세요');
				$('#pwd').focus();
				event.preventDefault();
			} else if ($('#nickname').val().length < 1) {
				alert('별명를 입력하세요');
				$('#nickname').focus();
				event.preventDefault();
			} else if ($('#pwd').val() != $('#pwd2').val()) {
				alert('비밀번호가 일치하지 않습니다.');
				$('#pwd2').focus();
				event.preventDefault();
			} else if (!validate_phone($('#hp2').val())
					|| !validate_phone($('#hp3').val())) {
				alert('전화번호는 숫자만 가능합니다.');
				$('#hp2').focus();
				event.preventDefault();
			} else if ($('#chkEmail').val() !="Y") {
				alert('이메일 중복확인 하세요');
				$('#btnChkEmail').focus();
				event.preventDefault();
			} else if ($('#chkNick').val() !="Y") {
				alert('별명 중복확인 하세요');
				$('#btnChkNick').focus();
				event.preventDefault();
			}
		});
		
		$('#btnChkEmail').click(function(){
			
			open("checkEmail.do?email1="+$('#email1').val()+"&email2="+$('#email2').val()+"&email3="+$('#email3').val(),"chk",
					"width=600,height=400,left=0,top=0,location=yes,resizable=yes");
		});

			
		$('#btnChkNick').click(function(){
			open("checkNickname.do?nickname="+$('#nickname').val(),"chk",
					"width=600,height=400,left=0,top=0,location=yes,resizable=yes");
		});
		
	});
	
	
</script>
<article id="banner"></article>
<!-- Main -->
<article id="main">
	<header class="special container">
	</header>

	<!-- One -->
	<section class="wrapper style4 container">
		<div class="row gtr-150">
			<div class="col-10 col-12-narrower">
				<!-- Content -->
				<div class="content">
<div class="registForm">
<form name="frm1" method="post" action="<c:url value='/member/register_ok.do'/>">
	<fieldset>
		<legend>회원 가입</legend>
		<br><br><br>
		<div>
			<label for="email1">이메일 주소</label> 
			<input type="text" name="email1" id="email1" title="이메일주소 앞자리"> @ 
				<select name="email2" id="email2" title="이메일주소 뒷자리">
					<option value="naver.com">naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="nate.com">nate.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="etc">직접입력</option>
				</select> 
			<input type="text" name="email3" id="email3" title="직접입력인 경우 이메일주소 뒷자리" style="visibility: hidden">
			<input type="button" name= "email" value="중복확인" id="btnChkEmail" title="새창열림">
		</div><br><br>
		<div>
			<label for="name">성명</label> 
			<input type="text" name="name" id="name" style="ime-mode: active">
		</div><br><br>
		<div>
			<label for="nickname">별명</label> 
			<input type="text" name="nickname"
				id="nickname" style="ime-mode: inactive">&nbsp; 
			<input type="button" value="중복확인" id="btnChkNick" title="새창열림">
		</div><br><br>
		
		<div>
			<label for="pwd">비밀번호</label> 
			<input type="Password" name="pwd" id="pwd">
		</div><br><br>
		<div>
			<label for="pwd2">비밀번호 확인</label> 
			<input type="Password" name="pwd2" id="pwd2">
		</div><br><br><br><br>
		
		<div>
			<label for="address">주소</label> 
			<span class="sp1"></span> 
			<input type="text" name="address" title="주소" class="width_350"><br /> 
			<span class="sp1"></span> 
		</div><br><br><br>
		<div class="hpDiv">
			<label for="hp1">핸드폰</label>
			<select name="hp1" id="hp1" title="휴대폰 앞자리">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="018">018</option>
				<option value="019">019</option>
			</select> -
			<input type="text" name="hp2" id="hp2" maxlength="4"
					title="휴대폰 가운데자리"> - 
			<input type="text" name="hp3" id="hp3" maxlength="4"
					title="휴대폰 뒷자리">
		</div><br><br><br><br>
		<div class="center">
			<input type="submit" id="wr_submit" value="회원가입">
		</div>
	</fieldset>

	<input type="text" name="chkEmail" id="chkEmail">
	<input type="text" name="chkNick" id="chkNick">
	
</form>
	
</div>
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