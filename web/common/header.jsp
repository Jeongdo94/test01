<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="semi.cf.jsp.member.model.vo.*"%>

<%
	session.setAttribute("userId", request.getParameter("userId"));
	Member m = (Member)session.getAttribute("member");
	System.out.println("member : "+m);
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    
    <!-- 글작성 에디터-->
    <!-- css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
    <!-- include summernote-ko-KR -->
    <script src="../../resources/js/summernote-ko-KR.js"></script>
    <!-- /글작성 에디터-->
    
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">
    <style>
        body{
        font-family:'Do Hyeon', sans-serif;
        }
        .dropdown {
          position: relative;
          display: inline-block;
          margin-top: 8px;
        }
        
        .dropdown-content {
          display: none;
          position: absolute;
          background-color: #f9f9f9;
          min-width: 160px;
          box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
          padding: 12px 16px;
          z-index: 1;
        }
        
        .dropdown:hover .dropdown-content {
          display: block;
        }
    </style>
</head>

<body>
    <header class="header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-4 pt-1" style="margin-left: 5px;">
          </div>
          <div class="col-4 text-center">
            <a class="blog-header-logo text-dark"
            style=" font-family: 'Tenor Sans', sans-serif; font-family: 'Bungee Shade', cursive; font-size: 5em;">
            <span style="color: indianred">CANDY</span>
            <span style="color: lightseagreen">FACTORY</span>
        </a>
          </div>
          <div class="col-4 d-flex justify-content-end align-items-center">
            <a class="text-muted" aria-label="Search">
              <!-- <input type="text" placeholder="사원 검색"> 
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24" focusable="false"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg> -->
            </a>
          </div>
        </div>
      </header>
    
      <hr>
    
      <div class="nav-scroller py-1 mb-2" style="margin-left: 50px; margin-right: 50px;">
        <nav class="nav d-flex justify-content-between">
          <a class="p-2 text-muted" href="/semi/main.jsp">메인</a>
          <div class="dropdown">
            <a class="p-2 text-muted" href="#">전자결재</a>
            <div class="dropdown-content">
                <a class="p-2 text-muted" href="signlist.sl">문서작성/임시저장</a><br>
                <a class="p-2 text-muted" href="javascript:list2()">내 결재 관리</a><br>
                <script>
                function list2(){
                	location.href='signlist2.sl'
                }
                </script>
            </div>
          </div>
          <div class="dropdown">
            <a class="p-2 text-muted" href="/semi/noticeList.nl?type=a">게시판</a>
            <div class="dropdown-content">
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=a">공지사항</a><br>
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=b">인사게시판</a><br>
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=c">일반게시판</a><br>
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=d">경조사게시판</a>
            </div>
          </div>
          <div class="dropdown">
            <a class="p-2 text-muted" href="/semi/meetingroomList.me?type=g">회의실예약</a>
            <div class="dropdown-content">
                <a class="p-2 text-muted" href="/semi/meetingroomList.me?type=g">일반회의실</a><br>
                <a class="p-2 text-muted" href="/semi/meetingroomList.me?type=b">대회의실</a><br>
                <a class="p-2 text-muted" href="/semi/meetingroomList.me?type=c">고객접견실</a><br>
            </div>
          </div>
          <div class="dropdown">
            <a class="p-2 text-muted" href="/semi/meetingroomList.me?type=g">기업정보</a>
            <div class="dropdown-content">
                <a class="p-2 text-muted" href="views/5_people/조직도.jsp">조직도</a><br>
                <% if(m != null && m.getUserId().equals("0000000")){ %>
                <a class="p-2 text-muted" href="views/1_login/join.jsp">회원등록</a><br>
                <% } %>
            </div>
          </div>
        </nav>
      </div>
      <hr>
</html>