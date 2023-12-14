
var IMP = window.IMP;
IMP.init(config.IMP); // 예: imp00000000
	let useMLGPrice;
	let addMLG;
	let minMLG;
	let addMoneyMLG;

function addMLGMoney(name, price, memberMLG, percentMLG, membership){
	addMoneyMLG = document.getElementById("addMoneyMLG");
	let oneAdd = document.getElementById("oneAdd").value;
	let twoAdd = document.getElementById("twoAdd").value;
	let threeAdd = document.getElementById("threeAdd").value;
	let fourAdd = document.getElementById("fourAdd").value;
	let resetAdd = document.getElementById("resetAdd");
	let textTotalPrice = document.getElementById("totalPrice");
	let textAddMLG = document.getElementById("addMLG");
	let MLGChk = document.getElementById("MLGChk");
	
	if(name == 'one'){
		addMoneyMLG.value = parseInt(addMoneyMLG.value) + parseInt(oneAdd);
	}
	else if(name == 'two'){
		addMoneyMLG.value = parseInt(addMoneyMLG.value) + parseInt(twoAdd);
	}
	else if(name == 'three'){
		addMoneyMLG.value = parseInt(addMoneyMLG.value) + parseInt(threeAdd);
	}
	else if(name == 'four'){
		addMoneyMLG.value = parseInt(addMoneyMLG.value) + parseInt(fourAdd);
	}
	else if(name == 'reset'){
		addMoneyMLG.value = 0;
	}
	useMLGPrice = price-addMoneyMLG.value;
	
	if(price <= addMoneyMLG.value || memberMLG <= addMoneyMLG.value){
		MLGChk.checked = true;
		addMLGChk(price, memberMLG, percentMLG, membership);
	}else{
	if(useMLGPrice <= 0){
			useMLGPrice = 0;
			addMLG = 0;
			minMLG = price;
			
		}else{
			useMLGPrice = useMLGPrice;
			addMLG = useMLGPrice*percentMLG;
			minMLG = memberMLG;
		}
		textTotalPrice.innerHTML = "결제금액 : "+ useMLGPrice + " 원";
		textAddMLG.innerHTML = "적립 마일리지 : " +Math.floor(addMLG)+" 원 (고객님은 "+membership+" 등급으로 "+percentMLG+"% 입니다.)"
	}
}	

function btnDisabled(name){
	let oneAdd = document.getElementById("oneAdd");
	let twoAdd = document.getElementById("twoAdd");
	let threeAdd = document.getElementById("threeAdd");
	let fourAdd = document.getElementById("fourAdd");
	let resetAdd = document.getElementById("resetAdd");
	
	oneAdd.disabled = name;
	twoAdd.disabled = name;
	threeAdd.disabled = name;
	fourAdd.disabled = name;
	resetAdd.disabled = name;
}
	
	
function addMLGChk(totalPrice, memberMLG, percentMLG, membership){
	let MLGChk = document.getElementById("MLGChk");
	let textTotalPrice = document.getElementById("totalPrice");
	let textAddMLG = document.getElementById("addMLG");
	addMoneyMLG = document.getElementById("addMoneyMLG");

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
		addMoneyMLG.value = 0;
		btnDisabled(true);
	}
	else{
		useMLGPrice = totalPrice;
		addMLG = totalPrice*percentMLG;
		textTotalPrice.innerHTML = "결제금액 : "+ useMLGPrice + " 원";
		textAddMLG.innerHTML = "적립 마일리지 : " +Math.floor(addMLG)+" 원 (고객님은 "+membership+" 등급으로 "+percentMLG+"% 입니다.)"
		minMLG = 0;
		btnDisabled(false);
	}
	
}

function requestPay(memberMLG, memberName, roomName, totalPrice, memberPhone, memberEmail, memberAddr, RChkIn, RChkOut, RPersonCount, RCount, percentMLG) {
	if(useMLGPrice == null){
		useMLGPrice = totalPrice;
	}
	if(addMLG == null){
		addMLG = totalPrice *percentMLG;
	}
	if(minMLG == null){
		minMLG = 0;
	}
	
	$.ajax({
		url: '/MLGChk.do',
		type: 'post',
		data: {
			memberMLG: memberMLG
		},
		success: function(data) {
			if (data == 'true') {
				console.log("마일리지가 일치합니다.");
				if (useMLGPrice == 0) {
					$.ajax({
						url: '/ReserveEnroll.do',
						type: 'post',
						data: {
							memberName: memberName,
							roomName: roomName,
							totalPrice: useMLGPrice,
							memberPhone: memberPhone,
							RChkIn: RChkIn,
							RChkOut: RChkOut,
							RPersonCount: RPersonCount,
							RCount: RCount,
							addMLG: addMLG,
							minMLG: minMLG
						},
						success: function(data) {
							if (data > 0) {
								alert("예왁완료되었습니다 예약완료페이지로 이동합니다.");
								window.location.href = "/MyReserve.do?cpage=1";
							}

						},
						error: function(err) {

						}
					});
				} else {
					IMP.request_pay({
						pg: 'kakaopay',
						merchant_uid: "IMP" + new Date().getTime(), // 상점에서 관리하는 주문 번호
						name: roomName,
						amount: useMLGPrice,               //연습이후 고치기  totalPrice 로
						buyer_email: memberEmail,
						buyer_name: memberName,
						buyer_tel: memberPhone,
						buyer_addr: memberAddr,
						buyer_postcode: null
					}, function(rsp) { // callback 로직
						//* ...중략 (README 파일에서 상세 샘플코드를 확인하세요)... *//
						if (rsp.success) {
							// 결제 성공 시 로직
							$.ajax({
								url: '/ReserveEnroll.do',
								type: 'post',
								data: {
									memberName: memberName,
									roomName: roomName,
									totalPrice: useMLGPrice,
									memberPhone: memberPhone,
									RChkIn: RChkIn,
									RChkOut: RChkOut,
									RPersonCount: RPersonCount,
									RCount: RCount,
									addMLG: addMLG,
									minMLG: minMLG
								},
								success: function(data) {
									if (data > 0) {
										alert("예왁완료되었습니다 예약완료페이지로 이동합니다.");
										window.location.href = "/MyReserve.do?cpage=1";
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
			} else {
				alert("새로고침해주세요.");
			}
		},
		error: function(err) {

		}
	});

}

	let payItemNo = [];
function itemChkList(event, count){
	let basketListChk = document.getElementById("basketListChk"+count)
	let foodNo = document.getElementById("hiddenBasketNo"+count).value;
	
	if(event.target.checked){
		payItemNo.push(foodNo);
	}else{
			payItemNo.splice(payItemNo.indexOf(foodNo),1); 
	}
}

function itemAllChkList(event){
	let hiddenBasketNo = document.getElementsByClassName("hiddenBasketNo");
	let basketListChk = document.getElementsByClassName("basketListChk");
	
	if(event.target.checked){
		for(let i = 0; i<hiddenBasketNo.length; i++){
			if(basketListChk[i].checked == false){
			payItemNo.push(hiddenBasketNo[i].value);
			}
		}
	}else{
			payItemNo.splice(0, payItemNo.length);
		}
}

function itemRequestPay(){
	let totalPrice = document.getElementById("basketTotalPrice").value;
	let basketMLG = document.getElementById("basketMLG").value;
	
	if(totalPrice > 0){
		IMP.request_pay({
			pg: 'kakaopay',
			merchant_uid: "IMP" + new Date().getTime(), // 상점에서 관리하는 주문 번호
			name: "e-shop 상품구매",
			amount: 100               //연습이후 고치기  totalPrice 로
		}, function(rsp) { // callback 로직
			//* ...중략 (README 파일에서 상세 샘플코드를 확인하세요)... *//
			if (rsp.success) {
				// 결제 성공 시 로직
				$.ajax({
					url: '/itemReserveEnroll.do',
					type: 'post',
					data: {
						payItemNo: payItemNo.join(),
						totalPrice: totalPrice,
						basketMLG: basketMLG
					},
					success: function(data) {
							if(data > 0){
								alert("결제가 완료되었습니다 결제페이지로 이동합니다.");
								window.location.href = "/itemPayComplite.do";
							}else{
								alert("실패");
							}
	
					},
					error: function(err) {
						alert("결제실패.");
					}
				});
			} else {
				// 결제 실패 시 로직
				alert("결제실패");
			}
		});
		
	}else{
		alert("결제할 금액이 없습니다.");
	}
	

}		

function oneItemPay(foodName ,foodPrice, foodTime){
	let foodDeailCount = document.getElementById("foodDeailCount").value;
	let totalPrice = foodPrice * foodDeailCount;
	
	IMP.request_pay({
		pg: 'kakaopay',
		merchant_uid: "IMP" + new Date().getTime(), // 상점에서 관리하는 주문 번호
		name: "e-shop 상품구매",
		amount: 100               //연습이후 고치기  totalPrice 로
	}, function(rsp) { // callback 로직
		//* ...중략 (README 파일에서 상세 샘플코드를 확인하세요)... *//
		if (rsp.success) {
			// 결제 성공 시 로직
			$.ajax({
				url: '/OneItemPay.do',
				type: 'post',
				data: {
					foodName: foodName,
					totalPrice: totalPrice,
					foodTime: foodTime,
					foodDetailCount: foodDeailCount
				},
				success: function(data) {
						if(data > 0){
							alert("결제가 완료되었습니다 결제페이지로 이동합니다.");
							window.location.href = "/itemPayComplite.do";
						}else{
							alert("실패");
						}
				},
				error: function(err) {
					alert("결제실패.");
				}
			});
		} else {
			// 결제 실패 시 로직
			alert("결제실패");
		}
	});
	
	
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

























