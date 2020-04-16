<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String authUser = (String)session.getAttribute("authUser");
		if(authUser == null){
			out.println("<script>");
			out.println("alert('로그인을 하지 않았습니다. 로그인 페이지로 이동합니다.');");
			out.println("location.href='login.jsp';");
			out.println("</script>");
		}
%>
<%!
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String id,pw,name,email,address,phone,gender,news,sms;
	String sql;
	Timestamp birth;
	

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		
		// main.jsp 파라미터 값
		try{
			id = request.getParameter("id");
			sql="select * from lms_member where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pw=rs.getString("pw");
				name=rs.getString("name");
				email=rs.getString("email");
				address=rs.getString("address");
				phone=rs.getString("phone");
				birth=rs.getTimestamp("birth");
				gender=rs.getString("gender");
				news=rs.getString("news");
				sms=rs.getString("sms");
			%>
			<!-- 데이터 html 부분 추가 -->
			<h2>회원정보 수정</h2>
			<form action="Modify_Ok" name="modify" method="post">
				아이디 : <input type="text" name="id" readonly value=<%=id%>><br>
				패스워드 : <input type="password" name="pw" value=<%=pw%>><br>	
				이름 : <input type="text" name="name" value=<%=name%>><br>
				이메일 : <input type="email" name="email" value=<%=email%>><br>
				주소 : <input type="text" name="address" value=<%=address%>><br>
				전화번호 : <input type="text" name="phone" value=<%=phone%>><br>
				생일 : <input type="date" name="birth" value=<%=birth%>><br>
				<p>성별 :</p>
				<%
					switch(gender){
						case "남성":
				%>
				<input type="radio" name="gender" value="남성" checked>남성
				<input type="radio" name="gender" value="여성">여성<br>			
				
				<% 			
							break;
						case "여성":
				%>
				<input type="radio" name="gender" value="남성">남성
				<input type="radio" name="gender" value="여성" checked>여성<br>	
				
				<% 			
							break;
					   }
				%>
				
				<!-- 뉴스레터 받기 여부 -->
				
				<p>뉴스레터 받기 여부</p>
				
				<%
					switch(news){
						case "예":
				%>
				<input type="radio" name="news" value="예" checked>예
				<input type="radio" name="news" value="아니오">아니오		
				
				<% 			
							break;
						case "아니오":
				%>
				<input type="radio" name="news" value="예">예
				<input type="radio" name="news" value="아니오" checked>아니오	
				
				<% 			
							break;
					   }
				%>
				
				<!-- sms수신여부 -->
				
				<p>sms수신여부</p>
				
				<%
					switch(sms){
						case "예":
				%>
				<input type="radio" name="sms" value="예" checked>예
				<input type="radio" name="sms" value="아니오">아니오		
				
				<% 			
							break;
						case "아니오":
				%>
				<input type="radio" name="sms" value="예">예
				<input type="radio" name="sms" value="아니오" checked>아니오	
				
				<% 			
							break;
					   }
				%>
				
				
				
			 	
			<% } %>
			
			<input type="submit" value="전송">
			<input type="reset" value="취소"><br>
		</form>
		<% 	
		}catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		
		%>
		
	</body>
</html>