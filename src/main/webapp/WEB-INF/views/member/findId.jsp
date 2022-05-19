<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<title>More than just movie, Ezen Cinema</title>
<link href="/resources/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- Custom Theme files -->
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<script src="/resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Cinema Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<meta charset="utf-8">
<c:if test='${not empty tried}'>
<script>
window.onload=function()
{
  result();
}

function result(){
	alert("아이디나  비밀번호가 틀립니다. 다시 로그인해주세요");
}
</script>
</c:if>
</head>
<body>
<div class="full">
			<div class="menu">
				<ul>
					<li><a href="/"><div class="hm"><i class="home1"></i><i class="home2"></i></div></a></li>
					<li><a href="videos.html"><div class="video"><i class="videos"></i><i class="videos1"></i></div></a></li>
					<li><a href="/replies/reviewMain"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
					<li><a href="/ticket/ticketForm"><div class="bk"><i class="booking"></i><i class="booking1"></i></div></a></li>
					<li><a class="active" href="contact.html"><div class="cnt"><i class="contact"></i><i class="contact1"></i></div></a></li>
				</ul>
			</div>
		<div class="main">
		<div class="contact-content">
			<div class="top-header span_top">
				<div class="logo">
					<a href="index.html"><img src="/resources/images/logo.png" alt="" /></a>
					<p>Movie Theater</p>
				</div>
				<div class="search v-search">
					<form>
						<input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						<input type="submit" value="">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		<div >
		 <h3 class="head">아이디 찾기</h3>
		 <div class>
		<form action="/member/findId" method="post">
			<div id="detail_table">
						<TABLE>
			<TBODY>
				<tr class="dot_line">
							<td class="fixed_join">이메일<br>(e-mail)
							</td>
							<td><input size="10px" type="text" name="email1" /> @ <input
								size="10px" type="text" name="email2" /> <select name="email2"
								onChange="" title="직접입력">
									<option value="non">직접입력</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="naver.com">naver.com</option>
									<option value="yahoo.co.kr">yahoo.co.kr</option>
									<option value="hotmail.com">hotmail.com</option>
									<option value="paran.com">paran.com</option>
									<option value="nate.com">nate.com</option>
									<option value="google.com">google.com</option>
									<option value="gmail.com">gmail.com</option>
									<option value="empal.com">empal.com</option>
									<option value="korea.com">korea.com</option>
									<option value="freechal.com">freechal.com</option>
									</select>
									</td>
									</tr>
			</TBODY>
		</TABLE>
		<br><br>
		<INPUT	type="submit" value="아이디찾기"> 
		<INPUT type="button" value="초기화">
			</div>
		</form>
		
				<Br><br>
		   <a href="/member/findId">아이디 찾기</a>  | 
		   <a href="/member/findPw">비밀번호 찾기</a> | 
		   <a href="/member/join">회원가입</a>    |
<div class="footer">
		<h6>Disclaimer : </h6>
		<p class="claim">This site is for Team project from EZEN Computer Academy Sangbong</p>
		<a href="example@mail.com">please connect us example@mail.com for all the problems</a>
		<div class="copyright">
			<p> Template by  <a href="http://w3layouts.com">  W3layouts</a></p>
		</div>
	</div>	
	</div>
	</div>
	<div class="clearfix"></div>
</body>
</html>