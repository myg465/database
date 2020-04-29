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
    
	//기본 생성자
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
		String uri=request.getRequestURI();// 전체주소
		String conPath=request.getContextPath();//프로젝트 주소
		String com=uri.substring(conPath.length());//파일이름
		
		if(com.equals("/list.do")) {
			//객체 선언
			bcom=new BListcommand();
			bcom.execute(request, response);
			pageView = "list.jsp";
		}
		if(com.equals("/content_view.do")) {
			bcom=new BContentViewcommand();
			bcom.execute(request, response);
			pageView="content_view.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
		
	}//action
	

}//class
