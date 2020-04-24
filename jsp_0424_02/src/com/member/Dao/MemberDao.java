package com.member.Dao;

import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.Dto.MemberDto;

public class MemberDao {
	
	private MemberDao() {
		
	}
	
	
	private static MemberDao Instance = new MemberDao();
	//싱글톤
	
	public MemberDao getInstance() {
		
		return Instance;
	}
	//select all
	public ArrayList<MemberDto> getMembers(){
		
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		
		
		
		
		return list;
	}//getMembers
	
	
	//추가하기
	public int insertMember(MemberDto mdto) {
		
		int check=0;
		
		
		
		return check;
		
	}//insertMember
	
	//수정하기
	public int updateMember(String id) {
		
		int check=0;
		
		
		return check;
		
	}//updateMember
	
	//삭제하기
	public int deleteMember(String id) {
		
		int check = 0;
		
		
		
		return check;
		
	}//deleteMember
	
	public Connection makeCon() {
		
		Context context=null;
		DataSource ds=null;
		Connection con=null;
		
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}//class
