<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 89점 B 를 if비교문으로 -->

<h2><c:out value="${param.user_id }" /></h2>
<c:set var="avg" value="${(param.kor+param.eng+param.math)/3 }" />

평균 : <c:out value="${avg }" /><br>

	<c:if test="${avg>90 }"><br>
	A학점입니다.
	</c:if>

	<c:if test="${avg>=80 && avg<=90 }"><br>
	B학점입니다.
	</c:if>

	<c:if test="${avg>=70 && avg<80 }"><br>
	C학점입니다.
	</c:if>
	
	<c:if test="${avg>=60 && avg<70 }"><br>
	D학점입니다.
	</c:if>
	
	<c:if test="${avg<60 }"><br>
	F학점입니다.
	</c:if>
<!-- ------------------------------------------- -->
	<c:if test="${param.name=='홍길동' }"> <!-- 문자열도 비교할수 있다. -->
		<p>${param.name }입니다.</p>
	</c:if>
	
	<c:if test="${param.name!='홍길동' }">
		<p>홍길동이 아닙니다.이름: ${param.name }</p>
	</c:if>
	

</body>
</html>