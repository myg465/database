function login_check(){
	//id-대문자,소문자만 가능
	//pw-대문자,소문자,특수문자 사용가능
	var id_ch=/^[a-zA-Z0-9]{1,}$/;
	var pw_ch=/^[a-zA-Z0-9]{1,}$/;
	
	if(!(id_ch.test(login.id.value))){
		alert("아이디를 다시 입력하세요.");
		login.id.value="";
		login.id.focus();
		return false;
	}
	
	if(!(pw_ch.test(login.pw.value))){
		alert("비밀번호를 다시 입력하세요.");
		login.pw.value="";
		login.pw.focus();
		return false;
	}
	return true;
}