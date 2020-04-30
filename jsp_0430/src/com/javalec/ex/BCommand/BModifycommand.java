package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BModifycommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId=Integer.parseInt(request.getParameter("bId"));
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		int page=Integer.parseInt(request.getParameter("page"));
		
		BDao dao=new BDao();
		int check=dao.modify(bId,bName,bTitle,bContent);
		//수정된 레코드를 다시 가져옴
		BDto dto=dao.content_view(bId);
		
		request.setAttribute("check", check);
		request.setAttribute("page", page);
		request.setAttribute("content_view", dto);
		
		
		
	}

}
