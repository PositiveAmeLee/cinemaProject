<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ include file="../common/header.jsp"%>


<c:if test="${isLogOn!=true or empty memberVO }">
	
	<script>
	
	alert("로그인이 필요한 작업입니다 로그인을 진행해 주세요!")
	location.href = "/member/login"
	
	</script>

</c:if>

			<!---contact-->
<div class="main-contact">
		 <h3 class="head">CONTACT</h3>
		 <p>WE'RE ALWAYS HERE TO HELP YOU</p>
		 <div class="contact-form">
			 <form action = "/mypage/contact"  method="post">
				 <div class="col-md-6 contact-left">
					  <input type="text" name="name" placeholder="Name" required/>
					  <input type="text" name="email" placeholder="E-mail" required/>
					  <input type="text" name="phone" placeholder="Phone" required/>
				  </div>
				  <div class="col-md-6 contact-right">
					 <textarea name="message" placeholder="메시지를 남겨주시면 관리자가 확인 후 이메일이나 핸드폰으로 연락을 드리겠습니다. 감사합니다."></textarea>
					 <input type="submit" value="SEND"/>
				 </div>
				 <div class="clearfix"></div>
			 </form>
	     </div>
		 <div class="contact_info">
			 <ul>개인정보</ul>
			 <li><a href="/member/modify">개인정보수정</a></li>
			 <li><a href="/member/deleteMember">회원탈퇴</a></li>
			 <li><a href="#">내가 예매한 티켓 보기</a>
	 </div>
</div>
	<%@ include file="../common/footer.jsp"%>