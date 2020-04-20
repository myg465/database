<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("authUser")!=null){
		response.sendRedirect("main.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/custom.js"></script>
	</head>
	<body>
		<form action="login_ok.jsp" name="l_form" method="post" onsubmit="return login_check()">
			아이디 : <input type="text" name="id"><br>
			패스워드 : <input type="text" name="pw"><br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입">
		</form>
	</body>
</html>