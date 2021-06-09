//로그인
	
		$(".login").click(function(){
			
		var memberId=$("input[name='memberId']").val();
		var memberPw=$("input[name='memberPw']").val();
		var form ={
				memberId:memberId,
				memberPw:memberPw
		}
		
		
		if(memberId==""){
			alert("아이디를 입력해주세요.");
			return false;
		}else if(memberPw==""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}else{
			$.ajax({
				type:"post",
				url:"/member/login",
				data:JSON.stringify(form),
				contentType: "application/json; charset=utf-8",
				success:function(result){
					if(result.trim()=="no"){
						alert("아이디 또는 비밀번호가 맞지 않숩니다.");
						$("input[name='memberId']").val("");
						$("input[name='memberPw']").val("");
						return false;
					}
				}
				
			})
			
		}
	});
		
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
		    			var kakaoName=response.nickname;//왜 못받아오지??????
		    			
		    			console.log("userId : "+kakaoId);
		    			console.log("userEmail : "+kakaoEmail);
		    			console.log("userName :"+kakaoName);
		    		
		    			$.ajax({
		    				type:"get",
		    				url:"/member/kakaoCheck/"+kakaoId,
		    				success:function(result){
		    					if(result.trim()=="no"){
		    						console.log("카카오 회원가입");
		    						alert("본인 인증을 진행해주세요.");
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
		
	
		
	
		