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

	//객체선언(커넥션풀)
	Connection con=null;
	Context context=null;
	DataSource ds=null;
	
	//db접속에 필요한 객체
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	//select할때 필요한것(전체)
	ArrayList<BDto> dtos=new ArrayList<BDto>();
	//select할때 필요한거(부분)
	BDto dto=new BDto();
	
	//데이터 담기용 변수
	int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent;
	Timestamp bDate;
	
	
		//생성하자마자 커넥션풀 연결(객체선언->싱글톤 패턴에서는 메소드로 따로 만듬)
		public BDao() {
			try {
				context=new InitialContext();
				ds=(DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//생성자   
		
		
		//전체 list를 가져옴(select)
		public ArrayList<BDto> list() {
			sql="select * from mvc_board";
			
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
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
					
					dtos.add(dto);
				}//데이터 전달
				
				
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
			return dtos;
		}//전체select
		
		
		
		//1개 select(select)
		public BDto contentView(int bId) {
			//클릭하면 조회수가 1증가해야함 
			//update mvc_board set bHit=1 where bId=4;
			
			upHit(bId);
			sql="select * from mvc_board where bId=?";
			
			try {
				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bId); //int로 변환해서 넣는다.
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
		}//1개 select
		
		
		//조회수 올리기(update)
		public int upHit(int bId) {
			int check = 0;
			
			sql="update mvc_board set bHit=bHit+1 where bId=?";
			try {
				con=ds.getConnection();
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
		}//조회수 올리기
	
}//class
