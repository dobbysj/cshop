<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>

<body>
    
    <jsp:include page="module/navi.jsp"></jsp:include>
    
    <section>
<!--         <div id="insert"> -->
<!--             <a href="input_event.html">글 등록</a> -->
<!--         </div> -->
        <div id="list">
            <h1>
                <a>이벤트</a>
            </h1>
            <ul id="list_ul_1">
                <li><a href="eventlist.do"><span>진행중</span></a></li>
                <li><a href="#"><span>당첨자 발표</span></a></li>
            </ul>

            <ul id="list_ul_2">
                <c:forEach var="elist" items="${ elist }">
                    <li>
                        <a href="eventview.do?eId=${ elist.eId }"><img src="upload/${ elist.eImg_thumb }"></a>
                        <p>
                            EVENT
                        </p>
                        <p>
                            ${ elist.eDate1 }~${ elist.eDate2 }
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
    <footer>

        <div id="foot">
            <div>
                <a href="#"></a>
                <p>ⓒCOOKIT ALL RIGHTS RESERVED</p>
            </div>

            <div>
                <ul>
                    <li><a href="#">이용약관</a></li>
                    <li></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li></li>
                    <li><a href="#">법적고지</a></li>
                    <li></li>
                    <li><a href="#">사업자정보 확인</a></li>
                </ul>

                <ul>

                    <li>씨제이제일제당(주)</li>
                    <li></li>
                    <li>대표이사:손경식,강신호,신현재</li>
                    <li></li>
                    <li>사업자등록번호:104-86-09535</li>
                </ul>

                <ul>

                    <li>주소 : 서울중구 동호로 330 CJ제일제당 센터 (우)04560</li>
                    <li></li>
                    <li>통신판매업신고 중구 제 07767호</li>
                    <li></li>
                    <li>개인정보보호책임자 : 조영민</li>
                </ul>

                <ul>

                    <li>이메일:cjon@cj.net</li>
                    <li></li>
                    <li>호스팅제공자:CJ올리브네트웍스(주)</li>

                </ul>
                <p>
                    고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 전자 결제의 매매보호(에스크로) 서비스를
                    이용하실 수 있습니다. <a href="#">가입 사실 확인</a>
                </p>

            </div>

            <div>
                <p>
                    <a href="#">CJ그룹계열사 바로가기 ∨</a>
                </p>
                <p>
                    <a href="#">고객행복센터 1688-1920</a>
                </p>
                <div>
                    <a href="#">1:1문의</a>
                </div>
            </div>
        </div>

    </footer>
</body>
</html>


































































