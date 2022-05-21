<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">답변 내역</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="answer" items="${answer }">
					<div style="border 1px solid">
						<div class="form-group">
							<label>이름</label><input class="form-control" name="memberName"
								value="<c:out value="${answer.memberName }" />"
								readonly="readonly">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>문의 내용</label>
							<textarea class="form-control" name="questionContents" rows="3"
								readonly="readonly"><c:out
									value="${answer.questionContents }" /></textarea>
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>이메일</label><input class="form-control" name="memberEmail"
								value="<c:out value="${answer.memberEmail }" />"
								readonly="readonly">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>연락처</label><input class="form-control" name="memberPhone"
								value="<c:out value="${answer.memberPhone }" />"
								readonly="readonly">
							<p class="help-block"></p>
						</div>
					</div>

					<div class="form-group">
						<label>제목</label><input class="form-control" name="answerTitle"
							value="<c:out value="${answer.answerTitle }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" name="answerContents" rows="3"
							readonly="readonly"><c:out
								value="${answer.answerContents }" /></textarea>
						<p class="help-block"></p>
					</div>

					<div style="width: 200px">
						<button data-oper="list" class="btn btn-default"
							onclick="location.href='/customerManager/answerList'">리스트</button>
					</div>
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