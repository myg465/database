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

	//db연결 필요 변수
	Context context=null;
	DataSource ds=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	
	ArrayList<BDto> list=new ArrayList<BDto>();
	BDto dto=new BDto();
	
	//데이터를 받는데 필요변수
	String bName,bTitle,bContent;
	int bId,bHit,bGroup,bStep,bIndent,rnum;
	Timestamp bDate;
	
	
	//생성자
	public BDao() {
		//커넥션풀 생성(생성하자마자)
		try {
			context=new InitialContext();
			ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체 select-list
	public ArrayList<BDto> list(int page,int limit) {
		//번호를 붙여서 가져옴(최대 갯수만큼)
		int startrow=(page-1)*10+1;
		int endrow=startrow+limit-1;
		
		sql="select * from (select rownum rnum,bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent from"+ 
			"(select * from mvc_board order by bGroup desc,bid asc)) where rnum>=? and rnum<=?";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				rnum=rs.getInt("rnum");
				bId=rs.getInt("bId");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				bHit=rs.getInt("bHit");
				bDate=rs.getTimestamp("bDate");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");

				dto=new BDto(rnum,bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
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
		
	}//전체 select
	
	
	//1개 얻어오기
	public BDto content_view(int bId) {
		
		plusHit(bId);
		
		sql="select from mvc_board where bId=?";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bId);
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
				
				dto=new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
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
	
	//조회수 증가 메소드
	public void plusHit(int bId) {
		sql="update mvc_board set bHit=bHit+1 where bId=?";
		try {
			con=ds.getConnection();
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
	}//plusHit
	
	//앞뒤글 제목 얻어오기
	public String[] broconget(int bId) {
		String[]result=new String[2];
		sql="select bTitle from mvc_board where bId in(?,?)";
		
		
		
	}
	
	
	
	
	//전체 카운트 얻어오기
	public int getlistCount() {
		
		int count=0;
		
		sql="select count(*) as count from mvc_board";
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count");
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
		
		return count;
	}//전체 카운트 얻어오기
	
	
	
}//class
