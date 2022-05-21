<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

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
				<c:forEach var="notice" items="${notice }">
					<div class="form-group">
						<label>제목</label> <input class="form-control"
							name="noticeTitle" value="<c:out value="${notice.noticeTitle }"/>"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" name="noticeContents" rows="3"
							readonly="readonly"><c:out
								value="${notice.noticeContents }" /></textarea>
					</div>
					<button data-oper="modify" class="btn btn-default"
						onclick="location.href='/noticeManager/modify?noticeNo=<c:out value="${notice.noticeNo}"/>'">수정</button>
					<button data-oper="list" class="btn btn-default"
						onclick="location.href='/noticeManager/list'">목록</button>
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