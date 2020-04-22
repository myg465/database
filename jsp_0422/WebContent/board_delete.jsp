<%@page import="com.javalec.ex.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int check = 0;
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	BoardDao bdao = BoardDao.getInstance();
	check = bdao.deleteBoard(b_num);
	if(check==1){ //삭제완료 %>
		<script>
			alert("삭제가 완료되었습니다.");
			window.location.href="board_main.jsp";
		</script>
		
	<% }else{ //삭제안됨 %>
		<script>
			alert("삭제가 되지 않았습니다. 다시 시도해 주세요.");
			history.back(-1);
		</script>
	<% }%>