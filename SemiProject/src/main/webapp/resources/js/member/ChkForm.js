document.getElementById('selectAllCheckbox').addEventListener('change', function () {
    var checkboxes = document.querySelectorAll('.custom-control-input');
    for (var i = 0; i < checkboxes.length; i++) {
      checkboxes[i].checked = this.checked;
    }
    validateAndSubmit(); // 모두 선택 버튼 클릭 시 동의 여부 확인
  });

  function validateAndSubmit() {
    var isTermsChecked = document.getElementById('termsCheckbox').checked;
    var isPrivacyChecked = document.getElementById('privacyCheckbox').checked;
    var isConfirmChecked = document.getElementById('confirmCheckbox').checked;

    // 필수 체크박스 개수
    var requiredCheckboxes = document.querySelectorAll('.required-checkbox');
    var requiredCheckboxCount = 0;

    // 필수 체크박스 개수 세기
    for (var i = 0; i < requiredCheckboxes.length; i++) {
      if (requiredCheckboxes[i].checked) {
        requiredCheckboxCount++;
      }
    }

    // 필수 체크박스가 모두 선택되어 있으면 동의 버튼 활성화
    if (requiredCheckboxCount === requiredCheckboxes.length && isConfirmChecked) {
      document.querySelector('.btn-block').disabled = false;
    } else {
      document.querySelector('.btn-block').disabled = true;
    }
  }