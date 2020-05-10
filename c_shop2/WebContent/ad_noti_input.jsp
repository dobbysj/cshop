<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/admin_input.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/admin_header.css">
<link rel="stylesheet" type="text/css" href="css/admin_main.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
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
 
 	<jsp:include page="module/ad_navi.jsp"></jsp:include>
 	<jsp:include page="module/ad_navi_board.jsp"/>
 
 
    <section>
    <h1>공지 등록</h1>
    <div class="container">
      <form name="notice" id="inputform" action="notiregi.do" method="post" enctype="multipart/form-data">

        <div class="input_set">
          <div class="input_1">
            <label class="input_label">제목</label>
            <div class="just_cont">
              <input type="text" name="ntitle" id="eTitle">
            </div>
          </div>
        
          <div class="input_1">
            <label class="input_label">내용작성</label>
            <div class="just_cont">
              <textarea id="txt_wr" name="ncontent" cols="127" rows="10"
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
                <input type="file" name="nattch" >
<!--               </div> -->
              <ul class="file_noti listst">
                <li>2장 등록 (PNG, JPEG, JPG, GIF 포맷)</li>
              </ul>
            </div>
          </div>
        </div>

        <div class="bttn_set">
          <button onclick="location.href='ad_main.do'">취소</button>
          <button type="submit">확인</button>
        </div>

      </form>


    </div>
  </section>
</body>
</html>