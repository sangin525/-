// 아이디 중복확인
function duplicateId() {
	var mid = $("[name='M_ID']").val();    
    if (mid === '') {
        alert('아이디를 입력하세요.');
        $("name='M_ID'").focus();
        return false;
    }

    $.ajax({
        type: "POST",                                                   
        url: "/duplicateId.do",
        data: { id: mid },
        success: function (res) {
			console.log(res);
            if (res === "true") {
    			alert("이미 사용중인 아이디입니다.");
   				return false;
			} else {
    			$("[name='checked_id']").val('y');
    			alert("사용 가능한 아이디입니다.");
    			return false;
		}
        },
        error: function (response) {
    console.error("Error:", response);
}

    });
}
	
// 이메일 중복확인
function duplicateEmail() {
	var email = $("[name='M_EMAIL']").val();    
    if (email === '') {
        alert('이메일를 입력하세요.');
        $("[name='M_EMAIL']").focus();
        return false;
    }

	$.ajax({
		type: "POST",
		url: "/duplicateEmail.do",
		data: { email : email },
		success : function(res) {
			if(res === "true") { 
				alert("이미 등록된 이메일입니다.");
			} else {
				$("[name='checked_email']").val("y");
				alert("사용 가능한 이메일입니다.");
			}
		}
	});
}

	
	// 이름 유효성 검사
    function validateName() {   
       const nameRegex = /^[가-힣]{2,}$/;
       const name = document.getElementById("M_Name").value;
       const nameMsg = document.getElementById("NameMsg");

       if(name == "") {
    	   nameMsg.innerHTML = "이름을 입력해주세요.";
    	   nameMsg.style.color = "red";
       } else if(nameRegex.test(name)) {
    	   nameMsg.innerHTML = "사용 가능한 이름입니다.";
    	   nameMsg.style.color = "green";
       } else {
    	   nameMsg.innerHTML = "이름은 한글만 가능합니다.";
    	   nameMsg.style.color = "red";
       }
   }
	
	// 비밀번호 유효성 검사 + 비밀번호 확인하고 같은지
    function validatePassword() {
       const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[@$!%*?&\#])[A-Za-z\d@$!%*?&\#]{8,20}$/;
       const password = document.getElementById("M_Pwd").value;
       const msg = document.getElementById("M_PwdMsg");
       
       if(password == "") {
           msg.innerHTML = "비밀번호를 입력하세요.";
           msg.style.color = "red";
       } else if(passwordRegex.test(password)) {
           msg.innerHTML = "사용 가능한 비밀번호 입니다.";
           msg.style.color = "green";
       } else {
           msg.innerHTML = "패스워드 정책에 맞지 않습니다.";
           msg.style.color = "red";
       }

       const passwordChk = document.getElementById("M_Pwdchek").value;
       const msg2 = document.getElementById("M_PwdchekMsg");

       if(password === passwordChk) {
           msg2.innerHTML = "패스워드가 동일합니다.";
           msg2.style.color = "green";
       } else {
           msg2.innerHTML = "패스워드가 동일하지 않습니다.";
           msg2.style.color = "red";
       }
   }
   
   // 생년월일 유효성 검사
  function validateBirth() {
      const BirthRegex = /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
      const Birth = document.getElementById("M_Birth").value;
      const msg = document.getElementById("M_BirthMsg");

	  if(Birth == "") {
           msg.innerHTML = "생년월일을 입력하세요.";
           msg.style.color = "red";
       } else if(BirthRegex.test(Birth)) {
           msg.innerHTML = "유효한 생년월일입니다.";
           msg.style.color = "green";
       } else {
           msg.innerHTML = "유효하지 않은 생년월일입니다.";
           msg.style.color = "red";
       }
    }
    
	// 이메일 유효성 검사
	 function validateEmail() {
      const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
      const email = document.getElementById("M_EMAIL").value;
      const msg = document.getElementById("M_EAMILMsg");

      if(email == "") {
           msg.innerHTML = "이메일을 입력하세요.";
           msg.style.color = "red";
       } else if(emailRegex.test(email)) {
           msg.innerHTML = "유효한 이메일 주소입니다.";
           msg.style.color = "green";
       } else {
           msg.innerHTML = "유효하지 않은 이메일 주소입니다.";
           msg.style.color = "red";
       }
    }
    
	// 전화번호 유효성 검사     
     function validatePhone() {
      const phoneRegex = /^\d{3}\d{4}\d{4}$/;
      const Phone = document.getElementById("M_Phone").value;
      const msg = document.getElementById("M_PhoneMsg");

      // 전화번호 유효성 검사 로직을 여기에 작성
      // 간단한 형식을 가정 (예: 1234567890)
      

      if(Phone == "") {
           msg.innerHTML = "전화번호를 입력하세요.";
           msg.style.color = "red";
       } else if(phoneRegex.test(Phone)) {
           msg.innerHTML = "유효한 전화번호입니다.";
           msg.style.color = "green";
       } else {
           msg.innerHTML = "유효하지 않은 전화번호입니다.";
           msg.style.color = "red";
       }
    }
    
	// 우편번호번호 카카오api    
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
   
function sendChk(){
	
	
	if($("[name='checked_id']").val()=="n"){
		alert("아이디 중복 체크하세요.");
		return false;
	}
	
	if($("[name='checked_email']").val()=="n"){
		alert("이메일 중복 체크하세요.");
		return false;
	}
	
	return true;
}


 