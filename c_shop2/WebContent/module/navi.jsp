<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ not empty sessionScope.authUser }">
    <c:set var="authId" value="${ sessionScope.authUser }"/>
    <c:set var="authName" value="${ sessionScope.name }"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- <link -->
<!--     href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" -->
<!--     rel="stylesheet"> -->
<!-- <link rel="stylesheet" type="text/css" href="../css/style_main.css"> -->
<!-- <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery-ui.min.js"></script> -->
<!-- <script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script> -->
<!-- <script type="text/javascript" src="js/navi_hover.js"></script> -->
</head>
<body>

    <header>
        <div id="nav_up">
            <ul>
                <c:if test="${ empty authId }">
                    <li><a href="joinview.do">회원가입</a></li>
                    <li><a href="loginview.do">로그인</a></li>
                </c:if> 
                <c:if test="${ not empty authId }">
                    <li><a href="#">${ authName } 님</a></li>
                    <li><a href="logout.do">로그아웃</a></li>
                </c:if>
                
                <li><a href="notice_list.html">고객행복센터</a></li>
                <li><a href="#">배송정보검색</a></li>
            </ul>
        </div>
        <nav>
            <h1><a href="main.do" id="gomain"></a></h1>
            <ul>
                <li class="navis"><a href="#">COOKIT소개</a></li>
                <li class="navis"><a href="#">COOKIT메뉴</a></li>
                <li class="navis"><a href="notilist.do">공지</a></li>
                <li class="navis"><a href="eventlist.do">이벤트</a></li>
                <li class="navis"><a href="#">MY쿡킷</a></li>
            </ul>
            <ul>
                <li><a href="#"><span>장바구니</span></a></li>
                <li><a href="#"><span>메뉴찾기</span></a></li>
            </ul>

        </nav>
    </header>

</body>
</html>