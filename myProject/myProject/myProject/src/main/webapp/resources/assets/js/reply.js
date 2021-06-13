

console.log("Reply Module....");

//뒤에 ()가 붙은 이유 선언하자마자 바로 사용하겠다는 이유이다.
//return값이 replyService에 넣어진다
var replyService =(function(){
	
	/*function a(){}//메소드는 주소값을 가지고있다.
		
	return {name: a}; //->a는 function메소드의 주소값을 담고있다
	 */
	
	//reply: json
	//callback : 함수를 받는다  ajax에서 success역할을 한다.
	//error : 함수를 받는다
	
	//댓글 추가
	function add(reply, callback, error){
		console.log("add reply.....");
		
		//uri방식이기 때문에 바로 ajax를 한다
		$.ajax({
			type:"post",
			url:"/replies/new",
			data:JSON.stringify(reply),	//JSON.stringify()->jsonkey&value 값에 ""를 붙여준다 주의해야할 것은 string타입으로 바꿔주는게 아니다.
			contentType:"application/json; charset=utf-8",
			success:function(result){
				if(callback){//콜백함수를 전달 받았으면 ture 아니면 false
					callback(result); //콜백함수가 있다면 result를 callback에담는다
				}
			},
			error: function(xhr, status, er){ //er: 에러메세지륿 보여줌
				if(error){
					error(er);
					
				}
			}
				
		});
	}
	
	//댓글 리스트
	function getList(param, callback, error){//param-->pageNum bno를 받는다
		console.log("get List....");
		
		var bno=param.bno;
		var page=param.page || 1; //사용자가 페이지를 선택하지 않으면 디폴트가 1이기 떄문에  1이 안넘어온다 그래서 1을 넣어준다
		
		/*
		 * getJson문법
		 * $.getJson("",function(){}).fail(function(){}); 
		 * 
		 */
		
		//url에 담겨서 오기 떄문에 ajax가 굳이 필요가 없다.
		//getJSON()->get방식						//+json데이터로 받기위해서 붙여준다(필수는 아니지만 알아보기 위해 붙인다)
		$.getJSON("/replies/pages/"+bno+"/"+page+".json", //url전달
				function(data){ 
			//getList 컨트롤러에서는 댓글 목록과 댓글 전체 개수를 응답해준다.
			//따로 전달받지 않고 ReplyPageDTO객체로 한 번에 전달 받는다.
					if(callback){
						callback(data.replyCnt, data.list);}//get값을 가지고 온 것이며 쓰기 편하도로 ㄱ나눠준 것
		}).fail(function(xhr, status,err){
			if(error){
				error(er);
			}
		});
	
	}
	
	//댓글 삭제
	function remove(rno, callback, error){
		console.log("remove..."+rno);
	
		$.ajax({
			type:"delete",
			url:"/replies/" + rno,
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr, status, err){
				if(error){
					error(err);
				}
			}
		});
	}
	
	
	//댓글 수정
	function modify(reply, callback, error){
		console.log("RNO : " + reply.rno);
		
		$.ajax({
			type: "put",
			url: "/replies/" + reply.rno,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success:function(result){
				/*console.log("UPDATE : " + result);*/
				if(callback){callback(result);}
			},
			error: function(xhr, status, err){
				/*console.log("ERROR");*/
				if(error){error(err);}
			}
		});
	}
	
	function get(rno, callback, error){
		$.get("/replies/" + rno + ".json", function(result){
			if(callback){callback(result);}
		}).fail(function(xhr, status, err){
			if(error){
				error(err);
			}
		})
	}

	return {add : add, getList: getList, remove: remove,modify:modify,get:get}
	
})();