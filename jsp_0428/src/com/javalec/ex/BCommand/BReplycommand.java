package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BReplycommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int bId=Integer.parseInt(request.getParameter("bId"));
		String bName= request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		int bGroup=Integer.parseInt(request.getParameter("bGroup"));
		int bStep=Integer.parseInt(request.getParameter("bStep"));
		int bIndent=Integer.parseInt(request.getParameter("bIndent"));
		
		BDao dao= BDao.getInstance();
		int check=dao.reply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent);
		BDto dto = dao.content_view(bGroup, bStep+1);
		
		
		request.setAttribute("content_view", dto);
		request.setAttribute("check", check);
		
		
	}

}
