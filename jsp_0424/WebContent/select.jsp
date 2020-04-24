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
	
	<h2>파일명 : ${requestScope.select_address }</h2><br>
	
	<h2>리스트 출력</h2>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="dto" items="${dtos }">
				<tr>
					<td>
						<a href="modify.jsp?id='${dto.getId() }'">
							${dto.getId() }
						</a>
					</td>
					<td>${dto.getPw() }</td>
					<td>${dto.getName() }</td>
					<td>${dto.getEmail() }</td>
					<td>${dto.getAddress() }</td>
					<td>${dto.getB_date() }</td>
				</tr>
			</c:forEach>
		
		
		
		</table>
	
	
	
	
	
</body>
</html>