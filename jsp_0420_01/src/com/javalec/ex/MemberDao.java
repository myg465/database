package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {

	MemberDto mdto=new MemberDto();
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	private MemberDao() {
		
	}
	
	public static MemberDao mdao=new MemberDao();
	
	public static MemberDao getInstance() {
		return mdao;
	}
	
	//전체얻기
	public ArrayList<MemberDto> selectAll() {
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		String sql="select * from b_member";
		
		try {
		con=makecon();
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			do {
				String id=rs.getString("id");
				String pw=rs.getString("pw");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String address=rs.getString("address");
				Timestamp b_date=rs.getTimestamp("b_date");
				list.add(new MemberDto(id, pw, name, email, address, b_date));
			}
			while(rs.next());
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
		return list;
	}//selectAll
	
	
	//1개 얻기
	public MemberDto selectOne() {
		return mdto;
	}
	
	//로그인
	public int login_ch(String id,String pw) {
		int check = 0;
		String sql="select * from b_member where id=?";
		String ch_id,ch_pw;
		
		try {
			con = makecon();
			pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ch_id=rs.getString("id");
				ch_pw=rs.getString("pw");
				if(pw.equals(ch_pw)) {
					mdto.setId(rs.getString("id"));
					mdto.setPw(rs.getString("pw"));
					mdto.setName(rs.getString("name"));
					mdto.setEmail(rs.getString("email"));
					mdto.setAddress(rs.getString("address"));
					mdto.setB_date(rs.getTimestamp("b_date"));
					check=1;
				}
				else {
					check=-1;
				}
			}
			else {
				check=0;
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
		
		return check;
		
	}//login_ch
	
	public Connection makecon() {
		try {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
}//class
