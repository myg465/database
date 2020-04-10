<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	Connection conn;
	Statement stmt;
	ResultSet rs;

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
			<tr>
				<th>상품구분</th>
				<th>상품코드</th>
				<th>상품명</th>
				<th>임대인</th>
				<th>보증여부</th>
				<th>연락처</th>
			</tr>
		<%
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ora_user", "1234");
				stmt=conn.createStatement();
				String sql="select * from instrument";
				rs=stmt.executeQuery(sql);
				
				while(rs.next()){
					String type=rs.getString("type");
					int code=rs.getInt("code");
					
				}
				
				
				
				
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
			}
		
		
		
		%>
		
		
		</table>
	</body>
</html>