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
		
		$("#searchForm button").on("click", function(e){
		
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();
		searchForm.submit();
		
	});
});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">리뷰목록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<table width="100%" class="table table-striped">
					<thead>
						<tr>
							<th style="width: 150px; overflow: hidden;">영화</th>
							<th style="width: 130px; overflow: hidden;">닉네임(아이디)</th>
							<th style="width: 300px">내용</th>
							<th style="width: 100px; overflow: hidden;">작성일</th>
							<th style="width: 50px">별점</th>
							<th style="width: 50px">삭제</th>
						</tr>
					</thead>
					<c:forEach var="commentList" items="${commentList}">
						<tbody>
							<tr>
								<td><c:out value="${commentList.movieTitle }" /></td>
								<td><a
									href="/memberManager/member?memberNo=<c:out value="${commentList.memberNo }"/>"><c:out
											value="${commentList.memberNickname }" />(<c:out
											value="${commentList.memberId }" />)</a></td>
								<td><c:out value="${commentList.movieTitle }" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${commentList.commentCreateTime }" /></td>
								<td><c:out value="${commentList.commentStarRating }" /></td>
								<td>
									<form method="post" action="/commentManager/delete">
										<input type="hidden" name="commentNo"
											value="${commentList.commentNo }"> <input
											class="btn btn-default" type="submit" value="삭제">
									</form>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<div class="input-group custom-search-form"
					style="display: block; margin: 50px auto 0; line-height: 34px; width: 400px;">
					<form id="searchForm" method="Get" action="/commentManager/list">
						<select style="width: 111px;" class="form-control" name="type">
							<option value="M">영화명</option>
							<option value="I">회원 아이디</option>
							<option value="N">회원 닉네임</option>
						</select> <input type="text" name="keyword" class="form-control"
							placeholder="Search..." style="width: 250px;"> <span
							class="input-group-btn" style="width: 39px">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</form>
				</div>

				<form id="actionForm" action="/commentManager/list" method="Get">
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