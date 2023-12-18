function detailPage(boardNo, secret) {	
	const m_No = document.getElementById("m_No").value;
	const session_No = document.getElementById("session_No").value;	
	const session_admin = document.getElementById("session_admin").value;
	
	if(secret == 'on'){
		if(m_No == session_No || session_admin == 'Y'){
			const pageUrl = '/BoardDetail.do?boardNo=' + boardNo;
			window.location.href = pageUrl;
		}else{
			alert("비밀글입니다.");
		}
	}else{
		const pageUrl = '/BoardDetail.do?boardNo=' + boardNo;
		window.location.href = pageUrl;
	}

	
}

function NoticedetailPage(boardNo) {
	const pageUrl = '/NoticeDetail.do?boardNo=' + boardNo;
	window.location.href = pageUrl;
}

// Board Detail Update 내용
function boardUpdate() {
	const form = document.getElementById("board-datail-form");

	form.action = "/boardUpdate.do";
	form.method = "POST";
	form.submit();

}

// Notice Detail Update 내용 // 함수 사용 안하는거 같은데 확인 필요함
function NoticeUpdate() {
	const form = document.getElementById("board-datail-form");

	form.action = "/noticeUpdate.do";
	form.method = "POST";
	form.submit();
}

// Board Detail 삭제
function boardDelete() {
	const form = document.getElementById("board-datail-form");

	form.action = "/boardDelete.do";
	form.method = "POST";
	form.submit();
}

function noticeDelete() {
	const form = document.getElementById("notice-datail-form");

	form.action = "/noticeDelete.do";
	form.method = "POST";
	form.submit();
}

// Board Update 페이지로 이동하기 위한 함수
// 이렇게 사용하는 이유는 스마트에디터 사용하고 나서 기존 수정 내용이 오류를 발생하여 새로 만든
// 업데이트 내용
function boardUpdateFormSend() {
	const form = document.getElementById("board-datail-form");

	form.action = "/boardSessionUpdate.do";
	form.method = "POST";
	form.submit();
}
function noticeUpdateFormSend() {
	const form = document.getElementById("notice-datail-form");

	form.action = "/noticeSessionUpdate.do";
	form.method = "POST";
	form.submit();
}


/* 게시글 추가 버튼 */
function boardEnrollBtn() {
	const test = document.getElementById("test").value;
	if (test === '') {
		alert("로그인을 해주시길 바랍니다.");
		location.href = 'views/member/Signin.jsp';

	} else {
		location.href = 'views/board/boardEnroll.jsp';
	}
}
/* 게시글 추가 버튼 */
function noticeEnrollBtn() {
	const test = document.getElementById("test").value;
	if (test === '') {
		alert("로그인을 해주시길 바랍니다.");
		location.href = 'views/member/Signin.jsp';

	} else {
		location.href = 'views/notice/noticeEnroll.jsp';
	}
}



function answerInput() {
	let input = document.getElementById("answerInput");
	input.style.display = 'block';
	
	window.scrollTo(0,document.body.scrollHeight);

}

function answerUpdate() {
	const form = document.getElementById("answer-form");

	form.action = "/answerDetailUpdate.do";
	form.method = "POST";
	form.submit();
}

function answerDelete() {
	const form = document.getElementById("answer-form");

	form.action = "/answerDelete.do";
	form.method = "POST";
	form.submit();
}

/*공지 사항*/
function commentInput() {
	let input = document.getElementById("commentInput");
	input.style.display = 'block';
	
	window.scrollTo(0,document.body.scrollHeight);
// 스크롤 아래로 내리며 display:none을 
}

function commentUpdate() {
	const form = document.getElementById("comment-form");

	form.action = "/commentDetailUpdate.do";
	form.method = "POST";
	form.submit();
}

function commentDelete() {
	const form = document.getElementById("comment-form");

	form.action = "/commentDelete.do";
	form.method = "POST";
	form.submit();
}

/*파일 첨부*/
document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('file').addEventListener('change', function() {
		var fileName = this.value;
		document.querySelector('.upload-name').value = fileName;
	});
});

function fileDownload(photo, route){
	const form = document.getElementById("board-datail-form");
	
	const photoInput = document.createElement("input");
	photoInput.type = "hidden";
	photoInput.name = "photo";
	photoInput.value = photo;
	
	const routeInput = document.createElement("input");
	routeInput.type = "hidden";
	routeInput.name = "route";
	routeInput.value = route;
	
	
	form.appendChild(photoInput);
	form.appendChild(routeInput);
	
	form.action = "/BoardDownload.do";
	form.method = "POST";
	form.submit();
}

function checkboxOnlyOne(category){
	const checkbox = document.getElementsByName("category");
	const hiddenCheckbox = document.getElementById("checkHidden");
	checkbox.forEach((cb) => {
		cb.checked = false;
	})
	category.checked = true;
	hiddenCheckbox.value = category.checked ? category.value : "";
}

function checkboxCheck(){
	const hiddenCheckbox = document.getElementById("checkHidden").value;
	
	if(hiddenCheckbox === ""){
		alert("체크박스를 선택해주세요");
		return false;
	}
	
	return true;
}


function clickCategory(event) {
	const categories = document.getElementsByName("category");

    if(event.target.value == "전체"){
		window.location.href = "/BoardList.do?cpage=1&category=전체";
	}else{
		window.location.href = "/BoardCategoryList.do?cpage=1&category="+event.target.value;
	}
	
	// 이전에 클릭한 버튼에 대한 스타일 초기화
    categories.forEach((category) => {
            category.style.backgroundColor = "white";
            category.style.color = "gray";
    });
	
	event.target.style.backgroundColor = "rgb(224, 162, 86)";
	event.target.style.color = "white";
	
	    // 중간 정도로 스크롤 이동

	
}

function search(){
	const searchBtn = document.getElementById("searchBtn").value;
	
	window.location.href = "BoardSearchList.do?cpage=1&search=" + searchBtn
}

function searchNotice(){
	const searchBtn = document.getElementById("searchNoticeBtn").value;
	window.location.href = "NoticeSearchList.do?cpage=1&search=" + searchBtn
}