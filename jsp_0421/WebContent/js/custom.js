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
function join_check() {
	 
	 // id 유효성검사 - 3자리 이상, 영문,숫자만 가능
	 var id_check = /^[a-zA-z0-9]{3,}$/;
	 
	 if(!(id_check.test(join_form.id.value))) {
	  alert("아이디는 영문, 숫자 3자리 이상만 가능합니다.");
	  join_form.id.focus();
	  return false;
	 }
	 
	 // pw 유효성검사 - 3자리 이상, 영문1개이상, 숫자1개이상 ,특수문자1개이상 반드시 넣을것
	 var pw_check = (/(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]).{3,}$/);
	 
	 if(!(pw_check.test(join_form.pw.value))) {
	  alert("패스워드는 영문, 숫자, 특수문자가 1개씩 들어가야 하며\n" +
	    "3자리 이상이여 합니다.");
	  join_form.pw.focus();
	  return false;
	 }
	 
	 if(join_form.pw.value != join_form.pw_check.value) {
	  alert("패스워드와 패스워드 체크가 일치하지 않습니다. 다시 입력해 주세요.")
	  join_form.pw.value = "";
	  join_form.pw_check.value = "";
	  join_form.pw.focus();
	  return false;
	 }

	 // name 유효성검사 - 1자리 이상, 국문만 가능
	 var name_check = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,}$/;

	 if(!(name_check.test(join_form.name.value))) {
	  alert("이름은 1자이상 국문만 가능합니다.");
	  join_form.name.focus();
	  return false;
	 }
	 
	 return true;
}

function update_check() {
	 
	 // id 유효성검사 - 3자리 이상, 영문,숫자만 가능
	 var id_check = /^[a-zA-z0-9]{3,}$/;
	 
	 if(!(id_check.test(update_join.id.value))) {
	  alert("아이디는 영문, 숫자 3자리 이상만 가능합니다.");
	  update_join.id.focus();
	  return false;
	 }
	 
	 // pw 유효성검사 - 3자리 이상, 영문1개이상, 숫자1개이상 ,특수문자1개이상 반드시 넣을것
	 var pw_check = (/(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]).{3,}$/);
	 
	 if(!(pw_check.test(update_join.pw.value))) {
	  alert("패스워드는 영문, 숫자, 특수문자가 1개씩 들어가야 하며\n" +
	    "3자리 이상이여 합니다.");
	  update_join.pw.focus();
	  return false;
	 }
	 
	 if(join_form.pw.value != update_join.pw_check.value) {
	  alert("패스워드와 패스워드 체크가 일치하지 않습니다. 다시 입력해 주세요.")
	  update_join.pw.value = "";
	  update_join.pw_check.value = "";
	  update_join.pw.focus();
	  return false;
	 }

	 // name 유효성검사 - 1자리 이상, 국문만 가능
	 var name_check = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,}$/;

	 if(!(name_check.test(update_join.name.value))) {
	  alert("이름은 1자이상 국문만 가능합니다.");
	  update_join.name.focus();
	  return false;
	 }
	 
	 return true;
}


function delete_check(){
	var check = confirm("삭제하시겠습니까?\n (삭제하시면 데이터 복구가 어렵습니다.)");
	if(check==true)
		{  
		location.href="delete.jsp?id="+update_join.id.value;
		}
	else
		{ 
		return false;
		}

}
