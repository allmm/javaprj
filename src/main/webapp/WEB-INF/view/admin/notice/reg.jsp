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
    <title>Document</title>
    <!-- 스타일 속성(x) -> 선택자 이용 스타일 부여 -->
    <style>
        #main-menu-list{
            color: cadetblue
        }
        .mainmenu{
            color: darkgoldenrod
        }
    </style>
    <link rel="stylesheet" type="text/css" href="../CSS/style.css">
</head>

<body>
    <!-- --- header block ---------------------------------------------------------------------------------------------------------------- -->
    <jsp:include page="../../inc/header.jsp" />
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

    <jsp:include page="../../inc/aside.jsp" />

    <main>
        <section>
            <h1 id="main-title">공지사항</h1>
            

            <section id="breadcrumb">
                <h1 class="d-none">경로</h1>
                <ol>
                    <li>home</li>
                    <li>고객센터</li>
                    <li>공지사항</li>
                </ol>
            </section>
         
         <section>
	         <form action="reg" method="post" enctype="multipart/form-data">
	         <h1>공지사항 내용</h1>
	         <table>
		         <tbody>
			         <tr>
				         <th>카테고리</th>
				         <td><select name="category">
					         	 <option>학습</option>
					         	 <option>결제</option>
					         	 <option>기타</option>
				         	 </select>
				         </td>
			         </tr>
			         <tr>
				         <th>제목</th>
				         <td><input name="title"></td>
			         </tr>
			         <tr>
				         <th>첨부파일</th>
				         <td><input type="file" name="file"></td>
			         </tr>
			         <tr>
				         <th>내용</th>
				         <td><textarea name="content"></textarea></td>
			         </tr>
		         </tbody>
	         </table>
	         <div>
	      
	         	<input type="submit" value="저장">
	         	<a href="list">취소</a>
	         </div>
	         </form>
         </section>

           
        </section>
    </main> 
    <!-- <div style="clear:left;">안녕 나는 막내야</div> -->
    </div>
</div>
<!-- --- footer block ---------------------------------------------------------------------------------------------------------------- -->
<jsp:include page="../../inc/footer.jsp" />

</body>

</html>