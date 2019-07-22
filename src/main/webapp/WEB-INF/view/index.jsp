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
<html lang="en" >

<head>
    <meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width,initial-scale=1"> 
    <title>Document</title>
    <!-- 스타일 속성(x) -> 선택자 이용 스타일 부여 -->
    <link rel="stylesheet" type="text/css" href="../CSS/style.css">
    <style>
/*         #main-menu-list{
            color: cadetblue
        }
        .mainmenu{
            color: darkgoldenrod
        } 
        #footer{ width:100px;}
        */
    </style>
</head>

<body>
    <!-- --- header block ---------------------------------------------------------------------------------------------------------------- -->
<header id="header">
	<div>
		<a href="" class="icon icon-menu">펼침버튼</a>
	</div>
    <h1 id ="logo"><a href="">뉴렉처 온라인</a></h1>
    <div>
    	<a href="" class="icon icon-search">검색버튼</a>
    </div>
</header>
	<section id="visual">
	</section>
<main>
	<section id="top-lecture">
	${x}
	</section>
	<section id="lecture">
	</section>
	<section id="notice">
	</section>
</main>
<!-- --- footer block ---------------------------------------------------------------------------------------------------------------- -->
    <jsp:include page="inc/footer.jsp"/>

</body>

</html>