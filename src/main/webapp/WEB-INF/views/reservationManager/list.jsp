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
		<h1 class="page-header">예매목록</h1>
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
							<th>예매번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>영화</th>
							<th>예매일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="reservationList" items="${reservationList}">

							<tr>
								<td><a
									href="reservation?resNo=<c:out value="${reservationList.resNo }"/>">
										<c:out value="${reservationList.resNo }" />
								</a></td>
								<td><c:out value="${reservationList.memberId }" /></td>
								<td><c:out value="${reservationList.memberName }" /></td>
								<td><c:out value="${reservationList.movieTitle }" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${reservationList.resDate }" /></td>
								<td>
									<button class="btn btn-default"
										onclick="location.href='/reservationManager/modify?resNo=<c:out value="${reservationList.resNo}"/>'">수정</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="input-group custom-search-form"
					style="display: block; margin: 50px auto 0; line-height: 34px; width: 400px;">
					<form id="searchForm" method="Get" action="/reservationManager/list">
						<select style="width: 111px;" class="form-control" name="type">
							<option value="M">아이디</option>
							<option value="N">이름</option>
						</select> <input type="text" name="keyword" class="form-control"
							placeholder="Search..." style="width: 250px;"> <span
							class="input-group-btn" style="width: 39px"> <input
							type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
							<input type='hidden' name='amount'
							value="${pageMaker.cri.amount }">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</form>
				</div>
				<form id='actionForm' action="/reservationManager/list" method='get'>
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