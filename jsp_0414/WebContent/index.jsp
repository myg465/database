<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String user_id,user_name,authUser;

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			*{ margin:0; padding:0;}
			
			a{ font-size:12px; color:#666666; text-decoration: none;}
			
			#login_f,#login_after{ width: 332px; height: 120px; border: 2px solid #efefef; margin:120px auto; 
				padding:15px 25px; box-sizing: border-box;}
			
			#login_p{ font-size:12px; color:#888888; }
			
			#login_btn_a{ margin:0 auto;}
			
			#login_btn{ width:280px; height: 37px; margin-top:8px;}
			
			#login_box_end{ float:right;}
			
			#login_f_bottom{ margin-top:8px;}
			
			#m_welcome{ display: block; font-size: 15px; color:#666666;}
			
			.logout_a{ display: inline-block; width:80px; height:20px; border:2px solid #606060; border-radius:5px; 
			text-align: center; margin-top:10px; margin-left:200px; font-weight: bold; }
		</style>
	</head>
	<body>
		<%
			authUser=(String)session.getAttribute("authUser");
			user_name=(String)session.getAttribute("user_name");
			user_id=(String)session.getAttribute("user_id");
		
			if(authUser==null){
				%>
				<!-- 로그인 안된 -->
				<div id="login_f">
				<p id="login_p">네이버를 더 안전하고 편리하게 이용하세요.</p>
				<a href="login.html" id="login_btn_a"><img alt="로그인 버튼" src="img/sp_login_v180727.png" id="login_btn"></a><br>
				<div id="login_f_bottom">
				<a href="#" id="login_box_first">아이디,비밀번호 찾기</a><a href="join.html" id="login_box_end">회원가입</a>
				</div>
				</div>
			<% } else { %>
				<!-- 로그인 된 -->
				<div id="login_after">
				<span id="m_welcome"><strong><%=user_name %></strong>님 환영합니다.</span>
				<a href="logout.jsp" class="logout_a">로그아웃</a>
				<a href="modify.jsp" class="logout_a">회원정보수정</a>
				</div>
				
			<% } %>
		
		
	</body>
</html>