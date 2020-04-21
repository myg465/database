<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(session.getAttribute("authUser")==null){%>
	<script>
		alert("로그인을 하셔야 이용하실수 있습니다.");
		location.href="login.jsp";
	</script>		
<% }%>    
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="mdto" class="com.javalec.ex.MemberDto" />
<jsp:setProperty property="*" name="mdto" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
	<%
	String id = mdto.getId();
	MemberDao mdao = MemberDao.getInstance();
	int check = mdao.updateMember(mdto);
	if(check==1){
	//수정완료
	%>
	<script>
		alert("회원정보수정이 완료되었습니다.");
		window.location.href="main.jsp";
	</script>	
	<% }else{ //수정에러 %>
	<script>
		alert("회원정보수정이 잘못되었습니다. 다시 수정해 주세요.");
		history.back(-1);
	</script>
	<% }%>
<body>
</body>
</html>