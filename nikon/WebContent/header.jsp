<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = (String) session.getAttribute("mid");
	String mname = (String) session.getAttribute("mname");
%> 
<header class="hd container">
        <a class="navbar-brand" href="index.jsp">니콘</a>
        <nav class="tnb">
        	<ul>
					<%
					if(mid!=null && mid.equals("admin")) {
						response.sendRedirect("admin.jsp");
					%>
					<%
					} else if(mid!=null) {	//로그인이 되어 있을 때
					%>
							<li><span><%=mname %></span></li>
							<li><a href="MyPageCtrl?mid=<%=mid %>">마이 페이지</a></li>
							<li><a href="LogoutCtrl">로그아웃</a></li>
							<li><a href="OutCtrl">회원탈퇴</a></li>
					<%		
						} else if(mid==null) {
					%>
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					<%
						}
					%>
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
                <li><a href="company.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><a href="notice.jsp">Community</a></li>
                <li><a href="service.jsp">Service</a></li>
              </ul>
            </div>
          </div>
        </nav>
	</header>