package com.javalec.ex.BDao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.BDto.BDto;

public class BDao {

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent;
	Timestamp bDate;
	
	ArrayList<BDto> list = null;
	BDto dto=null;
	BDao dao=null;
	String sql=null;
	
	
	private BDao() {
		
	}//생성자
	
	private static BDao instance= new BDao();
	
	public static BDao getInstance() {
		return instance;
	}//싱글턴 패턴
	
	public ArrayList<BDto> getBoards(){
		list=new ArrayList<BDto>();
		sql="select * from mvc_board";
		try {
			con=makecon();
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
				
				dto=new BDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, bDate);
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
	}//getBoards
	
	private Connection makecon() {
		Context context=null;
		DataSource ds=null;
		Connection con=null;
		
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
