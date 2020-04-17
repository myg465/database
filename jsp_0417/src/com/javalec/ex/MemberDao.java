package com.javalec.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	
	
	//전역변수
	ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
	//db접속에 필요한 객체선언
	DataSource dataSource;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String sql;
	String id,pw,name,phone1,phone2,phone3,gender;
	
	
	//생성자
	public MemberDao() {
		//jdbc로딩 -> connection연결 -> preparedStatement연결 -> executeQuery(Update)로 질의
		
		try {
			//객체 선언시 바로 jdbc Connection 연결
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//전체 리스트 출력
	
	public ArrayList<MemberDto> member_Select() { 
		
		//db연결
		try {
			
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			
			sql="select * from member2";
			
			con = dataSource.getConnection();
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//데이터담기
			while(rs.next()) {
				id=rs.getString("id");
				pw=rs.getString("pw");
				name=rs.getString("name");
				phone1=rs.getString("phone1");
				phone2=rs.getString("phone2");
				phone3=rs.getString("phone3");
				gender=rs.getString("gender");
				
				MemberDto mdto = new MemberDto(id,pw,name,phone1,phone2,phone3,gender);
				
				dtos.add(mdto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		//리턴 값으로 돌려줌
		
		return dtos;
	}
	
	
	
}
