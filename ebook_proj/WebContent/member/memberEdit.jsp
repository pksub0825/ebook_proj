<%@page import="java.sql.SQLException"%>
<%@page import="com.semiproj.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp" %>
<script type="text/javascript">
	$(function() {
		$('#edit_submit').click(function() {
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
			} else if ($('#pwd').val() != $('#pwd2').val()) {
				alert('비밀번호가 일치하지 않습니다.');
				$('#pwd2').focus();
				event.preventDefault();
			} else if (!validate_phone($('#hp2').val())
					|| !validate_phone($('#hp3').val())) {
				alert('전화번호는 숫자만 가능합니다.');
				$('#hp2').focus();
				event.preventDefault();
			}
		});
		
		$('#email22').change(function(){
			if($(this).val()=='etc'){
				$('#email3').css('visibility', 'visible');
			}else{
				$('#email3').css('visibility', 'hidden');
				
			}
		});
		
		/*$('#btnChkEmail').click(function(){
			open("checkEmail.do?email1="+$('#email1').val()+"&email2="+$('#email2').val()+"&email3="+$('#email3').val(),"chk",
				"width=600,height=400,left=0,top=0,location=yes,resizable=yes");
		});*/
		
		$('#btnMemberOut').click(function(){
			if (confirm("계정을 삭제 하시겠습니까?")) {
				location.href="<c:url value='/member/memberOut.do'/>";
			}
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
<form name="frm1" method="post" action="<c:url value='/member/memberEdit_ok.do'/>">
	<fieldset>
		<legend>회원 수정</legend>
			<input type="hidden" name="chkEmail" id="chkEmail">
			<input type="hidden" name="chkNick" id="chkNick">
		<br><br><br>
		<div>
			<label for="email">이메일 주소</label> 
			<input type="text" name="email" id="email" readonly
				title="이메일주소 앞자리" value="${memVo.email}">
			<!-- 이메일 주소 변경 필요없음
			<label for="email1">이메일 주소</label> 
			<input type="text" name="email1" id="email1" title="이메일주소 앞자리" value="${email1}"> @ 
			<select name="email2" id="email2" title="이메일주소 뒷자리" onchange="">
				<option value="naver.com" 
					<c:if test="${email2 == 'naver.com'}">
						selected="selected"
					</c:if>>naver.com</option>
				<option value="hanmail.net" 
					<c:if test="${email2 == 'hanmail.net'}">
						selected="selected"
					</c:if>>hanmail.net</option>
				<option value="nate.com"
					<c:if test="${email2 == 'nate.com'}">
						selected="selected"
					</c:if>>nate.com</option>
				<option value="gmail.com"
					<c:if test="${email2 == 'gmail.com'}">
						selected="selected"
					</c:if>>gmail.com</option>
				<option value="etc"
					<c:if test="${isEtc == 'y'}">
						selected="selected"
					</c:if>>직접입력</option>
			</select> 
			<input type="text" name="email3" id="email3" title="직접입력인 경우 이메일주소 뒷자리"
				<c:if test="${isEtc == 'y' }">
					style="visibility: visible" value="${email2}"
				</c:if>
				<c:if test="${isEtc == 'n' }">
					style="visibility: hidden" value=""
				</c:if>
			>
			<input type="button" value="중복확인" id="btnChkEmail" title="새창열림"> -->
		</div><br><br>
		<div>
			<label for="name">이름</label> 
			<input type="text" name="name"
				id="name" value="${memVo.name }" readonly>
		</div><br><br>
		<div>
			<label for="nickname">닉네임</label> 
			<input type="text" name="nickname"
				id="nickname" value="${memVo.nickname}" readonly>&nbsp; 
			<!-- <input type="button" value="중복확인" id="btnChknick" title="새창열림"> -->
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
			<input type="text" name="address" title="주소"
				class="width_350" value="${memVo.address}"><br /> 
			<span class="sp1"></span> 
		</div><br><br><br>
		<div class="hpDiv">
			<label for="hp1">핸드폰</label>
			<select name="hp1" id="hp1" title="휴대폰 앞자리">
				<option value="010"
					<c:if test="${hp1 == 010}">
						selected="selected"
						</c:if>>010</option>
				<option value="011"
					<c:if test="${hp1 == 011}">
						selected="selected"
						</c:if>>011</option>
				<option value="016"
					<c:if test="${hp1 == 016}">
						selected="selected"
					</c:if>>016</option>
				<option value="017"
					<c:if test="${hp1 == 017}">
						selected="selected"
					</c:if>>017</option>
				<option value="018"
					<c:if test="${hp1 == 018}">
						selected="selected"
					</c:if>>018</option>
				<option value="019"
					<c:if test="${hp1 == 019}">
						selected="selected"
					</c:if>>019</option>
			</select> -
			<input type="text" name="hp2" id="hp2" maxlength="4"
					title="휴대폰 가운데자리" value="${hp2}"> - 
			<input type="text" name="hp3" id="hp3" maxlength="4"
					title="휴대폰 뒷자리" value="${hp3}">
		</div><br><br><br><br>
		<div class="center">
			<input type="submit" id="edit_submit" value="정보 수정">
			<input type="button" name= "memberOut" value="회원 탈퇴" id="btnMemberOut" title="새창열림">
		</div>
	</fieldset>
</form>
</div>
				</div>
			</div>
		</div>
	</section>
<%@ include file="../inc/bottom.jsp" %>