package com.javalec.ex.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BListcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<BDto> list = null;
		BDao dao = BDao.getInstance();
		list=dao.getBoards();
		request.setAttribute("dtos", list);
		
	}//execute

}//class
