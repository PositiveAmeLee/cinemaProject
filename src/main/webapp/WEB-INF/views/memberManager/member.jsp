<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">회원정보</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:forEach var="member" items="${member }">
					<div class="form-group">
						<label>아이디</label><input class="form-control"
							name="memberId" value="<c:out value="${member.memberId }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>닉네임</label><input class="form-control"
							name="memberNickname" value="<c:out value="${member.memberNickname }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>이름</label><input class="form-control"
							name="memberName" value="<c:out value="${member.memberName }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>성별</label><input class="form-control"
							name="memberGender" value="<c:out value="${member.memberGender }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>핸드폰 번호</label><input class="form-control"
							name="memberPhone" value="<c:out value="${member.memberPhone }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>집 전화번호</label><input class="form-control"
							name="memberTell" value="<c:out value="${member.memberTell }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>이메일</label><input class="form-control"
							name="memberEmail" value="<c:out value="${member.memberEmail }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<label>생성 시간</label><input class="form-control"
							name="memberTell" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${member.createTime }" />"
							readonly="readonly">
						<p class="help-block"></p>
					</div>
					<div style="width:200px">
						<button data-oper="modify" class="btn btn-default"
						onclick="location.href='/memberManager/modify?memberNo=<c:out value="${member.memberNo}"/>'">수정</button>
					<button data-oper="list" class="btn btn-default"
						onclick="location.href='/memberManager/list'">리스트</button></div>
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