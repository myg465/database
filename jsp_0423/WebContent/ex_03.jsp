<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="ex_03_ok.jsp" name="ex03" method="post">
			이름 : <input type="text" name="name"><br>
			아이디 : <input type="text" name="id"><br>
			패스워드 : <input type="password" name="pw"><br>
			<input type="submit" value="전송">
		</form>
		<%
			application.setAttribute("appUser_id", "app_admin"); //서버종료시까지 사용가능
			session.setAttribute("sessUser_id", "sess_admin"); //세션 만료시까지 사용가능
			pageContext.setAttribute("pageUser_id", "page_admin"); //다른 페이지로 넘어가면 사라짐
			request.setAttribute("reqUser_id", "req_admin"); //다른 페이지로 넘어가면 사라짐(안사라지게 하는 방법도 있다.)
		%>
	
	</body>
</html>