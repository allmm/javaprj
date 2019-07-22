<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/* List<Notice> notices = new ArrayList<>();
	FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPprj\\WebContent\\WEB-INF\\data\\notice-file.df");
	Scanner fscan = new Scanner(fis);
	String line ="";
   
	Notice n = new Notice();
	
    while(fscan.hasNextLine()){ 
       line = fscan.nextLine();
      n = new Notice(line.split(","));
    }

   fscan.close();
   fis.close();
 */
%>


<!DOCTYPE html>
<html lang="en" style="">

<head>
    <meta charset="UTF-8">
  	<!-- <meta name="viewport" content="width=device-width,initial-scale=1"> -->
    <title>Document</title>
    <!-- 스타일 속성(x) -> 선택자 이용 스타일 부여 -->
    <link rel="stylesheet" type="text/css" href="../CSS/style.css">
    <style>
/*         #main-menu-list{
            color: cadetblue
        }
        .mainmenu{
            color: darkgoldenrod
        } */
        #footer{ width:100px;}
    </style>
</head>

<body>
    <!-- --- header block ---------------------------------------------------------------------------------------------------------------- -->
<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>
<!-- --- visual block ---------------------------------------------------------------------------------------------------------------- -->
<div id="visual">
    <div class="content-box" style="position: relative">
        
        <!-- <div style="height: 100px; width: 100px; border: 1px solid red;
        background: url(https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/news/201811/03/starnews/20181103152130511pdgw.jpg);
        background-size: cover;
        background-attachment: fixed;">
        </div> -->
        <span style="left:100px;top:100px;position:sticky;">헨리야헨리야</span>
        <!-- <img src="https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/mbcweeks/ae1819c696dd41038132185905ab587b.jpeg" style="left:100px;top:100px;position:absolute;" > -->
                
    </div>

</div>
<!-- --- Body block ---------------------------------------------------------------------------------------------------------------- -->
<div id="body">
    <div class="content-box">

    <jsp:include page="../../inc/aside.jsp"/>

 <main>
        <section>
            <h1 id="main-title">공지사항</h1>
            <section>
                <h1>공지사항 검색 폼</h1>
                <label>제목</label>
                <input type="text">
                <input type="submit" value="검색">
            </section>

            <section id="breadcrumb">
                <h1 class="d-none">경로</h1>
                <ol>
                    <li>home</li>
                    <li>고객센터</li>
                    <li>공지사항</li>
                </ol>
            </section>
            <section id="notice">
                <h1>공지사항 목록</h1>
                <form method="post">
                <table>
                    <thead>
                        <tr>
                            <td class="num">번호</td>
                            <td class="title">제목</td>
                            <td class="writer">작성자</td>
                            <td class="date">작성일</td>
                            <td class="hit">조회수</td>

                        </tr>
                    </thead>

                    <tbody>
                       <c:forEach var="n" items="${list}">
                       <c:if test="${param.eid == n.id}">
                        <tr>
                            <td class="num">${n.id}</td>
                            <td class="title">
                            	<input type="text" name="title" value="${n.title}">
                            	<span>[33]</span>
                            	<input type="hidden" name="id" value="${n.id}">
                            	<span><input type="submit" value="저장"></span>
                            </td>
                            <td class="wrtier">${n.writerId}</td>
                            <td class="date">${n.regDate}</td>
                            <td class="hit">${n.hit}</td>
                            <td class=""></td>
                        </tr>
                        </c:if>
                        
                        <c:if test="${param.eid != n.id}">
                        <tr>
                            <td class="num">${n.id}</td>
                            <td class="title">
                            	<a href="detail?id=${n.id}">${n.title}</a>
                            	<span class="commentCount">${n.commentCount}</span>
                            	<span><a href="list?eid=${n.id}">수정</a><a href="">삭제</a></span>
                            </td>
                            <td class="wrtier">${n.writerId}</td>
                            <td class="date">${n.regDate}</td>
                            <td class="hit">${n.hit}</td>
                            <td class=""></td>
                        </tr>
                        </c:if>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                <div>
                	<a href="reg"> 글쓰기</a>
                </div>
            </section>

            <section id="page-index">
                <h1 class="d-none">페이지 정보</h1>
                <div>
                    <span class="color-highlight font-bold">1</span>
                     / 1 pages
                </div>
            </section>

            <section id="pager">
                <h1 class="d-none">페이저</h1>
                <div>
                    <div class="icon-prev-page">이전</div>
                   
                    <ul>
                        <li class="current"><a href ="list?p=1">1</a></li>
                        <li><a href ="list?p=2">2</a></li>
                        <li><a href ="list?p=3">3</a></li>
                        <li><a href ="list?p=4">4</a></li>
                        <li><a href ="list?p=5">5</a></li>
                    </ul>
                    
                    <div class="icon-next-page">다음</div>
                </div>
            </section>
        </section>
    </main>
    <!-- <div style="clear:left;">안녕 나는 막내야</div> -->
    </div>
</div>
<!-- --- footer block ---------------------------------------------------------------------------------------------------------------- -->
    <jsp:include page="../../inc/footer.jsp"/>

</body>

</html>