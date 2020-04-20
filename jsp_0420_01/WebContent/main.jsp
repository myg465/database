<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(session.getAttribute("authUser")==null){%>
	<script>
		alert("로그인을 하셔야 이용하실수 있습니다.");
		location.href="login.jsp";
	</script>		
<% }%>
<%!ArrayList list = new ArrayList();
	MemberDao mdao = MemberDao.getInstance();%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p><strong><%=session.getAttribute("name") %></strong>님 환영합니다.</p>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
				<th>가입날짜</th>
			</tr>
			<%
			list=mdao.selectAll();
			 for(int i=0;i<list.size();i++){
			MemberDto mdto=(MemberDto) list.get(i);
			%>
			<tr>
				<td><%=mdto.getId() %></td>
				<td><%=mdto.getPw() %></td>
				<td><%=mdto.getName() %></td>
				<td><%=mdto.getEmail() %></td>
				<td><%=mdto.getAddress() %></td>
				<td><%=mdto.getB_date() %></td>
			</tr>
			<%} %>
		</table>
		
	</body>
</html>