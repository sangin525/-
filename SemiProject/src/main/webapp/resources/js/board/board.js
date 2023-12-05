function detailPage(boardNo) {
	const pageUrl = '/BoardDetail.do?boardNo=' + boardNo;
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

function boardEnrollBtn() {
	const test = document.getElementById("test").value;
	if (test === '') {
		alert("로그인을 해주시길 바랍니다.");
		location.href = 'views/member/Signin.jsp';

	} else {
		location.href = 'views/board/boardEnroll.jsp';
	}
}

function test() {
	alert("Hello");

}

function answerInput() {
	let input = document.getElementById("answerInput");
	input.style.display = 'block';

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
	document.getElementById('fileInsert').addEventListener('change', function() {
		var fileName = this.value;
		document.querySelector('.upload-name').value = fileName;
	});
});