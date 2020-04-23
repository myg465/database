<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.javalec.ex.MemberInfo" scope="page" />
<jsp:setProperty name="member" property="name" value="홍길동" />
<jsp:setProperty name="member" property="id" value="admin" />
<jsp:setProperty name="member" property="pw" value="1234" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>빈태그 사용</h2>
		<jsp:getProperty property="name" name="member" />
		<jsp:getProperty property="id" name="member" />
		<jsp:getProperty property="pw" name="member" />
		
		<h2>EL태그 사용</h2>
		${member.name }<br>
		${member.id }<br>
		${member.pw }<br>
	</body>
</html>