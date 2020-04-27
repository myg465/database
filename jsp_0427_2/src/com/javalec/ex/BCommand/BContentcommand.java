package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BContentcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//String bId=request.getParameter("bId");
		int bId =Integer.parseInt(request.getParameter("bId")) ;
		BDao dao=new BDao();
		BDto dto=dao.contentView(bId);
		request.setAttribute("content_view", dto);
	} // execute

}
