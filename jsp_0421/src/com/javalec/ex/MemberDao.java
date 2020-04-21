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
	String id, pw, name, email, address1, address2, address3;
	Timestamp b_date, u_date;
	MemberDto mdto=new MemberDto();
	String sql;
	PreparedStatement pstmt=null;
	Connection con=null;
	ResultSet rs=null;
	
	private MemberDao() {
		
	}
	
	public static MemberDao mdao=new MemberDao();
	
	public static MemberDao getInstance() {
		return mdao;
	}
	
	
	//아이디 중복체크
	public int confirmId(String id) {
		
		int check=0;
		sql = "select id from b_member where id=?";
		try {
			
			con = makecon();  //context에서 커넥션 가져오기
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//중복 아이디가 존재
				check = 1; //아이디가 있을때 1
			} else {
				//중복 아이디가 없음
				check = 0; //아이디가 없을때 0
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
	}//confirmId
	
	//------------------------------------------------------------------------------------------------
	
	//회원가입 입력 메소드
	public int insertMember(MemberDto mdto) {
		
		int check=0;
		sql = "insert into b_member (id,pw,name,email,address1,address2,address3) values (?,?,?,?,?,?,?)";
		try {
			con = makecon();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setString(5, mdto.getAddress1());
			pstmt.setString(6, mdto.getAddress2());
			pstmt.setString(7, mdto.getAddress3());
			
			check = pstmt.executeUpdate(); //저장 1, 저장안됨0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return check;
		
	} //insertMember
	
	//------------------------------------------------------------------------------------------------
	
	//update 메소드
	public int updateMember(MemberDto mdto) {
		int check = 0;
		sql = "update b_member set pw=?,name=?,email=?,u_date=sysdate,address1=?,address2=?,address3=? where id=?";
		
		try {
			con = makecon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getPw());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getEmail());
			pstmt.setString(4, mdto.getAddress1());
			pstmt.setString(5, mdto.getAddress2());
			pstmt.setString(6, mdto.getAddress3());
			pstmt.setString(7, mdto.getId());
			check=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return check;
	}//updateMember
	
	//------------------------------------------------------------------------------------------------
	
	//delete메소드
	public int deleteMember(String id) {
		
		int check = 0;
		sql = "delete b_member where id=?";
		
		try {
			con = makecon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return check;
	} //deleteMember
	
	//------------------------------------------------------------------------------------------------
	
	//전체 출력
	public ArrayList<MemberDto> selectAll() {
		
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		sql="select * from b_member order by b_date desc";
		
		try {
		con=makecon();
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			do {
				 id=rs.getString("id");
				 pw=rs.getString("pw");
				 name=rs.getString("name");
				 email=rs.getString("email");
				 address1=rs.getString("address1");
				 address2=rs.getString("address2");
				 address3=rs.getString("address3");
				 b_date=rs.getTimestamp("b_date");
				 u_date=rs.getTimestamp("u_date");
				 
				list.add(new MemberDto(id, pw, name, email, address1, address2, address3, b_date, u_date));
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
	
	//------------------------------------------------------------------------------------------------
	
	//1개의 정보 가져오기
	public MemberDto selectOne(String id) {
		sql="select * from b_member where id=?";
		
		try {
			con = makecon();
			pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
					mdto.setId(rs.getString("id"));
					mdto.setPw(rs.getString("pw"));
					mdto.setName(rs.getString("name"));
					mdto.setEmail(rs.getString("email"));
					if(rs.getString("address1").equals("null")) {
						 mdto.setAddress1("");
					 }else {
						 mdto.setAddress1(rs.getString("address1"));
					 }
					 
					 if(rs.getString("address2").equals("null")) {
						 mdto.setAddress2("");
					 }else {
						 mdto.setAddress2(rs.getString("address2"));
					 }
					 
					 if(rs.getString("address3").equals("null")) {
						 mdto.setAddress3("");
					 }else {
						 mdto.setAddress3(rs.getString("address3"));
					 }
					mdto.setB_date(rs.getTimestamp("b_date"));
					mdto.setU_date(rs.getTimestamp("u_date"));
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
		return mdto;
	}
	
	//------------------------------------------------------------------------------------------------
	
	//로그인
	public int login_ch(String id,String pw) {
		
		int check = 0;
		sql="select * from b_member where id=?";
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
	
	//------------------------------------------------------------------------------------------------
	
	//connect 생성 메소드
	public Connection makecon() {
		
		Context context=null;
		DataSource ds=null;
		try {
		context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}//makecon
	
	
}//class
