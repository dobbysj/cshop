<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/join.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script>
    <script type="text/javascript" src="js/join.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style_main.css">
    <script type="text/javascript" src="js/navi_hover.js"></script> 
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <style>
        .welcome{
            width: 500px;
            margin: 0 auto;
            margin-top: 300px;
        }
        h1{
            text-align: center;
        }
        .buttonset{
            text-align: center;
        }
        .buttonset button{
            width : 150px;
            height: 40px;
            margin-top: 20px;
            text-align: center;
            border :0;
            outline: 0;
            cursor: pointer;
        }
        .buttonset>button:nth-child(1){
            margin-right: 20px;
        }
    </style>
</head>
<body>
    <jsp:include page="module/navi.jsp"></jsp:include>
    <div class="welcome">
        <h1>${ mid } 님 회원가입을 축하합니다.</h1>
        <div class="buttonset">
            <a href="main.do"><button type="button">메인으로</button></a>
            <a href="loginview.do"><button type="button">로그인</button></a>
        </div>
    </div>
    




</body>
</html>