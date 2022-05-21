<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(
			function() {

				var result = '<c:out value="${result}"/>';

				checkModal(result);

				history.replaceState({}, null, null);

				function checkModal(result) {

					if (result === '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$(".modal-body").html(
								"게시물 " + parseInt(result) + " 번이 등록되었습니다.");
					}

					$("#myModal").modal("show");
				}

				$("#regBtn").on("click", function() {
					self.location = "";
				})
			});
</script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">영화 등록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<form role="form" method="post" action="/movieManager/register">
					<div class="form-group">
						<label>영화 이미지</label> <input class="form-control"
							name="movieImage">
						 <p class="help-block">이미지 링크 첨부</p>
					</div>
					<div class="form-group">
						<label>영화 타이틀</label> <input class="form-control"
							name="movieTitle">
						<p class="help-block">한글명</p>
					</div>
					<div class="form-group">
						<label>영화 타이틀(영문)</label> <input class="form-control"
							name="movieEtitle">
						<p class="help-block">영문명</p>
					</div>
					<div class="form-group">
						<label>타입</label> <select multiple size="2" class="form-control"
							name="movieType">
							<option value="2D">2D</option>
							<option value="IMAX">IMAX</option>
						</select>
						<p class="help-block">중복 체크 가능</p>
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
						<p class="help-block">중복 체크 가능</p>
					</div>
					<div class="form-group">
						<label>상영 시간</label> <input class="form-control"
							name="moviePlaytime">
						<p class="help-block">분 단위 기입</p>
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
						<label>감독</label> <input class="form-control" name="movieDirector">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>배우</label> <input class="form-control" name="movieActor">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>컨텐츠</label>
						<textarea class="form-control" name="movieContents" rows="3"></textarea>
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
					<button type="submit" class="btn btn-default">등록</button>
					<button type="reset" class="btn btn-default">초기화</button>
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