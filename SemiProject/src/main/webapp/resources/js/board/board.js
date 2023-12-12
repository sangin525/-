function detailPage(boardNo) {
	const pageUrl = '/BoardDetail.do?boardNo=' + boardNo;
	window.location.href = pageUrl;
}

function NoticedetailPage(boardNo) {
	const pageUrl = '/NoticeDetail.do?boardNo=' + boardNo;
	window.location.href = pageUrl;
}

function boardUpdate() {
	const form = document.getElementById("board-datail-form");

	form.action = "/boardUpdate.do";
	form.method = "POST";
	form.submit();

}

function boardDelete() {
	const form = document.getElementById("board-datail-form");

	form.action = "/boardDelete.do";
	form.method = "POST";
	form.submit();
}

function boardUpdateFormSend() {
	const form = document.getElementById("board-datail-form");

	form.action = "/boardSessionUpdate.do";
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


function clickCategory(button) {
    const categories = document.getElementsByName("category");

    categories.forEach((category) => {
        if (category === button) {
            category.style.backgroundColor = "rgb(224, 162, 86)";
            category.style.color = "white";
        } else {
            category.style.backgroundColor = "white";
            category.style.color = "gray";
        }
    });
}
