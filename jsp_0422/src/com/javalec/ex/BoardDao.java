package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private BoardDao () {
		
	}
	//싱글톤 패턴 생성
	public static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	//공통변수선언
	BoardDao bdao=null;
	BoardDto bdto=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String b_title="";
	String b_content="";
	String b_user="";
	String b_file="";
	int b_num = 0;
	String sql="";
	
	//----------------------------------------------------------------------------
	//게시글 입력 메소드
	
	public int insertBoard(String b_title,String b_content,String b_user,String b_file) {
		int check = 0;
		sql="insert into board values(b_num_seq.nextval,?,?,?,?)";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, b_title);
			pstmt.setString(2, b_content);
			pstmt.setString(3, b_user);
			pstmt.setString(4, b_file);
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
	} //insertBoard
	
	//----------------------------------------------------------------------------
	//한개 얻어오는 메소드
	
	public BoardDto getOneBoard(int b_num) {
		sql="select * from board where b_num=?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto=new BoardDto();
				bdto.setB_num(rs.getInt("b_num"));
				bdto.setB_title(rs.getString("b_title"));
				bdto.setB_content(rs.getString("b_content"));
				bdto.setB_user(rs.getString("b_user"));
				bdto.setB_file(rs.getString("b_file"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return bdto;
		
	}//getOneBoard
	
	//----------------------------------------------------------------------------
	//수정 메소드
	
	public int modifyBoard(int b_num, String b_title, String b_content, String b_user, String b_file) {
		
		int check = 0;
		sql="update board set b_title=?, b_content=?, b_user=?, b_file=? where b_num=?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, b_title);
			pstmt.setString(2, b_content);
			pstmt.setString(3, b_user);
			pstmt.setString(4, b_file);
			pstmt.setInt(5, b_num);
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
		
	} //modifyBoard
	
	//----------------------------------------------------------------------------
	//삭제 메소드
	
	public int deleteBoard(int b_num) {
		int check = 0;
		sql="delete from board where b_num=?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
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
	}

	
	//----------------------------------------------------------------------------
	//전체 출력 메소드
	
	public ArrayList<BoardDto> getBoards(){
		
		ArrayList<BoardDto>list=new ArrayList<BoardDto>();
		sql="select * from board order by b_num asc";
		
		try {
			con = makecon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					bdto=new BoardDto();
					b_num=rs.getInt("b_num");
					b_title=rs.getString("b_title");
					b_content=rs.getString("b_content");
					b_user=rs.getString("b_user");
					b_file=rs.getString("b_file");
					list.add(new BoardDto(b_num, b_title, b_content, b_user, b_file));
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
	} // getBoards
	
	//----------------------------------------------------------------------------
	//connection 생성 메소드
	public Connection makecon() {
		Context context=null;
		DataSource ds=null;
		try {
			context=new InitialContext();
			ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}//makecon
	
	
}//class
