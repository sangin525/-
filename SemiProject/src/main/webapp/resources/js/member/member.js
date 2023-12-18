function detailPage(boardNo) {
	const pageUrl = '/BoardDetail.do?boardNo=' + boardNo;
	window.location.href = pageUrl;
}

function back() {
	location.href = "/MyPageForm.do";
}

// 비밀번호 유효성 검사 + 비밀번호 확인하고 같은지
    function validatePassword() {
       const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[@$!%*?&\#])[A-Za-z\d@$!%*?&\#]{8,20}$/;
       const password = document.getElementById("newPassword").value;
	   const beforePwd = document.getElementById("password").value;
       const msg = document.getElementById("PwdMsg");
       
       if(password == "") {
           msg.innerHTML = "비밀번호를 입력하세요.";
           msg.style.color = "red";
       } else if(passwordRegex.test(password) && password !== beforePwd) {
           msg.innerHTML = "사용 가능한 비밀번호 입니다.";
           msg.style.color = "green";
       } else {
           msg.innerHTML = "패스워드 정책에 맞지 않습니다.";
           msg.style.color = "red";
       }


       const passwordChk = document.getElementById("passwordChk").value;
       const msg2 = document.getElementById("PwdChkMsg");
       if(password === passwordChk) {
           msg2.innerHTML = "패스워드가 동일합니다.";
           msg2.style.color = "green";
       } else {
           msg2.innerHTML = "패스워드가 동일하지 않습니다.";
           msg2.style.color = "red";
       }
   }


