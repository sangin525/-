<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<footer class="Main_footer">
	<a href="/"><img src="/resources/uploads/호텔로고1.png"></a>
	<div class="footerBox">
		<ul>
			<li class="footer1">호텔하루 약관</li>
			<li class="footer2">개인정보처리방침</li>
			<li class="footer3">이메일무단수집금지</li>
			<li class="footer4">윤리경영</li>
			<li class="footer4">건축·시설물 안전관리</li>
			<li class="footer5">
				<div id="google_translate_element"
					style="visibility: hidden; position: absolute; top: 0px;"></div>
				<div class="translation-icons"
					style="visibility: hidden; position: relative; text-align: center; margin: 0px; padding: 0px; width: 295.833px; height:21.333px; zoom: 1">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<colgroup>
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
						</colgroup>
						<tr class="translation-links">
							<td><a href="javascript:void(0)" class="ko" data-lang="ko"
								data-placement="0" id="lang">한국어</a></td>
							<td><a href="javascript:void(0)" class="en" data-lang="en"
								data-placement="2" id="lang">영어</a></td>
							<td><a href="javascript:void(0)" class="ja" data-lang="ja"
								data-placement="3" id="lang">일본어</a></td>
							<td><a href="javascript:void(0)" class="cn"
								data-lang="zh-CN" data-placement="4" id="lang">중국어</a></td>
						</tr>
					</table>

				</div>
			</li>
		</ul>



		<hr>
			<div>

		<dl>㈜호텔하루 서울 중구 청계천로 86 호텔하루 &nbsp;&nbsp; (우)11111
			&nbsp;&nbsp; Tel: 02-111-1111 &nbsp;&nbsp;Fax: 02-1111-1111
				<dl class="sns">SNS</dl>
		</dl>
		<p>사업자등록번호: 111-11-11123 &nbsp;&nbsp; 대표이사: 초특가 여기어때&nbsp;&nbsp;
			호스팅서비스제공자: 호텔하루
	<p class="sns-img"><a href="https://www.youtube.com/"><img src="/resources/uploads/footer/유튜브로고.png"></a>
	<a href="https://www.instagram.com/"><img src="/resources/uploads/footer/인스타그램로고.png"></a>
	<a href="https://www.facebook.com/"><img src="/resources/uploads/footer/페이스북로고.png"></a>
			</p>
	</div>
</div>
</footer>

<script
	src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	$('.translation-icons').css('visibility', 'visible');

	/* 구글 번역 초기화 */
	function googleTranslateElementInit() {
		new google.translate.TranslateElement({
			pageLanguage : 'ko',
			autoDisplay : true
		}, 'google_translate_element');
		//아래처럼 언어른 지정하면 구글의 언어 선택 셀렉트 박스가 안나옴. 그래서 goog-te-comb 찾지 못해서 오류 발생 
		//new google.translate.TranslateElement({pageLanguage: 'ko', includedLanguages: 'de,en,ja,ko,zh-CN', layout: google.translate.TranslateElement.InlineLayout.SIMPLE, autoDisplay: false, multilanguagePage: true}, 'google_translate_element');
	}

	/* 새 UI 선택 클릭 이벤트가 발생하면
	감춤 처리한 구글 번역 콤보리스트에
	선택한 언어를 적용해 변경 이벤트를 발생시키는 코드  */
	document
			.querySelector('.translation-links')
			.addEventListener(
					'click',
					function(event) {
						let el = event.target;
						if (el != null) {
							while (el.nodeName == 'FONT'
									|| el.nodeName == 'SPAN'
									|| el.nodeName == 'IMG') {
								el = el.parentElement;
							}//data-lang 속성이 있는 태그 찾기
							const tolang = el.dataset.lang; // 변경할 언어 코드 얻기
							const gtcombo = document
									.querySelector('.goog-te-combo');
							if (gtcombo == null) {
								alert("Error: Could not find Google translate Combolist.");
								return false;
							}
							gtcombo.value = tolang; // 변경할 언어 적용
							gtcombo.dispatchEvent(new Event('change')); // 변경 이벤트 트리거
						}
						document.body.style.cssText = ""
						return false;
					});
</script>