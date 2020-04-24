package com.javalec.ex.Bcon;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.DAO.MemberDao;
import com.javalec.ex.DTO.MemberDto;

@WebServlet("*.do")
public class BfrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BfrontCon() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet 들어옴");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost 들어옴");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		//페이지 이동에 사용하는 변수
		String viewPage=null;
		
		System.out.println("actionDo 들어옴");
		request.setCharacterEncoding("utf-8");
		
		//컨텍스트패스/ 파일명 까지 넘어옴 (/jsp0424/insert)
		//주소전체는 url
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//컨테스트패스-> 프로젝트명 (jsp_0424)
		String conPath = request.getContextPath();
		System.out.println(conPath);
		
		//파일명만 얻어온다. (/insert)
		String com = uri.substring(conPath.length());
		System.out.println(com); 
		
		
		if(com.equals("/insert.do")) {
			System.out.println("insert 페이지를 요청하였습니다.");
			//insert.jsp로 forwarding
			request.setAttribute("insert_com", com);
			//-> dao메소드 호출해서 값을 받아서 request.setAttribute
			viewPage="insert.jsp";
		}
		
		else if(com.equals("/update.do")) {
			System.out.println("update 페이지를 요청하였습니다.");
			//update.jsp로 forwarding
			request.setAttribute("update_com", com);
			viewPage="update.jsp";
		}
		
		else if(com.equals("/select.do")) {
			System.out.println("select 페이지를 요청하였습니다.");
			ArrayList<MemberDto> list = new ArrayList<MemberDto>();
			MemberDao mdao = MemberDao.getInstance();
			list = mdao.getMembers();
			request.setAttribute("dtos", list);
			//select.jsp로 forwarding
			//dao메소드 호출
			request.setAttribute("select_address", com);
			viewPage="select.jsp";
		}
		
		else if(com.equals("/delete.do")) {
			System.out.println("delete 페이지를 요청하였습니다.");
			//delete.jsp로 forwarding
			request.setAttribute("delete_com", com);
			viewPage="delete.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
		
	}

}
