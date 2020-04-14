package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 으로 들어옴");
		try {
			actionDo(request,response);
		} catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 으로 들어옴");
		try {
			actionDo(request,response);
		} catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void actionDo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, SQLException {
		
		String id,pw,name,phone1,phone2,phone3,gender;
		Connection con=null;
		Statement stmt=null;
		
		
		request.setCharacterEncoding("utf-8");
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		String sql = "insert into member2 values"
		+ "('"+id+"','"+pw+"','"+name+"','"+phone1+"','"+phone2+"','"+phone3+"','"+gender+"')";
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
				stmt=con.createStatement();
				int result=stmt.executeUpdate(sql);
				
				
				//저장결과 페이지 분기
				if(result==1) {
					response.sendRedirect("joinResult.jsp");
				}
				else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter writer = response.getWriter();
					writer.println("<html><head>");
					writer.println("<meta charset='utf-8'></head>");
					writer.println("<body>");
					writer.println("<script> alert('저장이 되지 않았습니다. 다시 입력해 주세요.');");
					writer.println("location.href('join.html');</script>");
					writer.println("</body>");
					writer.println("</html>");
					writer.close();
				}
				
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("join.html");
					
//					response.setContentType("text/html;charset=utf-8");
//					PrintWriter writer = response.getWriter();
//					writer.println("<html><head>");
//					writer.println("<meta charset='utf-8'></head>");
//					writer.println("<body>");
//					writer.println("<script> alert('저장이 되지 않았습니다. 다시 입력해 주세요.');");
//					writer.println("location.href('join.html');</script>");
//					writer.println("</body>");
//					writer.println("</html>");
//					writer.close();
				}
				finally {
					try {
						if(stmt!=null) stmt.close();
						if(con!=null) con.close();
						
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
		
		
	}

}
