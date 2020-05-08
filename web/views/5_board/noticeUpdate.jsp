<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,semi.cf.jsp.member.model.vo.*,semi.cf.jsp.board.model.vo.*"%>

<%
	Notice n = (Notice)request.getAttribute("notice");

	String ntype = request.getParameter("type");
	session.setAttribute("userId", request.getParameter("userId"));
	Member m = (Member)session.getAttribute("member"); 
	System.out.println("member : "+m);
	
	
 	String noticeType="";
	
	switch(ntype) {
	case "a" : noticeType ="공지사항" ; break;
	case "b" : noticeType ="인사게시판" ; break;
	case "c" : noticeType ="일반게시판" ; break;
	case "d" : noticeType ="경조사게시판" ; break;
	} 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 수정</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">
    <!-- 글작성 에디터-->
    <!-- css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
    <!-- /글작성 에디터-->
    <style>
      body{
        font-family:'Do Hyeon', sans-serif;
      }
    </style>
    <style>
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
          <label><%= m.getUserName() %> </label> <%= m.getPosit() %>님 반갑습니다.<br>
           <a class="btn btn-sm btn-outline-secondary" href="#">My Page</a>
           <a class="btn btn-sm btn-outline-secondary" href="#">Logout</a>
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
              <input type="text" placeholder="사원 검색"> 
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24" focusable="false"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
            </a>
          </div>
        </div>
      </header>
    
      <hr>
    
      <div class="nav-scroller py-1 mb-2" style="margin-left: 50px; margin-right: 50px;">
        <nav class="nav d-flex justify-content-between">
          <a class="p-2 text-muted" href="메인화면.html">메인</a>
          <a class="p-2 text-muted" href="#">전자결재</a>
          <div class="dropdown">
            <a class="p-2 text-muted" href="#">게시판</a>
            <div class="dropdown-content">
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=a">공지사항</a><br>
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=b">인사게시판</a><br>
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=c">일반게시판</a><br>
                <a class="p-2 text-muted" href="/semi/noticeList.nl?type=d">경조사게시판</a>
            </div>
          </div>
          <div class="dropdown">
            <a class="p-2 text-muted" href="#">회의실예약</a>
            <div class="dropdown-content">
                <a class="p-2 text-muted" href="#">일반회의실</a><br>
                <a class="p-2 text-muted" href="#">대회의실</a><br>
                <a class="p-2 text-muted" href="#">고객접견실</a><br>
            </div>
          </div>
          <a class="p-2 text-muted" href="#">기업정보</a>
        </nav>
      </div>
      <hr>
</body>
  
<body>
  <% if(m !=null &&m.getUserName().equals(n.getBwriter()) ) {%>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <!-- 세부내용 바디글 -->
        <!-- right column -->
         <form action="<%=request.getContextPath() %>/noticeUpdate.nu" 
         	   method="post" enctype="multipart/form-data">
        <div style="text-align: center; margin-top: 100px;">
		<input type="hidden" name="ntype" value="<%=noticeType %>"><h1><%=noticeType %></h1>
		<hr style="width: 50%;">
		</div>
        <div style="padding-left: 16%;">
          <input type="hidden" name="bno" value="<%=n.getBno() %>">
          <input type="hidden" name="write" value="<%=m.getUserName() %>"/>작성자 : <%=m.getUserName() %></input> 
          <div class="col-md-12" style="max-width: 90%; padding-left: 0px;">
            <div class="btn-group" style="width: 100px;">
              <select name="cls" style="height: 30px; background-color: rgb(240, 248, 255) ;">
                <option value="일반">일반</option>
                <option value="긴급">긴급</option>
              </select>
              
              <span class="navbar-search pull-left" style="height: 0px;">
                <input name="title" style="width: 952px"  type="text"  placeholder=" 제목" value="<%=n.getBtitle() %>" >
              </span>
            </div>
            <div>
              <input type="file" name="file" id="file" class="file" value="<%=n.getBoardfile()%>">
          </div>
          <textarea id="summernote" name="content" style="height: 400px;" value="textbox" ><%=n.getBcon() %></textarea>
          </div>
        <div>
          <div class="card-footer float-right" style="padding-left:0px; background-color: transparent !important; border-top: white; margin-right: 256px;">
            <button type="submit" class="btn btn-info " style="border-color: #007bff;  padding-left:10px; background-color: #007bff;">저장</button>
          </div>
        </div>
          </form>
            <div class="card-footer float-right" style="padding-rigt:0; background-color: transparent !important; border-top: white; ">
            
            <form action="<%=request.getContextPath() %>/ndelete.nd?tyepe=<%=noticeType %>"
            		method="get" enctype="multipart/form-data">
            <input type="hidden" name="bno" value="<%=n.getBno()%>">
            <input type="hidden" name="ntype" value=<%=ntype %>>
            <button type="submit" class="btn btn-default" style="position: absolute; left:1150px; border-color: #007bff;">삭제</button>     	
        	</form>
        	</div>
        </div>
      </div>
    </div>
    <% }%>
<!-- /.content -->
<!-- /.세부내용 바디글 -->

<hr>

  <footer class="main-footer" style="margin-left: 50px;">
    <small>
      CANDY FACTORY |
      <a href="mailto:webmaster@somedomain.com">help@example.com</a> | 
      서울특별시 강남구 테헤란로14길 6 남도빌딩 3F |
      사업자등록번호 : 123-45-678910  |  서울 강남 제2020-01호  |  대표자 : 홍길동  |  책임자 : 홍길동  |   개인정보관리책임자 : 홍길동
      <br>
      Copyright &copy; 2020 CF Company All Right Reserved</small> 
      <div class="float-right d-none d-sm-inline-block">
      </div>
  </footer>

<!-- 글작성 에디터 -->
<script>
  $(document).ready(function() {
      $('#summernote').summernote();
  });
  $('#summernote').summernote({
      height: 300,
      width: 1000,                 // set editor height
      minHeight: null,             // set minimum height of editor
      maxHeight: null,             // set maximum height of editor
      focus: true                  // set focus to editable area after initializing summernote
  });
</script>
<!-- /글작성 에디터 -->
</body>
</html>