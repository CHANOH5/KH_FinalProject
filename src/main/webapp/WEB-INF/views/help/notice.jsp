<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MOYAMOGA</title>
    
	<!-- include favicon -->
    <%@include file="/WEB-INF/views/common/favicon.jsp" %>

    <link rel="stylesheet" href="/resources/css/help/notice.css">

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>

    <!-- slick: cdn 방식으로 css, js 가져오기 -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>			
    
<!--     <style>
    	.content_list {
		    width: 760px;
		    margin: 40px;
		    border-top: 3px solid #ceced2;
		
		    font-size: 11px;
		    /* font-weight: bold; */
		}
    </style> -->

</head>
<body>
	<!-- header -->
	<%@include file= "/WEB-INF/views/common/header.jsp" %>
	
    <main>
        <div class="helf_wrap">


            <!-- 상단 고객센터, 검색창 -->
            <div class="helf_top">
                <div class="helf_center">
                    <p class="helf_center_text">고객센터</p>
                </div>
                <div class="helf_search">
                    <ul class="helf_search_ul">
                        <p>공지사항 검색</p>
                        <div class="helf_search_input_a">
                            <input type="text" id="noticeKeyword" value="" placeholder="자주 찾는 질문을 검색해 보세요! ">
                            <a href="#" onclick="noticeSearch(); return false;" style="color: #fff;">검색</a>
                        </div>
                    </ul>
                </div>
            </div>

            <!-- 중간 - notice 사이드 메뉴/ 게시물 -->
            <div class="helf_content_wrap">

                <!-- 중간 - notice 사이드 메뉴 -->
                <div class="helf_side_menu">
                    <ul class="sm_ul">
                        <li id="sm_li"><a href="/help/faq">FAQ</a></li>
                        <li id="sm_li"><a href="/help/notice">공지사항</a></li>
                        <li id="sm_li"><a href="/help/guide">이용안내</a></li>
                    </ul>

                </div>
                

                <!-- 중간 - 게시물 -->
                <div class="content_wrap">
                        <h2>공지사항 <span class="test">새로운 소식들을 확인하세요</span></h2>

                        <div class="content_list">
			            <table>
			                 <thead>
			                    <tr>
			                        <th>번호</th>
			                        <th>제목</th>
			                        <th>작성날짜</th>
			                    </tr>
			                </thead>
			                <tbody>
			                    <c:forEach items="${noticeList}" var="NoticeVO">
			                        <tr>
			                            <td>${NoticeVO.no}</td>
			                            <td><a href="/help/get?no=${NoticeVO.no}">${NoticeVO.title}</a></td>
			                            <td>${NoticeVO.reg_date}</td>
			                        </tr>       
			                    </c:forEach>    
			                </tbody>
			            </table>
			            
						<div class="pageInfo_wrap" >
						  <form id=moveForm method="get">
						    <div class="pageInfo_area">
						    	<ul id="pageInfo" class="pageInfo">
						    	
						    		<!-- 이전페이지 버튼 -->
						            <c:if test="${pageMaker.prev}">
						                <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
						            </c:if>
						            
					            	<!-- 각 번호 페이지 버튼 -->
					                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					                    <li class="pageInfo_btn "><a href="/help/notice?currPage=${num}&amount=${pageMaker.cri.amount}">${num}</a></li>
					                </c:forEach>
					             
						            <!-- 다음페이지 버튼 -->
						            <c:if test="${pageMaker.next}">
						                <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
						            </c:if>  
					             </ul>
					            
			            	</div>
			            	</form>
				    	</div>
        
            	</div>
        </div>
    </main>
    <!-- ==========================footer========================= -->
   <%@include file= "/WEB-INF/views/common/footer.jsp" %>
</body>
</html>