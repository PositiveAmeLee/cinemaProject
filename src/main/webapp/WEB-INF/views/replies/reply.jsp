<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ include file="../common/header.jsp"%>
<div class="main">
	<div class="single-content">
		<div class="top-header span_top">
			<div class="logo">
				<a href="index.html"><img src="/resources/images/logo.png"
					alt="" /></a>
				<p>Movie Theater</p>
			</div>
			<div class="search v-search">

				<input type="text" value="Search.." onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Search..';}" /> <input
					type="submit" value="">

			</div>
			<div class="clearfix"></div>
		</div>
		<div class="reviews-section">
			<h3 class="head">Movie Reviews</h3>
			<div class="col-md-9 reviews-grids">
				<div class="review">
					<div class="movie-pic">
						<a href="single.html"><img
							src="${movie.movie_image_file_name }" alt="" /></a>
					</div>
					<div class="review-info">
						<a class="span" href="single.html">${movie.movie_title} <i>Movie
								Review</i></a>
						<p class="dirctr">
							<a href="">${movie.movie_director } </a>${movie.movie_release_date }
						<p class="ratingview">Critic's Rating:</p>
						<div class="rating">
							<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
						</div>
						<p class="ratingview">&nbsp;${movie.movie_res_rating}/10</p>
						<div class="clearfix"></div>
						<p class="ratingview c-rating">Avg Readers' Rating:</p>
						<div class="rating c-rating">
							<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
						</div>
						<p class="ratingview c-rating">&nbsp;
							${movie.movie_star_rating}/10</p>
						<div class="clearfix"></div>
						<div class="yrw">
							<div class="dropdown-button"></div>
							<div class="rtm text-center"></div>

							<div class="wt text-center">
								<a href="${movie.movie_trailer}">WATCH THIS TRAILER</a>
							</div>
							<div class="clearfix"></div>
						</div>
						<p class="info">CAST:&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${movie.movie_cast }</p>
						<p class="info">DIRECTION:
							&nbsp;&nbsp;&nbsp;&nbsp;${movie.movie_director}</p>
						<p class="info">GENRE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${movie.movie_genre }</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="single">
					<p>
						STORY:<i> ${movie.movie_synopsis}</i>
					</p>
				</div>
				<!-- comments-section-starts -->
				<div class="comments-section">
					<div class="comments-section-head">
						<div class="comments-section-head-text">
								<h3>${fn:length(replyList)} Comments</h3>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<c:forEach var="reply" items="${replyList}">
				<div class="comments-section-grids">
					<div class="comments-section-grid"></div>
					<div class="col-md-10 comments-section-grid-text">
						<h4>
							<a href="/replies/get?replyNO=${reply.replyNO}">${reply.title}
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${reply.stars } 점 </a>
						</h4>
						<label>${reply.createdAt } </label>
						<p>${reply.content}</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</c:forEach>

			<!-- comments-section-ends -->
			<div class="reply-section">
				<div class="reply-section-head">
					<div class="reply-section-head-text">
						<h3>Leave Reply</h3>
					</div>
				</div>
				<br> <br> <br>
				<div class="blog-form">
					<form action="/replies/writeReview" method="post">
						<select class="dropdown" tabindex="9"
							data-settings='{"wrapperClass":"flat"}' name='stars'
							value=${reply }>
							<option value="0">Your rating</option>
							<option value="1">1.Poor</option>
							<option value="2">2.(Below average)</option>
							<option value="3">3.Average</option>
							<option value="4">4(Above average)</option>
							<option value="5">5.Watchable</option>
							<option value="6">6.(Good)</option>
							<option value="7">7.(Very good)</option>
							<option value="8">8.Outstanding</option>
							<option value="9">9.Best</option>
							<option value="10">10.Best You've never seen before</option>
						</select> <input type="hidden" value="${movie.movie_no}" name="movieNO">
						<input type="hidden" value="1" name="memberNO"> <input
							type="text" class="text" value="title" name="title"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Enter title';}">
						<textarea name="content"></textarea>
						<input type="submit" value="SUBMIT COMMENT">
					</form>


				</div>
			</div>
		</div>

		<div class="clearfix"></div>
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
						visibleItems : 1
					},
					landscape : {
						changePoint : 640,
						visibleItems : 2
					},
					tablet : {
						changePoint : 768,
						visibleItems : 3
					}
				}
			});
		});
	</script>
	<script type="text/javascript" src="/resources/js/jquery.flexisel.js"></script>
</div>
<%@ include file="../common/footer.jsp"%>