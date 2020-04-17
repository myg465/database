<%@page import="java.sql.Timestamp"%>
<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			h2{ text-align: center;}
			table{ border-collapse: collapse; margin:0 auto;}
		</style>
	</head>
	<body>
		<h2>회원정보 리스트</h2>
		<table border="1">
			<tr>
				<th>일련번호</th>
				<th>회원 아이디</th>
				<th>회원 비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>성별</th>
				<th>생일</th>
				<th>뉴스레터수신여부</th>
				<th>SMS수신여부</th>
				<th>가입일자</th>
			</tr>
		<%
			MemberDao mdao=new MemberDao();
			ArrayList dtos;
			MemberDto mdto;
			int j_num;
			String id,pw,email,address,gender,news,sms,name,phone;
			Timestamp birth,j_date;
			dtos=mdao.memberselect();
			
			for(int i=0;i<dtos.size();i++){
				mdto=(MemberDto)dtos.get(i);
				j_num=mdto.getJ_num();
				id=mdto.getId();
				pw=mdto.getPw();
				email=mdto.getEmail();
				address=mdto.getAddress();
				gender=mdto.getGender();
				news=mdto.getNews();
				sms=mdto.getSms();
				name=mdto.getName();
				phone=mdto.getPhone();
				birth=mdto.getBirth();
				j_date=mdto.getJ_date();
				%>
			<tr>
				<td><%=j_num %></td>
				<td><%=id %></td>
				<td><%=pw %></td>
				<td><%=name %></td>
				<td><%=email %></td>
				<td><%=address %></td>
				<td><%=phone %></td>
				<td><%=gender %></td>
				<td><%=birth %></td>
				<td><%=news %></td>
				<td><%=sms %></td>
				<td><%=j_date %></td>
			</tr>
				
			<% }%>
		
		</table>
		<a href="insert_member.html"><button>회원추가</button></a>
	</body>
</html>