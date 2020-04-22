<%@page import="com.javalec.ex.BoardDto"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_num = Integer.parseInt(request.getParameter("b_num")) ;
	BoardDao bdao = BoardDao.getInstance();
	BoardDto bdto = bdao.getOneBoard(b_num);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/custom_board.js"></script>
	</head>
	<body>
		<form action="board_modifyok.jsp" name="modify_form" method="post" enctype="multipart/form-data">
			<input type="hidden" name="b_num" value=<%=bdto.getB_num() %>>
			제목 : <input type="text" name="b_title" value=<%=bdto.getB_title() %>><br>
			작성자 : <input type="text" name="b_user" value=<%=bdto.getB_user() %>><br>
			내용 <br>
			<textarea rows="15" cols="80" name="b_content"><%=bdto.getB_content() %></textarea><br>
			파일 <input type="text" name="old_file" value=<%=bdto.getB_file() %> readonly><br>
			파일 첨부 : <input type="file" name="b_file"><br><br>
			<input type="submit" value="수정">
			<input type="button" onclick="javascript:window.location.href='board_main.jsp'" value="취소"><br>
			
			<input type="button" onclick="delete_check()" value="삭제하기">
		</form>
	</body>
</html>