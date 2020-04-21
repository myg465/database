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
		<a href="logout.jsp"><button>로그아웃</button></a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>가입날짜</th>
				<th>수정날짜</th>
			</tr>
			<%
			list=mdao.selectAll();
			 for(int i=0;i<list.size();i++){
			MemberDto mdto=(MemberDto) list.get(i);
			%>
			<tr>
				<td>
					<a href="modify.jsp?id=<%=mdto.getId() %>">
						<%=mdto.getId() %>
					</a>
				</td>
				<td><%=mdto.getPw() %></td>
				<td><%=mdto.getName() %></td>
				<td><%=mdto.getEmail() %></td>
				<td><%=mdto.getAddress1() %></td>
				<td>
				<%=mdto.getAddress2() %> 
				<%if(mdto.getAddress3()==null) out.println(""); else out.println(mdto.getAddress3());%>
				</td>
				<td><%=mdto.getB_date() %></td>
				<td><%if(mdto.getU_date()==null) out.println("정보없음"); else out.println(mdto.getU_date()); %></td>
			</tr>
			<%} %>
		</table>
		
	</body>
</html>