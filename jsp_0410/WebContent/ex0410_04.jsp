<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
		
			try{
			//jdbc 연결부분(톰캣과 jdbc가 연결됨)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//jdbc와 oracle을 연결하는 커넥션을 만들어주는 부분
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ora_user", "1234");
			//sql구문을 실행시킬수 있는 객체생성(Statement)
			stmt = conn.createStatement();
			//sql query구문 작성
			String sql="select * from member4";
			//sql실행후 결과를 resultset에 저장
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int stu_num=rs.getInt("stu_num");
				int grade=rs.getInt("grade");
				String name=rs.getString("name");
				int pay=rs.getInt("pay");
				String pay_str="";
				switch(pay){
					case 0:
						pay_str="아니오";
						break;
					case 1:
						pay_str="예";
						break;
						
				}
				String subject=rs.getString("subject");
				int fee=rs.getInt("fee");
				String pay_type=rs.getString("pay_type");
				
				out.println("학번 : "+stu_num+"<br>");
				out.println("학년 : "+grade+"<br>");
				out.println("이름 : "+name+"<br>");
				out.println("지불여부 : "+pay_str+"<br>");
				out.println("과목 : "+subject+"<br>");
				out.println("수강료 : "+fee+"<br>");
				out.println("납부유형 : "+pay_type+"<br>");
				out.println("---------------------------------<br>");
				
				
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
		
		
	</body>
</html>