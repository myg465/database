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
	
	//그냥하는 방법
	
	Connection con=null;
	Context context=null;
	DataSource ds=null;
	//객체선언
	ArrayList<BDto> list=new ArrayList<BDto>();
	BDto bdto=new BDto();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent;
	Timestamp bDate;
	
	
	//생성자
	public BDao() {
		
		try {
			context=new InitialContext();
			ds=(DataSource) context.lookup("java:comp.env.jdbc.Oracle11g");
			con=ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체select
	public ArrayList<BDto> list(){
		
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
				
				bdto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				
				list.add(bdto);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}
			
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//싱글톤 패턴으로 하는 방법
	
//	private BDao() {
//		
//	}
//	//싱글톤 패턴
//	private static BDao instance = new BDao();
//	
//	public BDao getInstance() {
//		return instance;
//	}
//	
//	//connection 얻기
//	public Connection makecon() {
//		Connection con=null;
//		Context context=null;
//		DataSource ds=null;
//		
//		try {
//			context = new InitialContext();
//			ds = (DataSource) context.lookup("java:comp.env.jdbc.Oracle11g");
//			con = ds.getConnection();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return con;
//	}
	
	
	
	
	
}
