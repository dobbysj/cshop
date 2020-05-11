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
<link rel="stylesheet" type="text/css" href="css/admin_main2.css">
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
                width: 110px;
                margin-top: 15px;
            }
            .button_array{
                text-align: right;
            }
        </style>
</head>
<body>

<jsp:include page="module/ad_navi.jsp"></jsp:include>


<section class="main_section">


		<h1>전체 공지 리스트</h1>
		<div id="main_list">
			<div id="main_user_list">
				<div>
					<table border="1">
						<tr>
							<th>No.</th>
							<th>ID</th>
							<th>제목</th>
							<th>날짜</th>
							<th>조회수</th>
							<th>첨부파일</th>
						</tr>
                        
                        <c:forEach var="nlist" items="${ main_nlist }">
    						<tr>
    							<td>${ nlist.nrnum }</td>
    							<td>${ nlist.nid }</td>
    							<td><a href="ad_noti_modify.do?nid=${ nlist.nid }">${ nlist.ntitle }</a></td>
    							<td>${ nlist.ndate }</td>
    							<td>${ nlist.nhit }</td>
    							<td><a href="${pageContext.request.contextPath }/upload/${nlist.nattch}">${ nlist.nattch }</a></td>
    						</tr>
                        
                        </c:forEach>
                        
					</table>


                    <div class="button_array"><a href="ad_noti_list.do"><span class="input_button">공지 전체 보기</span></a></div>

				</div>
			</div>
		</div>



		<h1>전체 이벤트 리스트</h1>
		<div id="main_list2">
			<div id="main_user_list2">
				<div>
					<table border="1">
                        <colgroup>
                            <col width="2%" />
                            <col width="5%" />
                            <col width="*" />
                            <col width="15%" />
                            <col width="15%" />
                            <col width="15%" />
                            <col width="15%" />
                        </colgroup>
                        
						<tr>
							<th>No.</th>
							<th>이벤트 아이디</th>
							<th>제목</th>
							<th>썸네일</th>
							<th>이미지</th>
							<th>시작일</th>
							<th>종료일</th>
						</tr>
                        
                        <c:forEach var="elist2" items="${ main_elist }">
    						<tr>
    							<td>${ elist2.rnum }</td>
    							<td>${ elist2.eId }</td>
    							<td><a href="ad_ev_modify.do?eId=${ elist2.eId }">${ elist2.eTitle }</a></td>
    							<td>${ elist2.eImg_thumb }</td>
    							<td>${ elist2.eImg_cont }</td>
    							<td>${ elist2.eDate1 }</td>
    							<td>${ elist2.eDate2 }</td>
    						</tr>
                        
                        </c:forEach>
                        
					</table>

			        <div class="button_array"><a href="ad_ev_list.do"><span class="input_button">이벤트 전체 보기</span></a></div>

				</div>
			</div>
		</div>
	</section>





</body>
</html>