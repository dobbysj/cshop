<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${ not empty sessionScope.aid }">
    <script>
    	location.href="ad_main.do";
    </script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		var logch = "${check}";
		var logok = "${logok}";
		console.log(logch);
		console.log(logok);
		if(logch === "-1" || logch === "0"){
			alert(logok);
		}
	});
</script>

</head>
<body>

	<form action="adminLogin.do" method="post" name="adminLogin">
		<label>아이디</label>
		<input type="text" name="aid"><br>
		<label>패스워드</label>
		<input type="text" name="apw"><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>