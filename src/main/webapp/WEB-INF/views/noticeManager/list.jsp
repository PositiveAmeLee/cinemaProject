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
		<h1 class="page-header">공지사항</h1>
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
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>등록일자</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="noticeList" items="${noticeList}">
							<tr>
								<td><a
									href="notice?noticeNo=<c:out value="${noticeList.noticeNo }"/>">
										<c:out value="${noticeList.noticeNo }" />
								</a></td>
								<td><a
									href="notice?noticeNo=<c:out value="${noticeList.noticeNo }"/>">
										<c:out value="${noticeList.noticeTitle }" />
								</a></td>
								<td><a
									href="notice?noticeNo=<c:out value="${noticeList.noticeNo }"/>">
										<c:out value="${noticeList.noticeContents }" />
								</a></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${noticeList.noticeCreateTime }" /></td>
								<td>
									<form method="post" action="/noticeManager/delete">
										<input type="hidden" name="noticeNo"
											value="<c:out value="${noticeList.noticeNo }"/>">
										<button class="btn btn-default" type="submit">삭제</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="input-group custom-search-form"
					style="display: block; margin: 50px auto 0; line-height: 34px; width: 400px;">
					<form id="searchForm" method="Get" action="/noticeManager/list">
						<select style="width: 111px;" class="form-control" name="type">
							<option value="T">제목</option>
						</select> <input type="text" name="keyword" class="form-control"
							placeholder="Search..." style="width: 250px;"> <span
							class="input-group-btn" style="width: 39px"> <input
							type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
							<input type='hidden' name='amount'
							value="${pageMaker.cri.amount }">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</form>
				</div>
				<div style="display:block">
					<button class="btn btn-default" type="button"
						onclick='location.href="/noticeManager/register"'>글쓰기</button>
				</div>
				<form id='actionForm' action="/noticeManager/list" method='Get'>
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