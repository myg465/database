package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Bcommand.Bcommand;
import com.javalec.ex.Bcommand.Blistcommand;

@WebServlet("*.do")
public class BFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFront() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 들어옴");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 들어옴");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo 호출");
		request.setCharacterEncoding("utf-8");
		
		//보낼 페이지
		String viewPage=null;
		//커맨드 인터페이스 선언
		Bcommand comm=null;
		// /jsp_0427/list.do
		String uri = request.getRequestURI();
		// /jsp_0427
		String conPath = request.getContextPath();
		// /list.do
		String com = uri.substring(conPath.length());
		//호출 페이지 분기
		//전체읽기 페이지
		if(com.equals("/list.do")) {
			comm=new Blistcommand(); //상위에 있는 인터페이스로 각각의 커맨드를 선언한다.(부모 형태로 자식을 선언)
			comm.execute(request, response);
			viewPage="list.jsp";
			
			
		}
		//각페이지 읽기 페이지
		else if(com.equals("/content_view.do")) {
			comm=new BContentcommand(); //상위에 있는 인터페이스로 각각의 커맨드를 선언한다.(부모 형태로 자식을 선언)
			comm.execute(request, response);
			viewPage="content_view.jsp";
		}
		
		//쓰기 페이지
		else if(com.equals("/write_view.do")) {
			comm=new BWritecommand(); //상위에 있는 인터페이스로 각각의 커맨드를 선언한다.(부모 형태로 자식을 선언)
			comm.execute(request, response);
			viewPage="write_view.jsp";
		}
		
		//댓글 읽기 페이지
		else if(com.equals("/reply_view.do")) {
			comm=new BRelyViewcommand(); //상위에 있는 인터페이스로 각각의 커맨드를 선언한다.(부모 형태로 자식을 선언)
			comm.execute(request, response);
			viewPage="reply_view.jsp";
		}
		
		
		
		//호출한 페이지 request객체와 함께 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
	}//actionDo
	
	
}//class
