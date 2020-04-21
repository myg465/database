<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.javalec.ex.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!-- dto에 정보를 입력시키고 얻어옴 -->
<jsp:useBean id="mdto" class="com.javalec.ex.MemberDto"/>
<jsp:setProperty property="*" name="mdto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
	// 현재 시간을 자바에서 입력하는 방법
	//mdto.setB_date(new Timestamp(System.currentTimeMillis()));
	MemberDao mdao = MemberDao.getInstance();
	int check = mdao.confirmId(mdto.getId());
	
	//아이디가 있을경우
	if(check==1){%>
	<script>
		alert("아이디가 존재합니다. 다시 입력하세요.");
		history.back(-1);
	</script>	
	<% }else{
		//아이디가 없을경우
		int ch = mdao.insertMember(mdto);
		if(ch==1){ //데이터 저장 완료%>
			<script>
				alert("회원가입이 완료 되었습니다. 로그인 페이지로 이동합니다.");
				window.location.href="login.jsp";
			</script>
		<% }else{ //저장 실패%>
			<script>
				alert("저장실패! 다시 시도해 주세요.");
				history.back(-1);
			</script>
		<% }
	}
%>
</head>
<body>

</body>
</html>