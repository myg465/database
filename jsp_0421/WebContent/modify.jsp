<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(session.getAttribute("authUser")==null){%>
	<script>
		alert("로그인을 하셔야 이용하실수 있습니다.");
		location.href="login.jsp";
	</script>		
<% }%>
<%
	String id = request.getParameter("id");
	MemberDao mdao = MemberDao.getInstance();
	MemberDto mdto = mdao.selectOne(id);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수정 페이지</title>
		<script type="text/javascript" src="js/custom.js"></script>
		<style type="text/css">
  			span{ cursor: pointer; color: red; border: 1px solid red; border-radius: 2px;}
  		</style>
	</head>
	<body>
	  <h2> 회 원 정 보 수 정 </h2>
	  <form action="modify_ok.jsp" name="update_join" method="post" onsubmit="return update_check()">
	  
		   <label for="id">아이디</label>
		   <input type="text" name="id" id="id" value="<%=mdto.getId()%>" readonly/> <br/>
		   
		   <label for="pw">패스워드</label>
		   <input type="password" name="pw" id="pw" /> <br/>
		   
		   <label for="pw_check">패스워드 체크</label>
		   <input type="password" name="pw_check" id="pw_check" /> <br/>
		   
		   <label for="name">이름</label>
		   <input type="text" name="name" id="name" value="<%=mdto.getName()%>"/> <br/>
		   
		   <label for="email">이메일</label>
		   <input type="email" name="email" id="email" value="<%=mdto.getEmail()%>"/> <br/>
		   
		   <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		   <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		   <script>
		       function openDaumZipAddress() {
		           new daum.Postcode({
		               oncomplete: function(data) {
		            	    $("#address1").val(data.zonecode);
			                $("#address2").val(data.address);
			                $("#address3").focus();
		               }
		           }).open();
		           
		       }
				
		   </script>
		   
		   <input type="text" name="address1" id="address1" placeholder="우편번호" 
		   	value="<%if(mdto.getAddress1().equals("-")) out.println(""); else out.println(mdto.getAddress1());%>" readonly> 
		   
		   <a onclick="openDaumZipAddress()">
				<span>우편번호 찾기</span>
		   </a> 
		   <br> 
		   
		   <input type="text" name="address2" id="address2" placeholder="도로명 주소" 
		   	value="<%if(mdto.getAddress2().equals("-")) out.println(""); else out.println(mdto.getAddress2());%>" readonly>
		   <input type="text" name="address3" id="address3" placeholder="상세주소" 
		  	value="<%if(mdto.getAddress3().equals("-")) out.println(""); else out.println(mdto.getAddress3());%>"><br> 
			
		   <input type="submit" value="회원정보수정" />
		   <input type="button" onclick="javascript:history.back(-1);" value="취소" />
		   <input type="button" onclick="delete_check();" value="삭제">
	  </form>
	</body>
</html>