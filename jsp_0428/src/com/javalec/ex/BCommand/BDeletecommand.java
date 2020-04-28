package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;

public class BDeletecommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId=Integer.parseInt(request.getParameter("bId"));
		BDao dao = BDao.getInstance();
		int check = dao.delete(bId);
		
		request.setAttribute("check", check);
	}

}
