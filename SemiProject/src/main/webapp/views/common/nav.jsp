<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav class="Main_nav">
    <ul>
      <li class="nav_bar"><a href="/hotel/HotelInfo.do" class="Main_a">호텔소개</a></li>
      <li class="nav_bar"><a href="/gradeInfo.do" class="Main_a">객실소개</a></li>
		<li class="nav_bar"><a onclick="reserveDisplay()" id="reserve" class="Main_a">예약</a></li>
		<li class="nav_bar"><a href="/foodInfo.do" class="Main_a">e-SHOP</a></li>
		<li class="nav_bar"><a href="/NoticeList.do?cpage=1" class="Main_a">공지사항</a></li>
		<li class="nav_bar"><a href="/BoardList.do?cpage=1&category=전체" class="Main_a">문의게시판</a></li>
		<li class="nav_last"><a href="/reviewList.do?cpage=1" class="Main_a">리뷰</a></li>
	</ul>
</nav>

<div class="reserveRoom" id="reserveRoom" onmousemove="navgetDate()" style="display:none">

		<select class="grade-menu" id="grade-menu" onchange="dropdownGrade()">
		    <option value="" class="dropdown-item" selected>--선택--</option>
		    <option value="디럭스" class="dropdown-item" >디럭스</option>
		    <option value="프리미엄" class="dropdown-item" >프리미엄</option>
		    <option value="스위트" class="dropdown-item" >스위트</option>
		    <option value="로얄스위트" class="dropdown-item" >로얄스위트</option>
		</select>
	<select class="room-menu" id="room-menu">
	    <option value="" class="dropdown-item" selected>--선택--</option>
	</select>
	<input type="date" required  class="R_room" name="start_date" id="start_date" onchange="navdateSum(); navCheckReserveInfo()">
	<input type="date" required class="R_room" name="end_date" id="end_date" onchange="navdateSum(); navCheckReserveInfo()">
	<input type="number" placeholder="숙박일" name="date_sum" class="R_room_small" id="date_sum"  disabled>
	<input type="number" required placeholder="인원수" min="1" max="4" name="R_person_count" id="R_person_count" class="R_room_small">

	<c:choose>
		<c:when test="${sessionScope.no != null}">
			<button type="button" class="left-btn"
				onclick="navReserveRoom()">예약하기</button>
		</c:when>
		<c:otherwise>
			<button type="button" class="left-btn" onclick="loginEnter()">예약하기</button>
				
				<!--window.location.href="/views/member/Signin.jsp">예약하기</button>-->
		</c:otherwise>
	</c:choose>
</div>

