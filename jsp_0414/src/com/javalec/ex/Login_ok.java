package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	
	
	//프로그램 구현
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("utf-8");
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String id,pw,name,phone1,phone2,phone3,gender;
		
		id=request.getParameter("n_id");
		pw=request.getParameter("n_pw");
		
		String sql="select * from member2 where id='"+id+"' and pw='"+pw+"'";
		//db에서 id,pw 검색후 비교
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql); //select는 query, insert/update/delete는 update
			ResultSetMetaData rsmd=null;
			rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			//id,pw가 있을때
			if(count!=0) {
				
				
				
				while(rs.next()) {
					id=rs.getString("id");
					pw=rs.getString("pw");
					name=rs.getString("name");
					phone1=rs.getString("phone1");
					phone2=rs.getString("phone2");
					phone3=rs.getString("phone3");
					gender=rs.getString("gender");
					
					//섹션 가지고 오기(바로 쓸수 없음)
					HttpSession session=request.getSession();
					session.setAttribute("user_pw", pw);
					session.setAttribute("user_id", id);
					session.setAttribute("user_name", name);
					session.setAttribute("authUser", id);
					
					response.sendRedirect("index.jsp");
					
				}
				
			}
			//id.pw가 없을때
			else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.println("<html><head></head><body>");
				writer.println("<script>");
				writer.println("alert('비밀번호가 틀립니다.');");
				writer.println("history.back(-1);");
				writer.println("</script>");
				writer.println("</body></html>");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer=response.getWriter();
			writer.println("<html><head></head><body>");
			writer.println("<script>");
			writer.println("alert('비밀번호가 틀립니다.');");
			writer.println("history.back(-1);");
			writer.println("</script>");
			writer.println("</body></html>");
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}
			catch(Exception e2) {
				e2.printStackTrace();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.println("<html><head></head><body>");
				writer.println("<script>");
				writer.println("alert('비밀번호가 틀립니다.');");
				writer.println("history.back(-1);");
				writer.println("</script>");
				writer.println("</body></html>");
			}
		}
		
	}

}
