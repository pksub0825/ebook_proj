<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jsp"%>
<article id="banner"></article>
<script type="text/javascript">
	$(function() {
		$('#email').focus();

		$('form[name=frmLogin]').submit(function() {
			$('.infobox').each(function(idx, item) {
				if ($(this).val().length < 1) {
					alert($(this).prev().text() + "를 입력하세요");
					$(this).focus();
					event.preventDefault();
					return false;
				}
			});
		});
	});
</script>
<%
	//쿠키 읽어오기
	String ckValue="";
	Cookie[] ckArr=request.getCookies();
	if(ckArr!=null){
		for(int i=0; i<ckArr.length;i++){
			if(ckArr[i].getName().equals("ck_userid")){
				ckValue=ckArr[i].getValue();
				break;
			}
		}//for
	}
%>


<article class="simpleForm">
	<form name="frmLogin" method="post" action="login_ok.do">
		<fieldset>
			<legend>로그인</legend>
			<br><br>
			<div>
				<label for="email" class="label">이메일</label> 
				<input type="text" name="email" id="email" 
				class="infobox" value="${param.email}">
				<!-- span태그 넣어도됨 : 아이디를 입력하세요 <<이런식으로 -->
			</div>
			<br>
			<div>
				<label for="pwd" class="label">비밀번호</label> 
				<input type="password" name="pwd" id="pwd" class="infobox">
			</div>
			<br>
			<div class="align_center">
				<input type="submit" id="lg_submit" value="로그인"> 
				<%-- <input type="checkbox" name="chkSave"
					<%if(ckValue!=null && !ckValue.isEmpty()){%>
						checked="checked"
					<%}%>
				> 
				<label for="chkSave">아이디 저장하기</label>--%>
			<a href="<c:url value='/member/register.do'/>" class="button primary">회원가입</a></div>
			
		</fieldset>
	</form>
</article>
<%@ include file="../inc/bottom.jsp" %>