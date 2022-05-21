<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">예매내역</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="reservation" items="${reservation }">
					<div class="form-group">
						<label>예매번호</label> <input class="form-control" name="resNo"
							value="<c:out value="${reservation.resNo }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>아이디</label> <input class="form-control" name="memberId"
							value="<c:out value="${reservation.memberId }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>이름</label> <input class="form-control" name="memberName"
							value="<c:out value="${reservation.memberName }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>영화</label> <input class="form-control" name="movieEtitle"
							value="<c:out value="${reservation.movieTitle }"/>(<c:out value="${reservation.movieEtitle }"/>)"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>타입</label><input class="form-control" name="movieType"
							value="<c:out value="${reservation.movieType }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>등급</label><input class="form-control" name="movieGrade"
							value="<c:out value="${reservation.movieGrade }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>극장</label> <input class="form-control" name="resCinema"
							value="<c:out value="${reservation.resCinema }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>상영관</label><input class="form-control" name="resTheater"
							value="<c:out value="${reservation.resTheater }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>예매일자</label> <input class="form-control"
							name="moviePlaytime"
							value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${reservation.resDate }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>인원</label>
						<input class="form-control" name="resPerson"
							value="<c:out value="${reservation.resPerson }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>결제금액</label> <input class="form-control" name="resTotal"
							value="<c:out value="${reservation.resTotal }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>좌석</label> <input class="form-control"
							name="resSeatNo" value="<c:out value="${reservation.resSeatNo }"/>"
							readonly="readonly">
					</div>
					<button data-oper="modify" class="btn btn-default"
						onclick="location.href='/reservationManager/modify?resNo=<c:out value="${reservation.resNo}"/>'">수정</button>
					<button data-oper="list" class="btn btn-default"
						onclick="location.href='/reservationManager/list'">리스트</button>
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