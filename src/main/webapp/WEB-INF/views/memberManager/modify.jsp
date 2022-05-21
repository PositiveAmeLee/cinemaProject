<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(
			function() {
				var formObj = $("form");

				$('button').on(
						"click",
						function(e) {

							e.preventDefault();

							var operation = $(this).data("oper");

							console.log(operation);

							if (operation === 'list') {
								formObj.attr("action", "/memberManager/list")
										.attr("method", "get");
								var pageNumTag = $("input[name='pageNum']")
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
		<h1 class="page-header">회원정보 수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="member" items="${member }">
					<form role="form" method="post" action="/memberManager/modify">
						<div class="form-group">
							<label>아이디</label>
							<input class="form-control"
								name="memberId" value="<c:out value="${member.memberId }" />" readonly="readonly">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
						<label>닉네임</label>
						<input class="form-control"
								name="memberNickname" value="<c:out value="${member.memberNickname }" />" readonly="readonly">
						<p class="help-block"></p>
					</div>
						<div class="form-group">
						<label>이름</label>
						<input class="form-control"
								name="memberName" value="<c:out value="${member.memberName }" />" readonly="readonly">
						<p class="help-block"></p>
					</div>
						<div class="form-group">
						<label>성별</label>
						<input class="form-control"
								name="memberGender" value="<c:out value="${member.memberGender }" />" readonly="readonly">
						<p class="help-block"></p>
					</div>
						<div class="form-group">
							<label>핸드폰 번호</label> <input class="form-control"
								name="memberPhone"
								value="<c:out value="${member.memberPhone }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>집 전화번호</label> <input class="form-control"
								name="memberTell"
								value="<c:out value="${member.memberTell }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>이메일</label> <input class="form-control"
								name="memberEmail"
								value="<c:out value="${member.memberEmail }"/>">
							<p class="help-block"></p>
						</div>
						<div class="form-group">
							<label>권한</label> <select class="form-control" name="memberAuthority">
								<option value="회원">회원</option>
								<option value="관리자">관리자</option>
							</select>
						</div>
						<button type="submit" data-oper='modify' class="btn btn-default">수정</button>
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