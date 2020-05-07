<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="idcheck" value="-1"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/join_idcheck.js"></script>
</head>
<body>

    <form action="join_check.do" name="join_id" method="post">
        <h1>아이디 중복 확인</h1>
        <p>
            4~16자리의 영문, 숫자, 특수기호(_)만 사용하실 수 있습니다.<br> 첫 글자는 영문으로 입력해 주세요.
        </p>
        <label>아이디 </label> 
        <input type="text" name="mid2" id="id_check" value="${ requestScope.mid2 }"> 
        <input type="button" value="중복확인" onclick="id_check_db()"><br>
        <c:if test="${ idcheck == '-1' }">
            <p id="ch_text"></p>
        </c:if>
        <c:if test="${ requestScope.idcheck == 1 }">
            <p id="ch_text">존재하는 아이디입니다.</p>
        </c:if>
        <c:if test="${ requestScope.idcheck == 0 }">
            <p id="ch_text">아이디를 사용하실 수 있습니다.</p>
            <input type="button" onclick="join_datainput()" value="확인">
        </c:if>
    </form>

</body>
</html>