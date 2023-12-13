<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<!-- layer popup content -->
	<div class="layerPopup" id="layer_popup" style="visibility: hidden;">
		<div class="layerBox">
			<h4 class="title">HotelHaru에 오신것을 환영합니다.</h4>
			<div class="cont">
				<p>
					<img src="/resources/uploads/mainPic/크리스마스.jpg" width=350 height=500 usemap="#popup"
						alt="event page">
				</p>
			</div>
			<form name="pop_form">
				<div id="check">
					<input type="checkbox" name="chkbox" value="checkbox" id='chkbox'>
					<label for="chkbox">&nbsp&nbsp오늘 하루동안 보지 않기</label>
				</div>
				<div id="close">
					<a href="javascript:closePop();">닫기</a>
				</div>
			</form>
		</div>
	</div>
</body>

</html>
