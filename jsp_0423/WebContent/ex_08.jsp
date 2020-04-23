<%@page import="java.util.Date"%>
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
		<c:set var="money1" value="1000000000" />
		<jsp:useBean id="t_date" class="java.util.Date" /><!-- 날짜 클래스를 선언한다. -->
		
		<!-- date클래스를 임포트 해야 사용가능 -->
		
		<h2> 현재 날짜 :<fmt:formatDate value="${t_date }" pattern="yyyy/MM/dd"/></h2><br> <!-- 패턴을 정해서 출력한다. -->
		<fmt:formatDate value="<%= new Date() %>" type="date" /><br><!-- 날짜만 출력한다. -->
		<fmt:formatDate value="<%= new Date() %>" type="time" /><br><!-- 시간만 출력한다. -->
		<fmt:formatDate value="<%= new Date() %>" type="both" /><br><!-- 둘다 출력한다. -->
		<hr>
		
		<!-- 숫자 형식 지정하기 -->
		
		<fmt:formatNumber value="${money1 }" groupingUsed="true" /><br><!-- 세자리씩 구분하여 콤마를 찍는다. -->
		<fmt:formatNumber value="1" pattern="0000" /> <!-- 자리수를 제한하고 빈자리를 0으로 채운다 -->
		<fmt:formatNumber value="341" pattern="####" /> <!-- 자리수를 제한하지만 빈자리를 채우지 않는다. -->
		
	</body>
</html>