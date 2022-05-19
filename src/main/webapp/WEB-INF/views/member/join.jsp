<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>RegistrationForm_v1 by Colorlib</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="/resources/cgv/css/style.css">
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>


function execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function(data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
      var extraRoadAddr = ''; // 도로명 조합형 주소 변수

      // 법정동명이 있을 경우 추가한다. (법정리는 제외)
      // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
      if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
        extraRoadAddr += data.bname;
      }
      // 건물명이 있고, 공동주택일 경우 추가한다.
      if(data.buildingName !== '' && data.apartment === 'Y'){
        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
      }
      // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
      if(extraRoadAddr !== ''){
        extraRoadAddr = ' (' + extraRoadAddr + ')';
      }
      // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
      if(fullRoadAddr !== ''){
        fullRoadAddr += extraRoadAddr;
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
      document.getElementById('roadAddress').value = fullRoadAddr;
      document.getElementById('jibunAddress').value = data.jibunAddress;

      // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
      if(data.autoRoadAddress) {
        //예상되는 도로명 주소에 조합형 주소를 추가한다.
        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
        document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

      } else if(data.autoJibunAddress) {
          var expJibunAddr = data.autoJibunAddress;
          document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
      } else {
          document.getElementById('guide').innerHTML = '';
      }
      
     
    }
  }).open();
}

	function fn_overlapped() {
		var _id = $("#_member_id").val();
		if (_id == '') {
			alert("ID를 입력하세요");
			return;
		}
		$.ajax({
			type : "post",
			async : false,
			url : "/member/overlapped",
			dataType : "text",
			data : {
				id : _id
			},
			success : function(data, textStatus) {
				if (data == 'false') {
					alert("사용할 수 있는 ID입니다.");
					$('#btnOverlapped').prop("disabled", true);
					$('#_member_id').prop("disabled", true);
					$('#member_id').val(_id);
				} else {
					alert("사용할 수 없는 ID입니다.");
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
				ㅣ
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
			}
		}); //end ajax	 
	}
</script>


</head>


<body>

	<div class="wrapper" style="">

		<div class="inner">
			<div class="image-holder">
				<img id="poster"
					src="https://upload.wikimedia.org/wikipedia/ko/f/f2/%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4-_%EC%97%94%EB%93%9C%EA%B2%8C%EC%9E%84_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg"
					alt="">
			</div>
			<form action="/member/join" id="registerForm" method="post">
				<p class="register-title">
					<img src="/resources/images/logo.png">&nbsp;&nbsp;&nbsp; <span>회원가입</span>
				</p>
				<div class="form-wrapper form-wrapper-id">
					<div class="id-wrapper">
						<input id="_member_id" name="_member_id" type="text"
							placeholder="아이디" class="form-control">
						<!-- <i class="zmdi zmdi-id">아이디 체크</i> -->
						<input type="hidden" name="member_id" id="member_id" />
						<button type="button" class="idCheckButton"
							onClick="fn_overlapped()">아이디 체크</button>
					</div>
				</div>

				<div class="form-wrapper">
					<input type="password" name="member_pw" placeholder="비밀번호"
						id="password" class="form-control"> <i
						class="zmdi zmdi-lock"></i>
				</div>
				<div class="form-wrapper">
					<input type="password" placeholder="비밀번호 확인" class="form-control"
						id="passwordRepeat" onChange="passwordValidate()"> <i
						class="zmdi zmdi-lock"></i>
				</div>

				<div class="form-wrapper">
					<input name="member_name" type="text" placeholder="이름"
						class="form-control"> <i class="zmdi zmdi-account-box"></i>
				</div>
				<div class="form-wrapper">
					성별 <input type="radio" name="member_gender" value="102" /> 여성<span
						style="padding-left: 120px"></span> <input type="radio"
						name="member_gender" value="101" checked />남성
				</div>
				<br> <br>
				<div class="form-wrapper">
					생년월일 <select name="member_birth_y">

						<c:forEach var="year" begin="1" end="100">
							<c:choose>
								<c:when test="${year==80}">
									<option value="${ 1920+year}" selected>${ 1920+year}</option>
								</c:when>
								<c:otherwise>
									<option value="${ 1920+year}">${ 1920+year}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>

					</select>년 <select name="member_birth_m">
						<c:forEach var="month" begin="1" end="12">
							<c:choose>
								<c:when test="${month==5 }">
									<option value="${month }" selected>${month }</option>
								</c:when>
								<c:otherwise>
									<option value="${month }">${month}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>월 <select name="member_birth_d">
						<c:forEach var="day" begin="1" end="31">
							<c:choose>
								<c:when test="${day==10 }">
									<option value="${day}" selected>${day}</option>
								</c:when>
								<c:otherwise>
									<option value="${day}">${day}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>일 <br> <br> <span style="padding-left: 50px"></span> <input
						type="radio" name="member_birth_gn" value="2" checked />양력 <span
						style="padding-left: 50px"></span> <input type="radio"
						name="member_birth_gn" value="1" />음력 <br> <br>
				</div>
				<div class="form-wrapper">
					전화번호 <br> <br> <select name="tel1">
						<option>없음</option>
						<option value="02">02</option>
						<option value="031">031</option>
						<option value="032">032</option>
						<option value="033">033</option>
						<option value="041">041</option>
						<option value="042">042</option>
						<option value="043">043</option>
						<option value="044">044</option>
						<option value="051">051</option>
						<option value="052">052</option>
						<option value="053">053</option>
						<option value="054">054</option>
						<option value="055">055</option>
						<option value="061">061</option>
						<option value="062">062</option>
						<option value="063">063</option>
						<option value="064">064</option>
						<option value="0502">0502</option>
						<option value="0503">0503</option>
						<option value="0505">0505</option>
						<option value="0506">0506</option>
						<option value="0507">0507</option>
						<option value="0508">0508</option>
						<option value="070">070</option>
					</select> <br> <br> <input size="10px" type="text" name="tel2">
					- <input size="10px" type="text" name="tel3">
				</div>
				<br> <br>
				<div class="form-wrapper">
					핸드폰번호 <br> <br> <select name="hp1">
						<option>없음</option>
						<option selected value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select> <br> <br> <input size="10px" type="text" name="hp2">
					- <input size="10px" type="text" name="hp3"><br> <br>
					<input type="checkbox" name="smssts_yn" value="Y" checked /> 쇼핑몰에서
					발송하는 SMS 소식을 수신합니다.
				</div>
				<br>
				<div class="form-wrapper">
					<input size="10px" type="text" name="email1" /> @ <input
						size="10px" type="text" name="email2" /> <br> <br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp; <select name="email2" onChange="" title="직접입력">
						<option value="non">직접입력</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="naver.com">naver.com</option>
						<option value="yahoo.co.kr">yahoo.co.kr</option>
						<option value="hotmail.com">hotmail.com</option>
						<option value="paran.com">paran.com</option>
						<option value="nate.com">nate.com</option>
						<option value="google.com">google.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="empal.com">empal.com</option>
						<option value="korea.com">korea.com</option>
						<option value="freechal.com">freechal.com</option>
					</select><br> <br> <input type="checkbox" name="emailsts_yn"
						value="Y" checked /> 쇼핑몰에서 발송하는 e-mail을 수신합니다.
				</div>
				<br> <br>
				<div class="form-wrapper">
					주소 <br> <br> <a href="javascript:execDaumPostcode()">우편번호검색</a>
					<br>
					<p>
						<input type="text" id="zipcode" name="zipcode" size="10">
					<p>
						지번 주소:<br> <input type="text" id="roadAddress"
							name="roadAddress" size="50"><br> <br> 도로명 주소:
						<input type="text" id="jibunAddress" name="jibunAddress" size="50"><br>
						<br> 나머지 주소: <input type="text" name="namujiAddress"
							size="50" />
				</div>


				<button class="registerButton clickedButton">
					<span>회원가입 하기</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>
			</form>
		</div>
	</div>
	<script src="/resources/cgv/js/register.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>















