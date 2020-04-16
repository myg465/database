package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Modify_Ok")
public class Modify_Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Connection con=null;
	PreparedStatement pstmt=null;
	
	String id,pw,name,email,address,phone,gender,news,sms,birth;
	String sql;
	
	int check;
	
    public Modify_Ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Modify_Ok doGet으로 실행");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Modify_Ok doPost으로 실행");
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			email = request.getParameter("email");
			address = request.getParameter("address");
			phone = request.getParameter("phone");
			birth = request.getParameter("birth");
			gender = request.getParameter("gender");
			news = request.getParameter("news");
			sms = request.getParameter("sms");
			
			sql="update lms_member set pw=?,name=?,email=?,address=?,phone=?,birth=?,gender=?,news=?,sms=? where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, phone);
			pstmt.setString(6, birth);
			pstmt.setString(7, gender);
			pstmt.setString(8, news);
			pstmt.setString(9, sms);
			pstmt.setString(10, id);
			check = pstmt.executeUpdate();
			
			if(check==1) {
				response.sendRedirect("main.jsp");
			}
			else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.println("<html><head></head><body>");
				writer.println("<script>");
				writer.println("alert('저장되지 않았습니다. 다시 시도해 주세요.');");
				writer.println("history.back(-1);");
				writer.println("</script>");
				writer.println("</body></html>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer=response.getWriter();
			writer.println("<html><head></head><body>");
			writer.println("<script>");
			writer.println("alert('저장되지 않았습니다. 다시 시도해 주세요.');");
			writer.println("history.back(-1);");
			writer.println("</script>");
			writer.println("</body></html>");
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.println("<html><head></head><body>");
				writer.println("<script>");
				writer.println("alert('저장되지 않았습니다. 다시 시도해 주세요.');");
				writer.println("history.back(-1);");
				writer.println("</script>");
				writer.println("</body></html>");
			}
		}
		
	
	
	}

}
