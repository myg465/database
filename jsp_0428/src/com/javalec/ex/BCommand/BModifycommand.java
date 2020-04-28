package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BModifycommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId=Integer.parseInt(request.getParameter("bId"));
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		
		BDao dao=BDao.getInstance();
		int check=dao.modify(bId,bName,bTitle,bContent);
		
		request.setAttribute("check", check);

	}

}
