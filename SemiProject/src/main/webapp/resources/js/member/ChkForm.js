$(document).ready(function () {
    // "모두 선택" 체크박스에 대한 클릭 이벤트 정의
    $('#selectAllCheckbox').on('click', function () {
        // 모든 체크박스의 상태를 전환합니다.
        $('.custom-control-input').prop('checked', $(this).prop('checked'));

        // 필수 체크박스들의 'value' 속성을 업데이트하기 위해 변경 이벤트를 트리거합니다.
        $('#termsCheckbox, #privacyCheckbox, #confirmCheckbox').trigger('change');
    });

    // 필수 체크박스들의 변경 이벤트를 정의합니다.
    $('#termsCheckbox, #privacyCheckbox, #confirmCheckbox').on('change', function () {
        var requiredCheckboxes = $('#termsCheckbox, #privacyCheckbox, #confirmCheckbox');
        var allSelected = $('.custom-control-input').length === $('.custom-control-input:checked').length;

        // '모두 선택' 체크박스의 상태를 업데이트합니다.
        $('#selectAllCheckbox').prop('checked', allSelected);

        // 필수 체크박스들의 상태에 기반하여 제출 버튼을 활성화 또는 비활성화합니다.
        $('#submitBtn').prop('disabled', !allSelected || requiredCheckboxes.filter(':checked').length !== requiredCheckboxes.length);
    });

    // 제출 버튼에 대한 클릭 이벤트를 정의합니다.
    $('#submitBtn').on('click', function () {
        var requiredCheckboxes = $('#termsCheckbox, #privacyCheckbox, #confirmCheckbox');

        // 모든 필수 체크박스가 선택되어 있는지 확인합니다.
        if ($('#selectAllCheckbox').prop('checked') && requiredCheckboxes.filter(':checked').length === requiredCheckboxes.length) {
            // 모든 조건이 충족되면 폼을 제출합니다.
            $('#frm').submit();
        } else {
            // 사용자에게 필수 체크박스를 모두 선택하도록 하는 메시지를 표시하거나 경고합니다.
            alert('필수 체크박스를 모두 선택해주세요.');
        }
    });
});
