<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/head.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/member/SignupForm.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<section class="Main_section">
		<div class="container">
			<div class="input-form-backgroud row">
				<div class="input-form col-md-12 mx-auto">
					<h4 class="mb-3">회원가입</h4>
					<form action="/Signup.do" method="POST">
						<div class="row">
							<div class="mb-3">
								<label for="nickname">■ 이름 *</label> <input type="text"
									class="form-control" id="M_Name" name="M_Name" placeholder="이름" value="" onkeyup="validateName()" 
									required>
									<span id="NameMsg"></span>
							</div>
				
							<div class="col-sm-10">
								<label for="zipp_btn" class="form-label">■ 아이디 *</label><br /> 
								<div class="input-group mb-3">
  								<input type="text" class="form-control" id="M_ID" name="M_ID" placeholder="아이디" aria-label="Recipient's userid" aria-describedby="button-addon2">
  								<button class="btn btn-outline-secondary" onclick="duplicateId()" id="M_IdCheckbtn" type="button">중복확인</button>
								</div>
								<span id="M_IdCheck"></span>
							</div>
							
						</div>

						<div class="mb-3">
							<label for="email">■ 비밀번호 *</label> <input type="password"
								class="form-control" id="M_Pwd" name="M_Pwd" onkeyup="validatePassword()" placeholder="비밀번호" required>
							<span id="M_PwdMsg"></span>
						</div>

						<div class="mb-3">
							<label for="email">■ 비밀번호확인 *</label> <input type="password"
								class="form-control" id="M_Pwdchek" name="M_Pwdchek" onkeyup="validatePassword()" placeholder="비밀번호확인" required>
								<span id="M_PwdchekMsg"></span>
						</div>

						<div class="mb-3">
							<label for="email">■ 생년월일 *( - 기입)</label> <input type="text"
								class="form-control" id="M_Birth" name="M_Birth" onkeyup="validateBirth()" placeholder="ex)2003-10-15"
								required>
								<span id="M_BirthMsg"></span>
						</div>

							<div class="col-sm-10">
							<label for="email">■ 이메일 *</label> <br />  
							<div class="input-group mb-3">
							<input type="email"class="form-control" id="M_EMAIL" name="M_EMAIL" onkeyup="validateEmail()" placeholder="you@example.com"required>
							<button class="btn btn-outline-secondary" onclick="duplicateEmail()" id="M_EamilCheckbtn" type="button">중복확인</button>
							</div>
							<span id="M_EAMILMsg"></span>
							<span id="M_EmailCheck"></span>
						</div>
					
					<div class="mb-3">
							<label for="email">■ 전화번호 *</label> <input type="text"
								class="form-control" id="M_Phone" name="M_Phone" onkeyup="validatePhone()" placeholder="01012345678"
								maxlength="13">
								<span id="M_PhoneMsg"></span>
						</div>
						<label for="addr">■ 주소 *</label>
						<div class="col-sm-10">
							<input type="text" id="sample6_postcode" name="M_Addr" placeholder="우편번호">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<input type="text" id="sample6_address" name="M_Addr1" placeholder="주소"><br>
							<input type="text" id="sample6_detailAddress" name="M_Addr2" placeholder="상세주소">
							<input type="text" id="sample6_extraAddress"  placeholder="참고항목">
						</div>

						<hr class="mb-4">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="aggrement" required> <label
								class="custom-control-label" for="aggrement">개인정보 수집 및
								이용에 동의합니다.</label>
						</div>
						<div class="mb-4"></div>
						<button class="btn btn-primary btn-lg btn-block" type="submit">가입
							완료</button>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>