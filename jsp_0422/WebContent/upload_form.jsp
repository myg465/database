<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="upload_formok.jsp" name="form" method="post" enctype="multipart/form-data">
			제목 : <input type="text" name="b_title"><br>
			작성자 : <input type="text" name="b_user"><br>
			내용 <br>
			<textarea rows="15" cols="80" name="b_content"></textarea><br>
			파일 첨부 : <input type="file" name="b_file"><br><br>
			<input type="submit" value="작성">
			<input type="button" onclick="javascript:window.location.href='board_main.jsp'" value="취소">
		</form>
	</body>
</html>