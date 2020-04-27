package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.javalec.ex.BCommand.*;

@WebServlet("*.do")
public class BFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFront() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet들어옴");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost들어옴");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo호출됨");
		
		String pageView=null;
		BCommand bcom=null;
		//페이지 확인
		String uri = request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		System.out.println("페이지 확인"+com);
		
		if(com.equals("/list.do")) {
			//BListcommand 메소드 호출
			bcom = new BListcommand();
			bcom.execute(request, response);
			pageView="list.jsp";
		}
		else if(com.equals("/content_view.do")) {
			bcom = new BContentcommand();
			bcom.execute(request, response);
			pageView = "content_view.jsp";
		}
		else if(com.equals("/write.do")) {
			//bcom = new BWritecommand();
			bcom.execute(request, response);
			pageView = "list.do";
		}
		else if(com.equals("/write_view.do")) {
			pageView="write_view.jsp";
		}
		
		
		//forward
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
	}//actionDo

}//class
