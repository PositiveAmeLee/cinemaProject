<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">문의 내역</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="question" items="${question }">
					<div class="form-group">
						<label>이름</label><input class="form-control"
							name="memberName" value="<c:out value="${question.memberName }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>문의 내용</label>
							<textarea class="form-control" name="questionContents" rows="3"
							readonly="readonly"><c:out value="${question.questionContents }" /></textarea>
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>이메일</label><input class="form-control"
							name="memberEmail" value="<c:out value="${question.memberEmail }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>연락처</label><input class="form-control"
							name="memberPhone" value="<c:out value="${question.memberPhone }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<form method="get" action="/customerManager/register" style="display:inline-block;">
					<input type="hidden" name="questionNo" value="<c:out value="${question.questionNo }"/>">
					<%-- <input type="hidden" name="memberName" value="<c:out value="${question.memberName }"/>">
					<input type="hidden" name="memberEmail" value="<c:out value="${question.memberEmail }"/>">
					<input type="hidden" name="memberPhone" value="<c:out value="${question.memberPhone }"/>">
					<input type="hidden" name="memberContents" value="<c:out value="${question.questionContents }"/>"> --%>
						<button type="submit" class="btn btn-default"
						onclick="location.href='/customerManager/register?questionNo=<c:out value="${question.questionNo}"/>'">답변 작성</button>
						</form>
					<button data-oper="list" class="btn btn-default"
						onclick="location.href='/customerManager/questionlist'">리스트</button>
				</c:forEach>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>