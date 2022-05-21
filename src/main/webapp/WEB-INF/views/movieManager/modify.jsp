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

							if (operation === 'delete') {
								formObj.attr("action", "/movieManager/delete");
							} else if (operation === 'list') {
								formObj.attr("action", "/movieManager/list")
										.attr("method", "get");
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
		<h1 class="page-header">영화정보 수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="movie" items="${movie }">
					<form role="form" method="post" action="/movieManager/modify">
						<div class="form-group">
							<label>영화 이미지</label> <input class="form-control"
								name="movieImage" value="<c:out value="${movie.movieImage }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>영화 타이틀</label> <input class="form-control"
								name="movieTitle" value="<c:out value="${movie.movieTitle }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>영화 타이틀(영문)</label> <input class="form-control"
								name="movieEtitle"
								value="<c:out value="${movie.movieEtitle }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>타입</label> <select multiple size="2" class="form-control"
								name="movieType">
								<option value="2D">2D</option>
								<option value="IMAX">IMAX</option>
							</select>
						</div>
						<div class="form-group">
							<label>장르</label> <select multiple class="form-control"
								name="movieGenre">
								<option value="멜로">멜로</option>
								<option value="코미디">코미디</option>
								<option value="액션">액션</option>
								<option value="서부극">서부극</option>
								<option value="갱스터">갱스터</option>
								<option value="느와르">느와르</option>
								<option value="스릴러">스릴러</option>
								<option value="미스터리">미스터리</option>
								<option value="모험">모험</option>
								<option value="공포">공포</option>
								<option value="전쟁">전쟁</option>
								<option value="탐정">탐정</option>
								<option value="SF">SF</option>
								<option value="판타지">판타지</option>
							</select>
						</div>
						<div class="form-group">
							<label>상영 시간</label> <input class="form-control"
								name="moviePlaytime"
								value="<c:out value="${movie.moviePlaytime }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>등급</label> <select class="form-control" name="movieGrade">
								<option value="전체관람가">전체관람가</option>
								<option value="12세관람가">12세관람가</option>
								<option value="15세관람가">15세관람가</option>
								<option value="청소년관람불가">청소년관람불가</option>
							</select>
						</div>
						<div class="form-group">
							<label>감독</label> <input class="form-control"
								name="movieDirector"
								value="<c:out value="${movie.movieDirector }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>배우</label> <input class="form-control" name="movieActor"
								value="<c:out value="${movie.movieActor }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>컨텐츠</label>
							<textarea class="form-control" name="movieContents" rows="3"><c:out
									value="${movie.movieContents }" /></textarea>
						</div>
						<div class="form-group">
							<label>개봉일</label> <input type="date" name="movieOpendate">
						</div>
						<div class="form-group">
							<label>상영 상태</label> <select class="form-control"
								name="movieStatus">
								<option value="상영 예정">상영 예정</option>
								<option value="상영중">상영중</option>
								<option value="상영 종료">상영 종료</option>
							</select>
						</div>
						<button type="submit" data-oper='modify' class="btn btn-default">수정</button>
						<button type="submit" data-oper='delete' class="btn btn-default">삭제</button>
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