package com.javalec.ex.Bcommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;

public class Blistcommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BDao dao=new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		request.setAttribute("list", dtos);
		
	}

}
