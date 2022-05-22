
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

<c:if test="${comment.memberNO != memberVO.member_no}">
	
	<script>
	
	alert("리뷰를 작성한 본인만 작성할 수 있습니다.")
	location.href = "/replies/reply?movieNO="+${comment.movieNO}
	
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
					data-settings='{"wrapperClass":"flat"}' name='stars'
					value="${comment.stars}" height="50%" width="50%" valign="middle" align="center">
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
				</select> <input type="hidden" value="${comment.movieNO}" name="movieNO">
				<input type="hidden" value="${memberVO.member_no}" name="memberNO"> <input
					type="hidden" value="${comment.replyNO}" name = "replyNO"> <input type="text"
					class="text" value="title" name="title"
					placeholder="${comment.title}" height="50%" width="50%" valign="middle" align="center">
				<textarea name="content" placeholder="${comment.content}" height="50%" width="50%" valign="middle" align="center"></textarea>
				<input type="submit" value="수정하기">
			</form>

			<form action="/replies/delete" method="post">
				<input type="hidden" value="${comment.commentNO}" name="commentNO">
				<input type="hidden" value="${comment.movieNO}" name="movieNO">
				<input type="submit" value="삭제하기">
			</form>

		</div>
	</div>

</div>
<%@ include file="../common/footer.jsp"%>