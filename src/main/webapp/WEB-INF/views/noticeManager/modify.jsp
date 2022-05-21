<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(
			function() {

				var formObj = $("form");

				$('button')
						.on(
								"click",
								function(e) {

									e.preventDefault();

									var operation = $(this).data("oper");

									console.log(operation);

									if (operation === 'delete') {
										formObj.attr("action",
												"/noticeManager/delete");
									} else if (operation === 'list') {
										formObj.attr("action",
												"/noticeManager/list").attr(
												"method", "get");
										var pageNumTag = $(
												"input[name='pageNum']")
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
		<h1 class="page-header">공지사항 수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="notice" items="${notice }">
					<form role="form" method="post" action="/noticeManager/modify">
						<input type="hidden" name="noticeNo"
							value="<c:out value="${notice.noticeNo }"/>">
						<div class="form-group">
							<label>제목</label> <input class="form-control" name="noticeTitle"
								value="<c:out value="${notice.noticeTitle }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" name="noticeContents" rows="3"><c:out
									value="${notice.noticeContents }" /></textarea>
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