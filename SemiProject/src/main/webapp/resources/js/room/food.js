
function sumFoodPrice(foodPrice){
	let foodCount = document.getElementById("foodDeailCount").value;
	let foodDetailPrice = document.getElementById("foodDetailPrice");
	
	if(foodCount < 1 || foodCount > 10){
		alert("주문수량이 작거나 큽니다 다시선택해주세요.");
		location.reload();
	}else{
	foodDetailPrice.innerHTML = parseInt(foodPrice) * parseInt(foodCount);
		
	}
	
}



function foodDetail(foodName){
	window.location.href ="/foodDetail.do?foodName="+foodName;
	
}
function basketListEnroll(foodName, foodPrice, foodTime){
	let foodCount = document.getElementById("foodDeailCount").value;
	let totalPrice = parseInt(foodPrice) * parseInt(foodCount);
	
	$.ajax({
		url: '/basketEnroll.do',
		type: 'get',
		data: {
			foodName: foodName,
			foodPrice: totalPrice,
			foodTime: foodTime,
			foodCount: foodCount
		},
		success: function(data) {
			if(data > 0){
				alert("장바구니에 담기 성공하셨습니다.")
				window.location.href = "/foodListChk.do";
			}else{
				alert("실패");
			}
		},
		error: function(err) {
			alert("에러발생");
		}
	});
}

function getTotalPrice(event, count, percentMLG){
	let foodPrice = document.getElementById("foodPrice"+count).innerText;
	let basketListChk = document.getElementById("basketListChk"+count);
	let basketTotalPrice = document.getElementById("basketTotalPrice");
	let basketMLG = document.getElementById("basketMLG");
	
	if(event.target.checked){
		basketTotalPrice.value = parseInt(basketTotalPrice.value) + parseInt(foodPrice);   
		basketMLG.value = parseInt(basketTotalPrice.value * percentMLG);
	}else{
		basketTotalPrice.value = parseInt(basketTotalPrice.value) - parseInt(foodPrice);
		basketMLG.value = parseInt(basketTotalPrice.value * percentMLG);
	}
	
	
	
}


function allChkBtn(event, count, percentMLG){
	let allChkBtn = document.getElementById("allChkBtn");
	let basketListChk = document.getElementsByClassName("basketListChk");
	let basketTotalPrice = document.getElementById("basketTotalPrice");
	let foodPrice = document.getElementsByClassName("foodPrice"); 
	let basketMLG = document.getElementById("basketMLG");
	
	if(event.target.checked){
		console.log("올체크");
		for(let i = 0; i<basketListChk.length; i++){
			if(basketListChk[i].checked == false){
				basketListChk[i].checked = true;
				basketTotalPrice.value = parseInt(basketTotalPrice.value) + parseInt(foodPrice[i].innerText);
				basketMLG.value = parseInt(basketTotalPrice.value * percentMLG);
			}

		}
	}else{
		console.log("올 해제");
		for(let i = 0; i<basketListChk.length; i++){
			basketListChk[i].checked = false;
			basketTotalPrice.value = "0";
			basketMLG.value = "0";
		}
	}
}

function deleteItem(foodBasketNo){
	$.ajax({
		url: '/basketDelete.do',
		type: 'get',
		data: {
			foodBasketNo: foodBasketNo
		},
		success: function(data) {
			if(data > 0){
				alert("장바구니에서 삭제를 성공하셨습니다.")
				location.reload();
			}else{
				alert("실패");
			}
		},
		error: function(err) {
			alert("에러발생");
		}
	});
}

function movePagePay(event){
	
	if(event.target.value == "장바구니"){
		console.log("장바구니입니다")
		window.location.href = "/foodListChk.do";
	}else if(event.target.value == "상품결제내역"){
		console.log("상품결제내역 입니다");
		window.location.href = "/itemPayComplite.do";
	}
	
}


function optionValue(event){
	if(event.target.value == "전체"){
		window.location.href = "/foodInfo.do";
	}else{
		window.location.href = "/ItemView.do?optionValue="+event.target.value;
	}
	
	
}

function foodNameClick(count){
	let foodName = document.getElementById("foodName"+count).innerText;
	window.location.href = "/foodDetail.do?foodName="+foodName;
}

function pageChangeBack(){
	window.location.href = "/foodInfo.do";
}

function pageChangeBasket(){
	window.location.href = "/foodListChk.do";
}


















