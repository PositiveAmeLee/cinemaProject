
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

<c:if test="${comment.memberNo != responseDto.memberNo}">
	
	<script>
	
	alert("리뷰를 작성한 본인만 작성할 수 있습니다.")
	location.href = "/replies/reply?movieNo="+${comment.movieNo}
	
	</script>

</c:if>


<div>
	<div class="reply-section" height="50%" width="50%" valign="middle" align="center">
		<div class="reply-section-head" >
			<div class="reply-section-head-text" >
				<h3>Leave Reply</h3>
			</div>
		</div>
		<br> <br> <br>
		<div class="blog-form" height="50%" width="50%" valign="middle" align="center">
			<form action="/replies/update" method="post">
				<select class="dropdown" tabindex="9"
					data-settings='{"wrapperClass":"flat"}' name='commentStarRating'
					value="${comment.commentStarRating}" height="50%" width="50%" valign="middle" align="center">
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
				</select> <input type="hidden" value="${comment.movieNo}" name="movieNo">
				<input type="hidden" value="${responseDto.memberNo}" name="memberNO"> 
				<input
					type="hidden" value="${comment.commentNo}" name = "commentNo"> 
				<textarea name="commentContents" placeholder="${comment.commentContents}" height="50%" width="50%" valign="middle" align="center"></textarea>
				<input type="submit" value="수정하기">
			</form>

			<form action="/replies/delete" method="post">
				<input type="hidden" value="${comment.commentNo}" name="commentNo">
				<input type="hidden" value="${comment.movieNo}" name="movieNo">
				<input type="submit" value="삭제하기">
			</form>

		</div>
	</div>

</div>
<%@ include file="../common/footer.jsp"%>