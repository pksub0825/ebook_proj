/**
 * member.js
 */
$(function(){
	$('#email2').change(function(){
		if($(this).val()=='etc'){
			$('#email3').val('');
			$('#email3').css('visibility', 'visible');
			$('#email3').focus();
		}else{
			$('#email3').css('visibility', 'hidden');
			
		}
	});
	

	
	$('#btnZipcode').click(function(){
		open("../zipcode/zipcode.jsp", "zipcode",
		"width=500, height=550, left=0, top=0, location=yes, resizable=yes");
	});
});

	function validate_email(email){
		var pattern=new RegExp(/^[a-zA-Z0-9_]+$/g);
		return pattern.test(email);
		/* a~z, A~Z의 문자 / 0~9의 숫자나 _로 시작하거나 끝나야 한다는 의미	|
		|  닫기 대괄호(])뒤의 +기호는 이 패턴이 한 번 또는 그 이상 반복된다는 의미  */
	}
	
	function validate_phone(tel){
		var pattern=new RegExp(/^[0-9]*$/g);
		return pattern.test(tel);
	}
	/* 0~9의 숫자로 시작하거나 끝나야 한다는 의미 (^는 시작, $는 끝을 의미)	|
	|  닫기 대괄호(]) 뒤의 *기호는 0번 이상 반복 					   */