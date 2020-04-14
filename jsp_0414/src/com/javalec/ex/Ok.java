package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ok")
public class Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public Ok() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			if(result==1) {
				response.sendRedirect("joinResult.jsp");
			}
			else {
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
			
		}catch(Exception e) {
			e.printStackTrace();
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
