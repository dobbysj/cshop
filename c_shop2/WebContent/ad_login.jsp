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
<style>
    body{
        margin:0px;
    }
    .ad_login_box{
        margin: 0 auto;
        text-align: center;
            display: flex;
    justify-content: center;
    background: #efefef;
    height: 100vh;
    flex-direction: column;
    }
    label{
        width: 100px;
    display: inline-block;
    }
    form{
        display: flex;
    justify-content: center;
    }
    .id_pw_btn{
        height: 96px;
        background: #efefef;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        width: 588px;
        margin-bottom: 184px;
    }
    button{
        height: 50px;
    }
    .log_btn{
        margin-left: 7px;
    }
    #aid{
        margin-bottom: 4px;
    }
</style>
</head>
<body>
    <div class="ad_login_box">
        <h1>어드민 로그인</h1>
    	<form action="adminLogin.do" method="post" name="adminLogin">
            <div class="id_pw_btn">
                <div class="id_pw">
            		<label>아이디</label>
            		<input type="text" name="aid" id="aid"><br>
            		<label>패스워드</label>
            		<input type="text" name="apw">
                </div>
                <div class="log_btn">
            		<button type="submit">로그인</button>
                </div>
            </div>    
    	</form>
    </div>
        
</body>
</html>