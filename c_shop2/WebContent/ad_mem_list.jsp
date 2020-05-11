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
        <style>
            #page_num{
                text-align: center;
                margin-top: 11px;
            }
            #page_num li{
                display: inline-block;
            }
            .input_button{
                display: inline-block;
                width: 85px;
                height: 32px;
                text-align: center;
                padding-top: 8px;
                border: 1px solid black;
                font-size: 13px;
                color: black;
            }
            .button_array{
                text-align: right;
            }
        </style>
        
        
	</head>
	<body>
	
    <jsp:include page="module/ad_navi.jsp"></jsp:include>
    <jsp:include page="module/ad_navi_member.jsp"/> 
    
    
	<section>
		<h1>전체 회원 리스트</h1>
		<div id="main_list">
			<div id="main_user_list">
				<div class="list_count">총 회원 수 :${ listcount }</div>
				<div>
					<table border="1">
						<tr>
							<th>No.</th>
							<th>고유번호</th>
							<th>ID</th>
							<th>이름</th>
							<th>이메일</th>
							<th>우편번호</th>
							<th>주소1</th>
							<th>주소2</th>
							<th>전화번호</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>News</th>
							<th>SMS</th>
							<th>가입일</th>
						</tr>
                        
                        <c:forEach var="mlist" items="${ mlist }">
    						<tr>
    							<td>${ mlist.mrnum }</td>
    							<td>${ mlist.mnum }</td>
    							<td>${ mlist.mid }</td>
    							<td>${ mlist.mname }</td>
    							<td>${ mlist.memail }@${mlist.memail2 }</td>
    							<td>${ mlist.mzonecode }</td>
    							<td>${ mlist.maddress1 }</td>
    							<td>${ mlist.maddress2 }</td>
    							<td>${ mlist.mphone1 }-${ mlist.mphone2 }-${ mlist.mphone3 }</td>
    							<td>${ mlist.mbirth }</td>
    							<td>${ mlist.mgender }</td>
    							<td>${ mlist.mnews }</td>
    							<td>${ mlist.msms }</td>
    							<td>${ mlist.mjoindate }</td>
    						</tr>
                        
                        </c:forEach>
                        
					</table>

<!-- 페이징 -->
        <div id="page_num">
            
            <ul class="page_num">
                <a href="ad_noti_list.do?page=1"><li class = "first"><<</li></a>
                
                <c:if test="${ page<=1 }">
                     <li class = "prev"><</li>
                </c:if>
                <c:if test="${ page>1 }">
                    <a href="ad_noti_list.do?page=${ page-1 }"><li class = "prev"><</li></a>
                </c:if>
                
                <c:forEach var="a" begin="${ startpage }" end="${ endpage }" step="1">
                    <c:choose>
                        <c:when test="${ a == page }">
                            <li class = "num"><div>${ a }</div></li>
                        </c:when>
                        <c:when test="${ a != page }">
                            <a href="ad_noti_list.do?page=${ a }"><li class = "num"><div>${ a }</div></li></a>
                        </c:when>
                    </c:choose>
                </c:forEach>
                
                <c:if test="${ page>=maxpage }">
                    <li class = "next">></li>
                </c:if>
                <c:if test="${ page<maxpage }">
                    <a href="ad_noti_list.do?page=${ page+1 }"><li class = "next">></li></a>
                </c:if>
                
                <a href="ad_noti_list.do?page=${ maxpage }">
                    <li class = "last">>></li>
                </a>
            </ul>
        </div>

        <div class="button_array"><a href="joinview.do"><span class="input_button">회원 등록</span></a></div>




				</div>
			</div>
		</div>
	</section>
	</body>
</html>