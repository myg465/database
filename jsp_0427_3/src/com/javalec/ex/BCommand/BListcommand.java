package com.javalec.ex.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class BListcommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		BDao bdao = BDao.getInstance();
		ArrayList<BDto> dtos = bdao.getBoards();
		
		request.setAttribute("list", dtos);
	
	}//execute

}//class
