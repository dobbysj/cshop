<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/admin_header.css">
<link rel="stylesheet" type="text/css" href="../css/admin_main.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/prefixfree.dynamic-dom.min.js"></script>
<script type="text/javascript" src="../js/admin_header.js"></script>
</head>
<body>

     <nav>
        <h2><em></em>게시판</h2>
        <div  id="student" class="user">
            <a>공지사항<span id="s_icon" class="icon_minus"></span></a>
            <div id="stu_list">
                <ul>
                    <li><a href="ad_noti_list.do"><img src="images/icon_title_left.png">공지 리스트</a></li>
                    <li><a href="notiregiview.do"><img src="images/icon_title_left.png">공지 등록</a></li>
                </ul>
            </div>
        </div>
        <div  id="teacher" class="user">
            <a>이벤트<span id="t_icon" class="icon_minus2"></span></a>
            <div id="tes_list">
                <ul>
                    <li><a href="ad_ev_list.do"><img src="images/icon_title_left.png">이벤트 리스트</a></li>
                    <li><a href="eventregiview.do"><img src="images/icon_title_left.png">이벤트 등록</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
</body>
</html>