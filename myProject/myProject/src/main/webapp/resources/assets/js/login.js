/**
 * 로그인
 */
			//수정중...
		/*$(".login").click(function(){
			
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
	});*/
		
		//카카오 로그인
		Kakao.init('77b7f648392a777f72608935c3e3e8ed'); //발급받은 키 중 javascript키를 사용해준다.
		console.log(Kakao.isInitialized());
		
		Kakao.Auth.createLoginButton({
			container: '#kakao-login-btn',
		    success: function(response) {
		    	Kakao.API.request({
		    	    url:'/v2/user/me',
		    		success:function(response){
		    			console.log("들어옴2");
		    				    				
		    			var kakaoId=response.id;
		    			var kakaoEmail=response.email;//이메일은 받아오지 못함
		    			var kakaoName=response.nickname;
		    			
		    			console.log("userId : "+kakaoId);
		    			console.log("userEmail : "+kakaoEmail);
		    			console.log("userName :"+kakaoName);
		    		
		    			$.ajax({
		    				type:"get",
		    				url:"/member/kakaoCheck/"+kakaoId,
		    				success:function(result){
		    					if(result.trim()=="no"){
		    						console.log("카카오 회원가입");
		    						window.location.href= contextPath+"/member/kakao?kakaoId="+kakaoId+"&kakaoName="+kakaoName;
		 
		    					} 					
		    				}, 
		    				error:function(data){
		    					console.log("로그인 안됨");
		    				}
		    			})
		    			
		    		},
		    		fail:function(error){
		    			console.log("request fail", error);
		    		}
		    	});
		    },
		    fail:function(error){
		    	console.log("faile", error);
		    },
			
		});
		
	
		
	
		