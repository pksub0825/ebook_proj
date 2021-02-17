<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value='/assets/js/jquery-3.5.1.min.js'/>"></script>
<script type="text/javascript">
	$(function(){
		$('#pwd').focus();
		
		$('form[name=frmOut]').submit(function(){
			if($('#pwd').val().length<1){
				alert('비밀번호를 입력하세요');
				$('#pwd').focus();
				event.preventDefault();
			}else{
				if(!confirm('탈퇴하시겠습니까?')){
					event.preventDefault();
				}
			}
		});
		
		$('input[type="button"]').click(function(){
			history.back();
		});
	});

</script>
</head>
<body>
<form name="frmOut" method="post" action="<c:url value='/member/memberOut_ok.do'/>" >
<fieldset> 
<legend>회원 탈퇴</legend>
	<p class="p">탈퇴를 원하신다면 비밀번호를 입력하세요</p>
		<div>
			<label for="pwd" class="p">비밀번호</label>
			<input type="password" name="pwd" id="pwd">
		</div>
		<br>
		<div class="align_center">
			<input type="submit" id="submit" value="회원탈퇴">
			<input type="button" id="back" value="취소">
		</div>
</fieldset>
</form>
</body>
</html>