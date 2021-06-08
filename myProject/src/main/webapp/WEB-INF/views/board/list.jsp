<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<style>
		.button primary{margin-left:15%}
        .big-width{display:block;}
        .small-width{display:none;}
       	.table-wrapper {overflow-x:hidden !important;}
         .category{width:23%; display:inline-block;margin-left:10%}
       	 input[name='keyword']{width: 41%; display: inline;}
       	  .table-wrapper {overflow-x:hidden !important;}
       	 
         @media (max-width: 918px){
         	.button primary{width:100%; margin-left:0% !important;}
            .boardDate {display:none;}
            .updateDate {display:none;}
            .big-width{display:none;}
            .small-width{display:block;}
       		.category{width: 100%;display: inline; margin-left:0%;}
         	input[name='keyword']{width: 100%; display: inline;}
         	.search{width: 100%;}
         
         }


</style>
<title>게시판</title>
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
					<li><a href="/member/Login" >Log in</a></li>
					<li><a href="/member/signup">Sign up</a></li>
					<li><a href="/board/list">Board</a></li>
				</ul>
			<ul class="actions stacked">
					<li><a href="/member/Login"  class="button primary fit">LogIn</a></li>
					<li><a href="/member/SignUp" class="button fit">Sign Up</a></li>
				</ul>
			</nav>



	<!-- Main -->
	<section id="main" class="wrapper style1">
	<div class="inner">

		<!-- Title -->
			<header class="major special">
						<h1>Board</h1>
							<p>게시판</p>
		
			</header>
		<!-- 내 아이디만 보이도록 유지보수 하기 -->	
	<div class="col-6 col-12-small">
		<ul class="actions small"> 
			<li><a href="#" class="button primary">게시글 작성</a></li>
		</ul>
	</div>	
	

		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th class="bno">게시물 번호</th>
						<th class="option">카테고리</th>
						<th class="title">제목</th>
						<th class="boardDate">작성한 날짜</th>
						<th class="updateDate">수정한 날짜</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="board" items="${list}">
						<tr class="tHead">
							<td class="boardNum">${board.boardNum}</td>
							<td class="category">${board.category}</td>
							<td class="boardTitle">${board.boardTitle}</td>
							<td class="boardDate">${board.boardDate}</td>
							<td class="updateDate">${board.updateDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="big width" style="text-align:center;">
			<c:if test="${pageMaker.prev}"><!-- 이전버튼이 있으면 -->
				<a class="changePage" href="${1}"><code>&lt;&lt;</code></a><!-- 처음으로 -->
				<a class="changePage" href="${pageMaker.startPage-1}"><code>&lt;</code></a>
			</c:if>	
			
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<c:choose>
					<c:when test="${num eq pageMaker.cri.pageNum}">
						<code>${num}</code>
					</c:when>
					
					<c:otherwise>
						<a class="changePage" href="${num}"><code>${num}</code></a>
					</c:otherwise>					
				</c:choose> 
			</c:forEach>
			
			<c:if test="${pageMaker.next}">
				<a class="changePage" href="${pageMaker.endPage+1}"><code>&lt;</code></a>
				<a class="changePage" href="${pageMaker.realEnd}"><code>&lt;&lt;</code></a>
			</c:if>
		</div>
		
		<!--모바일  -->
		<div class="small-width" style="text-align:center;">
			<c:if test="${pageMaker.cri.pageNum >1}"><!-- 이전버튼 -->
				 <a class="changePage" href="${1}"><code>&lt;&lt;</code></a><!--제일 처음으로  -->
                                 									<!-- 3페이지일떄 : 3-1=2임으로  이접버튼 누르면 2로 간다 -->
                   <a class="changePage" href="${pageMaker.cri.pageNum-1}"><code>&lt;</code></a>
              </c:if>
               <a><code>${pageMaker.cri.pageNum}</code></a>	
                <c:if test="${pageMaker.cri.pageNum<pageMaker.realEnd}">
                 <a class="changePage" href="${pageMaker.cri.pageNum +1}"><code>&gt;</code></a><!-- 다음버튼 -->
                 <a class="changePage" href="${pageMaker.realEnd}"><code>&gt;&gt;</code></a><!-- 맨 마지막으로-->
              </c:if>
		</div>

		<!-- 페이지 이동시 디비조회를 하기위한것  처음 로딩되는 페이지여도 type와 keyword도 받기 떄문에 일다 넘겨준다-->
		<form id="actionForm" action="/board/list">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			<%-- <input type="hidden" name="type" value="${pageMaker.cri.type}">
                                 	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}"> --%>
		</form>

		<!-- 검색란-->
		<form action="/board/list" id="searchForm">
			<!-- 검색하기를 누르면 리스트를 뿌려줘야 함으로 리스트로 form을 보낸다 -->
			<div class="fields">
				<div class="field">
					<div style="text-align: center">
						<select name="type">
							<!--페이징 처리를 하기 위한 것     null이 아니면 selecte값을 ''로 해준다  selected는 변수가 아니라 값이기 떄문에 ''를 붙여준다-->
							<option value="" ${pageMaker.cri.type== null ? 'selected':''}>검색
								기준</option>
							<option value="T" ${pageMaker.cri.type== 'T' ? 'selected':''}>제목</option>
							<option value="C" ${pageMaker.cri.type== 'C' ? 'selected':''}>내용</option>
							<option value="W" ${pageMaker.cri.type== 'W' ? 'selected':''}>작성자</option>
							<option value="TC" ${pageMaker.cri.type== 'TC' ? 'selected':''}>제목
								또는 내용</option>
							<option value="TW" ${pageMaker.cri.type== 'TW' ? 'selected':''}>제목
								또는 작성자</option>
							<option value="TCW" ${pageMaker.cri.type== 'TCW' ? 'selected':''}>전체</option>
						</select>
						<!-- 검색하는 키워드 -->
						<input id="keyword" type="text" name="keyword"
							value="${pageMaker.cri.keyword}"> <a
							href="javascript:void(0)"
							class="search button primary icon solid fa-search">검색</a>
						<!--javascript:void(0)" : onclick 이벤트  -->
					</div>
				</div>
			</div>
		</form>


		<!-- Content -->
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
 <script>
  
   $("a.search").on("click", function(e){
	   e.preventDefault();
	   var searchForm=$("#searchForm");
	   
	   	//searchform태그에 selecte라는 옵션이 있니->있으면 true 없으면 false
	 	if(!searchForm.find("option:selected").val()){
		   alert("검색 종류를 선택하세요.");
	   		return false;
	   }
	   //검색란이 공백일 시
		if(!searchForm.find("input[name='keyword']").val()){
		   alert("키워드를 입력하세요");
	   		return false;
	   }
	   
	   searchForm.submit();
   })
   
   
   
   
   //changePage가 클릭 이벤트가 발생되었을 시 
   $(".changePage").on("click", function(e){
	   e.preventDefault(); //기본에 있는 이벤트는 막아준다 -->a태그 이동 막아줌
	   var actionForm=$("#actionForm");
	   var pageNum=$(this).attr("href");
					//this :누른  a태그
		actionForm.find("input[name='pageNum']").val(pageNum);
		actionForm.submit();
   })
   
   
   	//alert("${result}");
   	
   	var result="${result}";
   	
   	//$(document).ready()는 문서가 준비되면 매개변수로 넣은 콜백 함수를 실행하라는 의미
   	$(document).ready(function(){
   					//isNaN=>숫자가 아닐떄
   		if(result=='' || isNaN(result)){
   			return;
   		}
   		alert("게시글"+result+"번에 등록되었습니다.");
   	})
   </script>
   </body>
</html>