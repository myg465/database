package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.ws.Response;

public class MemberDao {

	ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
	DataSource dataSource;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql;
	int j_num;
	String id,pw,email,address,gender,news,sms,name,phone;
	Timestamp birth,j_date;
	public MemberDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<MemberDto> memberselect(){
		try {
			sql="select * from member3 order by j_num asc";
			
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				j_num=rs.getInt("j_num");
				id=rs.getString("id");
				pw=rs.getString("pw");
				email=rs.getString("email");
				address=rs.getString("address");
				gender=rs.getString("gender");
				news=rs.getString("news");
				sms=rs.getString("sms");
				name=rs.getString("name");
				phone=rs.getString("phone");
				birth=rs.getTimestamp("birth");
				j_date=rs.getTimestamp("j_date");
				
				MemberDto mdto=new MemberDto(j_num, id, pw, email, address, birth, gender, news, sms, j_date, name, phone);
				dtos.add(mdto);
			}//while
			
			
			
		}//try
		catch(Exception e) {
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
		}//finally
		
		return dtos;
		
		
	}//member select method
	
	
	
	public int reg_member(String id, String pw, String email, String address, Timestamp birth, 
			String gender,String news, String sms, String name,String phone) {
		
		int check = 0;
		
		try {
			
		
		sql="insert into member3(id,pw,email,address,birth,gender,news,sms,name,phone) values (?,?,?,?,?,?,?,?,?)";
		
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		pstmt.setString(3,email);
		pstmt.setString(4,address);
		pstmt.setTimestamp(5,birth);
		pstmt.setString(6,gender);
		pstmt.setString(7,news);
		pstmt.setString(8,sms);
		pstmt.setString(9,name);
		pstmt.setString(10,phone);
		
		check = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return check;
		
	}
	
	
	
	
	
	
	
	
}
