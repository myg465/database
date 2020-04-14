function check(){
			var id_ch=(/^(?=.*[a-zA-Z])(?=.*[0-9]).{1,16}$/);
			var pw_ch=(/^(?=.*[!@#$%^&*()_+|~])(?=.*[0-9]).{1,16}$/);
			var name_ch=/^[가-힣]{1,}$/;
			var num_ch=/^[0-9]{3,4}$/;
			
			
//			if(!(id_ch.test(join.id.value))){
//				alert("아이디를 다시 입력하세요.");
//				join.id.value="";
//				join.id.focus();
//				return false;
//			}
//			if(!(pw_ch.test(join.pw.value))){
//				alert("비밀번호를 다시 입력하세요.");
//				join.pw.value="";
//				join.pw.focus();
//				return false;
//			}
			
			if(join.pw.value!=join.pw2.value){
				alert("비밀번호가 일치하지 않았습니다.");
				join.pw2.value="";
				join.pw2.focus();
				return false;
			}
			
			if(!(name_ch.test(join.name.value))){
				alert("이름은 한글만 입력하세요.");
				join.name.value="";
				join.name.focus();
				return false;
			}
			
			if(!(num_ch.test(join.phone2.value))){
				alert("이름은 한글만 입력하세요.");
				join.phone2.value="";
				join.phone2.focus();
				return false;
			}
			
			if(!(num_ch.test(join.phone3.value))){
				alert("이름은 한글만 입력하세요.");
				join.phone3.value="";
				join.phone3.focus();
				return false;
			}
			
			if(join.gender.value==""){
				alert("성별을 선택하세요.");
				return false;
			}
			
			
			
			
			
			return true;
			
		}