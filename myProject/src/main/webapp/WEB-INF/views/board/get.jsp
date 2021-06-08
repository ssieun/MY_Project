<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />

<title>게시글  </title>
</head>
   <body class="is-preload">

      <!-- Header -->
    		<header id="header">
				<a href="#menu">Menu</a>
				<a href="/member/Login.me" class="button">Login</a>
			</header>

      <!-- Nav -->
        <nav id="menu">
				<ul class="links">
						<li><a href="index.jsp">Home</a></li>
					<li><a href="/member/Login.me" >Log in</a></li>
					<li><a href="/member/SignUp.me">Sign up</a></li>
					<li><a href="/member/find.me">Find ID Password</a></li>
				</ul>
			<ul class="actions stacked">
					<li><a href="/member/Login.me"  class="button primary fit">Log In</a></li>
					<li><a href="/member/SignUp.me" class="button fit">Sign Up</a></li>
				</ul>
			</nav>


	<!-- Main -->
	<section id="main" class="wrapper style1">
	<div class="inner">

		<!-- Title -->
		<header class="major special">
		<h1>게시글 보기</h1>

		</header>
		<!-- Content -->
		         <div class="content">
                     <div class="form">
                        <form action="/board/remove">

                           <input type="hidden" name="boardNum" value="${board.boardNum}">
                           <input type="hidden" name="pageNum" value="${cri.pageNum}">
                            <input type="hidden" name="amount" value="${cri.amount}">
                           <input type="hidden" name="keyword" value="${cri.keyword}">
                           <input type="hidden" name="type" value="${cri.type}">
                           
              				<div class="col-6 col-12-xsmall">
                              <div class="field">
                                 <h4>제목</h4>
                                 <input name="boardTitle" placeholder="Title" type="text" value="${board.boardTitle}" readonly/>
                              </div>
                              <div class="field">
                                 <h4>내용</h4>
                                 <textarea name="content" rows="6" placeholder="Content" style="resize:none" readonly>${board.boardContent}</textarea>
                              </div>
                              <div class="field">
                                 <h4>작성자</h4>
                                 <input name="writer" placeholder="Writer" type="text" value="${board.memberId}" readonly/>
                              </div>
                      	</div>
                           <ul class="actions">
                              <li>
                              <input type="submit" class="button" value="수정" onclick="location.href='/board/modify${cri.getListLink()}&boardNum=${board.boardNum}'" />
                              <input type="submit" class="button" value="삭제" />
                              
                              </li>
                           </ul>
                        </form>
                     </div>
      			</div>
		
			</div>
	</section>



	<!-- Scripts -->
     		<script src="/resources/assets/js/jquery.min.js"></script>
			<script src="/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="/resources/assets/js/browser.min.js"></script>
			<script src="/resources/assets/js/breakpoints.min.js"></script>
			<script src="/resources/assets/js/util.js"></script>
			<script src="/resources/assets/js/main.js"></script>

   </body>
   <script>
 		$(document).ready(function(){
   			var bno = "${board.bno}";
   			var pageNum = 1; //처음 뿌려질떄 디폴트 값
			
			showList();//처음 상세보기 들어왔을떄 실행
			
			$(".register").on("click", function(e){
	   			e.preventDefault();//페이지를 이동시키거나 하는 동작들을 중단시킨다.
	   			$(".register-form").show();//댓글 작성 폼을 보여준다.
	   			$(this).hide();
	   		});
	   		
			//댓글 작성 취소 버튼
			$(".cancel").on("click", function(e){
	   			e.preventDefault();
	   			$(".register-form").hide();
	   			$(".register").show();
	   		});
	   		
			//댓글 등록버튼
			$(".finish").on("click", function(e){
	   			e.preventDefault();
	   			
	   			//textarea에서 이미 작성한 글을 가져올 때에는 text()도 ok, val()도 ok
	   			//하지만 랜더링 후 입력한 값을 가져올 때에는 반드시 val()를 사용한다.
	   			var reply = $("textarea[name='reply']").val();
	   			var replyer = $("input[name='replyer']").val();
	   			
	   			//값이 없으면 넘어가지 못하도록
	   			if(replyer =="" || reply==""){
						return;	   				
	   			}
	   			
	   			replyService.add({bno:bno, reply:reply, replyer:replyer},
	   					function(result){
	   						alert(result);
	   						//등록이 완료되면 댓글 작성창이 숨겨진다 
	   						$("input[name='replyer']").val("");
	   						$("input[name='reply']").val("");
	   			   			$(".register-form").hide();
	   			   			$(".register").show();
	   						pageNum = 1; //댓글 작성 완료되면 댓글 1페이지로 이동해주기
	   						showList(pageNum);
	   			});
	   		});
	   		
			
			//댓글 목록 페이징처리
			function showReplyPage(replyCnt){
				var str = "";			
				var replyPaging= $(".paging");
				var endNum = Math.ceil( pageNum / 10.0) *10; 
				var startNum = endNum -9;
				//전체갯수를 받아와야 한다.
				var realEnd = Math.ceil(replyCnt / 10.0);  
				
				//endNum이 realEnd보다 크면 안된다
				//그러므로 endNum이 크면 realEnd값을 넣어준다.
				//ex)endNum=20 realEnd=17
				if(endNum > realEnd){
					endNum = realEnd; 	
				}
				                  
				var prev= startNum != 1; //11부터 이전버튼이 생김
				//10 이후부터 다음 버튼이 생김
				var next= endNum * 10  < replyCnt ; 
				
	   			if(matchMedia("screen and (max-width:918px)").matches){
	   				//918px보다 작을 때
	   				//모바일
		   			if(pageNum != 1){
			   			str += "<a class='changePage' href='" + (pageNum - 1) + "'><code>&lt;</code></a>" 
		   			}
		   				str += "<code>" + pageNum + "</code>";
		   			if(pageNum != realEnd){
			   			str += "<a class='changePage' href='" + (pageNum + 1) + "'><code>&gt;</code></a>" 
		   			}
	   			}else{
		   			//918px보다 클 때
		   			if(prev){ //이전버튼
			   			str += "<a class='changePage' href='" + (startNum - 1) + "'><code>&lt;</code></a>" 
		   			}
		   			for(let i=startNum; i<=endNum; i++){
		   				if(pageNum == i){
		   					str += "<code>" + pageNum + "</code>"; //페이지 번호
		   					continue;
		   				}
		   				str += "<a class='changePage' href='" + i + "'><code>" + i + "</code></a>"
		   			}
		   			if(next){ //다음버튼							//문자로 파싱됨
			   			str += "<a class='changePage' href='" + (endNum + 1) + "'><code>&gt;</code></a>" 
		   			}
	   			}
	   			replyPaging.html(str);
	   		}
			
			//리스트 뿌리고 난 후 페이지 선택지 오는 곳
			//이벤트위임
			//처음부터 없던 코드를 자바스크립트로 붙이면, 이벤트 함수가 새로운 코드를 인식하지 못하여 사용이 안된다.
			//이럴 때에는 처음부터 있는 부모 태그에 이벤트를 주고, 그 자식 태그로 선책자를 작성하여 이벤트를 위임해야 한다.
			//이동할 페이지 번호 클릭시 			//이벤트위임->a태그중changePage에(자식태그) 위임할것이다
			$(".paging").on("click","a.changePage", function(e){
				e.preventDefault();
				pageNum = parseInt($(this).attr("href"));//문자열로 연결이 되기  때문에 int로 형변환을 해줘어야 한다
				showList(pageNum); //클릭한 페이지 번호를 showList에 전달하여 실행시킨다.
			});
			
			//댓글 리스트
			function showList(page){
	   			var replyUL = $(".replies"); //댓글리스트 div태그를 가져온다
	   			replyService.getList({bno:bno, page:page||1},
	   					function(replyCnt, list){//컨트롤러에서 응답한 댓글 전체 개수와 댓글 목록을 받는다.
	   						if(list == null || list.length == 0){
	   							//만약 현재 페이지가 1보다 클 때 더 이상 보여줄 댓글이 없다면
	   							//이전 페이지로 이동하여 댓글 목록을 보여주도록 한다.
	   							//그래서 페이지 -1을 해준다
	   							if(pageNum > 1){
	   								//다시 그려주기
	   								pageNum -= 1; showList(pageNum);
	   							}
	   							
	   							replyUL.html("등록된 댓글이 없습니다.");
	   							return;
	   						}
	   						var str = "";
	   						//data 속성
	   						//태그에 원하는 value를 저장시키기 위해서 사용한다.
	   						//data-변수명="value"로 작성하며, jQuery에서 해당 태그객체.data("변수명")으로
	   						//value를 가져와 사용할 수 있다.
	   						//만약 value를 수정하고 싶다면 해당 태그객체.data("변수명","새로운 값");
	   						for(let i=0, len=list.length; i<len; i++){
	   							str += "<li data-rno='" + list[i].rno + "'>";
	   							str += "<strong>" + list[i].replyer + "</strong>";
	   							str += "<p class='reply" + list[i].rno + "'>" + list[i].reply + "</p>";
	   							str += "<div style='text-align:right;'>";
	   							str += "<a class='modify' href='" + list[i].rno + "'>수정</a>"
	   							str += "<a class='finish' href='" + list[i].rno + "' style='display:none;'>수정완료</a>"
	   							str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	   							str += "<a class='remove' href='" + list[i].rno + "'>삭제</a>"
	   							str += "</div><div class='line'></div></li>";
	   						}
	   						replyUL.html(str);
	   						showReplyPage(replyCnt);
	   			});
	   		}
			
			//댓글 삭제
	   		//삭제 버튼 클릭 시 해당 댓글 번호를 가져와 삭제하기
	   		$(".replies").on("click", "a.remove", function(e){
	   			e.preventDefault();
	   			var rnoValue = $(this).attr("href"); //this--> 이벤트 위임을 해서 a.remove  
	   			
	   			replyService.remove(rnoValue, function(result){
	   				alert(result);
	   				showList(pageNum); //삭제후 새로고침 안하고 다시 현제페이지 유지하면서  리스트 뿌려주기
				});
	  		});
	   		
			//댓글 수정중에 다른 댓글 수정하지 못하도록 막아준다
	   		var check = false;
	   		
	   		//댓글 수정
	   		//1. p태그를 textarea로 변경(기존 p태그의 내용을 textarea로 옮겨야 한다.)
	   		//2. 수정완료 버튼
	   		$(".replies").on("click", "a.modify", function(e){
	   			e.preventDefault();
	   			if(check){alert("이미 수정중인 댓글이 있습니다."); return;}
	   			
	   			var rnoValue = $(this).attr("href"); //수정버튼 rno값이 있다.
	   			var replyTag = $(".reply" + rnoValue)//해당rno게 있는 댓글 내용을 가지고 있는 태그 가져오기
	   			
	   			//p태그를 댓글 수정을 해주기 위해 textarea로 바꿔주기				//댓글 내용 가지고 있는 태그 내용.text로 가져오기 
	   			replyTag.html("<textarea class='" + rnoValue + "'>" + replyTag.text() + "</textarea>")
	   			$(this).hide();//수정버튼 숨기기
	   			
	   		
	   			//다 가져오기
	   			var finishs = $(".finish")
	   			for(let i=0; i<finishs.length; i++){
	   							//.attr ->href속성 가져오기
	   				if($(finishs[i]).attr("href") == rnoValue){
	   					$(finishs[i]).show(); //수정하기 눌렀을 시 수정완료 버튼을 띄어준다
	   					check = true;
	   					break; //찾았으면 찾을 필요가 없으니 break를 걸어준다
	   				}
	   			}
	   		});
	   		
	   		//수정완료 버튼
	   		$(".replies").on("click", "a.finish", function(e){
	   			e.preventDefault();
	   			var rnoValue = $(this).attr("href");
	   			var newReply = $("." + rnoValue).val(); //새롭게 작성한  textarea 댓글 내용 값
	   			
	   			replyService.modify({rno:rnoValue, reply:newReply}, 
	   				function(result){
	   					alert(result);
	   					check = false;
	   					showList(pageNum);//수정완료 해도 기존 페이지를 유지하기 위해
	   				});
	   		});
			
		})
		
	
	</script>

   
</html>