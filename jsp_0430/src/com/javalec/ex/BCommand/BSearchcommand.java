package com.javalec.ex.BCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BSearchcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int page=1;//최초 기본 1페이지 세팅
		int limit=10;//1페이지 = 게시글10개
		int listcount=0;
		//객체선언
		BDao dao = new BDao();
		ArrayList<BDto> dtos= new ArrayList<BDto>();
		
		//넘어온값이 있으면 넘어온것을 그대로 넘겨줌 / 넘어온값이 없으면 1을 넘겨줌
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt((request.getParameter("page"))) ;
		}
		String category="";
		String searchcon="";
		category=request.getParameter("category");
		if(category.equals("whole")) {
			dtos = dao.list(page,limit);
			listcount = dao.getlistCount();
		}
		else {
			searchcon= request.getParameter("searchcon");
			//페이지별 리스트 갯수 가져오기
			dtos = dao.list(page,limit,category,searchcon);
			//전체게시글 카운트
			listcount = dtos.size();
		}
		
		//최대 페이지수
		int maxpage = (int)((double)listcount/limit+0.9);
		//처음 페이지
		int startpage = ((int)((double)page/10+0.9)-1)*10+1;
		//마지막 페이지
		int endpage = maxpage;//1~10까지는 maxpage가 endpage가 되야함
		if(endpage>startpage+10-1) endpage=startpage+10-1;//만약에 11이상의 수가 endpage라면
		
		
		request.setAttribute("list", dtos);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		

	}

}
