<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/sub_event_view_style1.css" rel="stylesheet" type="text/css">
<link
    href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style_main.css">
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script>
        <script type="text/javascript" src="js/navi_hover.js"></script> 
<style>
.overflow_content{
    width:100%;
}
</style>
</head>

<body>
    <jsp:include page="module/navi.jsp"></jsp:include>
    <section>
        <div id="description">
            <h1>
                <a>이벤트</a>
            </h1>

            <div>
                <!--#description>div:nth-child(2)  -->
                <h1>${ event.eTitle }</h1>

                <div>
                    <div>
                        <!-- 공유 이미지 -->
                        &nbsp;
                    </div>
                    <p>공유</p>
                </div>

                <p>${ event.eDate1 }~${event.eDate2 }
                <p>
            </div>

            <div>
                <!-- 이벤트 이미지 -->
                <c:if test="${ not empty event.eImg_cont }">
                    <img src="upload/${ event.eImg_cont }" class="overflow_content">
                </c:if>
            </div>
            <div class="bottom_line">
        </div>
        <!-- 목록 버튼 -->
        <div id="button">
            <div>
                <a href="eventlist.do">목록</a>
            </div>
        </div>

        </div>
        
        

    </section>
    
    <jsp:include page="module/footer.jsp"></jsp:include>
    
    
    
</body>
</html>



