<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <title>글수정</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/write.css">
	  <script type="text/javascript" src="js/check.js"></script>
	</head>
	<body>
	  <section>
	    <h1>게시글 수정</h1>
	    <hr>
	
	    <form action="modify.do" name="modify" method="post" onsubmit="return modifyCheck()">
	      <table>
	      <input type="hidden" name="bId" value="${content_view.bId }">
	        <colgroup>
	          <col width="15%">
	          <col width="85%">
	        </colgroup>
	        <tr>
	          <th>작성자</th>
	          <td>
	            <input type="text" name="bName" value="${content_view.bName }" readonly>
	          </td>
	        </tr>
	        <tr>
	          <th>제목</th>
	          <td>
	            <input type="text" name="bTitle" value="${content_view.bTitle }">
	          </td>
	        </tr>
	        <tr>
	          <th>내용</th>
	          <td>
	            <textarea name="bContent" cols="50" rows="10"> ${content_view.bContent }</textarea>
	          </td>
	        </tr>
	        <tr>
	          <th>이미지 표시</th>
	          <td>
	            <input type="file" name="file" id="file">
	          </td>
	        </tr>
	      </table>
	      <hr>
	      <div class="button-wrapper">
	        <button type="submit" class="write">수정완료</button>
	        <button type="reset" onclick="javascript:history.back(-1);" class="cancel">취소</button>
	      </div>
	    </form>
	  </section>
	</body>
</html>