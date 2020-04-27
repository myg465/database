<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	    <link rel="stylesheet" href="css/style.css">
	    <link rel="stylesheet" href="css/notice_list.css">
	    <style>
	    	td{ padding-left:160px;}
	    </style>
	</head>
	<body>
		<table>
	       <colgroup>
		      <col width="18%">
		      <col width="50%">
		      <col width="18%">
		      <col width="10%">
	       </colgroup>
	       <tr>
		     <th>No.</th>
		     <th>제목</th>
		     <th>작성일</th>
		     <th>조회수</th>
		   </tr>
		    <!-- 내용부분 -->
		   <c:forEach var="dtos" items="${list}">
			   <tr>
			     <td>
			      <span class="table-notice">
			      	<!-- 번호 --> ${dtos.bId }
			      </span>
			     </td>
			     <td class="table-title">
			      <a href="#" >
			      	<!-- 제목 --> ${dtos.bTitle }
			      </a>
			     </td>
			     <td>
			     <!-- 작성자 -->${dtos.bName }
			     </td>
			     <td>
			     <!-- 조회수 -->${dtos.bHit }
			     </td>
			   </tr>
		  </c:forEach>
		</table>
	</body>
</html>