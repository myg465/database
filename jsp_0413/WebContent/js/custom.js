
				function check(){
				var num_ch=/^\d{4,}$/;
				var name_ch=/^[a-zA-Z]{1,}$/;
				var sh_ch=form.sh_ch.value;
				
				switch(sh_ch){
					//이름으로 검색시 유효성 검사
					case "1":
						if(!(name_ch.test(form.name.value))){
							alert("영문만 입력가능합니다.");
							form.name.value="";
							form.name.focus();
							return false;
						}
						break;
					//월급으로 검색시 유효성 검사
					case "2":
						
						if(!(num_ch.test(form.start.value))){
							alert("숫자만 입력가능합니다.");
							form.start.value="";
							form.start.focus();
							return false;
						}
						if(!(num_ch.test(form.end.value))){
							alert("숫자만 입력가능합니다.");
							form.end.value="";
							form.end.focus();
							return false;
						}
						if(Number(form.start.value)>Number(form.end.value)){
							alert("시작값은 더 클수 없습니다.");
							form.start.value="";
							form.start.focus();
							return false;
						}
						
						break;
					}
				
				
					return true;
				}