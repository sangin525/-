<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이용약관</title>

<!-- 부트스트랩 CSS 링크 -->
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/ChkForm.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</head>

<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

	<section class="Main_section">
		<div class="container">
			<div class="input-form">
				<h2 class="text-center mb-4">Hotel Haru 이용약관</h2>

				<form name="frm" action="SignupForm.do" method="Post">
					<div class="checkbox-container">
						<!-- 체크박스 및 textarea 추가 -->
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="selectAllCheckbox"> <label
								class="custom-control-label" for="selectAllCheckbox">모두
								선택</label>
						</div>

						<!-- 이용 약관 -->
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input chkInp"
								id="termsCheckbox" name="termsCheckbox" value="y"> <label
								class="custom-control-label" for="termsCheckbox">이용 약관에
								동의합니다. (필수)</label>
						</div>
						<div class="custom-control custom-checkbox">
							<!-- textarea 추가 -->
							<textarea class="form-control" rows="10" readonly>
                            호텔 이용 약관
                            제1조 (약관의 목적)
                            본 약관은 호텔 이용과 관련된 회원 간의 권리와 의무, 서비스의 이용조건 및 절차, 기타 필요한 사항을 정함을 목적으로 합니다.
                            
                            제2조 (이용 계약의 성립)
                            이용자는 본 약관에 동의함으로써 호텔 서비스 이용에 대한 계약이 성립됩니다.
                            호텔은 이용자의 신청에 대해 승낙의 의사를 표시함으로써 이용 계약이 성립됩니다.
                            
                            제3조 (서비스의 종류)
                            호텔은 숙박 서비스뿐만 아니라 음식, 이벤트, 행사 등 다양한 서비스를 제공할 수 있습니다.
                            서비스의 구체적인 내용은 호텔의 안내에 따릅니다.
                            
                            제4조 (예약 및 결제)
                            숙박 및 기타 서비스를 이용하고자 하는 경우, 사전 예약이 필요합니다.
                            결제는 호텔 제공의 안내에 따라 진행되며, 예약 취소 및 환불 정책에 따라 처리됩니다.
                            
                            제5조 (안전 및 손해 배상)
                            호텔은 이용자의 안전을 최우선으로 하며, 이용자가 호텔 시설 및 장비를 불법적으로 사용함으로써 발생하는 사고에 대해서는 책임을 지지 않습니다.
                            이용자가 호텔 시설, 장비를 소모, 훼손하는 경우, 손해 배상이 청구될 수 있습니다.
                            </textarea>
						</div>

						<!-- 개인 정보 수집 동의 -->
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input chkInp"
								id="privacyCheckbox" name="privacyCheckbox" value="y"> <label
								class="custom-control-label" for="privacyCheckbox">개인 정보
								수집 및 이용에 동의합니다. (필수)</label>
						</div>
						<div class="custom-control custom-checkbox">
							<!-- textarea 추가 -->
							<textarea class="form-control" rows="10" readonly>
                                개인정보 수집 및 이용 동의
                                제1조 (수집 목적)
                                호텔은 다음과 같은 목적으로 개인정보를 수집합니다:
						        - 회원 가입 및 관리
						        - 서비스 제공과 관련된 계약 이행 및 서비스 제공
						        - 불만 처리 등 민원처리
						        - 고지사항 전달 및 마케팅 활용
						        
						        제2조 (수집 항목)
						        호텔이 수집하는 개인정보의 항목은 다음과 같습니다:
						        - 필수 항목: [이름, 이메일 주소, 연락처 등]
						        - 선택 항목: [생년월일, 성별, 주소 등]
						        
						        제3조 (개인정보 보유 기간)
						        호텔은 개인정보를 회원 탈퇴 시 또는 수집 목적 달성 후 즉시 파기합니다.
						        
						        제4조 (동의 거부 권리)
						        이용자는 개인정보 수집 및 이용에 대한 동의를 거부할 권리가 있습니다.
                            </textarea>
						</div>

						<!-- 회원가입 안내 -->
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input chkInp"
								id="confirmCheckbox" name="confirmCheckbox" value="y"> <label
								class="custom-control-label" for="confirmCheckbox">회원가입
								안내사항을 확인했습니다. (필수)</label>
						</div>
						<div class="custom-control custom-checkbox">
							<!-- textarea 추가 -->
							<textarea class="form-control" rows="10" readonly>
                            회원가입 안내사항
                            회원가입 조건
                            호텔의 서비스를 이용하려면 회원가입이 필요합니다.
                            회원으로 가입하려면 만 18세 이상이어야 합니다.
                          
                            회원가입 절차
                            홈페이지 또는 앱에서 회원가입 페이지로 이동하여 필요한 정보를 기입합니다.
                            이메일 인증 및 기타 인증 절차를 거친 후 회원가입이 완료됩니다.
                          
                            회원정보의 수정 및 탈퇴
                            회원은 언제든지 개인정보를 열람하고 수정할 수 있습니다.
                            회원 탈퇴를 원할 경우, 고객센터를 통해 요청할 수 있습니다.
                          
                            서비스 이용시 유의사항
                            호텔의 서비스를 이용할 때에는 약관 및 규정을 준수하여야 합니다.
                            부정한 방법으로 서비스를 이용할 경우, 서비스 이용이 제한될 수 있습니다.
                            </textarea>
						</div>

						<!-- SNS 관련 이용약관 -->
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input chkInp"
								id="snsCheckbox" name="snsCheckbox" value="y"> <label
								class="custom-control-label" for="snsCheckbox">SNS 관련
								이용약관에 동의합니다. (선택)</label>
						</div>
						<div class="custom-control custom-checkbox">
							<!-- textarea 추가 -->
							<textarea class="form-control" rows="10" readonly>
                            제1조 (약관의 목적)
                            본 약관은 호텔의 SNS (Social Networking Service) 서비스에 관한 제반 사항을 정함을 목적으로 합니다.
                            
                            제2조 (서비스 내용)
                            호텔은 다양한 SNS 서비스를 제공할 수 있으며, 이에는 다음과 같은 내용이 포함될 수 있습니다:
                            사진 및 동영상 업로드
                            친구 추가 및 메시지 송수신
                            이벤트 및 특별 혜택 안내
                            기타 다양한 커뮤니케이션 기능
                          
                            제3조 (계정 및 개인정보)
                            이용자는 SNS 서비스 이용을 위해 개인 계정을 생성해야 합니다. 계정 관리 및 개인정보에 대한 책임은 이용자에게 있습니다.
                          
                            제4조 (책임과 규정 준수)
                            이용자는 SNS 서비스 이용 시 다음 사항을 준수해야 합니다
                            
                            타인의 개인정보 보호
                            저작권 및 지적재산권 존중
                            도배, 욕설, 비방 등의 부적절한 행동 금지
                            법령 및 이용 약관 준수
                            </textarea>
						</div>

						<!-- 다른 약관에 대한 체크박스 및 textarea 추가 가능 -->
					</div>
					<button id="submitBtn" class="left-btn btn-block">동의 완료</button>
				</form>
			</div>
		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>
	<script src="/resources/js/member/ChkForm.js"></script>
</body>

</html>
