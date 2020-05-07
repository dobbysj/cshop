<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>공지사항 리스트</title>
        <link type="text/css" rel="stylesheet" href="css/notice_list_style.css">
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500&display=swap" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script>
        <script type="text/javascript" src="js/navi_hover.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style_main.css">
</head>
    <body>
        
        <jsp:include page="module/navi.jsp"></jsp:include>
        
        
        
        <section>
        <form action="search.do" name="bsearch" method="get">
            <select name="opt">
                <option value="all">전체</option>
                <option value="tit">제목</option>
                <option value="cont">내용</option>
            </select>
            <input type="text" name="search">
            <input type="submit" value="검색">                
        </form>
            <div>
                <h1>공지사항</h1>
                <div>
                    <div>
                        <table>
                            <colgroup>
                                <col width="10%">
                                <col width="*">
                                <col width="15%">
                                <col width="15%">
                                <col width="10%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>제목</th>
                                    <th>등록일</th>
                                    <th>조회수</th>
                                </tr>
                            </thead>
                            <c:forEach var="nlist" items="${ nlist }">
                            <!-- db에서 받아오기 -->
                                <tr>
                                    <td>${nlist.nrnum }</td>
                                    <td>${nlist.ntitle }</td>
                                    <td>${nlist.ndate }</td>
                                    <td>${nlist.nhit }</td>
                                </tr>
                            </c:forEach>
                        </table>
                        
                    </div>
                    <div>
                        <span>
                            <a href="#">입력</a>
                        </span>
                    </div>
                        
                    <div>
                    <c:choose>
                        <c:when test="${ searchflag!=null }">
                            <ul>
                                <a href="notilist.do?opt=${ opt }&search=${ search }&page=1"><li> 처음 </li></a>
                                <c:if test="${ page<=1 }">
                                    <li> 이전 </li>
                                </c:if>
                                <c:if test="${ page>1 }">
                                    <a href="notilist.do?opt=${ opt }&search=${ search }&page=${page-1}"><li>이전</li></a>
                                </c:if>
                                <c:forEach var="a" begin="${ startpage }" end="${ endpage }" step="1">
                                    <c:choose>
                                        <c:when test="${ a == page }">
                                            <li>${ a }</li>
                                        </c:when>
                                        <c:when test="${ a != page }">
                                            <a href="notilist.do?opt=${ opt }&search=${ search }&page=${a}"><li>${ a }</li></a>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${ page>=maxpage }">
                                    <li>다음</li>
                                </c:if>
                                <c:if test="${ page<maxpage }">
                                    <a href="notilist.do?opt=${ opt }&search=${ search }&page=${page+1}"><li>다음</li></a>
                                </c:if>
                                <a href="notilist.do?opt=${ opt }&search=${ search }&page=${maxpage}"><li>마지막</li></a>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <a href="notilist.do?page=1"><li> 처음 </li></a>
                                <c:if test="${ page<=1 }">
                                    <li> 이전 </li>
                                </c:if>
                                <c:if test="${ page>1 }">
                                    <a href="notilist.do?page=${page-1}"><li>이전</li></a>
                                </c:if>
                                <c:forEach var="a" begin="${ startpage }" end="${ endpage }" step="1">
                                    <c:choose>
                                        <c:when test="${ a == page }">
                                            <li>${ a }</li>
                                        </c:when>
                                        <c:when test="${ a != page }">
                                            <a href="notilist.do?page=${a}"><li>${ a }</li></a>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${ page>=maxpage }">
                                    <li>다음</li>
                                </c:if>
                                <c:if test="${ page<maxpage }">
                                    <a href="notilist.do?page=${page+1}"><li>다음</li></a>
                                </c:if>
                                <a href="notilist.do?page=${maxpage}"><li>마지막</li></a>
                            </ul>
                        
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
            </div>
        </section>
        
        <footer>
            <div id="footer">
                <div>
                  <h1><a href="#"></a></h1>
                  <p>© COOKIT ALL RIGHTS RESERVED</p>
                </div>
                    
                <div>
                    <ul>
                    <li><a href="#">이용약관</a></li>
                    <li class="lime"><a href="#">개인정보처리 방침</a></li>
                    <li><a href="#">법적고지</a></li>
                    <li><a href="#">사업자정보 확인</a></li>
                    </ul>
                    <p>씨제이제일제당(주)</p>
                    <p>대표이사 : 손경식,강신호,신현재</p>
                    <p class="right_n">사업자등록번호 : 104-86-09535</p>
                    <p>주소 : 서울 중구 동호로 330 CJ제일제당 센터 (우) 04560</p>
                    <p>통신판매업신고 중구 제 07767호  </p>
                    <p class="right_n">개인정보보호책임자 : 조영민</p>
                    <p>이메일 : cjon@cj.net</p>
                    <p class="right_n">호스팅제공자 : CJ올리브네트웍스㈜</p>
                    <p class="right_n">고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 전자 결제의 매매보호(에스크로) 서비스를 이용하실 수 있습니다.<a href="#">가입 사실 확인</a></p>
                </div>
                        
                <div>
                    <button type="button"><span>CJ그룹계열사 바로가기 ▽</span></button>
                    <p>고객행복센터</p><p>1668-1920</p>
                    <div><a href="#">1:1문의</a></div>
                </div>
            </div>
        </footer>
    </body>
</html>