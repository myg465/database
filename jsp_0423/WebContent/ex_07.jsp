<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="check" value="1" />
		
		<c:choose><!-- 선택문 시작 -->
		
			<c:when test="${check==1 }"> <!-- 스위치의 케이스와 같음 -->
				<p>10개의 풀옵션 차량을 선택하셨습니다.</p>
				<!--  
				<c:param name="user_id" value="admin" />
				-->
				<c:redirect url="ex_05.jsp" />
			</c:when>
			
			<c:when test="${check==2 }">
				<p>5개의 옵션 차량을 선택하셨습니다.</p>
			</c:when>
			
			<c:when test="${check==3 }">
				<p>3개의 옵션 차량을 선택하셨습니다.</p>
			</c:when>
			
			<c:otherwise> <!-- 스위치의 디폴트와 같음 -->
				<p>선택한 옵션이 없습니다.</p>
			</c:otherwise>
		
		</c:choose>
	</body>
</html>