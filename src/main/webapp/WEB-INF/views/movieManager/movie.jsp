<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">영화정보</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="movie" items="${movie }">
					<div class="form-group">
						<label>영화 이미지</label> <input class="form-control"
							name="movieImage" value="<c:out value="${movie.movieImage }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>영화 타이틀</label> <input class="form-control"
							name="movieTitle" value="<c:out value="${movie.movieTitle }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>영화 타이틀(영문)</label> <input class="form-control"
							name="movieEtitle" value="<c:out value="${movie.movieEtitle }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<input class="form-control" name="movieType"
							value="<c:out value="${movie.movieType }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<input class="form-control" name="movieGenre"
							value="<c:out value="${movie.movieGenre }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>상영 시간</label> <input class="form-control"
							name="moviePlaytime"
							value="<c:out value="${movie.moviePlaytime }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>

					<div class="form-group">
						<input class="form-control" name="movieGrade"
							value="<c:out value="${movie.movieGrade }"/>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>감독</label> <input class="form-control" name="movieDirector"
							value="<c:out value="${movie.movieDirector }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>배우</label> <input class="form-control" name="movieActor"
							value="<c:out value="${movie.movieActor }"/>" readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>컨텐츠</label>
						<textarea class="form-control" name="movieContents" rows="3"
							readonly="readonly"><c:out
								value="${movie.movieContents }" /></textarea>
					</div>
					<div class="form-group">
						<label>개봉일</label> <input class="form-control"
							name="movieOpendate"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${movie.movieOpendate }"/>"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>상영 상태</label> <input class="form-control"
							name="movieStatus" value="<c:out value="${movie.movieStatus }"/>"
							readonly="readonly">
					</div>
					<button data-oper="modify" class="btn btn-default"
						onclick="location.href='/movieManager/modify?movieNo=<c:out value="${movie.movieNo}"/>'">수정</button>
					<button data-oper="list" class="btn btn-default"
						onclick="location.href='/movieManager/list'">리스트</button>
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