<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <script>
        	$(function(){
        		var joinch = "${check}";
        		if(joinch=="0"){
        			alert("회원가입이 실패했습니다. 다시 시도하세요.");
        		}
        	});
        </script>
        
    </head>
    <body>
        <jsp:include page="module/navi.jsp"></jsp:include>
        
        <form name="join" action="joinok.do" method="post">
        <section>
            <div>
                <div id="top">
                    <ul>
                        <li>HOME</li>
                        <li>회원가입</li>
                        <li>회원정보입력</li>
                    </ul>
                </div>
                <div id="title">
                    <h3>회원가입</h3>
                </div>
                <div id="step">
                    <ul>
                        <li>
                        <div>
                            <span>STEP.1</span>
                            <p>약관동의</p>
                        </div>
                        </li>
                        <li>
                        <div>
                            <span>STEP.2</span>
                            <p>본인확인</p>
                        </div>
                        </li>
                        <li>
                        <div>
                            <span>STEP.3</span>
                            <p>회원정보입력</p>
                        </div>
                        </li>
                        <li>
                        <div>
                            <span>STEP.4</span>
                            <p>회원관리완료</p>
                        </div>
                        </li>
                    </ul>
                </div>
                <h3>필수 정보 입력<span>( * 항목은 필수 항목입니다.)</span></h3>
                
                <table>
                    <tr>
                        <th><span></span>이름</th>
                        <td>
                            <input type="text" name="mname">
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>아이디</th>
                        <td>
                            <input type="text" name="mid" id="j_id" readonly>
                            <input type="button" onclick="id_ch()" value="중복확인">
                            <p>
                            4~16자리의 영문, 숫자, 특수기호(_)만 사용하실 수 있습니다.<br>
                            첫 글자는 영문으로 입력해 주세요.
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>비밀번호</th>
                        <td>
                            <input type="password" name="mpw" id="pw">
                            <p>
                            영문, 숫자, 특수문자 중 2종류 조합 시 10자리 이상 입력<br>
                            영문, 숫자, 특수문자 모두 조합 시 8자리 이상 입력
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>비밀번호 확인</th>
                        <td>
                            <input type="password" id="pw2">
                            <span>비밀번호를 다시 한번 입력해주세요.</span>
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>이메일</th>
                        <td>
                            <input type="text" id="email_id" name="memail">@
                            <select id="email_select" onchange="e_select(this.value)" name="memail2">
                                <option value="">선택</option>
                                <option value="naver.com">네이버</option>
                                <option value="google.com">구글</option>
                                <option value="daum.net">다음</option>
                                <option value="yahoo.com">야후</option>
                                <option value="self">직접입력</option>
                            </select>
                            <input type="text" id="email_1" readonly>
                            <input type="hidden" name="email" id="email">
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>주소</th>
                        <td id="address">
                            <input type="text" name="mzonecode" id="zonecode" readonly>&nbsp&nbsp
                            <input type="button" onclick="openDaumZipAddress();" value="우편번호찾기"><br>
                            <input type="text" name="maddress1" id="address1" value="" readonly>&nbsp&nbsp
                            <input type="text" name="maddress2" id="address2" value="" style="width:200px;">&nbsp&nbsp
                        
<!--                             <input type="text" name="z_code1" readonly> -->
<!--                             &nbsp;-&nbsp; -->
<!--                             <input type="text" name="z_code2" readonly> -->
<!--                             <button>우편번호</button><br> -->
<!--                             <input type="text" name="address1" readonly placeholder="우편번호를 선택하면 자동입력"> -->
<!--                             <br> -->
<!--                             <input type="text" name="address2" > -->
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>휴대전화</th>
                        <td id="call">
                            <input type="text" id="phone1" name="mphone1" maxlength="3"> - <input type="text" id="phone2"  name="mphone2" maxlength="4"> - <input type="text" id="phone3" name="mphone3" maxlength="4">
                            <input type="hidden" name="phone">
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>생년월일</th>
                        <td>
                            <input type="date" name="mbirth">
                            <br>
                            <div id="cal">
                            <label><input type="radio" name="양력음력" value="양력" checked>양력</label>
                            <label><input type="radio" name="양력음력" value="음력" >음력</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span></span>성별</th>
                        <td>
                            <label><input type="radio" name="mgender" value="여성" >여성</label>
                            <label><input type="radio" name="mgender" value="남성">남성</label>
                        </td>
                    </tr>
                    <tr  id="news_letter">
                        <th><span></span>뉴스레터 수신여부</th>
                        <td>
                            <p>이메일을 통한 상품 및 이벤트 정보 수신에 동의합니다.</p>
                            <label><input type="radio" name="mnews" value="yes" checked>예</label>
                            <label><input type="radio" name="mnews" value="no">아니오</label>
                        </td>
                    </tr>
                    <tr id="sms_letter">
                        <th ><span></span>SMS 수신여부</th>
                        <td>
                            <p>문자를 통한 상품 및 이벤트 정보 수신에 동의합니다.</p>
                            <label><input type="radio" name="msms" value="yes"checked>예</label>
                            <label><input type="radio" name="msms" value="no">아니오</label>
                        </td>
                    </tr>
                </table>
                
                
                <div id="join_btn">
                <button type="button" onclick="location.href='main.html'">취소</button>
<!--                <button type="submit" onclick="location.href='join_view.html'">가입하기</button> -->
                <button type="button" onclick="check()">가입하기</button>
                </div>
            </div>
        </section>
        </form>
        <footer>
            <div>
                <div id="left">
                    <div>
                        <a href="#"></a>
                    </div>
                    <p>© COOKIT ALL RIGHTS RESERVED</p>
                </div>
                <div id="center">
                    <ul>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">개인정보처리 방침</a></li>
                        <li><a href="#">법적고지</a></li>
                        <li><a href="#">사업자 정보 확인</a></li>
                    </ul>
                <div id="center_1">
                    <p>씨제이제일제당(주)</p>
                    <p>대표이사 : 손경식,강신호,신현재</p>
                    <p>사업자등록번호 : 104-86-09535</p>
                    <p>주소 : 서울 중구 동호로 330 CJ제일제당 센터 (우) 04560</p>
                    <p>통신판매업신고 중구 제 07767호</p>
                    <p>개인정보보호책임자 : 조영민</p>
                    <p>이메일 : cjon@cj.net</p>
                    <p>호스팅제공자 : CJ올리브네트웍스㈜</p>
                    <P>고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 
                    전자 결제의 매매보호(에스크로) 서비스를 이용하실 수 있습니다. <a href="#">가입 사실 확인</a></P>
                </div>
                </div>
                <div id="right">
                    <div>
                        <span>CJ그룹계열사 바로가기 </span>
                        <p>고객행복센터  1668-1920</p>
                        <a href="#">1:1문의</a>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>