function id_check_db() {
	var id_chk = /^[a-zA-Z][a-zA-Z0-9_]{3,16}$/;

	if (id_check.value == "") {
		alert("아이디를 입력해주세요.");
		return false;
	}
	if (!(id_chk.test(id_check.value))) {
		alert("4~16자리의 영문, 숫자, 특수기호(_)만 사용하실 수 있습니다.(첫 글자는 영문)");
		id_check.value = "";
		id_check.focus();
		return false;
	}
	//db와 연동 후 아이디가 있는지 확인하는 형태
//	location.href="join_check.do";
	join_id.submit();
	
//	document.getElementById("ch_text").innerHTML = "아이디 사용이 가능합니다.";
}


function join_datainput(){
	
	opener.document.getElementById("j_id").value = document.getElementById("id_check").value;
	window.close();
	
}