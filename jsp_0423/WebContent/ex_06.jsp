<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<!-- 구구단을 표현식으로 -->
	<body>
		<table border="1">
			<tr>
				<th>변수 i</th>
				<th>변수 sum</th>
				<th>합계</th>
			</tr>
			<c:forEach var="i" begin="2" end="9" step="1"> <!-- 단 부분 -->
			<c:forEach var="j" begin="1" end="9" step="2"> <!-- 내용부분 -->
			<c:set var="gop" value="${i*j }" />
			<tr>
				<td>${i }</td>
				<td>${j }</td>
				<td>${gop }</td>
				
			</tr>
			
			</c:forEach>
			</c:forEach>
		</table>
		<!-- -------for each------- -->
		
	</body>
</html>