<%@page import="com.cinema.domain.TicketVO"%>
<%@page import="java.util.List"%>
<%@page import="com.cinema.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%
MemberVO login = (MemberVO) session.getAttribute("memberVO");
if (login != null)
	System.out.println(login.toString());

List<TicketVO> list = (List<TicketVO>) request.getAttribute("ticketList");
%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="/resources/cgv/css/reset.css">
<link rel="stylesheet" href="/resources/cgv/css/header.css">
<link rel="stylesheet" href="/resources/cgv/css/myPage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<!-- MATERIAL DESIGN ICONIC FONT -->

</head>

<body>



	<%
	if (login == null) {
	%>
	<script>
		alert("로그인이 필요한 작업입니다 로그인을 진행해 주세요!")
		location.href = "moveMain.do"
	</script>
	<%
	}
	%>
	<%@ include file="../common/header.jsp"%>
	<div>
		<div class="my-page-container">
			<div class="my-page-wrapper">
				<div class="my-page-header">예약한 영화 목록</div>
				<div class="movie-reserve-list">
					<%
					if (list == null) {
					%>
					<div>예약한 영화가 없습니다</div>
					<%
					} else {
					for (int i = 0; i < list.size(); i++) {
						TicketVO reserveDto = list.get(i);
					%>
					<div class="movie-reserve">
						
						<div class="movie-reserve-title"><%=reserveDto.getTitle()%></div>
						<div class="movie-reserve-theater-wrapper">
							<div><%=reserveDto.getSelectedTheater()%></div>
							&nbsp;/&nbsp;
							<div class="ticket-numeber"><%=reserveDto.getTicketNumber()%>장
							</div>
						</div>
						<div class="movie-reserve-seats"><%=reserveDto.getSelectedSeat()%></div>
						<div class="movie-reserve-date-wrapper">
							<div class="movie-reserve-date"><%=reserveDto.getMovieDate()%></div>
							<div class="movie-reserve-runningTime"><%=reserveDto.getRunningTime()%></div>
						</div>
						<div class="movie"></div>

						<div class="pay-information-wrapper">

							<div class="barcode-wrapper">
								<div>Ezen Cinema</div>
								<img src="/resources/cgv/images/barcode.png">
							</div>
							<div>
								<form action="/ticket/cancle" method="post">
								<input type="hidden" value="<%=reserveDto.getTicketNO() %>" name="ticketNO">
								<input type="submit" value="예약취소">								
								</form>
							</div>
						</div>
					</div>
					<%
					}
					%>
					<!-- <div class="movie-reserve">
						<div class="movie-reserve-age">15세이상 관람가</div>
						<div class="movie-reserve-title">겨울왕국2</div>
						<div class="movie-reserve-theater-wrapper">
							<div>CGV 강남 1관 3층</div>
							&nbsp;/&nbsp;
							<div class="ticket-numeber">1명</div>
						</div>
						<div class="movie-reserve-seats">A01, A02</div>
						<div class="movie-reserve-date-wrapper">
							<div class="movie-reserve-date">2019.11.22 (금)</div>
							<div class="movie-reserve-runningTime">24:10 ~ 26:03</div>
						</div>
						<div class="movie"></div>

						<div class="pay-information-wrapper">
							<div class="pay-information-date-wrapper">
								<div class="pay-information-date-title">결제한 날</div>
								<div class="pay-information-date">2020-03-07-00시</div>
							</div>

							<div class="pay-information-money-wrapper">
								<div class="pay-information-money-title">결제한 비용</div>
								<div class="pay-information-money">60000원</div>
							</div>

							<div class="barcode-wrapper">
								<div>CGV</div>
								<img src="images/barcode.png">
							</div>

						</div>
					</div> -->
					<%
					}
					%>




				</div>

			</div>
		</div>
	</div>
</body>
	<%@ include file="../common/footer.jsp"%>