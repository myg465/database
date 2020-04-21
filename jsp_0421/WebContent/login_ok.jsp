<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! MemberDao mdao = MemberDao.getInstance(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	int check=0;
	
	check=mdao.login_ch(id, pw);
	
	if(check==0){%>
	<script type="text/javascript">
		alert("아이디가 존재하지 않습니다.");
		history.back(-1);
	</script>
	<%} else if(check==-1){%>
	<script type="text/javascript">
		alert("패스워드가 일치하지 않습니다.");
		history.back(-1);
	</script>
	<%} else{ 
		MemberDto mdto= mdao.selectOne(id);
		session.setAttribute("id", mdto.getId());
		session.setAttribute("authUser", mdto.getId());
		session.setAttribute("pw", mdto.getPw());
		session.setAttribute("name", mdto.getName());
		response.sendRedirect("main.jsp");
	}%>

</head>
<body>

</body>
</html>