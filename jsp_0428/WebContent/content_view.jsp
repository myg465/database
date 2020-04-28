<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <script type="text/javascript">
  	function deletecheck(){
  		alert("${content_view.bId}");
  		var result=confirm("정말로 삭제하시겠습니까?\n 삭제시 복구가 어렵습니다.");
  		if(result==true){
  			alert("삭제를 진행합니다.");
  			window.location.href='delete.do?bId=${content_view.bId}';
  		}else{
  			alert("삭제취소");
  		}
  	}
  </script>
  
  <c:if test="${check==1 }">
  	<script type="text/javascript">
  		alert("저장이 정상적으로 완료되었습니다.");
  	</script>
  </c:if>
  <c:if test="${check==0 }">
  	<script type="text/javascript">
  		alert("저장이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
		history.back(-1);
  	</script>
  </c:if>
  
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
        <th colspan="3"><span>제목 : </span>${content_view.bTitle }</th>
      </tr>
      <tr>
        <td>번호 : <strong>${content_view.bId }</strong></td>
        <td>작성자</td>
        <td>${content_view.bName }</td>
      </tr>
      <tr>
        <td>작성일 : ${content_view.bDate }</td>
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

    <a href="list.do">
	    <div class="list">
	   		 목록
	    </div>
    </a>
    <a onclick="deletecheck()" style="cursor: pointer;">
	    <div class="list">
	    	삭제
	    </div>
    </a>
    <a href="modify_view.do?bId=${content_view.bId }">
	    <div class="list">
	   		 수정
	    </div>
    </a>
    <a href="reply_view.do?bId=${content_view.bId }">
	    <div class="list">
	   		 답글달기
	    </div>
    </a>
  </section>

  
</body>
</html>