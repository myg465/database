<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String id,pw,name,phone1,phone2,phone3,gender;
%>   
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function check(){
				var id_ch=(/^(?=.*[a-zA-Z])(?=.*[0-9]).{1,16}$/);
				var pw_ch=(/^(?=.*[!@#$%^&*()_+|~])(?=.*[0-9]).{1,16}$/);
				var name_ch=/^[가-힣]{1,}$/;
				var num_ch=/^[0-9]{3,4}$/;
				
				
	//			if(!(id_ch.test(join.id.value))){
	//				alert("아이디를 다시 입력하세요.");
	//				join.id.value="";
	//				join.id.focus();
	//				return false;
	//			}
	//			if(!(pw_ch.test(join.pw.value))){
	//				alert("비밀번호를 다시 입력하세요.");
	//				join.pw.value="";
	//				join.pw.focus();
	//				return false;
	//			}
				
				if(join.pw.value!=join.pw2.value){
					alert("비밀번호가 일치하지 않았습니다.");
					join.pw2.value="";
					join.pw2.focus();
					return false;
				}
				
				if(!(name_ch.test(join.name.value))){
					alert("이름은 한글만 입력하세요.");
					join.name.value="";
					join.name.focus();
					return false;
				}
				
				if(!(num_ch.test(join.phone2.value))){
					alert("이름은 한글만 입력하세요.");
					join.phone2.value="";
					join.phone2.focus();
					return false;
				}
				
				if(!(num_ch.test(join.phone3.value))){
					alert("이름은 한글만 입력하세요.");
					join.phone3.value="";
					join.phone3.focus();
					return false;
				}
				
				if(join.gender.value==""){
					alert("성별을 선택하세요.");
					return false;
				}
				
				
				
				
				
				return true;
				
			}
			</script>
	</head>
	<body>
		<%
			id = (String)session.getAttribute("authUser");
			String sql="select * from member2 where id='"+id+"'";
			
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ora_user", "1234");
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				
				if(rs!=null){
					while(rs.next()){
						pw=rs.getString("pw");
						name=rs.getString("name");
						phone1=rs.getString("phone1");
						phone2=rs.getString("phone2");
						phone3=rs.getString("phone3");
						gender=rs.getString("gender");
					}
				}else{
					//정보가 없을때
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
			
			
		%>	
	
		<form action="Modify_Ok" name="join" method="post" onsubmit="return check()">
			<h2>회원정보수정</h2>
			아이디 : 
			<input type="text" name="id" value=<%=id %> readonly>
			<br>
			
			패스워드 : 
			
			<input type="password" name="pw"> 
			<span>*비밀번호를 입력해주세요</span>
			<br>
			
			이름 : 
			
			<input type="text" name="name" value=<%=name %>>
			<span>* 한글만 가능</span>
			<br>
			
			전화번호 : 
			<!-- if나 switch로 해야함 -->
			<%
				switch(phone1){
				case "010":%>
					<select name="phone1">
					<option value="010" selected>010</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					<option value="011">011</option>
					</select>
					<% break;
					
				case "016":%>
					<select name="phone1">
					<option value="010">010</option>
					<option value="016" selected>016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					<option value="011">011</option>
					</select>
					<% break;
				
				case "017":%>
					<select name="phone1">
					<option value="010">010</option>
					<option value="016">016</option>
					<option value="017" selected>017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					<option value="011">011</option>
					</select>
					<% break;
				case "018":%>
					<select name="phone1">
					<option value="010">010</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018" selected>018</option>
					<option value="019">019</option>
					<option value="011">011</option>
					</select>
				<% break;
				case "019":%>
					<select name="phone1">
					<option value="010">010</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019" selected>019</option>
					<option value="011">011</option>
					</select>
				<% break;
				case "011":%>
					<select name="phone1">
					<option value="010">010</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					<option value="011" selected>011</option>
					</select>
				<% break;
				
				}
			
			%>
			
			-
			<input type="text" name="phone2" value=<%=phone2 %>>
			-
			<input type="text" name="phone3" value=<%=phone3 %>>
			<br>
			
			성별 : 
				<%
				if(gender.equals("남자")){%>
					<!-- 남자일때 -->
					<input type="radio" name="gender" value="남자" id="man" checked>
					<label for="man">남자</label>
					
					<input type="radio" name="gender" value="여자" id="woman">
					<label for="woman">여자</label><br>
					
				<% }else{%>
					<!-- 여자일때 -->
					<input type="radio" name="gender" value="남자" id="man">
					<label for="man">남자</label>
					
					<input type="radio" name="gender" value="여자" id="woman" checked>
					<label for="woman">여자</label><br>
					
					
				<% }%>
			
			<input type="submit" value="회원정보수정">
			<input type="reset" value="취소">
			
			
		</form>
	</body>
</html>