<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String mid = (String) session.getAttribute("mid");
	String mname = (String) session.getAttribute("mname");
%>      
	<header class="hd container">
        <a class="navbar-brand" href="index.jsp">일산 쇼핑몰</a>
        <nav class="tnb">
        	<ul>
        		<span><%=mname %>님 안녕하세요  </span>
				<li><a href="GetInformListCtrl">게시판 관리</a></li>
				<li><a href="GetCustomListCtrl">회원 관리</a></li>
				<li><a href="GetProListCtrl">상품 관리</a></li>
				<li><a href="LogoutCtrl">로그아웃</a></li>
        	</ul>
        </nav>
		<nav class="navbar navbar-inverse navbar-static-top" id="gnb">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">메뉴</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="company.jsp">제품정보</a></li>
                <li><a href="contact.jsp">고객지원</a></li>
                <li><a href="notice.jsp">E-Shop</a></li>
                <li><a href="service.jsp">니콘스쿨</a></li>
              </ul>
            </div>
          </div>
        </nav>
	</header>