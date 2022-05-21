<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {

		var actionForm = $("#actionForm");

		$(".paginate_button a").on("click", function(e) {

			e.preventDefault();

			console.log("click");

			actionForm.find("input[name='pageNum']").val($(this).attr("href"));

			actionForm.submit();
		});

		var searchForm = $("#searchForm");

		$("#searchForm button").on("click", function(e) {

			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			searchForm.submit();

		});
	});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">영화목록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<button class="btn btn-danger btn-lg" type="button"
				onclick='location.href="/movieManager/register"'
				style="display: block; margin: 0 auto -20px;">등록</button>
			<div class="panel-body">
				<table width="100%" class="table table-striped"
					id="dataTables-example">
					<tbody>
						<c:forEach var="movieList" items="${movieList}">

							<tr>
								<td><a
									href="movie?movieNo=<c:out value="${movieList.movieNo }"/>"><img
										src="<c:out value="${movieList.movieImage }"/>"></a></td>
								<td>
									<p>
										<a href="movie?movieNo=<c:out value="${movieList.movieNo }"/>"><c:out
												value="${movieList.movieTitle }" /> (<c:out
												value="${movieList.movieEtitle }" />)</a>
									</p>
									<p>
										상영 타입 :
										<c:out value="${movieList.movieType }" />
										/ 장르 :
										<c:out value="${movieList.movieGenre }" />
										/ 개봉일 :
										<fmt:formatDate pattern="yyyy.MM.dd"
											value="${movieList.movieOpendate }" />
									</p>
									<p>
										감독 :
										<c:out value="${movieList.movieDirector }" />
									</p>
									<p>
										배우 :
										<c:out value="${movieList.movieActor }" />
									</p>
									<p>
										상영 상태 :
										<c:out value="${movieList.movieStatus }" />
									</p>
									<button class="btn btn-default"
										onclick="location.href='/movieManager/modify?movieNo=<c:out value="${movieList.movieNo}"/>'">수정</button>
										<form style="display: inline-table;" method="post" action="/movieManager/delete">
											<input type="hidden" name="movieNo"
												value="${movieList.movieNo }"> <input
												class="btn btn-default" type="submit" value="삭제">
										</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="input-group custom-search-form"
					style="display: block; margin: 50px auto 0; line-height: 34px; width: 400px;">
					<form id="searchForm" method="Get" action="/movieManager/list">
						<select style="width: 111px;" class="form-control" name="type">
							<option value="M">영화명</option>
						</select> <input type="text" name="keyword" class="form-control"
							placeholder="Search..." style="width: 250px;"> <span
							class="input-group-btn" style="width: 39px"> <input
							type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
							<input type='hidden' name='amount'
							value="${pageMaker.cri.amount }">
							<button class="btn btn-default">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</form>
				</div>
				<form id="actionForm" action="/movieManager/list" method="Get">
					<input type='hidden' name="pageNum"
						value='<c:out value="${pageMaker.cri.pageNum }"/>'> <input
						type='hidden' name="amount"
						value='<c:out value="${pageMaker.cri.amount }"/>'>

					<div class='pull-right'>
						<ul class="pagination">
							<c:if test="${pageMaker.prev }">
								<li class="paginate_button previous"><a
									href="${pageMaker.startPage -1 }">Previous</a></li>
							</c:if>

							<c:forEach var="num" begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }">
								<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":"" }">
									<a href="${num }">${num }</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next }">
								<li class="paginate_button next"><a
									href="${pageMaker.endPage +1 }">Next</a></li>
							</c:if>
						</ul>
					</div>
				</form>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>