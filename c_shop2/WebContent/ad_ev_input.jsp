<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/admin_header.css">
<link href="css/admin_input.css" rel="stylesheet">
<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/prefixfree.dynamic-dom.min.js"></script>
<script src="js/input_custom.js"></script>
<script type="text/javascript" src="js/admin_header.js"></script> 
<style>
#eTitle{
    width: 600px;
}
</style>
</head>
<body>
 <header>
        <div>
            <div id="top">
            <a href="admin_main.html"><p>LMS <span>STARTUP</span> Type</p></a>
            <ul>
                <li>관리자</li>
                <li><img src="images/logout.png"></li>
                <li>
                    <select>
                        <option>한국어</option>
                        <option>영어</option>
                        <option>중국어(간체)</option>
                        <option>일본어</option>
                    </select>
                </li>
                <li>
                    <select >
                        <option>LMS매뉴얼</option>
                        <option>나의 홈페이지</option>
                        <option>아이티맵</option>
                    </select>
                </li>
            </ul>
            </div>
            <div id="menu"  class="admin_gnb">
            <ul>
                <li><a href="#"><span></span>커뮤니티</a></li>
                <li><a href="#"><span></span>환경설정</a></li>
                <li><a href="#"><span></span>회원/강사</a></li>
                <li><a href="#"><span></span>상품/결제(신청)</a></li>
                <li><a href="#"><span></span>수업/스케쥴</a>
                    <ul class="sub_list">
                    <li><a href="#">임시 리스트1</a></li>
                    <li><a href="#">임시 리스트2</a></li>
                    <li><a href="#">임시 리스트3</a></li>
                     </ul>
                </li>
                <li><a href="#"><span></span>프로모션</a>
                    <ul class="sub_list">
                        <li><a href="#">임시 리스트1</a></li>
                        <li><a href="#">임시 리스트2</a></li>
                        <li><a href="#">임시 리스트3</a></li>
                     </ul>
                </li>
                <li><a href="#"><span></span>홈페이지</a>
                    <ul class="sub_list">
                    <li><a href="ad_notice_list.html">공지사항 관리</a></li>
                    <li><a href="ad_event_list.html">이벤트  관리</a></li>
                    <li><a href="#">회원 관리</a></li>
                     </ul>
                </li>
                <li><a href="#"><span></span>회계관리</a>
                    <ul class="sub_list">
                        <li><a href="#">임시 리스트1</a></li>
                        <li><a href="#">임시 리스트2</a></li>
                        <li><a href="#">임시 리스트3</a></li>
                     </ul>
                </li>
                <li><a href="#"><span></span>통계 분석</a>
                    <ul class="sub_list">
                        <li><a href="#">임시 리스트1</a></li>
                        <li><a href="#">임시 리스트2</a></li>
                        <li><a href="#">임시 리스트3</a></li>
                     </ul>
                </li>
            </ul>
            </div>
        </div>
    </header>
    <nav>
        <h2><em></em>회원/강사</h2>
        <div  id="student" class="user">
            <a>학생 관리<span id="s_icon" class="icon_minus"></span></a>
            <div id="stu_list">
                <ul>
                    <li><a href="#"><img src="images/icon_title_left.png">학생 등록</a></li>
                    <li><a href="#"><img src="images/icon_title_left.png">학생 리스트(탈퇴)</a></li>
                    <li><a href="#"><img src="images/icon_title_left.png">학생등급 관리</a></li>
                    <li><a href="#"><img src="images/icon_title_left.png">학생등급 분류/해택</a></li>
                    <li><a href="#"><img src="images/icon_title_left.png">회원 상담 관리</a></li>
                </ul>
            </div>
        </div>
        <div  id="teacher" class="user">
            <a>강사 관리<span id="t_icon" class="icon_minus2"></span></a>
            <div id="tes_list">
                <ul>
                    <li><a href="#"><img src="images/icon_title_left.png">강사 등록</a></li>
                    <li><a href="#"><img src="images/icon_title_left.png">강사 리스트</a></li>
                    <li><a href="#"><img src="images/icon_title_left.png">강사 리스트(사용중지)</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <section>
    <h1>이벤트 등록</h1>
    <div class="container">
      <form name="event" id="inputform" action="eventregi.do" method="post" enctype="multipart/form-data">

        <div class="input_set">
          <div class="input_1">
            <label class="input_label">제목</label>
            <div class="just_cont">
              <input type="text" name="eTitle" id="eTitle">
            </div>
          </div>
        
          <div class="input_1">
            <label class="input_label">내용작성</label>
            <div class="just_cont">
              <textarea id="txt_wr" name="eContent" cols="127" rows="10"
                maxlength="1000" placeholder="내용을 입력해주세요"></textarea>
              <div class="txt_wr_cnt">
                <span class="counter">0</span><span id="test">/1000자</span>
              </div>
              <div class="noti_box listst">
                <ul>
                  <li>공지 작성시 주의사항 입력 부분입니다.</li>
                  <li>공지 작성시 주의사항 입력 부분입니다.</li>
                </ul>
              </div>
            </div>
          </div>

          <div class="input_1">
            <label class="input_label">첨부파일</label>
            <div class="just_cont">
<!--               <div class="file_frame"> -->
<!--                 <span class="temp"></span>  -->
                <input type="file" name="eImg_thumb" >
                <input type="file" name="eImg_cont" >
<!--               </div> -->
              <ul class="file_noti listst">
                <li>2장 등록 (PNG, JPEG, JPG, GIF 포맷)</li>
              </ul>
            </div>
          </div>
          
          <div class="input_1">
            <label class="input_label">기간</label>
            <div class="just_cont">
                <input type="date" name="eDate1" >
                <input type="date" name="eDate2" >
            </div>
          </div>
          
          

        </div>

        <div class="bttn_set">
          <button onclick="location.href='#'">취소</button>
          <button type="submit">확인</button>
        </div>

      </form>


    </div>
  </section>
</body>
</html>