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
public class BFrontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFrontcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet들어옴");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost들어옴");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("actionDo들어옴");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		String pageView="";
		BCommand comm=null;
		
		if(com.equals("/list.do")) {
			//전체 리스트를 가져온다.
			comm=new BListcommand();
			comm.execute(request, response);
			pageView="list.jsp";
		}
		
		else if(com.equals("/content_view.do")) {
			comm=new BContentViewcommand();
			comm.execute(request, response);
			pageView="content_view.jsp";
		}
		else if(com.equals("/delete.do")) {
			comm=new BDeletecommand();
			comm.execute(request, response);
			pageView="list.do";
		}
		else if(com.equals("/write.do")) {
			comm=new BWritecommand();
			comm.execute(request, response);
			pageView="list.do";
		}
		else if(com.equals("/modify_view.do")) {
			comm=new BContentViewcommand();
			comm.execute(request, response);
			pageView="modify_view.jsp";
		}
		else if(com.equals("/modify.do")) {
			comm=new BModifycommand();
			comm.execute(request, response);
			pageView="content_view.do";
		}
		else if(com.equals("/reply_view.do")) {
			comm=new BContentViewcommand();
			comm.execute(request, response);
			pageView="reply_view.jsp";
		}
		else if(com.equals("/reply.do")) {
			comm=new BReplycommand();
			comm.execute(request, response);
			pageView="content_view.jsp";
		}
		
		
		//페이지로 보내준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
	}//actionDo

}//class
