<%@page import="javax.swing.text.TabableView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header">
    <div class="content-box">   
        
        <h1 id="logo">뉴렉처 온라인</h1>
        <section id="header-menu-list">
            <h1 class="d-none">머릿말</h1>
           <nav id="main-menu-list">
                <h1 class="d-none" style="color: darkmagenta;font-size: 25px;">메인메뉴</h1>
                <!-- <h2>나나나</h2> -->
                <ul class="mainmenu"  >
                    <li><a href="">학습가이드</a></li>
                    <li><a href="">강좌선택</a></li>
                    <li><a href="">AnswerIs</a></li>
                </ul>
            </nav>

            <section id="lecture-search-form">
                <h1 class="d-none">강좌검색 폼</h1>
                <form action="">
                    <label>과정검색</label>
                        <input type="text">
                        <input type="submit" value="검색">
                </form>
            </section>
            <nav id="member-menu-list">
                <h1 class="d-none">회원메뉴</h1>
                <ul class="mainmenu">
                    <li>HOME</li>
                    <li>
	                    <c:if test="${empty sessionScope.id}">
	                    <a href="/member/login">로그인</a>
	                    </c:if>
	                    <c:if test="${not empty sessionScope.id}">
	                    <a href="/member/logout">로그아웃</a>
	                    </c:if>
					</li> <!-- 상대경롤르 쓰면 안된다. -->
                    <li>회원가입</li>
                </ul>
            </nav>

            <nav id="direct-menu">
                <h1 class="d-none">자주사용하는 메뉴</h1>
                <ul class="mainmenu">
                    <li>마이페이지</li>
                    <li>고객센터</li>
                </ul>
            </nav>
        </section> 
   
    </div>
    </header>