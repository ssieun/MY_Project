<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />

<title>게시글 수정 </title>
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
		<h1>게시글 수정</h1>

		</header>
		<!-- Content -->
		         <div class="content">
                     <div class="form">
                        <form action="/board/modify" method="post" >

                           <input type="hidden" name="pageNum" value="${cri.pageNum}">
                            <input type="hidden" name="amount" value="${cri.amount}">
                           <input type="hidden" name="keyword" value="${cri.keyword}">
                           <input type="hidden" name="type" value="${cri.type}">
                           
              				<div class="col-6 col-12-xsmall">
                              <div class="field">
                                 <h4>제목</h4>
                                 <input name="boardTitle" placeholder="Title" type="text" value="${board.boardTitle}"/>
                              </div>
                              <div class="field">
                                 <h4>내용</h4>
                                 <textarea name="content" rows="6" placeholder="Content" style="resize:none">${board.boardContent}</textarea>
                              </div>
                              <div class="field">
                                 <h4>작성자</h4>
                                 <input name="writer" placeholder="Writer" type="text" value="${board.memberId}"/>
                              </div>
                      	</div>
                           <ul class="actions">
                              <li><input type="submit" class="button" value="등록" /></li>
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

   
</html>