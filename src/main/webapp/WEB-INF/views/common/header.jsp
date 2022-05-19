<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>More than just movie, Ezen Cinema</title>



<c:if test="${not empty message}">
	<script>
		var message = "${message}";
		alert(message);
	</script>
</c:if>



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
</head>
<body>
	<!-- header-section-starts -->
	<div class="full">
		<div class="menu">
			<ul>

				<c:choose>
					<c:when test="${isLogOn==true and not empty memberVO }">
						<li><a href="/member/logout" style="color: #dfb636;">로그아웃</a></li>
						<li><a href="/mypage/mypage" style="color: #dfb636;">마이페이지</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/member/login" style="color: #dfb636;">로그인 </a></li>
						<li><a href="/member/join" style="color: #dfb636;">회원가입</a></li>
					</c:otherwise>
				</c:choose>
				<c:if test="${isLogOn==true and memberInfo.member_id =='admin' }">
					<li class="no_line"><a
						href="${contextPath}/admin/goods/adminGoodsMain.do">관리자</a></li>
				</c:if>
			</ul>


			<ul>
				<li><a class="active" href="/"><i class="home"></i></a></li>
				<li><a href="videos.html"><div class="video">
							<i class="videos"></i><i class="videos1"></i>
						</div></a></li>
				<li><a href="/replies/reviewMain"><div class="cat">
							<i class="watching"></i><i class="watching1"></i>
						</div></a></li>
				<li><a href="/ticket/ticketForm"><div class="bk">
							<i class="booking"></i><i class="booking1"></i>
						</div></a></li>
				<li><a href="/mypage/mypage"><div class="cnt">
							<i class="contact"></i><i class="contact1"></i>
						</div></a></li>
			</ul>
		</div>
		<div class="main">
			<div class="header">
				<div class="top-header">
					<div class="logo">
						<a href="/"><img src="/resources/images/logo.png" alt="" /></a>
						<p>Ezen Cinema</p>
					</div>