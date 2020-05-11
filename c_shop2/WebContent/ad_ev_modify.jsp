<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<script>
    function del_check(){
        var result = confirm("게시글을 삭제하시겠습니까?");
        if(result==true){
            window.location.href='ad_ev_del.do?eId=${edto.eId}';
        } else {
            return false;
        }
    }
</script>

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
    <h1>이벤트 등록</h1>
    <div class="container">
      <form name="event" id="inputform" action="eventmodi.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="eId" value="${ edto.eId }">
        
        
        <div class="input_set">
          <div class="input_1">
            <label class="input_label">제목</label>
            <div class="just_cont">
              <input type="text" name="eTitle" id="eTitle" value="${edto.eTitle }">
            </div>
          </div>
        
          <div class="input_1">
            <label class="input_label">내용작성</label>
            <div class="just_cont">
              <textarea id="txt_wr" name="eContent" cols="127" rows="10"
                maxlength="1000" placeholder="내용을 입력해주세요">${ edto.eContent }</textarea>
              <div class="txt_wr_cnt">
                <span class="counter">0</span><span id="test">/1000자</span>
              </div>
              <div class="noti_box listst">
                <ul>
                  <li>이벤트 작성시 주의사항 입력 부분입니다.</li>
                  <li>이벤트 작성시 주의사항 입력 부분입니다.</li>
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
                <li>기존 썸네일 : ${ edto.eImg_thumb }</li>
                <li>기존 본문파일 : ${ edto.eImg_cont }</li>
                <li>PNG, JPEG, JPG, GIF 포맷</li>
              </ul>
              <input type="hidden" name="eImg_thumb2" value="${ edto.eImg_thumb }">
              <input type="hidden" name="eImg_cont2" value="${ edto.eImg_cont }">
            </div>
          </div>
          
          <div class="input_1">
            <label class="input_label">기간</label>
            <div class="just_cont">
                <input type="date" name="eDate1" value="${  edto.geteDate1() }">
                <input type="date" name="eDate2">
                <fmt:formatDate value="${ edto.eDate1 }" pattern="yyyy/MM/dd" var="eDate11"/>
                <fmt:formatDate value="${ edto.eDate2 }" pattern="yyyy/MM/dd" var="eDate22"/>
                <ul class="file_noti listst">
                <li>기존 시작일 : <input type="text" name="eDate12" value="${ eDate11 }" readonly> </li>
                <li>기존 종료일 : <input type="text" name="eDate22" value="${ eDate22 }" readonly> </li>
                <li>수정하지 않을 시 기존 시작, 종료일로 유지됩니다.</li>
              	</ul>
                
            </div>
          </div>
        </div>

        <div class="bttn_set">
          <button onclick="location.href='ad_main.do'">취소</button>
          <button type="submit">확인</button>
          <button type="button" onclick="del_check();">삭제</button>
        </div>

      </form>


    </div>
  </section>
</body>
</html>