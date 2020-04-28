package com.javalec.ex.BDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.BDto.BDto;

public class BDao {

	private BDao() {
		
	}
	
	//싱글턴
	private static BDao instance = new BDao();
	
	public static BDao getInstance() {
		return instance;
	}
	//객체선언
	int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent;
	Timestamp bDate;
	String sql=null;
	
	ArrayList<BDto> list;
	BDto dto=new BDto();
	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//전체글 얻기
	
	public ArrayList<BDto> getBoards(){
		sql="select * from mvc_board order by bGroup desc , bStep asc";
		list=new ArrayList<BDto>();
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new BDto();
				dto.setbId(rs.getInt("bId"));
				dto.setbName(rs.getString("bName"));
				dto.setbTitle(rs.getString("bTitle"));
				dto.setbContent(rs.getString("bContent"));
				dto.setbDate(rs.getTimestamp("bDate"));
				dto.setbHit(rs.getInt("bHit"));
				dto.setbGroup(rs.getInt("bGroup"));
				dto.setbStep(rs.getInt("bStep"));
				dto.setbIndent(rs.getInt("bIndent"));
				
				list.add(dto);
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
	}//전체글 얻기
	
	//contentView(select)
	public BDto content_view(int bId) {
		plusHit(bId);
		sql="select * from mvc_board where bId=?";
		
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//bId=rs.getInt("bId");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				bDate=rs.getTimestamp("bDate");
				bHit=rs.getInt("bHit");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");
				dto= new BDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, bDate);
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
		
		return dto;
		
	}//content_view
	
	
	//content_view(오버로딩)-답글작성후 답글 불러오는데 사용
	public BDto content_view(int bGroup,int bStep){
		
		sql="select * from mvc_board where bGroup=? and bStep=?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bGroup);
			pstmt.setInt(2, bStep);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bId=rs.getInt("bId");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				bDate=rs.getTimestamp("bDate");
				bHit=rs.getInt("bHit");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");
				dto= new BDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, bDate);
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
		
		return dto;
	}//content_view(오버로딩)
	
	//게시글 등록(insert)
	public int write(String bName,String bTitle,String bContent) {
		
		int check=0;
		sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,mvc_board_seq.currval,0,0)";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
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
		
	}//write
	
	//게시글 삭제(delete)
	public int delete(int bId) {
		
		int check=0;
		sql="delete from mvc_board where bId=?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
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
		
	}//delete
	
	
	//게시글 수정(update)
	public int modify(int bId,String bName,String bTitle,String bContent) {
		
		int check=0;
		sql="update mvc_board set bName=?,bTitle=?,bContent=? where bId=?";
		
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, bId);
			
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
		
	}//update
	
	
	//답글달기(insert)
	public int reply(int bId, String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent) {
		
		int check=0;
		plusStep(bGroup, bStep);
		sql="insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,?,?,?)";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, bGroup);
			pstmt.setInt(5, bStep+1);
			pstmt.setInt(6, bIndent+1);
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

	}//답글달기
	
	
	//step을 1증가 시키는 메소드(update)
	public void plusStep(int bGroup,int bStep) {
		sql="update mvc_board set bStep=bStep+1 where bGroup=? and bStep<?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bGroup);
			pstmt.setInt(2, bStep);
			pstmt.executeUpdate();
			
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
	}//plusStep
	
	
	//hit올리는 메소드
	private void plusHit(int bId) {
		
		sql="update mvc_board set bHit=bHit+1 where bId=?";
		try {
			con=makecon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
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
	}//plusHit(update)
	
	
	//connection얻는 메소드
	private Connection makecon() {
		
		Context context=null;
		DataSource ds=null;
		
		try {
			context=new InitialContext();
			ds= (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			con=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}//makecon
	
	
}//class
