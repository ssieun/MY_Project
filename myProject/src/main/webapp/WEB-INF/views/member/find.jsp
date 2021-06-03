<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/purple/assets/css/main.css" />
<title>아이디/비밀번호 찾기</title>
</head>
   <body class="is-preload">

      <!-- Header -->
    	<header id="header">
				<a href="#menu">Menu</a>
				<a href="${pageContext.request.contextPath}/member/Login.me" class="button">Login</a>
			</header>


      <!-- Nav -->
        <nav id="menu">
				<ul class="links">
						<li><a href="index.jsp">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/member/Login.me" >Log in</a></li>
					<li><a href="${pageContext.request.contextPath}/member/SignUp.me">Sign up</a></li>
					<li><a href="${pageContext.request.contextPath}/member/find.me">Find ID Password</a></li>
				</ul>
			<ul class="actions stacked">
					<li><a href="${pageContext.request.contextPath}/member/Login.me"  class="button primary fit">Log In</a></li>
					<li><a href="${pageContext.request.contextPath}/member/SignUp.me" class="button fit">Sign Up</a></li>
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
						<a href="#" class="image fit"><img src="${pageContext.request.contextPath}/purple/images/img3.jpg" style="width:1000px; height:400px; margin-left:20px;"/></a>
						</div>

               <!-- Content -->
               <center>
       
                  <div class="content">
                     <form id="findForm" method="post" action="">

				<div class="box" style="margin: 70px; margin-top:20px;">
					<div class="col-6 col-12-xsmall">
					<label for="name">Find ID</label>
						<input type="text" id="phoneNum"
							style="width: 44%; margin-bottom: 10px; display: inline;" placeholder="phoneNumber" />
							 <input type="button" id="button_id" value="아이디 발송" onclick="idFindSubmit()">
					</div>
					
				</div>

				<div class="box" style="margin: 70px;  margin-top:10px;" >
						<div class="col-6 col-12-xsmall">
							<label for="name">Find PASSWORD</label>
					<input type="text" name="id" id="id"
							style="width: 44%; margin-bottom: 10px; display: inline; margin-right:21%;"  placeholder="ID"/>
						<P id="checkId_text" style="font-size :20%";></P>
						</div>
						
						<div class="col-6 col-12-xsmall">
						<input type="text" id="phone" name="phone" style="width: 44%; margin-bottom: 10px; display: inline;" placeholder="phoneNumber"  /> 
							<input type="button" id="button_pw" value="비밀번호 발송"
							onclick="pwFindSubmit()" method="post">
					</div>
					</div>
					
							<a href="${pageContext.request.contextPath}/member/Login.me" style="font-size:15px; padding-left:400px; margin-left:300px;">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath}/member/SignUp.me" style="font-size:15px;" >회원가입</a>
					
			</form>
                  </div>
                          </center>
         </section>

      <!-- Footer -->
         <footer id="footer">
            <ul class="alt-icons">
               <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
               <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
               <li><a href="#" class="icon brands fa-linkedin-in"><span class="label">LinkedIn</span></a></li>
               <li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
               <li><a href="#" class="icon solid fa-phone"><span class="label">Phone</span></a></li>
               <li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
            </ul>
            <ul class="menu">
               <li><a href="#">Terms of Use</a></li>
               <li><a href="#">Privacy Policy</a></li>
               <li><a href="#">Contact Us</a></li>
            </ul>
            <p class="copyright">
               &copy; Untitled Corp. All rights reserved. Lorem ipsum dolor sit amet nullam.
            </p>
         </footer>

      <!-- Scripts -->
     		<script src="${pageContext.request.contextPath}/purple/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/purple/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/purple/assets/js/jquery.scrollex.min.js"></script>
			<script src="${pageContext.request.contextPath}/purple/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/purple/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/purple/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/purple/assets/js/main.js"></script>
			<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
			<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
			<script>var contextPath ="${pageContext.request.contextPath}";</script>
			<script src="${pageContext.request.contextPath}/assets/js/find.js"></script>
			

   </body>
   
</html>