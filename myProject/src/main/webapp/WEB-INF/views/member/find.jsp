<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Find</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
</head>
<style>

		.my{width: 97% !important; height: 400px !important; margin-left: 20px !important;}
		.box{margin: 70px; margin-top: 20px;}
	
		@media (max-width: 918px){
			.my{width:85% !important; height: 79% !important;}
			.box{width:100%; margin:0% ;}
		}
 
	</style>
   <body class="is-preload">

      <!-- Header -->
    	<header id="header">
				<a href="#menu">Menu</a>
				<a href="/member/signup" class="button">Sign up</a>
			</header>

      <!-- Nav -->
        <nav id="menu">
				<ul class="links">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="/member/login" >Log in</a></li>
					<li><a href="/member/signup">Sign up</a></li>
					<li><a href="/member/find">Find</a></li>
					<li><a href="/board/list">Board</a></li>
				</ul>
			<ul class="actions stacked">
					<li><a href="/member/login"  class="button primary fit">LogIn</a></li>
					<li><a href="/member/signup" class="button fit">Sign Up</a></li>
				</ul>
			</nav>

      <!-- Main -->
         <section id="main" class="wrapper style1">
            <div class="inner">

               <!-- Title -->
                  <header class="major special">
                     <h1>Find ID Password</h1>
           
                  </header>
                  
           <div class="content">
				<img src="/resources/images/img.jpg" class="my" />
			</div>
			
			
          <!-- Content -->
          <center>
       
                  <div class="content">
                     <form id="findForm" method="post" action="">

				<div class="box" style="margin: 70px; margin-top:20px;">
					<div class="col-6 col-12-xsmall">
					<label for="name">Find ID</label>
						<input type="text" id="memberName" style="width: 44%; margin-bottom: 10px; margin-right:19%;" placeholder="Name" />
						<input type="text" id="memberName" style="width: 44%; margin-bottom: 10px; display: inline;" placeholder="Email" />
							 <input type="button" id="button_id" value="아이디 발송" >
					</div>
					
				</div>

				<div class="box" style="margin: 70px;  margin-top:10px;" >
						<div class="col-6 col-12-xsmall">
							<label for="name">Find PASSWORD</label>
					<input type="text" name="id" id="id" style="width: 44%; margin-bottom: 10px; display: inline; margin-right:21%;"  placeholder="ID"/>
						<P id="checkId_text" style="font-size :20%";></P>
						</div>
						
						<div class="col-6 col-12-xsmall">
						<input type="text" id="memberEmail" name="memberEmail" style="width: 44%; margin-bottom: 10px; display: inline;" placeholder="Email"  /> 
							<input type="button" id="button_pw" value="비밀번호 발송"
							onclick="pwFindSubmit()" method="post">
					</div>
					</div>
					
							<a href="/member/login.me" style="font-size:15px; padding-left:400px; margin-left:300px;">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="/member/signup.me" style="font-size:15px;" >회원가입</a>
					
			</form>
                  </div>
                          </center>
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
			<script src="/resources/assets/js/find.js"></script>
			

   </body>
   
</html>