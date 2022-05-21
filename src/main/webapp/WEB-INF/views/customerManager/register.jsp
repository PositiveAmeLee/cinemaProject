<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">답변 등록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
			<form role="form" method="post" action="/customerManager/register">
					<c:forEach var="question" items="${question }">
					<input type="hidden" name="questionNo" value="<c:out value="${question.questionNo }"/>">
					<div class="form-group">
						<label>이름</label><input class="form-control" name="memberName"
							value="<c:out value="${question.memberName }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>이메일</label><input class="form-control" name="memberEmail"
							value="<c:out value="${question.memberEmail }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>연락처</label><input class="form-control" name="memberPhone"
							value="<c:out value="${question.memberPhone }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>문의 내용</label>
						<textarea class="form-control" name="questionContents" rows="3"
							readonly="readonly"><c:out
								value="${question.questionContents }" /></textarea>
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>제목</label><input class="form-control" name="answerTitle"
							value="<c:out value="${answer.answerTitle }" />"
							>
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" name="answerContents" rows="3"
							><c:out
								value="${answer.answerContents }" /></textarea>
						<p class="help-block"></p>
					</div>
					<button type="submit" class="btn btn-default">등록</button>
					<button type="reset" class="btn btn-default">초기화</button>
					</c:forEach>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>