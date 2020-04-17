<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! MemberDao mdao; %>

<%
	
	String id,pw,email,address,gender,news,sms,name,phone;
	
	id=request.getParameter("id");
	pw=request.getParameter("pw");
	email=request.getParameter("email");
	address=request.getParameter("address");
	gender=request.getParameter("gender");
	news=request.getParameter("news");
	sms=request.getParameter("sms");
	name=request.getParameter("name");
	phone=request.getParameter("phone");
	
	int check = mdao.reg_member(id, pw, email, address,
			(Timestamp)request.getAttribute("birth"), gender, news, sms, 
			name, phone);
	
	if(check==1){
		response.sendRedirect("member3_Select.jsp");
	}
	else{
		%>
		
<!DOCTYPE html>
<html>
<!--  입력값을 전송, 입력완료시 m.select.jsp로 전송 -->
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			alert("서버에 이상이 있습니다. 다시 입력하여 주세요.");
			history.back(-1);
		</script>
	</head>
	<body>
		
	</body>
</html>
		
		
		
		
	<% }%>
	
	

   
