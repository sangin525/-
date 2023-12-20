<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/SignupForm.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/member/SignupForm.js"></script>
<title>회원가입</title>
</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<section class="Main_section">
		<div class="container">
			<div class="row justify-content-center">
				<div>
					<div class="input-form">
						<h2 class="mb-4 text-center">회원가입</h2>
						<form name="frm" action="Signup.do" method="POST"
							onsubmit="return sendChk()">
							<input type="hidden" id="checked_id" name="checked_id" value="n">
							<input type="hidden" id="checked_email" name="checked_email"
								value="n"> <input type="hidden" id="snsCheckbox"
								name="snsCheckbox" value="${snsCheckbox}">

							<div class="mb-3">
								<label for="M_Name" class="form-label">이름 *</label> <input
									type="text" class="form-control" id="M_Name" name="M_Name"
									placeholder="이름" value="" onkeyup="validateName()"> <span
									id="NameMsg"></span>
							</div>

							<div class="mb-3">
								<label for="M_ID" class="form-label">아이디 *</label>
								<div class="input-group">
									<input type="text" class="form-control" id="M_ID" name="M_ID"
										placeholder="아이디" aria-label="Recipient's userid"
										maxlength="10" aria-describedby="button-addon2">
									<button class="left-btn" onclick="duplicateId()"
										id="M_IdCheckbtn" type="button">중복확인</button>
								</div>
								<span id="idHelpInline" class="form-text"> 아이디는 5~10자 길이로
									문자와 숫자를 포함해야 하며 공백, 특수 문자 또는 이모티콘을 포함할 수 없습니다. </span> <span
									id="M_IdCheck"></span>
							</div>

							<div class="mb-3">
								<label for="M_Pwd" class="form-label">비밀번호 *</label> <input
									type="password" class="form-control" id="M_Pwd" name="M_Pwd"
									onkeyup="validatePassword()" maxlength="20" placeholder="비밀번호">
								<span id="passwordHelpInline" class="form-text"> 비밀번호는
									8~20자 길이로 문자와 숫자를 포함해야 하며 공백, 특수 문자 또는 이모티콘을 포함할 수 없습니다. </span><br>
								<span id="M_PwdMsg"></span>
							</div>

							<div class="mb-3">
								<label for="M_Pwdchek" class="form-label">비밀번호확인 *</label> <input
									type="password" class="form-control" id="M_Pwdchek"
									name="M_Pwdchek" onkeyup="validatePassword()" maxlength="20"
									placeholder="비밀번호확인"> <span id="M_PwdchekMsg"></span>
							</div>

							<div class="mb-3">
								<label for="M_Birth" class="form-label">생년월일 *</label> <input
									type="date" class="form-control" id="M_Birth" name="M_Birth"
									onkeyup="validateBirth()" placeholder="(예:20031015)"> <span
									id="M_BirthMsg"></span>
							</div>

							<div class="mb-3">
								<label for="M_EMAIL" class="form-label">이메일 *</label>
								<div class="input-group">
									<input type="email" class="form-control" id="M_EMAIL"
										name="M_EMAIL" onkeyup="validateEmail()"
										placeholder="you@example.com">
									<button class="left-btn" onclick="duplicateEmail()"
										id="M_EamilCheckbtn" type="button">중복확인</button>
								</div>
								<span id="M_EAMILMsg"></span> <span id="M_EmailCheck"></span>
							</div>

							<div class="mb-3">
								<label for="M_Phone" class="form-label">전화번호 *</label> <input
									type="text" class="form-control" id="M_Phone" name="M_Phone"
									onkeyup="validatePhone()" placeholder="'-'제외하고 숫자만 입력"
									maxlength="13"> <span id="M_PhoneMsg"></span>
							</div>

							<div class="mb-3">
								<label for="sample6_postcode" class="form-label">주소 *</label>
								<div class="input-group mb-3">
									<input type="text" class="form-control" id="sample6_postcode"
										name="M_Addr" placeholder="우편번호">
									<button class="left-btn" onclick="sample6_execDaumPostcode()"
										type="button">우편번호 찾기</button>
								</div>
								<input type="text" class="form-control" id="sample6_address"
									name="M_Addr1" placeholder="주소"> <input type="text"
									class="form-control" id="sample6_detailAddress" name="M_Addr2"
									placeholder="상세주소"> <input type="text"
									class="form-control" id="sample6_extraAddress"
									placeholder="참고항목">
							</div>

							<hr class="mb-5">

							<div class="text-center mb-4">
								<button type="submit" id="subtn" class="left-btn">가입 완료</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>
