$(document).ready(function () {
    // "모두 선택" 체크박스에 대한 클릭 이벤트 정의
    $('#selectAllCheckbox').on('click', function () {
        // 모든 체크박스의 상태를 전환합니다.
        if($(this).prop("checked")){
        	//체크
			$(".chkInp").prop("checked",true);			        
        } else {
	        //해제
	        $(".chkInp").prop("checked",false);
        }
        // 필수 체크박스들의 'value' 속성을 업데이트하기 위해 변경 이벤트를 트리거합니다.
        //$('#termsCheckbox, #privacyCheckbox, #confirmCheckbox').trigger('change');
    });
	
	$('.custom-control-input').on("change",function(){
		if($(".chkInp").length==$(".chkInp:checked").length){
			$('#selectAllCheckbox').prop("checked", true);			
		} else {
			$('#selectAllCheckbox').prop("checked", false);
		}
	});

    // 제출 버튼에 대한 클릭 이벤트를 정의합니다.
    $('#submitBtn').on('click', function () {
        var requiredCheckboxes = $('#termsCheckbox, #privacyCheckbox, #confirmCheckbox');
		
        // "모두 선택" 체크박스가 선택되어 있거나 모든 필수 체크박스가 선택되어 있는지 확인합니다.
        if (requiredCheckboxes.filter(':checked').length === requiredCheckboxes.length) {
            // 모든 조건이 충족되면 폼을 제출합니다.
            $('#frm').submit();            
        } else {
            // 사용자에게 필수 체크박스를 모두 선택하도록 하는 메시지를 표시하거나 경고합니다.
            alert('필수 체크박스를 모두 선택해주세요.');
            return false;
        }
    });
});


