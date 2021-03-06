<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ include file="../common/header.jsp"%>


<style>
.header {
	background: url('${main.movieImage}') no-repeat 0px 0px;
	background-size:  100% 100%;
	-webkit-background-size: 100% 100%;
	-moz-background-size: 100% 100%;
	-o-background-size:  100% 100%;
	-ms-background-size: 100% 100%;
	min-height: 750px;
	
}
</style>

			<div class="clearfix"></div>
		</div>
		<div class="header-info" >
			<h2 style="color: white;">${main.movieTitle}</h2>
			
			<p class="review reviewgo">Genre
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;
				${main.movieGenre}</p>
			<p class="review">Release &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp;
				${main.movieOpendate}</p>
			<p class="special">${main.movieContents}</p>
			<a class="video" href="${main.movieTrailer}"><i class="video1"></i>트레일러
				보기</a> <a class="book" href="/ticket/ticketForm"><i class="book1"></i>예매하러 가기</a>
		</div>
	</div>
	<div class="review-slider">
		<ul id="flexiselDemo1">
			<li><img src="${list[0].movieImage}" alt="" /></li>
			<li><img src="${list[1].movieImage}" alt="" /></li>
			<li><img src="${list[2].movieImage}" alt="" /></li>
			<li><img src="${list[3].movieImage}" alt="" /></li>
			<li><img src="${list[4].movieImage}" alt="" /></li>
			<li><img src="${list[5].movieImage}" alt="" /></li>
		</ul>
		<script type="text/javascript">
			$(window).load(function() {

				$("#flexiselDemo1").flexisel({
					visibleItems : 6,
					animationSpeed : 1000,
					autoPlay : true,
					autoPlaySpeed : 3000,
					pauseOnHover : false,
					enableResponsiveBreakpoints : true,
					responsiveBreakpoints : {
						portrait : {
							changePoint : 480,
							visibleItems : 2
						},
						landscape : {
							changePoint : 640,
							visibleItems : 3
						},
						tablet : {
							changePoint : 768,
							visibleItems : 4
						}
					}
				});
			});
		</script>
		<script type="text/javascript" src="/resources/js/jquery.flexisel.js"></script>
	</div>
	<div class="video">
		<iframe src="${main.movieTrailer}" frameborder="0" allowfullscreen></iframe>
	</div>
	<div class="news">
		<div class="col-md-6 news-left-grid">
			<h3>영화보러 가요!</h3>
			<h2>지금 당장 예매하기</h2>
			<h4>#쉽고 #간편한 #빠른</h4>
			<a href="/ticket/ticketForm"><i class="book"></i>빠른 예매</a>
			<p>
				멤버쉽등급을 높이고 <strong>10%</strong> 할인을 받으세요!
			</p>
		</div>
		<div class="col-md-6 news-right-grid">
			<h3>News</h3>
			<div class="news-grid">
				<h5>Lorem Ipsum Dolor Sit Amet</h5>
				<label>Nov 11 2014</label>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo.</p>
			</div>
			<div class="news-grid">
				<h5>Lorem Ipsum Dolor Sit Amet</h5>
				<label>Nov 11 2014</label>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo.</p>
			</div>
			<a class="more" href="#">MORE</a>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="more-reviews">
		<ul id="flexiselDemo2">
			<li><img src="${list[0].movieImage}" alt="" /></li>
			<li><img src="${list[1].movieImage}" alt="" /></li>
			<li><img src="${list[2].movieImage}" alt="" /></li>
			<li><img src="${list[3].movieImage}" alt="" /></li>
		</ul>
		<script type="text/javascript">
			$(window).load(function() {

				$("#flexiselDemo2").flexisel({
					visibleItems : 4,
					animationSpeed : 1000,
					autoPlay : true,
					autoPlaySpeed : 3000,
					pauseOnHover : false,
					enableResponsiveBreakpoints : true,
					responsiveBreakpoints : {
						portrait : {
							changePoint : 480,
							visibleItems : 2
						},
						landscape : {
							changePoint : 640,
							visibleItems : 3
						},
						tablet : {
							changePoint : 768,
							visibleItems : 3
						}
					}
				});
			});
		</script>
		<script type="text/javascript" src="resources/js/jquery.flexisel.js"></script>
	</div>
	<%@ include file="../common/footer.jsp"%>