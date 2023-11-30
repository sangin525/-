
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

// 체크박스선택시 나버지버튼 비활성화

function unlockChkBtn(event, DetailCount){
	let Detailcheckbox = document.getElementById("Detailcheckbox" + DetailCount);
	let allChkbox = document.getElementsByClassName("Detailcheckbox");
	if(event.target.checked){
		for(let i = 0; i<allChkbox.length; i++){
			allChkbox[i].disabled = true;
		}
		Detailcheckbox.disabled = false;
	}else{
		for(let i = 0; i<allChkbox.length; i++){
			allChkbox[i].disabled = false;
		}
	}
}
// 모달창에서 close 누를시 전체체크해제, disabled 해제
function unChkBtn(){
	let allChkbox = document.getElementsByClassName("Detailcheckbox");
	for(let i = 0; i<allChkbox.length; i++){
		allChkbox[i].disabled = false;
		allChkbox[i].checked = false;
	}
}


// 날짜계산
function dateSum(count){
	let startDate = document.getElementById("start_date" + count).value;
	let endDate = document.getElementById("end_date" + count).value;

    var ar1 = startDate.split('-');
    var ar2 = endDate.split('-');
	
    var da1 = new Date(ar1[0], ar1[1]-1, ar1[2], 23, 59, 59);
    var da2 = new Date(ar2[0], ar2[1]-1, ar2[2], 23, 59, 59);

	var difDate = new Date();
	
    var dif = da2 - da1;
    var cDay = 24 * 60 * 60 * 1000;
	var difDay = parseInt(dif/cDay);
    if(difDay >= 10){
        alert("예약 10일을 초과할수 없습니다.");
        document.getElementById("start_date" + count).value = null;
        document.getElementById("end_date" + count).value = null;
        document.getElementById('date_sum' + count).value = 0;
        
	}else if(da1 < difDate){
        alert("날짜를 다시선택해주세요.");
        document.getElementById("start_date" + count).value = null;
        document.getElementById("end_date" + count).value = null;
        document.getElementById('date_sum' + count).value = 0;
		
    }else if(difDay <= 0){
        alert("오늘 이후로 예약해주세요.");
        document.getElementById("start_date" + count).value = null;
        document.getElementById("end_date" + count).value = null;
        document.getElementById('date_sum' + count).value = 0;
    }else{
        document.getElementById('date_sum' + count).value = difDay;
        
    }
}

function getDate(count){
	dateSum(count);
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


function checkReserveInfo(count){
	let Rname = document.getElementById("R_name"+count).value;
	let startDate = document.getElementById("start_date"+count).value;
	let endDate = document.getElementById("end_date"+count).value;
	$.ajax({
		url: '/checkReserveInfo.do',
		type: 'get',
		data: {
			Rname: Rname,
			startDate: startDate,
			endDate: endDate
		},
		success: function(data) {
			if(data == 'true'){
				alert("해당일자에 예약된 내역이 있습니다. 다른날짜를 선택해주세요.");
				document.getElementById("start_date" + count).value = null;
		        document.getElementById("end_date" + count).value = null;
		        document.getElementById('date_sum' + count).value = 0;
			}
		},
		error: function(err) {
			alert("에러발생");
		}
	});
}
















	
