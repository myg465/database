function replyCheck(){
	if(reply.bName.value==""){
		alert("작성자를 입력해 주세요.");
		reply.bName.focus();
		return false;
	}
	if(reply.bTitle.value==""){
		alert("제목을 입력해 주세요.");
		reply.bTitle.focus();
		return false;
	}
	if(reply.bContent.value==""){
		alert("내용을 입력해 주세요.");
		reply.bContent.focus();
		return false;
	}
	
	return true;
}
function modifyCheck(){
	if(modify.bName.value==""){
		alert("작성자를 입력해 주세요.");
		modify.bName.focus();
		return false;
	}
	if(modify.bTitle.value==""){
		alert("제목을 입력해 주세요.");
		modify.bTitle.focus();
		return false;
	}
	if(modify.bContent.value==""){
		alert("내용을 입력해 주세요.");
		modify.bContent.focus();
		return false;
	}
	
	return true;
}
function writeCheck(){
	if(write.bName.value==""){
		alert("작성자를 입력해 주세요.");
		write.bName.focus();
		return false;
	}
	if(write.bTitle.value==""){
		alert("제목을 입력해 주세요.");
		write.bTitle.focus();
		return false;
	}
	if(write.bContent.value==""){
		alert("내용을 입력해 주세요.");
		write.bContent.focus();
		return false;
	}
	
	return true;
}
