<%@page import="com.cinema.domain.ReservationDto.ReservationCreateDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	
     ReservationCreateDto reserve = (ReservationCreateDto) request.getAttribute("reserve");
	/* if (reserve != null && reserve.getCgvPayDto() != null) {
		System.out.println(reserve.toString());
	} else {
		System.out.println("오류가있습니다!!");
	} */
%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/resources/cgv/css/reset.css">
<link rel="stylesheet" href="/resources/cgv/css/header.css">
<link rel="stylesheet" href="/resources/cgv/css/seat.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<link rel="stylesheet"
	href="/resources/cgv/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<!-- MATERIAL DESIGN ICONIC FONT -->

</head>

<body>

<%@ include file="../common/header.jsp"%>
	
	<div class="select-container">
		<div class="select-wrapper">
			<div class="select-title">인원/좌석</div>
			<div class="select-seat-container">
				<div class="select-seat-number-container">
					<div class="select-seat-number-wrapper">
						<div class="select-seat">
							<div class="select-seat-age">일반</div>
							<div class="select-seat-number">
								<ul class="select-seat-ul select-seat-ul-normal">
									<li class="select-number-normal ">0</li>
									<li class="select-number-normal">1</li>
									<li class="select-number-normal">2</li>
									<li class="select-number-normal">3</li>
									<li class="select-number-normal">4</li>
									<li class="select-number-normal">5</li>
									<!--  <li class="select-number-normal">6</li>
                                    <li class="select-number-normal">7</li>
                                    <li class="select-number-normal">8</li> -->
								</ul>
							</div>
						</div>
						<div class="select-seat">
							<div class="select-seat-age">청소년</div>
							<div class="select-seat-number">
								<ul class="select-seat-ul select-seat-ul-teen">
									<li class="select-number-teen">0</li>
									<li class="select-number-teen">1</li>
									<li class="select-number-teen">2</li>
									<li class="select-number-teen">3</li>
									<li class="select-number-teen">4</li>
									<li class="select-number-teen">5</li>
									<!-- <li class="select-number-teen">6</li>
                                    <li class="select-number-teen">7</li>
                                    <li class="select-number-teen">8</li> -->
								</ul>
							</div>
						</div>
						<div class="select-seat">
							<div class="select-seat-age">우대</div>
							<div class="select-seat-number">
								<ul class="select-seat-ul  select-seat-ul-old">
									<li class="select-number-old">0</li>
									<li class="select-number-old">1</li>
									<li class="select-number-old">2</li>
									<li class="select-number-old">3</li>
									<li class="select-number-old">4</li>
									<li class="select-number-old">5</li>
									<!-- <li class="select-number-old">6</li>
                                    <li class="select-number-old">7</li>
                                    <li class="select-number-old">8</li> -->
								</ul>
							</div>
						</div>

					</div>
					<div class="reserve-number-wrapper">
						<div class="reserve-number-title">선택된 좌석 수</div>
						<div class="reserve-number">0</div>
					</div>
				</div>
				<div class="select-seat-information">
					<div class="selected-movie"><%=reserve.getTitle()%></div>
					<div class="select-seat-information-wrapper">
						<div class="select-theater-place selected-theater-place-info">CGV강남</div>
						<div class="select-theater-place selected-theater-place-info">3관
							8층</div>
						<div class="select-theater-place">
							<span>남은좌석</span><span class="remain-seats">152</span>/<span
								class="all-seats">172</span>
						</div>

					</div>
					<div class="select-theater-date">
						<div class="theater-date"><%=reserve.getMovieDate()%></div>
						<div class="theater-time"><%=reserve.getRunningTime()%></div>
					</div>
					<div class="selected-seats-wrapper">
						<span class="selected-seats-title">좌석번호</span> <span
							class="selected-seats">선택한 좌석이 없습니다.</span>
					</div>
					<div class="ticket-price-wrapper">
						<div class="ticket-price-title">가격</div>
						<div class="ticket-price">0원</div>
					</div>
					<form action="/ticket/ticketing" class="seatForm" method="post">
						<input type="hidden" class="title" name="title"> <input
							type="hidden" class="selectedTheater" name="selectedTheater">
						<input type="hidden" class="reserveDate" name="movieDate">
						<input type="hidden" class="runningTime" name="runningTime">
						
						<!-- 멤버 하드코딩 -->
						<input type="hidden" class="memberNO" name="memberNo" value="${responseDto.memberNo}">
						<input type="hidden" class="id" name="id" value="id">
						<!-- 티켓의수(선택한 좌석) -->
						<input type="hidden" class="ticketNumber" name="ticketNumber">
						<input type="hidden" class="selectedSeat" name="selectedSeat">
						<!-- 결제 정보 -->
						<input type="hidden" class="payMoney" name="payMoney">
						<button type="button" class="reserve-button">
							예약하기
						</button>
					</form>
				</div>

			</div>
			<div class="seat-container">

				<div class="seat-wrapper">
					<div class="screen-view-wrapper">
						<div class="screen-view">SCREEN</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/resources/cgv/js/seat.js"></script>

</html>