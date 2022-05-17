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


			<div class="clearfix"></div>
		</div>
		<div class="reviews-section">
			<h3 class="head">Movie Reviews</h3>
			<div class="col-md-9 reviews-grids">
				<c:forEach var="movie" items="${list}">
					<div class="review">
						<div class="movie-pic">
							<a href="/replies/reply?movieNO=${movie.movie_no}"><img src="${movie.movie_image_file_name}"
								alt="" /></a>
						</div>
						<div class="review-info">
							<a class="span" href="/replies/reply?movieNO=${movie.movie_no}">${movie.movie_title} <i>Movie
									Review</i></a>
							<p class="dirctr">
								<a href="">${movie.movie_director } </a>${movie.movie_release_date }
							</p>
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
							<p class="ratingview c-rating">&nbsp; ${movie.movie_star_rating}/10</p>
							<div class="clearfix"></div>
							<div class="yrw">
								<div class="dropdown-button">
								<form action="/replies/writeReview" method="post">
									<select class="dropdown" tabindex="9"
										data-settings='{"wrapperClass":"flat"}' name='stars'>
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
									</select>
									<input type = "hidden" value="${movie.movie_no}" name = "movieNO">
									<input type = "hidden" value="1" name="memberNO">
									<input type = "hidden" value="NO TITLE" name="title">
									<input type = "hidden" value="NO CONTENT" name="content">
								</div>
								<div class="rtm text-center">
								<input type="submit"
									value="REVIEW THIS MOVIE">
								</div>
								</form>
								<div class="wt text-center">
									<a href="${movie.movie_trailer}">WATCH THIS TRAILER</a>
								</div>
								<div class="clearfix"></div>
							</div>
							<p class="info">CAST:&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								${movie.movie_cast }</p>
							<p class="info">DIRECTION: &nbsp;&nbsp;&nbsp;&nbsp;${movie.movie_director}</p>
							<p class="info">GENRE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								${movie.movie_genre }</p>
						
						</div>
						<div class="clearfix"></div>
					</div>
				</c:forEach>
			</div>
			<div class="col-md-3 side-bar">
				<div class="featured">
					<h3>평론가 리뷰 보기</h3>
					<ul>
						<li><a href="single.html"><img
								src="/resources/images/f1.jpg" alt="" /></a>
							<p>lorem movie review</p></li>
						<li><a href="single.html"><img
								src="/resources/images/f2.jpg" alt="" /></a>
							<p>lorem movie review</p></li>
						<li><a href="single.html"><img
								src="/resources/images/f3.jpg" alt="" /></a>
							<p>lorem movie review</p></li>
						<li><a href="single.html"><img
								src="/resources/images/f4.jpg" alt="" /></a>
							<p>lorem movie review</p></li>
						<li><a href="single.html"><img
								src="/resources/images/f5.jpg" alt="" /></a>
							<p>lorem movie review</p></li>
						<li><a href="single.html"><img
								src="/resources/images/f6.jpg" alt="" /></a>
							<p>lorem movie review</p></li>
						<div class="clearfix"></div>
					</ul>
				</div>

				<div class="entertainment">
					<h3>베스트 리뷰 보기</h3>
					<ul>
						<li class="ent"><a href="single.html"><img
								src="/resources/images/f6.jpg" alt="" /></a></li>
						<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
								during WC match</a></li>
						<div class="clearfix"></div>
					</ul>
					<ul>
						<li class="ent"><a href="single.html"><img
								src="/resources/images/f5.jpg" alt="" /></a></li>
						<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
								during WC match</a></li>
						<div class="clearfix"></div>
					</ul>
					<ul>
						<li class="ent"><a href="single.html"><img
								src="/resources/images/f3.jpg" alt="" /></a></li>
						<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
								during WC match</a></li>
						<div class="clearfix"></div>
					</ul>
					<ul>
						<li class="ent"><a href="single.html"><img
								src="/resources/images/f4.jpg" alt="" /></a></li>
						<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
								during WC match</a></li>
						<div class="clearfix"></div>
					</ul>
					<ul>
						<li class="ent"><a href="single.html"><img
								src="/resources/images/f2.jpg" alt="" /></a></li>
						<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
								during WC match</a></li>
						<div class="clearfix"></div>
					</ul>
					<ul>
						<li class="ent"><a href="single.html"><img
								src="/resources/images/f1.jpg" alt="" /></a></li>
						<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
								during WC match</a></li>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="might">
					<h4>You might also like</h4>
					<div class="might-grid">
						<div class="grid-might">
							<a href="single.html"><img src="/resources/images/mi.jpg"
								class="img-responsive" alt=""> </a>
						</div>
						<div class="might-top">
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting industry.</p>
							<a href="single.html">Lorem Ipsum <i> </i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="might-grid">
						<div class="grid-might">
							<a href="single.html"><img src="/resources/images/mi1.jpg"
								class="img-responsive" alt=""> </a>
						</div>
						<div class="might-top">
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting industry.</p>
							<a href="single.html">Lorem Ipsum <i> </i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="might-grid">
						<div class="grid-might">
							<a href="single.html"><img src="/resources/images/mi2.jpg"
								class="img-responsive" alt=""> </a>
						</div>
						<div class="might-top">
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting industry.</p>
							<a href="single.html">Lorem Ipsum <i> </i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="might-grid">
						<div class="grid-might">
							<a href="single.html"><img src="/resources/images/mi3.jpg"
								class="img-responsive" alt=""> </a>
						</div>
						<div class="might-top">
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting industry.</p>
							<a href="single.html">Lorem Ipsum <i> </i></a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!---->
				<div class="grid-top">
					<h4>Archives</h4>
					<ul>
						<li><a href="single.html">Lorem Ipsum is simply dummy
								text of the printing and typesetting industry. </a></li>
						<li><a href="single.html">Lorem Ipsum has been the
								industry's standard dummy text ever since the 1500s</a></li>
						<li><a href="single.html">When an unknown printer took a
								galley of type and scrambled it to make a type specimen book. </a></li>
						<li><a href="single.html">It has survived not only five
								centuries, but also the leap into electronic typesetting</a></li>
						<li><a href="single.html">Remaining essentially
								unchanged. It was popularised in the 1960s with the release of </a>
						</li>
						<li><a href="single.html">Letraset sheets containing
								Lorem Ipsum passages, and more recently with desktop publishing
						</a></li>
						<li><a href="single.html">Software like Aldus PageMaker
								including versionsof Lorem Ipsum.</a></li>
					</ul>
				</div>
				<!---->

			</div>

			<div class="clearfix"></div>
		</div>
	</div>
	<div class="review-slider">
		<ul id="flexiselDemo1">
			<li><img src="${list[0].movie_image_file_name}" alt=""/></li>
			<li><img src="${list[1].movie_image_file_name}"alt=""/></li>
			<li><img src="${list[2].movie_image_file_name}" alt=""/></li>
			<li><img src="${list[3].movie_image_file_name}" alt=""/></li>
			<li><img src="${list[4].movie_image_file_name}" alt=""/></li>
			<li><img src="${list[5].movie_image_file_name}" alt=""/></li>
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
							visibleItems : 3
						}
					}
				});
			});
		</script>
		<script type="text/javascript" src="/resources/js/jquery.flexisel.js"></script>
	</div>
	<%@ include file="../common/footer.jsp"%>