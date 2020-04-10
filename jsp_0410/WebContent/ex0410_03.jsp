<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	int id;
	int grade;
	String name;
	String payok;
	String subject;
	int price;
	String payroot;

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
		<h2>학생정보</h2>
		<table>
			<tr>
				<th>학번</th>
				<th>학년</th>
				<th>이름</th>
				<th>납부여부</th>
				<th>과목</th>
				<th>가격</th>
				<th>납부방법</th>
			</tr>
			
			<%
			
			try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user", "1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from member3 order by id asc");
			
			while(rs.next()){
				id=rs.getInt("id");
				grade=rs.getInt("grade");
				name=rs.getString("name");
				payok=rs.getString("payok");
				subject=rs.getString("subject");
				price=rs.getInt("price");
				payroot=rs.getString("payroot");
				
				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+grade+"</td>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+payok+"</td>");
				out.println("<td>"+subject+"</td>");
				out.println("<td>"+price+"</td>");
				out.println("<td>"+payroot+"</td>");
				out.println("</tr>");
				} //while
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
					
				}catch(Exception e2){
					e2.printStackTrace();
				}
			} //finally
			
			%>		
		</table>
	</body>
</html>