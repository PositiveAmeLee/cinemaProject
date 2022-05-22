<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>More than just movie, Ezen Cinema</title>

<!-- header.jsp -->
<link href="/resources/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- Custom Theme files -->
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<script src="/resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
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
<!-- end header.jsp -->

<link rel="stylesheet" href="/resources/cgv/css/reset.css">
<link rel="stylesheet" href="/resources/cgv/css/reserve.css">
<link rel="stylesheet" href="/resources/cgv/css/header.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<link rel="stylesheet"
	href="/resources/cgv/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<style>
* {
	font-size: 11px;
}

body {
	background-color: #FDFCF0;
}

/* header */
.header-nav-wrapper {
	background: url(/resources/cgv/images/bg_header.gif) repeat-x 0 0;
	background-position: center;
	background-size: contain;
	height: 120px;
	padding-top: 4px;
}

.header-nav-container {
	position: fixed;
}

.header {
	display: flex;
	justify-content: space-between;
	padding-left: 40px;
	padding-right: 150px;
}

.header-inner {
	display: flex;
}

.header-inner>div {
	border-right: 1px solid #DDDDDD;
	margin-left: 8px;
	padding-right: 4px;
}

/* //header */

/* nav */
.nav-line {
	background-color: red;
	border-radius: 50px;
	height: 5px;
	/* background-image: linear-gradient(to right, white 33%, rgba(255, 255, 255, 0) 0%);
  background-position: bottom;
  background-size: 15px 1px;
  background-repeat: repeat-x; */
}

.nav-wrapper {
	/* background: url(../images/bg_header.gif) repeat-x 0 0; */
	/* width: 100%;*/
	height: 94px;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.nav-content {
	padding-top: 15px;
}

.movieLogo-wrapper {
	text-align: center;
}

.cgvLogo {
	width: 120px;
	margin-left: 150px;
	/* margin-right: -40px; */
}

.cgvMovie {
	width: auto;
	height: 28px;
}

.nav-inner {
	display: flex;
	/* margin-left: -250px; */
	margin-left: 150px;
	margin-right: auto;
	align-items: center;
	padding-bottom: 15px;
}

.nav-inner>div>button {
	padding-top: 5px;
	font-size: 14px;
	font-weight: bold;
	margin-left: 15px;
}

.search-wrapper {
	margin-left: 70px;
	height: 20px;
}

.search-wrapper>input {
	width: 100px;
	height: 20px;
}

.searchButton {
	margin: 0 !important;
	padding: 2px !important;
	background-color: red;
	color: white;
	width: 30px;
	height: 100%;
	font-size: 10px !important;
}

/* content */
.reserve-container {
	margin-top: 20px;
	display: flex;
	justify-content: center;
	height: 800px;
	/* border: 1px solid #dddddd; */
}

.reserve-container>div {
	border: 1px solid #dddddd;
}

.reserve-title {
	border-bottom: 1px solid #dddddd;
	background-color: #444444;
	text-align: center;
	color: #dddddd;
	padding: 5px;
	font-size: 13px;
	font-weight: bold;
}

.movie-part {
	width: 284px;
}

.theater-part {
	width: 264px;
}

.day-part {
	width: 91px;
}

.time-part {
	width: 384px;
}

.sort-wrapper {
	margin: 10px 6px 6px 10px;
	/* padding: 3px; */
	display: flex;
	border-bottom: 1px solid #dddddd;
	font-size: 12px;
}

.sort-wrapper>div {
	padding: 3px;
}

.sort-wrapper>div:hover {
	border-bottom: 1px solid #111111;
}

.sort-selected {
	font-weight: bold;
	border-bottom: 1px solid #111111;
}

.sort-korean {
	margin-left: 6px;
}

.reserve-date {
	padding-top: 5px;
	display: flex;
	flex-direction: column;
	align-items: center;
	height: 770px;
	overflow: scroll;
	overflow-x: hidden;
}

.movie-date-wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 5px 2px;
}

.movie-week-of-day {
	margin-left: 5px;
	font-size: 10px;
	width: 12px;
	height: 22px;
	line-height: 22px;
}

.movie-day {
	text-align: center;
	width: 34px;
	height: 22px;
	font-size: 17px;
	font-weight: bold;
}

.saturday {
	color: #31597E;
	font-weight: bold;
}

.sunday {
	color: #AF2D2D;
	font-weight: bold;
}

.movie-date-wrapper-active {
	background-color: #333333;
}

.movie-date-wrapper-active>* {
	color: white;
}
</style>

<c:if test="${isLogOn!=true or empty responseDto }">
	
	<script>
	
	alert("로그인이 필요한 작업입니다 로그인을 진행해 주세요!")
	location.href = "/member/login"
	
	</script>

</c:if>
</head>

<body>
	<!-- header.jsp body -->
	<div class="full">
		<div class="menu">
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
				<li><a href="contact.html"><div class="cnt">
							<i class="contact"></i><i class="contact1"></i>
						</div></a></li>
			</ul>
		</div>
		<!-- end header.jsp body -->
		<div class="reserve-container">
			<div class="movie-part">
				<div class="reserve-title">영화</div>
				<div class="sort-wrapper">
					<div class="sort-rate sort-selected">예매율순</div>
					<div class="sort-korean">가나다순</div>
				</div>
				<div class="movie-list-wrapper">
					<div class="movie-list">
						<%-- <div class="movie-list-age">15</div>
                    <div class="movie-list-title">1917</div> --%>
					</div>
				</div>
			</div>
			<div class="theater-part">
				<div class="reserve-title">극장</div>
				<div class="theater-container">
					<div class="theater-wrapper">
						<div class="theater-location-wrapper">

							<button class="theater-location">서울(30)</button>
							<button class="theater-location">경기(43)</button>
							<button class="theater-location">인천(10)</button>
							<button class="theater-location">강원(5)</button>
						</div>
						<div class="theater-place-wrapper">

							<button class="theater-place">천호</button>
							<button class="theater-place">강변</button>
							<button class="theater-place">건대입구</button>
							<button class="theater-place">구로</button>
							<button class="theater-place">대학로</button>
							<button class="theater-place">동대문</button>
							<button class="theater-place">목동</button>
							<button class="theater-place">명동</button>
							<button class="theater-place">미아</button>
							<button class="theater-place">불광</button>
							<button class="theater-place">상봉</button>
							<button class="theater-place">송파</button>
							<button class="theater-place">수유</button>
							<button class="theater-place">압구정</button>
							<button class="theater-place">여의도</button>
							<button class="theater-place">영등포</button>
							<button class="theater-place">왕십리</button>
							<button class="theater-place">중계</button>
						</div>
					</div>
				</div>
			</div>
			<div class="day-part">
				<div class="reserve-title">날짜</div>
				<div class="reserve-date"></div>
			</div>
			<div class="time-part">
				<div class="reserve-title">시간</div>
				<div class="reserve-time">
					<div class="reserve-where">4관(Laser) 6층(총 240석)</div>
					<div class="reserve-time-wrapper">
						<button class="reserve-time-button">
							<span class="reserve-time-want">12:20</span> <span
								class="reserve-time-remain">240석</span>
						</button>
						<button class="reserve-time-button">
							<span class="reserve-time-want">14:20</span> <span
								class="reserve-time-remain">240석</span>
						</button>
						<button class="reserve-time-button">
							<span class="reserve-time-want">16:20</span> <span
								class="reserve-time-remain">240석</span>
						</button>
						<button class="reserve-time-button">
							<span class="reserve-time-want">18:20</span> <span
								class="reserve-time-remain">240석</span>
						</button>

					</div>
				</div>
				<div>
					<form class="moveSeatForm" action="/ticket/ticketSeat"
						method="post">
						<input type="hidden" class="title" name="title"> <input
							type="hidden" class="movieAge" name="movieAge"> <input
							type="hidden" class="selectedTheater" name="selectedTheater">
						<input type="hidden" class="reserveDate" name="movieDate">
						<input type="hidden" class="runningTime" name="runningTime">
						<button class="moveSeatButton" type="button">예약하기</button>
					</form>
				</div>
			</div>

		</div>
		<script src="/resources/cgv/js/reserve.js"></script>
</body>