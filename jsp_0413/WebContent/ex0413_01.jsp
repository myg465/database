<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	float salary;
	int employee_id;
	String emp_name,job_id=null;
	String sort;
	
	//정렬기준 선택
	void sh_ch(String ch){
		switch(ch){
		case "sort1":
			sort="employee_id asc";
			break;
		case "sort2":
			sort="employee_id desc";
			break;
		case "sort3":
			sort="salary asc";
			break;
		case "sort4":
			sort="salary desc";
			break;
		}
	}
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		//jdbc연결은 try-catch문에 입력
		try{
			//jdbc연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection연결
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl", "ora_user", "1234");
			//statement객체 생성
			stmt = con.createStatement();
			//넘어온값, sql구문 선언
			
			String start,end,sql=null;
			sh_ch(request.getParameter("sort_type"));
			
			
			
			if(request.getParameter("sh_ch").equals("2")){
			start= request.getParameter("start");
			end= request.getParameter("end");
			sql="select employee_id,emp_name,salary,job_id from employees "
					+"where salary between "+start+" and "+end+" order by "+sort;
			}
			else{
				String name= request.getParameter("name");
				sql="select employee_id,emp_name,salary,job_id from employees "
						+"where emp_name like '%"+name+"%' order by "+sort;
			}
			
			
			rs = stmt.executeQuery(sql);
			out.println("<h2>회원정보</h2>");
			while(rs.next()){
				employee_id=rs.getInt("employee_id");
				emp_name=rs.getString("emp_name");
				salary=rs.getFloat("salary");
				job_id=rs.getString("job_id");
				
				out.println("사원번호 : "+employee_id+" ");
				out.println("사원이름 : "+emp_name+" ");
				out.println("월급 : "+salary+" ");
				out.println("부서명 : "+job_id+"<br>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
				try{
					if(rs != null) rs.close();
					if(stmt != null)stmt.close();
					if(con != null)con.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
		}
		
		
		%>
		
		<a href="form.html">다시 검색하기</a>
		
	</body>
</html>