function detailPage(boardNo){
    const pageUrl = '/BoardDetail.do?boardNo=' + boardNo;
    window.location.href = pageUrl;
}

function boardUpdate(){
	const form = document.getElementById("board-datail-form");
	
	form.action = "/boardUpdate.do";
	form.method = "POST";
	form.submit();
	
}

function boardDelete(){
	const form = document.getElementById("board-datail-form");
	
	form.action = "/boardDelete.do";
	form.method = "POST";
	form.submit();
}

function boardDisabled() {
	const title = document.getElementById("boardTitle");
	const content = document.getElementById("boardContent");
	const btn = document.getElementById("boardContent");
	content.disabled = false;
	title.disabled = false;
  
	const modifyBtn = document.getElementById("modifyBtn");
	const submitBtn = document.getElementById("submitBtn");
	
	modifyBtn.style.display = 'none';
	submitBtn.style.display = 'block';
}