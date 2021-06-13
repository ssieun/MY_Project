/**
 * 
 */

//ajax 로 찾은 아이디값 저장
	
	var id;
	//아이디 찾기
  	function idFindSubmit(){
  		
  		var form=document.findForm;
  		var phone = document.getElementById("phoneNum");
  		if(phone.value==""){
  			alert("핸드폰 번호를 입력해주세요.");
  			phone.focus();
  			return false;
  		}else{
  			
  			$.ajax({
  				url:contextPath+"/member/IdFindOkAction.me?phoneNumber="+phone.value,
  				type:"get",
  				dataType:"text",
  				success:function(result){
  					if(result.trim()=="no"){
  						//실패
  						alert("없는 회원입니다.");
  					}else{
  						alert("아이디 전송완료");
  						
  					}
  					},
  			error:function(){
				console.log("오류");
			}
  				
  			});
  		}
  		
  	}
  	
  	
 	var check=false;

 
  	function pwFindSubmit(){
  		
  		var form=document.findForm;
  		var phone =$("input[name='phone']").val();
  		var id =$("input[name='id']").val();
  		
  		
  		if(id==""){
  				alert("아이디를 입력하세요.");
  				return false;
  		}
  		
  		if(phone==""){
  			alert("핸드폰 번호를 입력해주세요.");
  			phone.focus();
  			return false;
  		}else{
  			$.ajax({
  				url:contextPath+"/member/PwFindOkAction.me",
  				type:"post",
  				data:({"id":id,"phone":phone}),
  				dataType:"text",
  				success:function(result){
  					if(result.trim()=="no"){
  						//실패
  						alert("아이디 또는 핸드폰 번호를 확인해주세요.");
  
  					 	
  					}else{
  						alert("임시비밀번호 전송완료");
  					
  				
  						}
  					},
  			error:function(){
				console.log("오류");
			}
  				
  			});
  		}
  	}