package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BWritecommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		
		BDao dao = BDao.getInstance();
		int check=dao.write(bName,bTitle,bContent);
		
		request.setAttribute("check", check);
		
	}

}
