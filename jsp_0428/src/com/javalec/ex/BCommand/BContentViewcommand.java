package com.javalec.ex.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BContentViewcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		BDao dao = BDao.getInstance();
		BDto dto = dao.content_view(bId);
		
		request.setAttribute("content_view", dto);
		

	}

}
