<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/admin_header.css">
		<link rel="stylesheet" type="text/css" href="css/admin_main.css">
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script>
        <script type="text/javascript" src="js/admin_header.js"></script> 
	</head>
	<body>
	
    <jsp:include page="module/ad_navi.jsp"></jsp:include>
    
	<section>
		<h1>전체 이벤트 리스트</h1>
		<div id="main_list">
			<div id="main_user_list">
				<div class="list_count">총 게시글 수 :${ listcount } / 진행 중 이벤트 : ${ inprog_lc } / 종료된 이벤트 : ${ end_lc }</div>
				<div>
					<table border="1">
						<tr>
							<th>No.</th>
							<th>이벤트 아이디</th>
							<th>제목</th>
							<th>내용</th>
							<th>썸네일</th>
							<th>이미지</th>
							<th>시작일</th>
							<th>종료일</th>
						</tr>
                        
                        <c:forEach var="elist2" items="${ elist }">
    						<tr>
    							<td class="table_left">${ elist2.rnum }</td>
    							<td class="table_left">${ elist2.eId }</td>
    							<td class="table_left">${ elist2.eTitle }</td>
    							<td>${ elist2.eContent }</td>
    							<td>${ elist2.eImg_thumb }</td>
    							<td>${ elist2.eImg_cont }</td>
    							<td>${ elist2.eDate1 }</td>
    							<td>${ elist2.eDate2 }</td>
    						</tr>
                        
                        </c:forEach>
                        
					</table>

<!-- 페이징 -->
        <div id="page_num">
            
            <ul class="page_num">
                <a href="ad_ev_list.do?page=1"><li class = "first"><<</li></a>
                
                <c:if test="${ page<=1 }">
                     <li class = "prev"><</li>
                </c:if>
                <c:if test="${ page>1 }">
                    <a href="ad_ev_list.do?page=${ page-1 }"><li class = "prev"><</li></a>
                </c:if>
                
                <c:forEach var="a" begin="${ startpage }" end="${ endpage }" step="1">
                    <c:choose>
                        <c:when test="${ a == page }">
                            <li class = "num"><div>${ a }</div></li>
                        </c:when>
                        <c:when test="${ a != page }">
                            <a href="ad_ev_list.do?page=${ a }"><li class = "num"><div>${ a }</div></li></a>
                        </c:when>
                    </c:choose>
                </c:forEach>
                
                <c:if test="${ page>=maxpage }">
                    <li class = "next">></li>
                </c:if>
                <c:if test="${ page<maxpage }">
                    <a href="ad_ev_list.do?page=${ page+1 }"><li class = "next">></li></a>
                </c:if>
                
                <a href="ad_ev_list.do?page=${ maxpage }">
                    <li class = "last">>></li>
                </a>
            </ul>
        </div>

        <div><a href="eventregiview.do">이벤트 등록</a></div>




				</div>
			</div>
		</div>
	</section>
	</body>
</html>