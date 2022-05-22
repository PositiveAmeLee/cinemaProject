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
			<div class="clearfix"></div>
		</div>
		<div class="reviews-section">
			<h3 class="head">Movie Reviews</h3>
			<div class="col-md-9 reviews-grids">
				<div class="review">
					<div class="movie-pic">
						<a href=""><img
							src="${movie.movieImage }" alt="" /></a>
					</div>
					<div class="review-info">
						<a class="span" href="">${movie.movieTitle} <i>Movie
								Review</i></a>
						<p class="dirctr">
							<a href="">${movie.movieDirector } </a>${movie.movieOpendate }
						<p class="ratingview">Critic's Rating:</p>
						<div class="rating">
							<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
						</div>
						<p class="ratingview">&nbsp;9.34/10</p>
						<div class="clearfix"></div>
						<p class="ratingview c-rating">Avg Readers' Rating:</p>
						<div class="rating c-rating">
							<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
						</div>
						<p class="ratingview c-rating">&nbsp;
							9.34/10</p>
						<div class="clearfix"></div>
						<div class="yrw">
							<div class="dropdown-button"></div>
							<div class="rtm text-center"></div>

							<div class="wt text-center">
								<a href="${movie.movieTrailer}">WATCH THIS TRAILER</a>
							</div>
							<div class="clearfix"></div>
						</div>
						<p class="info">CAST:&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${movie.movieActor }</p>
						<p class="info">DIRECTION:
							&nbsp;&nbsp;&nbsp;&nbsp;${movie.movieDirector}</p>
						<p class="info">GENRE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${movie.movieGenre }</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="single">
					<p>
						STORY:<i> ${movie.movieContents}</i>
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
							<a href="/replies/get?commentNo=${reply.commentNo}">${reply.memberId}님의 점수는?
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${reply.commentStarRating } 점 </a>
						</h4>
						<label>${reply.commentCreateTime } </label>
						<p>${reply.commentContents}</p>
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
							data-settings='{"wrapperClass":"flat"}' name='commentStarRating'
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
						</select> <input type="hidden" value="${movie.movieNo}" name="movieNo">
						<input type="hidden" value="${responseDto.memberNo}" name="memberNO"> 
						<input type="hidden" value="${movie.movieTitle}" name="movieTitle">
						<input type="hidden" value="${responseDto.memberId}" name="memberId">
						<input type="hidden" value="${responseDto.memberName }" name="memberName">
						<input type="hidden" value="${responseDto.memberName }" name="memberNickname">
						<textarea name="commentContents"></textarea>
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