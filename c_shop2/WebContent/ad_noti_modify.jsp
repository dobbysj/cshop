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
<script>
    function del_check(){
        var result = confirm("게시글을 삭제하시겠습니까?");
        if(result==true){
            window.location.href='ad_noti_del.do?nid=${ndto.nid}';
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
    <h1>공지 등록</h1>
    <div class="container">
      <form name="notice" id="inputform" action="notimodi.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="nid" value="${ndto.nid }">
        <input type="hidden" name="nattch_origin" value="${ ndto.nattch }">

        <div class="input_set">
          <div class="input_1">
            <label class="input_label">제목</label>
            <div class="just_cont">
              <input type="text" name="ntitle" id="eTitle" value="${ ndto.ntitle }">
            </div>
          </div>
        
          <div class="input_1">
            <label class="input_label">내용작성</label>
            <div class="just_cont">
              <textarea id="txt_wr" name="ncontent" cols="127" rows="10"
                maxlength="1000" placeholder="내용을 입력해주세요">${ ndto.ncontent }</textarea>
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
                <li>기존 파일 : <a href="${pageContext.request.contextPath }/upload/${ndto.nattch}">${ ndto.nattch }</a></li>
                <li>새로 파일을 첨부하면 기존 파일은 삭제되고 새로 등록한 파일로 수정됩니다.</li>
                <li>새로 파일을 첨부하지 않을 경우 기존 파일을 유지합니다.</li>
                <li>1장 등록 (PNG, JPEG, JPG, GIF 포맷)</li>
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