package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BReplycommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int page=Integer.parseInt(request.getParameter("page"));
		int bId=Integer.parseInt(request.getParameter("bId"));
		int bGroup=Integer.parseInt(request.getParameter("bGroup"));
		int bStep=Integer.parseInt(request.getParameter("bStep"));
		int bIndent=Integer.parseInt(request.getParameter("bIndent"));
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		
		BDao dao=new BDao();
		int check=dao.reply(bId,bGroup,bStep,bIndent,bName,bTitle,bContent);
		
		
		request.setAttribute("page", page);
		request.setAttribute("check", check);
		
		
	}

}
