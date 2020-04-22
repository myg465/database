<%@page import="com.javalec.ex.BoardDto"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 섹션 추가할곳 -->
<%!
	ArrayList list = new ArrayList();
	BoardDao bdao = BoardDao.getInstance();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			*{ margin:0; padding:0;}
			table{ width:900px; margin:0 auto; border-collapse: collapse; margin-top:20px;}
			th,td{ text-align: center;}
			img{ width: 30px; height: 30px;}
			button{ width:60px; height: 30px; position: relative; left:510px; top:10px;}
		</style>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>파일이름</th>
			</tr>
			<%
				list = bdao.getBoards(); //전체 들고오기
				for(int i=0;i<list.size();i++){
					BoardDto bdto = (BoardDto) list.get(i); 
			%>
			<tr>
				<td><a href="board_modify.jsp?b_num=<%= bdto.getB_num()%>"><%= bdto.getB_num()%></a></td>
				<td><%= bdto.getB_title() %></td>
				<td><%= bdto.getB_content() %></td>
				<td><%= bdto.getB_user() %></td>
				<td>
					<%= bdto.getB_file() %>
					<a href="upload/<%= bdto.getB_file() %>">
						<img alt="다운" src="img/down.png">
					</a>
				</td>
			</tr>
			<% }%>
		</table>
		<button><a href="upload_form.jsp">새글작성</a></button>
	</body>
</html>