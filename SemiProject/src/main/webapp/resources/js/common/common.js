
function reserveDisplay(){
	let reserveRoom = document.getElementById("reserveRoom");
	if(reserveRoom.style.display == 'none'){
		reserveRoom.style.display = 'block';
	}else{
		reserveRoom.style.display = 'none';
	}
}

let roomMenu;
function dropdownGrade(){
	let gradeMenu = document.getElementById("grade-menu").value;
	roomMenu = document.getElementById("room-menu");
	roomMenu.textContent = null;
	console.log("ajax 시작부분");
		$.ajax({
				url: '/navRoomGrade.do',
				type: 'get',
				data: { gradeMenu: gradeMenu},
				success: function(data) {
					var data = data.replace('[','');
					data = data.replace(']','');
					data = data.replaceAll(' ','');
					data = data.split(',');
					for(let i =0; i<data.length; i++){
					let option=document.createElement("option");
					option.text=data[i];
					option.value=data[i];
					roomMenu.appendChild(option);
					}
				},
				error: function(err) {
				}
			});
}
function navdateSum(){
	let startDate = document.getElementById("start_date").value;
	let endDate = document.getElementById("end_date").value;

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
        document.getElementById("start_date").value = null;
        document.getElementById("end_date").value = null;
        document.getElementById('date_sum').value = 0;
        
	}else if(da1 < difDate){
        alert("날짜를 다시선택해주세요.");
        document.getElementById("start_date").value = null;
        document.getElementById("end_date").value = null;
        document.getElementById('date_sum').value = 0;

    }else if(difDay <= 0){
        alert("오늘 이후로 예약해주세요.");
        document.getElementById("start_date").value = null;
        document.getElementById("end_date").value = null;
        document.getElementById('date_sum').value = 0;
    }else{
        document.getElementById('date_sum').value = difDay;
        
    }
}
function navgetDate(){
	navdateSum();
} 


// 예약 홈페이지로 이동
function navReserveRoom(){
	let RName = document.getElementById("room-menu").value;
	let startDate = document.getElementById("start_date").value;
	let endDate = document.getElementById("end_date").value;
	let dateSum = document.getElementById("date_sum").value;
	let RPersonCount = document.getElementById("R_person_count").value;
	let roomDetailGrade = document.getElementById("grade-menu").value;
	
	
	const pageUrl = '/ReserveRoom.do?RName='+RName+'&startDate='+startDate+
									'&endDate='+endDate+'&dateSum='+dateSum+
									'&RPersonCount='+RPersonCount+
									'&roomDetailGrade='+roomDetailGrade;
	window.location.href = pageUrl;
}

function loginEnter(){
	alert("로그인 후 이용해주세요");
	window.location.href="/views/member/Signin.jsp";
}

function navCheckReserveInfo(){
	let startDate = document.getElementById("start_date").value;
	let endDate = document.getElementById("end_date").value;
	let Rname = roomMenu.value;
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
				document.getElementById("start_date").value = null;
		        document.getElementById("end_date").value = null;
		        document.getElementById('date_sum').value = 0;
			}
		},
		error: function(err) {
			alert("에러발생");
		}
	});
}


















