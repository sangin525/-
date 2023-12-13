<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/resources/css/hotelInfo/hotelInfo.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="../common/head.jsp"%>


</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

  <div class="contain">
    <div class="container">

	<%@ include file="../common/hotelInfoSidebar.jsp" %>
      <div class="contentss" id="contents">
      
	
        <h3 class="secondtit">서울호텔 식당</h3>
        <hr>
        <br>
        <div class="pic">
          <img src="/resources/uploads/호텔식당.jpg" alt="호텔식당">
        </div>
        <br>        
        <div class="container-table">
          <h3 class="rIntro">호텔식당 소개</h3>

          <table class="tableclass">
          <thead>
            <tr>
              <th><strong>BREAKFAST</strong></th>
              <th><strong>LUNCH</strong></th>
              <th><strong>DINNER</strong></th>
            </tr>
          </thead>
            <tbody>
              <tr>
                <td>주중: 06:30~10:00<br>
                  공휴일 및 주말 2부제<br>
                (1부 06:30 ~ 08:00 / 2부 08:10 ~ 10:00)<br>
               평일 성인 : ￦ 30,000 소인 : ￦ 15,000<br>
               주말 성인 : ￦ 50,000 소인 : ￦ 30,000
              </td>
              <td>점심 11:30~14:30<br>
                (라스트 오더 14:00)<br>
               평일 성인 : ￦ 70,000 <br>소인 : ￦ 50,000<br>
               주말 성인 : ￦ 120,000 <br>소인 : ￦ 90,000
              </td>
              <td>저녁 17:30~22:00<br>
                (라스트 오더 21:30)<br>
               평일 성인 : ￦ 150,000 <br>소인 : ￦ 100,000<br>
               주말 성인 : ￦ 200,000 <br>소인 : ￦ 130,000
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <br>
      </div>
    </div>
  </div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>