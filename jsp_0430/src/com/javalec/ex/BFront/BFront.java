package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BCommand.*;

@WebServlet("*.do")
public class BFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public BFront() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		String pageView=null;
		BCommand bcom=null;
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		if(com.equals("/list.do")) {
			bcom=new BListcommand();
			bcom.execute(request, response);
			pageView = "list.jsp";
		}
		else if(com.equals("/content_view.do")) {
			bcom=new BContentViewcommand();
			bcom.execute(request, response);
			pageView="content_view.jsp";
		}
		else if(com.equals("/write.do")) {
			bcom=new BWritecommand();
			bcom.execute(request, response);
			pageView="list.do";
		}
		else if(com.equals("/delete.do")) {
			bcom=new BDeletecommand();
			bcom.execute(request, response);
			pageView="list.do";
		}
		else if(com.equals("/modify_view.do")) {
			bcom=new BContentViewcommand();
			bcom.execute(request, response);
			pageView="modify_view.jsp";
		}
		else if(com.equals("/modify.do")) {
			bcom=new BModifycommand();
			bcom.execute(request, response);
			pageView="content_view.jsp";
		}
		else if(com.equals("/reply_view.do")) {
			bcom=new BContentViewcommand();
			bcom.execute(request, response);
			pageView="reply_view.jsp";
		}
		else if(com.equals("/reply.do")) {
			bcom=new BReplycommand();
			bcom.execute(request, response);
			pageView="list.do";
		}
		else if(com.equals("/search.do")) {
			bcom=new BSearchcommand();
			bcom.execute(request, response);
			pageView="list.jsp";
		}
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
		
	}//action
	

}//class
