<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
</head>

<body>
  <section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
      	<col width="80%">
      	<col width="10%">
      	<col width="10%">
      </colgroup>	
      <tr>
        <th colspan="3">${content_view.bTitle }</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${content_view.bId }</strong></td>
      </tr>
      <tr>
        <td>${content_view.bDate }</td>
        <td>조회수</td>
        <td>${content_view.bHit }</td>
      </tr>
      <tr>
        <td class="article" colspan="3">
        ${content_view.bContent }
		</td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> <a href="#">[키즈잼] 2월 프로그램 안내</a></td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span> <a href="#">[키즈잼] 2020년 1분기 정기 휴관일 안내</a></td>
      </tr>
    </table>

    <a href="list.do"><div class="list">목록</div></a>
    <a href="#"><div class="list">삭제</div></a>
    <a href="#"><div class="list">수정</div></a>
  </section>

  
</body>
</html>