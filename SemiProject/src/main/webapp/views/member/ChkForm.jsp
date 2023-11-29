<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이용약관</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/ChkForm.css">
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
			<h2 class="text-center mb-4">호텔 사이트 이용약관</h2>
			<form name="frm" action="SignupForm.do" method="GET">
				<div class="checkbox-container">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="selectAllCheckbox"> <label
							class="custom-control-label" for="selectAllCheckbox">모두
							선택</label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="termsCheckbox" name="termsCheckbox"> <label
							class="custom-control-label" for="termsCheckbox"
							data-toggle="modal" data-target="#termsModal">이용 약관에
							동의합니다. (필수)</label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="privacyCheckbox"> <label class="custom-control-label"
							for="privacyCheckbox" data-toggle="modal"
							data-target="#privacyModal">개인 정보 수집 및 이용에 동의합니다. (필수)</label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="confirmCheckbox"> <label class="custom-control-label"
							for="confirmCheckbox" data-toggle="modal"
							data-target="#confirmModal">회원가입 안내사항을 확인했습니다. (필수)</label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="snsCheckbox" name="snsCheckbox"> <label
							class="custom-control-label" for="snsCheckbox"
							data-toggle="modal" data-target="#snsModal">SNS 관련 이용약관에
							동의합니다. (선택)</label>
					</div>
					
					
					<!-- 다른 약관에 대한 체크박스 추가 가능 -->
				</div>

				<button id="submitBtn" class="left-btn btn-block">동의 완료</button>
			</form>
		</div>
		<!-- 이용 약관 모달 -->
		<div id="termsModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">이용 약관</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>호텔 이용 약관 제1조 (약관의 목적)
						<ol>
							<li>본 약관은 호텔 이용에 관한 제반 사항을 정함을 목적으로 합니다.</li>
							<li>호텔 이용자는 본 약관의 내용에 동의함으로써 호텔 서비스를 이용할 수 있습니다.</li>
						</ol>
						제2조 (서비스의 종류)
						<ol>
							<li>호텔은 숙박 서비스뿐만 아니라, 그 외 음식, 행사, 휴식 등 다양한 서비스를 제공할 수 있습니다.</li>
						</ol>
						제3조 (예약 및 결제)
						<ol>
							<li>숙박 및 기타 서비스를 이용하고자 하는 경우, 사전 예약이 필요합니다.</li>
							<li>결제는 호텔 제공의 안내에 따라 진행되며, 예약 취소 및 환불 정책에 따라 처리됩니다.</li>
						</ol>
						제4조 (안전 및 손해 배상)
						<ol>
							<li>호텔은 이용자의 안전을 최우선으로 하며, 이용자가 호텔 시설 및 장비를 불법적으로 사용함으로써
								발생하는 사고에 대해서는 책임을 지지 않습니다.</li>
							<li>이용자가 호텔 시설, 장비를 소모, 훼손하는 경우, 손해 배상이 청구될 수 있습니다.</li>
						</ol>
						제5조 (기타 규정)
						<ol>
							<li>본 약관에 명시되지 않은 사항은 관계 법령과 호텔 내규에 따릅니다.</li>
						</ol>
					</div>
					<div class="modal-footer">
						<button type="button" class="left-btn" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 개인 정보 약관 모달 -->
		<div id="privacyModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">개인 정보 수집 및 이용 약관</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>호텔 개인정보 수집 및 이용 약관 제1조 (수집 및 이용 목적) 1.호텔은 이용자의 개인정보를 다음과 같은
							목적으로 수집 및 이용합니다.
						<ul>
							<li>회원 가입 및 관리</li>
							<li>예약 서비스 제공</li>
							<li>고객 상담 및 불만 처리</li>
							<li>서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금 정산</li>
							<li>뉴스레터 발송 또는 마케팅 활용</li>
						</ul>
						제2조 (수집하는 개인정보의 항목) 1.호텔은 다음과 같은 개인정보를 수집할 수 있습니다.
						<ul>
							<li>필수 항목: 성명, 연락처, 이메일 주소, 신용카드 정보 (예약 시)</li>
							<li>선택 항목: 생년월일, 성별, 국적 등</li>
						</ul>

						제3조 (개인정보의 보유 및 이용기간)
						<ol>
							<li>호텔은 이용자의 개인정보를 수집 및 이용목적이 달성된 후에는 지체 없이 파기합니다.</li>
							<li>다만, 관계 법령에 따라 보존하여야 하는 경우에는 해당 기간 동안 보관합니다.</li>
						</ol>
						제4조 (개인정보의 제3자 제공)
						<ol>
							<li>호텔은 원칙적으로 이용자의 동의 없이 개인정보를 외부에 제공하지 않습니다. 단, 관계 법령에 의거하여
								제공이 필요한 경우에는 사전에 이용자에게 고지하고 동의를 받습니다.</li>
						</ol>
					</div>
					<div class="modal-footer">
						<button type="button" class="left-btn" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 회원가입 안내사항 모달 -->
		<div id="confirmModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">회원가입 안내사항</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>회원가입 안내사항
						<ol>
							<li>회원가입 조건</li>
						</ol>
						<ul>
							<li>호텔의 서비스를 이용하려면 회원가입이 필요합니다.</li>
							<li>회원으로 가입하려면 만 18세 이상이어야 합니다.</li>
						</ul>
						<ol>
							<li>회원가입 절차</li>
						</ol>
						<ul>
							<li>홈페이지 또는 앱에서 회원가입 페이지로 이동하여 필요한 정보를 기입합니다.</li>
							<li>이메일 인증 및 기타 인증 절차를 거친 후 회원가입이 완료 됩니다.</li>
						</ul>
						<ol>
							<li>회원정보의 수정 및 탈퇴</li>
						</ol>
						<ul>
							<li>회원은 언제든지 개인정보를 열람하고 수정할 수 있습니다.</li>
							<li>회원 탈퇴를 원할 경우, 고객센터를 통해 요청할 수 있습니다.</li>
						</ul>
						<ol>
							<li>서비스 이용시 유의사항</li>
						</ol>
						<ul>
							<li>호텔의 서비스를 이용할 때에는 약관 및 규정을 준수하여야 합니다.</li>
							<li>부정한 방법으로 서비스를 이용할 경우, 서비스 이용이 제한될 수 있습니다.</li>
							<li>이는 간단한 예시일 뿐이며, 실제 운영 시에는 법적인 검토와 함께 해당 호텔의 정책에 맞게 수정이
								필요합니다.</li>
						</ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="left-btn" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>

		<!-- SNS 이용약관 모달 -->
		<div id="snsModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">SNS 이용 약관</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>호텔 SNS 이용 약관
						<ol>
							<li>본 약관은 호텔의 SNS (Social Networking Service) 서비스에 관한 제반 사항을
								정함을 목적으로 합니다.</li>
							<li>이용자는 본 약관의 내용에 동의함으로써 호텔의 SNS 서비스를 이용할 수 있습니다.</li>
						</ol>

						<h5>제1조 (서비스 내용)</h5>
						<p>호텔은 다양한 SNS 서비스를 제공할 수 있으며, 이에는 다음과 같은 내용이 포함될 수 있습니다:
						<ul>
							<li>사진 및 동영상 업로드</li>
							<li>친구 추가 및 메시지 송수신</li>
							<li>이벤트 및 특별 혜택 안내</li>
							<li>기타 다양한 커뮤니케이션 기능</li>
						</ul>

						<h5>제2조 (계정 및 개인정보)</h5>
						<p>이용자는 SNS 서비스 이용을 위해 개인 계정을 생성해야 합니다. 계정 관리 및 개인정보에 대한 책임은
							이용자에게 있습니다.</p>
						<h5>제3조 (책임과 규정 준수)</h5>
						<p>이용자는 SNS 서비스 이용 시 다음 사항을 준수해야 합니다:
						<ul>
							<li>타인의 개인정보 보호</li>
							<li>저작권 및 지적재산권 존중</li>
							<li>도배, 욕설, 비방 등의 부적절한 행동 금지</li>
							<li>법령 및 이용 약관 준수</li>
						</ul>

					</div>
					<div class="modal-footer">
						<button type="button" class="left-btn" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
	<script src="/resources/js/member/ChkForm.js"></script>
</body>
</html>