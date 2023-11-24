
// 버튼선택시 이름가져오기

function getCheckboxValue(event, DetailCount, count)  {
  let result = '';
  if(event.target.checked)  {
    result = event.target.value;
  }else {
    result = '';
  }
  var text = document.getElementById('R_name'+count);
    text.value = result;
}

// 날짜계산
function dateSum(count){
	let startDate = document.getElementById("start_date" + count).value;
	let endDate = document.getElementById("end_date" + count).value;

    var ar1 = startDate.split('-');
    var ar2 = endDate.split('-');

    var da1 = new Date(ar1[0], ar1[1], ar1[2]);
    var da2 = new Date(ar2[0], ar2[1], ar2[2]);

    var dif = da2 - da1;
    var cDay = 24 * 60 * 60 * 1000;

    if(parseInt(dif/cDay) >= 10){
        alert("예약 10일을 초과할수 없습니다.");
        document.getElementById("start_date" + count).value = null;
        document.getElementById("end_date" + count).value = null;
        document.getElementById('date_sum' + count).value = 0;
        
    }else if(parseInt(dif/cDay) <= 0){
        alert("오늘 이후로 예약해주세요.");
        document.getElementById("start_date" + count).value = null;
        document.getElementById("end_date" + count).value = null;
        document.getElementById('date_sum' + count).value = 0;
    }else{
        document.getElementById('date_sum' + count).value = parseInt(dif/cDay);
        
    }
}

// 예약 홈페이지로 이동
function reserveRoom(count){
	let RName = document.getElementById("R_name" + count).value
	let startDate = document.getElementById("start_date" + count).value
	let endDate = document.getElementById("end_date" + count).value
	let dateSum = document.getElementById("date_sum" + count).value
	let RPersonCount = document.getElementById("R_person_count" + count).value
	let roomDetailGrade = document.getElementById("roomDetailGrade" + count).value
	
	
	const pageUrl = '/ReserveRoom.do?RName='+RName+'&startDate='+startDate+
									'&endDate='+endDate+'&dateSum='+dateSum+
									'&RPersonCount='+RPersonCount+
									'&roomDetailGrade='+roomDetailGrade;
	window.location.href = pageUrl;
}


function intoInfoPage(){
	window.location.replace("/gradeInfo.do");
}



















	
