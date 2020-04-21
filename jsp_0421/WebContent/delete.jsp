<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(session.getAttribute("authUser")==null){%>
	<script>
		alert("로그인을 하셔야 이용하실수 있습니다.");
		location.href="login.jsp";
	</script>		
<% }%>
<%
	String id = request.getParameter("id");
	MemberDao mdao = MemberDao.getInstance();
	int check = mdao.deleteMember(id);
	if(check==1){ //삭제완료 %>
		<script>
			alert("삭제가 완료되었습니다.");
			window.location.href="main.jsp";
		</script>
		
	<% }else{%>
		<script>
			alert("삭제가 되지 않았습니다. 다시 시도해 주세요.");
			history.back(-1);
		</script>
	<% }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>