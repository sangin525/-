
var IMP = window.IMP;
IMP.init(config.IMP); // 예: imp00000000

function requestPay(memberName, roomName, totalPrice, memberPhone, memberEmail, memberAddr, RChkIn, RChkOut, RPersonCount, RCount) {
	IMP.request_pay({
    pg : 'kakaopay',
    merchant_uid: "IMP" +new Date().getTime(), // 상점에서 관리하는 주문 번호
    name : roomName,
    amount : 100,               //연습이후 고치기  totalPrice 로
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
						 totalPrice : totalPrice,
						memberPhone : memberPhone,
						RChkIn : RChkIn,
						RChkOut : RChkOut,
						RPersonCount : RPersonCount,
						RCount : RCount},
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
	
//            IMP.request_pay({
//                pg : 'TC0ONETIME',
//                pay_method : 'kakaoPay',
//                merchant_uid: "57008833-33004", 
//                name : '당근 10kg',
//                amount : 1004,
//                buyer_email : 'Iamport@chai.finance',
//                buyer_name : '포트원 기술지원팀',
//                buyer_tel : '010-1234-5678',
//                buyer_addr : '서울특별시 강남구 삼성동',
//                buyer_postcode : '123-456'
//            }, function (rsp) { // callback
//                //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
//				if (rsp.success) {
//		          // 결제 성공 시 로직
//					alert("결제성공");
//		         }else {
//		          // 결제 실패 시 로직
//					alert("결제실패");
//			      }
//    		});
}
	
	
//function requestPay() {
//	let memberName = document.getElementById("memberName").value;
//	let roomName = document.getElementById("roomName").value;
//	let roomCount = document.getElementById("roomCount").value;
//	let RPersonCount = document.getElementById("RPersonCount").value;
//	let totalPrice = document.getElementById("totalPrice").value;
//	let memberMLG = document.getElementById("memberMLG").value;
//	
////   IMP.request_pay(param, callback) 결제창 호출
//  IMP.request_pay({ // param
//      pg: "kakaopay",
////      name: roomName,
//      amount: totalPrice,
////	memberName, roomName, roomCount, RPersonCount, totalPrice, memberMLG
//  }, function (rsp) { // callback
//      if (rsp.success) {
//          // 결제 성공 시 로직
//			alert("결제성공");
//      } else {
//          // 결제 실패 시 로직
//			alert("결제실패");
//      }
//  });
//}
































