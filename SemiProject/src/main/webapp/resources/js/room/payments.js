
var IMP = window.IMP;
IMP.init(config.IMP); // 예: imp00000000
	let useMLGPrice;
	let addMLG;
	let minMLG;
function addMLGChk(totalPrice, memberMLG, percentMLG, membership){
	let MLGChk = document.getElementById("MLGChk");
	let textTotalPrice = document.getElementById("totalPrice");
	let textAddMLG = document.getElementById("addMLG");
	
	if(MLGChk.checked){
		if((totalPrice-memberMLG) <= 0){
			useMLGPrice = 0;
			addMLG = 0;
			minMLG = totalPrice;
			console.log(totalPrice)
			console.log(memberMLG)
			console.log(minMLG)
			console.log(totalPrice)
		}else{
			useMLGPrice = totalPrice - memberMLG;
			addMLG = useMLGPrice*percentMLG;
			minMLG = memberMLG;
		}
		textTotalPrice.innerHTML = "결제금액 : "+ useMLGPrice + " 원";
		textAddMLG.innerHTML = "적립 마일리지 : " +Math.floor(addMLG)+" 원 (고객님은 "+membership+" 등급으로 "+percentMLG+"% 입니다.)"
		
	}
	else{
		useMLGPrice = totalPrice;
		addMLG = totalPrice*percentMLG;
		textTotalPrice.innerHTML = "결제금액 : "+ useMLGPrice + " 원";
		textAddMLG.innerHTML = "적립 마일리지 : " +Math.floor(addMLG)+" 원 (고객님은 "+membership+" 등급으로 "+percentMLG+"% 입니다.)"
		minMLG = 0;
	}
	
}

function requestPay(memberName, roomName, totalPrice, memberPhone, memberEmail, memberAddr, RChkIn, RChkOut, RPersonCount, RCount, percentMLG) {
	if(useMLGPrice == null){
		useMLGPrice = totalPrice;
	}
	if(addMLG == null){
		addMLG = totalPrice *percentMLG;
	}
	if(minMLG == null){
		minMLG = 0;
	}
	if(useMLGPrice == 0){
		$.ajax({
				url: '/ReserveEnroll.do',
				type: 'post',
				data: { memberName: memberName,
						 roomName : roomName,
						 totalPrice : useMLGPrice,
						memberPhone : memberPhone,
						RChkIn : RChkIn,
						RChkOut : RChkOut,
						RPersonCount : RPersonCount,
						RCount : RCount,
						addMLG : addMLG,
						minMLG : minMLG},
				success: function(data) {
					if(data > 0){
						alert("예왁완료되었습니다 예약완료페이지로 이동합니다.");
						window.location.href="/MyReserve.do?cpage=1";
					}

				},
				error: function(err) {

				}
			});
	}else{
	IMP.request_pay({
    pg : 'kakaopay',
    merchant_uid: "IMP" +new Date().getTime(), // 상점에서 관리하는 주문 번호
    name : roomName,
    amount : useMLGPrice,               //연습이후 고치기  totalPrice 로
    buyer_email : memberEmail,
    buyer_name : memberName,
    buyer_tel : memberPhone,
    buyer_addr : memberAddr,
    buyer_postcode : null
}, function(rsp) { // callback 로직
	//* ...중략 (README 파일에서 상세 샘플코드를 확인하세요)... *//
		if (rsp.success) {
			// 결제 성공 시 로직
			$.ajax({
				url: '/ReserveEnroll.do',
				type: 'post',
				data: { memberName: memberName,
						 roomName : roomName,
						 totalPrice : useMLGPrice,
						memberPhone : memberPhone,
						RChkIn : RChkIn,
						RChkOut : RChkOut,
						RPersonCount : RPersonCount,
						RCount : RCount,
						addMLG : addMLG,
						minMLG : minMLG},
				success: function(data) {
					if(data > 0){
						alert("예왁완료되었습니다 예약완료페이지로 이동합니다.");
						window.location.href="/MyReserve.do?cpage=1";
					}

				},
				error: function(err) {

				}
			});
		} else {
			// 결제 실패 시 로직
			alert("결제실패");
		}
	}); 
}

}


//}, function(rsp) { // callback 로직
//		//* ...중략 (README 파일에서 상세 샘플코드를 확인하세요)... *//
//		$.ajax({
//			type: "POST",
//			url: "/verifyIamport.do",
//			data: {impUid : rsp.imp_uid}
//		}).done(function(data) {
//
//			if (rsp.paid_amount == data.response.amount) {
//				alert("결제 및 결제검증완료");
//				$.ajax({
//				url: '/ReserveEnroll.do',
//				type: 'post',
//				data: { memberName: memberName,
//						 roomName : roomName,
//						 totalPrice : useMLGPrice,
//						memberPhone : memberPhone,
//						RChkIn : RChkIn,
//						RChkOut : RChkOut,
//						RPersonCount : RPersonCount,
//						RCount : RCount,
//						addMLG : addMLG,
//						minMLG : minMLG},
//				success: function(re) {
//					if(re > 0){
//						alert("예왁완료되었습니다 예약완료페이지로 이동합니다.");
//						window.location.href="/MyReserve.do?cpage=1";
//					}
//
//				},
//				error: function(err) {
//
//				}
//			});
//				//결제 성공 시 비즈니스 로직
//
//			} else {
//				alert("결제 실패");
//			}
//		});
//	});
//	}
//}	

























