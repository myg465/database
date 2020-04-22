<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
	BoardDao bdao = BoardDao.getInstance();
	String b_title="";
	String b_content="";
	String b_user="";
	String old_file="";
	int b_num=0;
	
	int check=0;
	//저장경로 지정
	String path = request.getRealPath("upload");
	//파일사이즈 지정-업로드 파일용량 제한
	int size = 1024 * 1024 * 10; //총 10 메가 용량 제한  
	//파일이름 설정
	String b_file="";
	//파일 원본 이름
	String b_orifile="";
	
	try{
		// request,파일 저장경로,용량,인코딩타입,
		//중복 파일명에 대한 정책(DefaultFileRenamePolicy-> 중복일 경우 (1),(2)..이런식으로 저장)
		
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		b_title = multi.getParameter("b_title");
		b_content = multi.getParameter("b_content");
		b_user = multi.getParameter("b_user");
		old_file = multi.getParameter("old_file");
		b_num = Integer.parseInt(multi.getParameter("b_num"));
		//파일이름 가져오기
		Enumeration files = multi.getFileNames();
		String name1 = (String) files.nextElement();
		b_file = multi.getFilesystemName(name1);
		if(b_file==null){
			b_file = old_file;
		}
		
		check = bdao.modifyBoard(b_num, b_title, b_content, b_user, b_file); //게시글수정 메소드 호출
		
		//String name2 = (String) files.nextElement(); // 파일 한개더 있을때
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	if(check==1){ //저장이 잘 되었을때%>
	
	<script>
		alert("수정이 되었습니다.");
		window.location.href="board_main.jsp";
	</script>
	
	<% } else{ //저장이 안 되었을때%>
	
	<script>
		alert("저장중 오류가 발생하였습니다. 다시 시도해 주세요.");
		history.back(-1);
	</script>
	
	<% }%>