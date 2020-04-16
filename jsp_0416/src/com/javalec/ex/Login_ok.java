package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login_ok")
public class Login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String id,pw;
	
	String sql;
	
	
    public Login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet으로 들어옴");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost으로 들어옴");
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		id=request.getParameter("id");
		pw=request.getParameter("pw");
		sql="select\r\n" + 
			"id,pw\r\n" + 
			"from\r\n" + 
			"lms_member\r\n" + 
			"where\r\n" + 
			"id='"+id+"' and pw='"+pw+"'";
		
		try {
			//db연결부분
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				//id,pw 데이터가 있는경우
				id=rs.getString("id");
				pw=rs.getString("pw");
				//섹션추가
				HttpSession session = request.getSession();
				session.setAttribute("user_id", id);
				session.setAttribute("user_pw", pw);
				session.setAttribute("authUser", id);
				
				response.sendRedirect("main.jsp");
				
			}else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.println("<html><head></head><body>");
				writer.println("<script>");
				writer.println("alert('아이디나 비밀번호가 틀립니다.');");
				writer.println("history.back(-1);");
				writer.println("</script>");
				writer.println("</body></html>");
			}
			
			
//			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer=response.getWriter();
			writer.println("<html><head></head><body>");
			writer.println("<script>");
			writer.println("alert('아이디나 비밀번호가 틀립니다.');");
			writer.println("history.back(-1);");
			writer.println("</script>");
			writer.println("</body></html>");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.println("<html><head></head><body>");
				writer.println("<script>");
				writer.println("alert('아이디나 비밀번호가 틀립니다.');");
				writer.println("history.back(-1);");
				writer.println("</script>");
				writer.println("</body></html>");
			}
			
		}
		
	}

}
