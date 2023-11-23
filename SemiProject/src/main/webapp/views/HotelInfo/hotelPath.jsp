<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="/resources/css/hotelInfo/hotelInfo.css">
<meta charset="UTF-8">
<%@ include file="../common/head.jsp"%>

</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

	<div class="contain">
		<div class="container">

				<%@ include file="../common/hotelInfoSidebar.jsp"%>
			<div class="contentss" id="contents">




				<h3 class="secondtit">오시는 길</h3>
				<hr>
				<div id="map" style="width: 866px; height: 450px;"></div>

				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2fa1debf9be449ec915f84b1b690158d"></script>
				<script>
					var mapContainer = document.getElementById('map'), // 지도의 중심좌표
					mapOption = {
						center : new kakao.maps.LatLng(37.398765975569994, 126.9207914112465), // 지도의 중심좌표
						level : 3
					// 지도의 확대 레벨
					};

					var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

					// 지도에 마커를 표시합니다 
					var marker = new kakao.maps.Marker({
						map : map,
						position : new kakao.maps.LatLng(37.398765975569994, 126.9207914112465)
					});

					// 커스텀 오버레이에 표시할 컨텐츠 입니다
					// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
					// 별도의 이벤트 메소드를 제공하지 않습니다 
					var content = '<div class="wrap">'
							+ '    <div class="info">'
							+ '        <div class="title">'
							+ '            초특가 여기어때 호텔'
							+ '            <div class="close" onclick="closeOverlay()" title="닫기"></div>'
							+ '        </div>'
							+ '        <div class="body">'
							+ '            <div class="img">'
							+ '                <img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/thumnail.png" width="73" height="70">'
							+ '           </div>'
							+ '            <div class="desc">'
							+ '                <div class="ellipsis">경기도 안양시 무슨구 무슨동 111-1</div>'
							+ '                <div class="jibun ellipsis">(우) 11111 (지번) 안양시 만안구</div>'
							+ '            </div>' + '        </div>'
							+ '    </div>' + '</div>';

					// 마커 위에 커스텀오버레이를 표시합니다
					// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
					var overlay = new kakao.maps.CustomOverlay({
						content : content,
						map : map,
						position : marker.getPosition()
					});

					// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
					kakao.maps.event.addListener(marker, 'click', function() {
						overlay.setMap(map);
					});

					// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
					function closeOverlay() {
						overlay.setMap(null);
					}
				</script>
				<br>
				<div class="content-box">
          			<h3>호텔 주소: 경기도 안양시 무슨구 무슨동 111-1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 호텔 번호: 031-111-1111</h3>
          			<br>
          			<h4><strong>교통편</strong></h4>
          			<p>1호선 안양역 => 1번출구에서 1번가쪽으로</p>
          			<p>버스이용 => 8번, 10번, 88번, 3번 등등</p>
          			<p>호텔버스이용 => 1시, 3시, 5시 서울역 1번출구에서 출발</p>
          			
          			



        </div>

			</div>
		</div>
	</div>



	<%@ include file="../common/footer.jsp"%>
</body>
</html>