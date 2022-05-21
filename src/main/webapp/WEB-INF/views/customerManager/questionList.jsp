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
		
});
</script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">문의 목록</h1>
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
							<th>이름</th>
							<th>이메일</th>
							<th>연락처</th>
							<th>문의 내용</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="questionList" items="${questionList}">

							<tr>
								<td><a
									href="question?questionNo=<c:out value="${questionList.questionNo }"/>">
										<c:out value="${questionList.questionNo }" />
								</a></td>
								<td><c:out value="${questionList.memberName }" /></td>
								<td><c:out value="${questionList.memberEmail }" /></td>
								<td><c:out value="${questionList.memberPhone }" /></td>
								<td><c:out value="${questionList.questionContents }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form id='actionForm' action="/customerManager/questionList" method='Get'>
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