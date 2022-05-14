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
	background: url('${main.movie_image_file_name}') no-repeat 0px 0px;
	background-size:  100% 100%;
	-webkit-background-size: 100% 100%;
	-moz-background-size: 100% 100%;
	-o-background-size:  100% 100%;
	-ms-background-size: 100% 100%;
	min-height: 750px;
	
}
</style>

<div class="main">
	<div class="header">
		<div class="top-header">
			<div class="logo">
				<a href="index.html"><img src="resources/images/logo.png" alt="" /></a>
				<p>Ezen Cinema</p>
			</div>
			<div class="search">
				<form>
					<input type="text" value="Search.." onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search..';}" /> <input
						type="submit" value="">
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="header-info" >
			<h2 style="color: white;">${main.movie_title}</h2>
			<p class="age">
				<a href="#">12세 관람가</a> ${main.movie_director}, ${main.movie_cast}
			</p>
			<p class="review">Rating
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp;
				${main.movie_star_rating}/10</p>
			<p class="review reviewgo">Genre
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;
				${main.movie_genre}</p>
			<p class="review">Release &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp;
				${main.movie_release_date}</p>
			<p class="special">${main.movie_synopsis}</p>
			<a class="video" href="${main.movie_trailer}"><i class="video1"></i>트레일러
				보기</a> <a class="book" href="#"><i class="book1"></i>예매하러 가기</a>
		</div>
	</div>
	<div class="review-slider">
		<ul id="flexiselDemo1">
			<li><img src="${list[0].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[1].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[2].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[3].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[4].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[5].movie_image_file_name}" alt="" /></li>
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
		<iframe src="${list[0].movie_trailer}" frameborder="0" allowfullscreen></iframe>
	</div>
	<div class="news">
		<div class="col-md-6 news-left-grid">
			<h3>영화보러 가요!</h3>
			<h2>지금 당장 예매하기</h2>
			<h4>#쉽고 #간편한 #빠른</h4>
			<a href="#"><i class="book"></i>빠른 예매</a>
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
			<li><img src="${list[0].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[1].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[2].movie_image_file_name}" alt="" /></li>
			<li><img src="${list[3].movie_image_file_name}" alt="" /></li>
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