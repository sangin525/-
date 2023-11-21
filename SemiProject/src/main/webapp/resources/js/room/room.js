
// 버튼선택시 이름가져오기

function getCheckboxValue(event)  {
  let result = '';
  if(event.target.checked)  {
    result = event.target.value;
  }else {
    result = '';
  }
	console.log(event.target.value);
  var text = document.getElementById('R_name');
    text.value = result;
}

// 날짜계산
function dateSum(){
	let startDate = document.getElementById("start_date").value;
	let endDate = document.getElementById("end_date").value;

    var ar1 = startDate.split('-');
    var ar2 = endDate.split('-');

    var da1 = new Date(ar1[0], ar1[1], ar1[2]);
    var da2 = new Date(ar2[0], ar2[1], ar2[2]);

    var dif = da2 - da1;
    var cDay = 24 * 60 * 60 * 1000;

    if(parseInt(dif/cDay) >= 10){
        alert("예약 10일을 초과할수 없습니다.");
        document.getElementById("start_date").value = null;
        document.getElementById("end_date").value = null;
        document.getElementById('date_sum').value = 0;
        
    }else if(parseInt(dif/cDay) <= 0){
        alert("오늘 이후로 예약해주세요.");
        document.getElementById("start_date").value = null;
        document.getElementById("end_date").value = null;
        document.getElementById('date_sum').value = 0;
    }else{
        document.getElementById('date_sum').value = parseInt(dif/cDay);
        
    }
}

	
