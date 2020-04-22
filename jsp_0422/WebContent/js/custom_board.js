function delete_check(){
	var check = confirm("삭제하시겠습니까?\n (삭제하시면 데이터 복구가 어렵습니다.)");
	if(check==true)
		{  
		window.location.href="board_delete.jsp?b_num="+modify_form.b_num.value;
		}
	else
		{ 
		return false;
		}

}