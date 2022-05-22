<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>


<meta charset="utf-8">
<title>Ezen cinema 로그인페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="/resources/cgv/css/style.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js"
	type="text/javascript"></script>
</head>

<body>
	<c:if test="${not empty message}">
	<script>
	var message = "${message}";
	alert(message);
	</script>
	</c:if>
	<div class="wrapper" style="">

		<div class="inner">
			<div class="image-holder">
				<img id="poster" src="${main.movieImage}" alt="">
			</div>
			<form action="/member/login" id="loginForm" method="post">
				<p class="register-title">
					<img src="/resources/images/logo.png"> &nbsp;&nbsp; <span>
						&nbsp;&nbsp;로그인</span>
				</p>
				<div class="form-wrapper form-wrapper-id">
					<div class="id-wrapper">
						<input id="id" name="memberId" type="text" placeholder="아이디"
							class="form-control"> <i class="zmdi zmdi-accounts"></i>
					</div>
				</div>

				<div class="form-wrapper">
					<input type="password" name="memberPw" placeholder="비밀번호"
						id="password" class="form-control"> <i
						class="zmdi zmdi-lock"></i>
				</div>




				<button type="button" class="loginButton">
					<span>로그인 하기</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>
				<button type="button" class="moveRegister" style="margin-top: 10px;">
					<span>회원가입 하기</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>

				<button type="button" class="moveMain" style="margin-top: 10px;">
					<span>메인 홈페이지</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>
			</form>

		</div>
	</div>
	<script src="/resources/cgv/js/login.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>















