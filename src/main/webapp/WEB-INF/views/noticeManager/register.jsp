<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">공지사항 등록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
						<form role="form" method="post" action="/noticeManager/register">
							<div class="form-group">
								<label>제목</label> <input class="form-control"
									name="noticeTitle">
								<p class="help-block"></p>
							</div>
							<div class="form-group">
								<label>내용</label>
								<textarea class="form-control" name="noticeContents" rows="3"></textarea>
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