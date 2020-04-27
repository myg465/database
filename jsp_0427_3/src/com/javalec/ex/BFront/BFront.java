package com.javalec.ex.BFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BCommand.BCommand;
import com.javalec.ex.BCommand.BListcommand;

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
		System.out.println("actionDo들어옴");
		//패스얻기
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		//이동할 페이지 선언
		String pageView=null;
		BCommand comm=null;
		
		if(com.equals("/list.do")) {
			comm=new BListcommand();
			comm.execute(request, response);
			pageView="list.jsp";
		}
		
		//requestDispatcher에 객체 담아서 보내기
		RequestDispatcher dispatcher =request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
		
		
		
	}

}
