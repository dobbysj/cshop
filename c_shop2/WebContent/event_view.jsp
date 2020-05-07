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
    
</head>

<body>
    <jsp:include page="module/navi.jsp"></jsp:include>
    <section>
        <div id="description">
            <h1>
                <a href="sub_event_list.html">이벤트</a>
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
                <img src="upload/${ event.eImg_cont }">
            </div>
        <!-- 목록 버튼 -->
        <div id="button">
            <div>
                <a href="eventlist.do">목록</a>
            </div>
        </div>

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


































































