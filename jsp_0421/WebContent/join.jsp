<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
	<head>
	 	<meta charset="UTF-8">
	 	<title>JSP - 커넥션 풀 연습 - 회원관리 프로그램(회원가입화면)</title>
  		<script type="text/javascript" src="js/custom.js"></script>
  		<style type="text/css">
  			span{ cursor: pointer; color: red; border: 1px solid red; border-radius: 2px;}
  		</style>
		
 	</head>
 	<body>
	  <h2> 회 원 가 입 </h2>
	  <form action="join_ok.jsp" name="join_form" method="post" onsubmit="return join_check()">
	  
	   <label for="id">아이디</label>
	   <input type="text" name="id" id="id" /> <br/>
	   
	   <label for="pw">패스워드</label>
	   <input type="password" name="pw" id="pw" /> <br/>
	   
	   <label for="pw_check">패스워드 체크</label>
	   <input type="password" name="pw_check" id="pw_check" /> <br/>
	   
	   <label for="name">이름</label>
	   <input type="text" name="name" id="name" /> <br/>
	   
	   <label for="email">이메일</label>
	   <input type="email" name="email" id="email" /> <br/>
	   
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
		
	   <input type="text" name="address1" id="address1" placeholder="우편번호" readonly> 
	
	   <a onclick="openDaumZipAddress()">
			<span>우편번호 찾기</span>
	   </a> 
	   <br> 
	   
	   <input type="text" name="address2" id="address2" placeholder="도로명 주소" readonly>
	   <input type="text" name="address3" id="address3" placeholder="상세주소"><br> 
	   
	   <input type="submit" value="회원가입완료" />
	   <input type="button" onclick="javascript:location.href='login.jsp'" value="취소" />
	   
	  
	  
	  </form>
 	</body>
</html>