<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<title>More than just movie, Ezen Cinema</title>
<link href="/resources/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- Custom Theme files -->
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<script src="/resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Cinema Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<meta charset="utf-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 도로명 조합형 주소 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
						if (fullRoadAddr !== '') {
							fullRoadAddr += extraRoadAddr;
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('roadAddress').value = fullRoadAddr;
						document.getElementById('jibunAddress').value = data.jibunAddress;

						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							//예상되는 도로명 주소에 조합형 주소를 추가한다.
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
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
<div class="full">
			<div class="menu">
				<ul>
					<li><a href="/"><div class="hm"><i class="home1"></i><i class="home2"></i></div></a></li>
					<li><a href="videos.html"><div class="video"><i class="videos"></i><i class="videos1"></i></div></a></li>
					<li><a href="/replies/reviewMain"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
					<li><a href="/ticket/ticketForm"><div class="bk"><i class="booking"></i><i class="booking1"></i></div></a></li>
					<li><a class="active" href="contact.html"><div class="cnt"><i class="contact"></i><i class="contact1"></i></div></a></li>
				</ul>
			</div>
		<div class="main">
		<div class="contact-content">
			<div class="top-header span_top">
				<div class="logo">
					<a href="index.html"><img src="/resources/images/logo.png" alt="" /></a>
					<p>Movie Theater</p>
				</div>
				<div class="search v-search">
					<form>
						<input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						<input type="submit" value="">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		<div >
		 <h3 class="head">회원정보 수정</h3>
		 <div class>
		<form action="/member/modify" method="post">
			<div id="detail_table">
				<table>
					<tbody>
						<tr class="dot_line">
							<td class="fixed_join">아이디</td>
							<td><input type="text" name="_member_id" id="_member_id"
								size="20" readonly="readonly" placeholder="${memberVO.member_id}"/> <input type="hidden" name="member_id"
								id="member_id" /> </td>
						</tr>
						<tr class="dot_line">
							<td class="fixed_join">비밀번호</td>
							<td><input name="member_pw" type="password" size="20" /></td>
						</tr>
						<tr class="dot_line">
							<td class="fixed_join">이름</td>
							<td><input name="member_name" type="text" size="20" readonly="readonly" value="${memberVO.member_name}" /></td>
						</tr>
						
						
						<tr class="dot_line">
							<td class="fixed_join">전화번호</td>
							<td><select name="tel1">
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
							</select> - <input size="10px" type="text" name="tel2"> - <input
								size="10px" type="text" name="tel3"></td>
						</tr>
						<tr class="dot_line">
							<td class="fixed_join">휴대폰번호</td>
							<td><select name="hp1">
									<option>없음</option>
									<option selected value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
							</select> - <input size="10px" type="text" name="hp2"> - <input
								size="10px" type="text" name="hp3"><br> <br> <input
								type="checkbox" name="smssts_yn" value="Y" checked /> 쇼핑몰에서
								발송하는 SMS 소식을 수신합니다.</td>
						</tr>
						<tr class="dot_line">
							<td class="fixed_join">이메일<br>(e-mail)
							</td>
							<td><input size="10px" type="text" name="email1" /> @ <input
								size="10px" type="text" name="email2" /> <select name="email2"
								onChange="" title="직접입력">
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
								value="Y" checked /> 쇼핑몰에서 발송하는 e-mail을 수신합니다.</td>
						</tr>
						<tr class="dot_line">
							<td class="fixed_join">주소</td>
							<td><input type="text" id="zipcode" name="zipcode" size="10">
								<a href="javascript:execDaumPostcode()">우편번호검색</a> <br>
								<p>
									지번 주소:<br>
									<input type="text" id="roadAddress" name="roadAddress"
										size="50"><br>
									<br> 도로명 주소: <input type="text" id="jibunAddress"
										name="jibunAddress" size="50"><br>
									<br> 나머지 주소: <input type="text" name="namujiAddress"
										size="50" />
									<!--   <span id="guide" style="color:#999"></span> -->
								</p></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="clear">
				<br>
				<br>
				<table align=center>
					<tr>
						<td><input type="submit" value="회원 정보 수정"> <input
							type="reset" value="다시입력"></td>
					</tr>
				</table>
			</div>
		</form>
<div class="footer">
		<h6>Disclaimer : </h6>
		<p class="claim">This site is for Team project from EZEN Computer Academy Sangbong</p>
		<a href="example@mail.com">please connect us example@mail.com for all the problems</a>
		<div class="copyright">
			<p> Template by  <a href="http://w3layouts.com">  W3layouts</a></p>
		</div>
	</div>	
	</div>
	</div>
	<div class="clearfix"></div>
</body>
</html>