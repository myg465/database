<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 변수입력 ,출력,삭제 -->
		<c:set var="id" value="admin" />
		<c:set var="pw" value="1234" />
		<c:set var="pw2" value="1234" />
		<c:remove var="pw2"/>
		<c:set var="str" value="^#@#" />
		
		<h2>jstl태그</h2>
		아이디 : <c:out value="${id }" /><br>
		패스워드 : <c:out value="${pw }" default="없음"/><br>
		문자 : <c:out value="${str }" /><br>
		
		---------------------------<br>
		<!-- 예외처리 -->
		
		<c:catch var="error">
			<%=2/0 %>
		</c:catch>
		<c:redirect url="ex_05.jsp" /><br><!-- 에러발견시 페이지를 넘겨줄수 있다.(error변수에는 에러내용이 담긴다.) --> 
		<hr>
		
		<!-- if문 -->
		
		<c:if test="${id=='admin' }">
			패스워드가 일치합니다. 패스워드는<c:out value="${id }" />	<br>
		</c:if>
		
		<c:if test="${id!='admin' }">
			패스워드가 일치하지 않습니다. 불일치<c:out value="${id }"/>
		</c:if>
		
	</body>
</html>