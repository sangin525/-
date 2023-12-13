/* 팝업 */

//head 태그 안에 스크립트 선언
       function setCookie( name, value, expiredays ) {
    var todayDate = new Date();
    todayDate.setTime(todayDate.getTime() + (expiredays*24*60*60*1000)); 
    document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";";
}

function closePop() {
    if ( document.pop_form.chkbox.checked ){
        setCookie( "maindiv", "done" , 1 );
    }
    document.getElementById('layer_popup').style.visibility = "hidden";
}