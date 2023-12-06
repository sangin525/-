
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
// 원페이지 스크롤
        // 적용할 클래스명
        var className = "main-dining";
        // 지금의 스크롤 위치를 담을 변수
        var currentScroll = 0;
        // 에니메이션 효과를 주기위한 function 명 선언
        var tim;
        window.onload = function () {
            /* Div Class 명 */
            // box클래스 추출
            var elm = document.getElementsByClassName(className);
            // box클래스 개수만큼 실행
            for (var i = 0; i < elm.length; i++) {
                // box 에 각각 마우스 휠 감지
                // 휠감지
                elm[i].addEventListener("mousewheel", MouseWheelHandler, false);
                // firefox 용 휠처리
                elm[i].addEventListener("DOMMouseScroll", MouseWheelHandler, true);
            }
        }
        function MouseWheelHandler(e) {
            // 스크롤 취소시킴(이걸 안할경우 도중에 명령을 받아 화면이 덜덜 거릴수 있음)
            e.preventDefault();
            // 휠값처리
            var delta = 0;
            if (!event) event = window.event;
            if (event.wheelDelta) {
                delta = event.wheelDelta / 120;
                if (window.opera) delta = -delta;
            }
            else if (event.detail)
                delta = -event.detail / 3;
 
            // 여러개일경우 다른 selector 을 확인하기위한 상위 dom 으로 이동
            var p = e.target.parentElement;
            // 몇번째 dom 인지 저장
            var index = Array.prototype.indexOf.call(p.children, e.target);
            // 같은 위치의 돔목록 을 저장
            var elmArr = e.target.parentElement.children;
            // 지금의 스크롤 위치 저장
            currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
            // 다음위치의 좌표(기본이므로 현재의 Y 좌표 저장)
            var NextTarget = currentScroll;
            // 마우스휠 위로
            if (delta > 0) {
                // 맨처음 지점 제외
                if (index > 0) {
                    // 이전 dom 의 index 번호
                    var no = (index - 1);
                    // 좌표위치 저장
                    NextTarget = elmArr[no].offsetTop;
                }
            }
            // 마우스휠 아래로
            else if (delta < 0)
            {
                // 맨마지막 지점 제외
                if (index < elmArr.length - 1) {
                    // 다음 dom 의 index 번호
                    var no = (index + 1);
                    // 좌표위치 저장
                    NextTarget = elmArr[no].offsetTop;
                }
            }
            // 애니메이션
            // 필요없으면 바로 window.scrollTo(0, NextTarget);
            // 에니메이션 초기화
            clearInterval(tim);
            // 애니메이션 실행
            tim = setInterval(tran, 1);
            // 애니메이션 function
            function tran() {
                // 이동속도 숫자가 작아질수록 느려짐
                var speed = 5;
                // 현재 스크롤과 이동후 스크롤이 같으면 정지시킨다 
                if (currentScroll == NextTarget) {
                    clearInterval(tran);
                } else {
                    // 스크롤을 위로 올릴 경우
                    if (currentScroll - speed > NextTarget)
                    {
                        currentScroll -= speed;
                    }
                    // 스크롤을 내일 경우
                    else if (currentScroll + speed < NextTarget)
                    {
                        currentScroll += speed;
                    }
                    // 스크롤이 속도로 지정된 변수보다 작을 경우 강제적으로 맞춰준다
                    else
                    {
                        currentScroll = NextTarget;
                    }
                    // 스크롤위치 변경
                    window.scrollTo(0, currentScroll);
                }
            }
 
        }
















