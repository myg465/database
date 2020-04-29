<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//int listcount=Integer.parseInt((String)request.getAttribute("listcount")); -->에러남
	//int listcount =((Integer)request.getAttribute("listcount")).intValue();
	//int listcount=Integer.parseInt(request.getAttribute("listcount")).toString;
	//int nowpage=((Integer)request.getAttribute("page")).intValue();
	//int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	//int startpage=((Integer)request.getAttribute("startpage")).intValue();
	//int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>

<!DOCTYPE html>
<html>
	<head>
	  <title>게시판리스트</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/notice_list.css">
	</head>
	<body>
		<section>
		    <h1>NOTICE</h1>
		    <div class="wrapper">
		      <form action="/search" name="search" method="post">
		        <select name="category" id="category">
		          <option value="0">전체</option>
		          <option value="title">제목</option>
		          <option value="content">내용</option>
		        </select>
		
		        <div class="title">
		          <input type="text" size="16">
		        </div>
		  
		        <button type="submit"><i class="fas fa-search"></i></button>
		      </form>
		    </div>
		
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
		      <c:forEach var="dto" items="${list }">
			      <tr>
			        <td>
				        <span class="table-notice">
				      	  	${dto.bId }
				        </span>
			        </td>
			        <td class="table-title">
				        <a href="content_view.do?bId=${dto.bId }&page=${page}" >
				        	<!-- 댓글일 경우 들여쓰기 부분 -->
				        	<c:forEach begin="1" end="${dto.bIndent }">&nbsp;&nbsp;→</c:forEach>
				        	${dto.bTitle }
				        	
				        </a>
			        </td>
			        <td>${dto.bDate }</td>
			        <td>${dto.bHit }</td>
			      </tr>
		      </c:forEach>
		    </table>
		    
		    
			<!-- 하단버튼 -->
		    <ul class="page-num">
		    	<!-- 첫페이지 이동 -->
		      <a href="list.do?page=1">
		      	<li class="first"></li>
		      </a>
		      <!-- 이전페이지 이동 -->
		      <c:if test="${page<=1 }">
		      	<li class="prev"></li>
		      </c:if>
		      
		      <c:if test="${page>1 }">
		      	<a href="list.do?page=${page-1 }">
		      		<li class="prev"></li>
		      	</a>
		      </c:if>
		      
		      <!-- 순차적 페이지 번호 출력 -->
		      <c:forEach var="a" begin="${startpage }" end="${endpage }" step="1">
		      	<c:choose>
					<c:when test="${a==page }">
						<li class="num">
							  <div>${a }</div>
						</li>
					</c:when>
					
					<c:when test="${a!=page }">
						<a href="list.do?page=${a }">
							<li class="num">
								  <div>${a }</div>
							 </li>
						</a>
					</c:when>
				</c:choose>
		      </c:forEach>
		      
		      <!-- 다음페이지 이동 -->
		      <c:if test="${page>=maxpage }">
		      	<li class="next"></li>
		      </c:if>
		      <c:if test="${page<maxpage }">
			    <a href="list.do?page=${page+1 }">
			    	<li class="next"></li>
			    </a>
		      </c:if>
		      
		      <!-- 마지막페이지 이동 -->
		      <a href="list.do?page=${maxpage }">
		    	  <li class="last"></li>
		      </a>
		      
		    </ul>
		
		    <a href="#">
		      <div class="write">쓰기</div>
		    </a>
		</section>
	</body>
</html>