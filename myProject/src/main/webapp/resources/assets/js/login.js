/**
 * 로그인
 */

		$(".login").click(function(){
			
		var id=$("input[name='id']").val();
		var pw=$("input[name='password']").val();
		
		if(id==""){
			alert("아이디를 입력해주세요.");
			return false;
		}else if(pw==""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}else{
			
			$.ajax({
				type:"post",
				url:"/login/"+id+"/"+pw,
				success:function(result){
					if(result.trim()=="no"){
						alert("아이디 또는 비밀번호가 맞지 않숩니다.");
						return false;
					}else{
						loginForm.submit();
						
					}
				}
				
				
				
			})
			
			
		}
		
		
	
		});
	