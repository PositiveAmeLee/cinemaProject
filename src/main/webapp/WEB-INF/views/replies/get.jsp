
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
					value="${reply.stars}" height="50%" width="50%" valign="middle" align="center">
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
				</select> <input type="hidden" value="${reply.movieNO}" name="movieNO">
				<input type="hidden" value="1" name="memberNO"> <input
					type="hidden" value="${reply.replyNO}" name = "replyNO"> <input type="text"
					class="text" value="title" name="title"
					placeholder="${reply.title}" height="50%" width="50%" valign="middle" align="center">
				<textarea name="content" placeholder="${reply.content}" height="50%" width="50%" valign="middle" align="center"></textarea>
				<input type="submit" value="SUBMIT COMMENT">
			</form>

			<form action="/replies/delete" method="post">
				<input type="hidden" value="${reply.replyNO}" name="replyNO">
				<input type="hidden" value="${reply.movieNO}" name="movieNO">
				<input type="submit" value="삭제하기">
			</form>

		</div>
	</div>

</div>
<%@ include file="../common/footer.jsp"%>