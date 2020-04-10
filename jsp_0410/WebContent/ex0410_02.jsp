<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	String id;
	String pw;
	String name;
	int hobby1;
	int hobby2;
	int hobby3;
	int hobby4;
	String gender;
	String address;
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{ width: 1000px; border-collapse: collapse;
				text-align: center; font-size: 20px; margin:50px auto;}
			tr,th,td{ border: 1px solid black;}
			h2{ width:1000px; margin:30px auto; text-align: center;
				font-size: 30px;}
		</style>
	</head>
	<body>
	
	
		<table>
			<h2>KOITT 회원정보 현황</h2>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>취미1</th>
				<th>취미2</th>
				<th>취미3</th>
				<th>취미4</th>
				<th>성별</th>
				<th>주소</th>
			</tr>
			<%
			try{
				//jdbc 드라이버 연결
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Connection 연결
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
				//sql 실행 객체
				stmt=conn.createStatement();
				String sql="select * from member2";
				//sql을 수행하고 결과를 받아옴
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					id=rs.getString("id");
					pw=rs.getString("pw");
					name=rs.getString("name");
					hobby1=rs.getInt("hobby1");
					hobby2=rs.getInt("hobby2");
					hobby3=rs.getInt("hobby3");
					hobby4=rs.getInt("hobby4");
					gender=rs.getString("gender");
					address=rs.getString("address");
					
			
					
					out.println("<tr>");
					//받은 값을 출력
					out.println("<td>"+id+"</td>");
					out.println("<td>"+pw+"</td>");
					out.println("<td>"+name+"</td>");
					out.println("<td>"+hobby1+"</td>");
					out.println("<td>"+hobby2+"</td>");
					out.println("<td>"+hobby3+"</td>");
					out.println("<td>"+hobby4+"</td>");
					out.println("<td>"+gender+"</td>");
					out.println("<td>"+address+"</td>");
					
					out.println("<tr>");
					
					
				}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(rs !=null) rs.close();
					if(stmt !=null) stmt.close();
					if(conn !=null) conn.close();
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			}
			
			
			
			%>
			
				
		</table>
		
	
	</body>
</html>