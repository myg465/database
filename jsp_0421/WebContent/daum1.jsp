<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<script>
		    function openDaumZipAddress() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		              $("#postcode1").val(data.postcode1);
		              $("#postcode2").val(data.postcode2);
		              $("#zonecode").val(data.zonecode);
		              $("#address").val(data.address);
		              $("#address_etc").val(data.address_etc);
		            }
		        }).open();
		    }
		
		</script>
	</head>
	<body>
		<form action="join_ok.jsp" name="join" method="post">
			<input type="text" id="postcode1" value="" readonly> &nbsp;&nbsp;
			<input type="text" id="postcode2" value="" readonly> &nbsp;&nbsp;
			<input type="text" id="zonecode" value="" readonly> &nbsp;&nbsp;
			<input type="button" onclick="openDaumZipAddress()" value="우편번호 찾기">
			<input type="text" id="address" value="" readonly>&nbsp;&nbsp;
			<input type="text" id="address_etc" value="" style="width: 100px">
		</form>
	</body>
</html>