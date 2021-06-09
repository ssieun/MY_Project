/**
 * 회원가입

 */	
	var checkEmail= false;
	
		
	$(document).ready(function(){
		var emailcode="";
		
		$("#email_button").click(function(){
			var memberEmail=$("input[name='memberEmail']").val();
			var check = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			//인증번호 전송하면 이메일 input태그 readnly해주고 인증번호 전송 버튼을 이메일 다시 입력하기로 바꿔주기
			$("#email_button").val('인증다시 하기').click(function(){
				$("input[name='memberEmail']").attr('readonly', false);
				$("input[name='code']").attr('readonly', false);
				//$("input[name='email']").val('');
				$("#email_button").val('인증번호 발송');	

			});
			
			if(memberEmail==""){
				alert("이메일을 입력해주세요");
				checkEmail=false;
				return false;
			}else if(!check.test(memberEmail)){
				alert("이메일 형식으로 입력해주세요.");
				checkEmail=false;
				return false;
			}else{
				$.ajax({
					type:"get",
					url:"/member/checkEmail/"+memberEmail,
					success:function(result){
						if(result.trim()=="no"){
							alert("중복된 이메일입니다.");
							checkEmail=false;
						}else{
							emailcode=result;
							console.log(memberEmail);
							alert("입력하신 이메일로 인증번호 전송 완료 되었습니다.");
							$("input[name='memberEmail']").attr('readonly', true);
							$("#email_button").val('인증다시 하기');
						}
					},
						error:function(){
							console.log("오류");
						}
				});
				
			}
		});
		
		//인증 완료 버튼
		$("#code_button").click(function(){
			var resultCode=$("input[name='code']").val();
			
			if(emailcode == resultCode){
				alert("인증 완료되었습니다.");
				$("input[name='code']").attr('readonly', true);
				checkEmail=true;
			}else{
				alert("인증번호가 맞지 않습니다.");
				$("input[name='memberEmail']").attr('readonly', false);
				$("input[name='code']").attr('readonly', false);
				checkEmail=false;
			}
		
		});
			
		
		//회원가입 완료
		$(".finish").click(function(){
			var check=$("input[name='human]").prop("checked");
			var form=document.signupForm;
			
			
			if(checkEmail==false){
				alert("이메일 인증을 확인해주세요.");
				return false;
			}else if(check==false){
				alert("약관에 모두 동의해주세요.");
				return false;
			}else{
				alert("회원가입이 완료되었습니다.");
				form.submit();
			}
						
			
		});
		
		
		
		

	});
 

	
	