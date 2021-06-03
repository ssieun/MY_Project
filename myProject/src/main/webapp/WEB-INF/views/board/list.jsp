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
		
			<select name="category" id="category">
				<option value="">선택하기</option>
				<option value="java">JAVA</option>
				<option value="javaScript">JAVASCRIPT</option>
				<option value="jsp">JSP</option>
				<option value="spring">SPRING</option>
				<option value="memo">MEMO</option>
			</select>
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

   </body>
</html>