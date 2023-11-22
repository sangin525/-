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

			<div class="contentss" id="contents">


				<%@ include file="../common/nav2.jsp"%>


				<h3 class="secondtit">오시는 길</h3>
				<hr>
				<div id="map"
					style="width: 866px; height: 554px; margin-left: 277px; margin-right: 57px;"></div>
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2fa1debf9be449ec915f84b1b690158d"></script>
				<script>
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new kakao.maps.LatLng(37.398765975569994, 126.9207914112465), // 지도의 중심좌표
						level : 3
					// 지도의 확대 레벨
					};

					var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

					// 마커가 표시될 위치입니다 
					var markerPosition = new kakao.maps.LatLng(37.398765975569994, 126.9207914112465);

					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
						position : markerPosition
					});

					// 마커가 지도 위에 표시되도록 설정합니다
					marker.setMap(map);

					// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
					// marker.setMap(null);
				</script>
				<br>

			</div>
		</div>
	</div>



	<%@ include file="../common/footer.jsp"%>
</body>
</html>