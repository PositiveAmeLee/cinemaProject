<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(
			function() {
				var formObj = $("form");

				$('button').on(
						"click",
						function(e) {

							e.preventDefault();

							var operation = $(this).data("oper");

							console.log(operation);

							if (operation === 'list') {
								formObj.attr("action",
										"/reservationManager/list").attr(
										"method", "get");
								var pageNumTag = $("input[name='pageNum']")
										.clone();

								formObj.empty();
								formObj.append(pageNumTag);
							}
							formObj.submit();
						});
			});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">예매내역 수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="reservation" items="${reservation }">
					<form role="form" method="post" action="/reservationManager/modify">
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
							value="<c:out value="${reservation.movieTitle }"/>">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>타입</label><input class="form-control" name="movieType"
							value="<c:out value="${reservation.movieType }"/>">
					</div>
					<div class="form-group">
						<label>등급</label><input class="form-control" name="movieGrade"
							value="<c:out value="${reservation.movieGrade }"/>">
					</div>
					<div class="form-group">
						<label>극장</label> <input class="form-control" name="resCinema"
							value="<c:out value="${reservation.resCinema }"/>">
							
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>상영관</label><input class="form-control" name="resTheater"
							value="<c:out value="${reservation.resTheater }"/>">
					</div>
					<div class="form-group">
						<label>예매일자</label> <input class="form-control"
							name="resDate" type="date">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>인원</label>
						<input class="form-control" name="resPerson"
							value="<c:out value="${reservation.resPerson }"/>">
					</div>
					<div class="form-group">
						<label>결제금액</label> <input class="form-control" name="resTotal"
							value="<c:out value="${reservation.resTotal }"/>">
					</div>
					<div class="form-group">
						<label>좌석</label> <input class="form-control"
							name="resSeatNo" value="<c:out value="${reservation.resSeatNo }"/>">
					</div>
						<button type="submit" data-oper='modify' class="btn btn-default">수정</button>
						<button type="submit" data-oper='list' class="btn btn-default">리스트</button>
					</form>
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