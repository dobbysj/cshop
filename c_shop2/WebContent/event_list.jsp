<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/sub_event_list_style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style_main.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script>
<script type="text/javascript" src="js/navi_hover.js"></script> 
<style>
#list_ul_1{
    margin-top: 15px;
}
.border_bottom_no{
    padding-bottom: 91px;
}
</style>
</head>

<body>
    
    <jsp:include page="module/navi.jsp"></jsp:include>
    
    <section>
<!--         <div id="insert"> -->
<!--             <a href="input_event.html">글 등록</a> -->
<!--         </div> -->
        <div id="list">
            <h1 class="border_bottom_no">
                <a>이벤트</a>
            </h1>
            <ul id="list_ul_1">
                <li><a href="eventlist.do"><span>진행중</span></a></li>
                <li><a href="#"><span>당첨자 발표</span></a></li>
            </ul>

            <ul id="list_ul_2">
                <c:forEach var="elist" items="${ elist }">
                    <li>
                        <a href="eventview.do?eId=${ elist.eId }"><img src="${pageContext.request.contextPath }/upload/${ elist.eImg_thumb }"></a>
                        <p>
                            EVENT
                        </p>
                        <p>
                            <fmt:formatDate value="${ elist.eDate1 }" pattern="yyyy/MM/dd" var="startDate"/>
                            <fmt:formatDate value="${ elist.eDate2 }" pattern="yyyy/MM/dd" var="endDate"/>
                                    
                            ${ startDate } ~ ${ endDate }
                        </p>
                        <p>
                            <a href="eventview.do?eId=${ elist.eId }">${ elist.eTitle }</a>
                        </p>
                    </li>
                </c:forEach>
            </ul>
        </div>
        
        <div id="page_num">
            <strong><a href="#">1</a></strong>
            
            <ul class="page_num">
                <a href="eventlist.do?page=1"><li class = "first"><<</li></a>
                
                <c:if test="${ page<=1 }">
                     <li class = "prev"><</li>
                </c:if>
                <c:if test="${ page>1 }">
                    <a href="eventlist.do?page=${ page-1 }"><li class = "prev"><</li></a>
                </c:if>
                
                <c:forEach var="a" begin="${ startpage }" end="${ endpage }" step="1">
                    <c:choose>
                        <c:when test="${ a == page }">
                            <li class = "num"><div>${ a }</div></li>
                        </c:when>
                        <c:when test="${ a != page }">
                            <a href="eventlist.do?page=${ a }"><li class = "num"><div>${ a }</div></li></a>
                        </c:when>
                    </c:choose>
                </c:forEach>
                
                <c:if test="${ page>=maxpage }">
                    <li class = "next">></li>
                </c:if>
                <c:if test="${ page<maxpage }">
                    <a href="eventlist.do?page=${ page+1 }"><li class = "next">></li></a>
                </c:if>
                
                <a href="eventlist.do?page=${ maxpage }">
                    <li class = "last">>></li>
                </a>
            </ul>
        </div>
        
    </section>
    
    <jsp:include page="module/footer.jsp"></jsp:include>
    
</body>
</html>


































































