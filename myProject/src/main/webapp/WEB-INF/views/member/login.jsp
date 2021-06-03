<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
	
	<style>

		.box{width:60%;}	
		.find{font-size:0.7em; padding-left:400px;}
		.signup{font-size:0.7em;}
		@media (max-width: 918px){
			.box{width:100%;}
			
		}
 
	</style>
	
	</head>
	<body class="is-preload">
	
	
		  <!-- Header -->
    		<header id="header">
				<a href="#menu">Menu</a>
				<a href="/member/login" class="button">Login</a>
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
					<header class="major special">
						<h1>Login</h1>
						<p>welcome</p>
		
					</header>

			<center>
			<div class="box" >
				<form name="loginForm" name="loginForm" method="post" action="index.jsp">
						
					<div class="col-6 col-12-xsmall">
						<label for="id">ID</label>
						<input type="text"  name="id" style="width:60%;" />
					</div>
						
					<div class="col-6 col-12-xsmall">
						<label for="password">Pw</label>
						<input type="text" name="password" style="width:60%; margin-bottom:10px;"/>
					</div>
						
						<a href="/member/Find.me"  class="find" style="display:contents;">아이디 비밀번호 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="/member/SignUp.me" class="signup" >회원가입</a>
					
					
						<ul class="actions">
							<li style="margin:0 auto; margin-top:15px;">
							<a type="submit" class="button primary login" style="width:220%; margin-left:-56%;">Login</a>
							</li>
						</ul>
						<a href="/login">
							<img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="300"/>
						</a>
					</form>
				</div>
			</center>
		</div>
</section>

	

		<!-- Scripts -->
			<script>var contextPath = "${pageContext.request.contextPath}";</script>
			<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
			<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
			<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
			<script src="/resources/assets/js/jquery.min.js"></script>
			<script src="/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="/resources/assets/js/browser.min.js"></script>
			<script src="/resources/assets/js/breakpoints.min.js"></script>
			<script src="/resources/assets/js/util.js"></script>
			<script src="/resources/assets/js/main.js"></script>
			<script src="/resources/assets/js/login.js"></script>
	</body>


</html>