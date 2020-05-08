<%@page import="oracle.net.aso.r"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.* ,semi.cf.jsp.board.model.vo.*"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
	Page pg = (Page)request.getAttribute("pg");
	int listCount = pg.getListCount();
	int currentPage = pg.getCurrentPage();
	int maxPage = pg.getMaxPage();
	int startPage = pg.getStartPage();
	int endPage = pg.getEndPage();
	int limit = pg.getLimit();

	String ntype = request.getParameter("type");
	String noticeType = "";

	switch (ntype) {
	case "a":
		noticeType = "공지사항";
		break;
	case "b":
		noticeType = "인사게시판";
		break;
	case "c":
		noticeType = "일반게시판";
		break;
	case "d":
		noticeType = "경조사게시판";
		break;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap"
	rel="stylesheet">

<style>
body {
	font-family: 'Do Hyeon', sans-serif;
}
</style>
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<div style="text-align: center; margin-top: 100px;">
		<h1><%=noticeType %></h1>
		<hr style="width: 50%;">
	</div>

	<!-- 목록 머리글 -->
	<section class="content">
		<div class="row">
			<div class="col-12">
				<div>
					<!--<h5 class="card-title" style="color:rgb(13, 39, 71);font-size:30px;font-weight: bold;">사내경조사</h5>-->
				</div>
				<!-- /.목록 머리글-->
				<!-- 목록 바디글-->
				<div class="card-body"
					style="padding-left: 200px; padding-right: 200px;">
					<table id="example2" class="table table-hover"
						style="text-align: center; " >
						<thead style="background-color: rgb(240, 248, 255);">
							<tr>
								<th style="width: 3%;">No.</th>
								<th style="width: 7%;">분류</th>
								<th style="width: 60%;">제목</th>
								<th style="width: 10%;">작성자</th>
								<th style="width: 10%;">작성일</th>
								<th style="width: 10%;">조회수</th>
							</tr>
						</thead>

						<tbody>
							<% for(Notice n : list) {%>
							<tr>
								<input type="hidden" value="<%= n.getBno() %>" />
								<td><%= n.getBno() %></td>
								<td><%= n.getBcls() %></td>
								<td><%= n.getBtitle() %></td>
								<td><%= n.getBwriter() %></td>
								<td><%= n.getBdate() %></td>
								<td><%= n.getBcount() %></td>
							</tr>
							<% } %>
							<%  System.out.println(list); %>
						</tbody>
					</table>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

		<!--버튼 묶음-->
		<div>
			<!--검색-->
			<form class="navbar-search pull-left" style="height: 0px;"
				action="<%=request.getContextPath()%>/nsearch.ns?currentPage=1&type=<%=ntype%>">
				<div class="btn-group" style="width: 100px; padding-left: 13.2%;">
					<select name="slist" style="height: 35px;">
						<option value="btitle">제목</option>
						<option value="bwrite">작성자</option>
					</select> 
					<input style="height:35px" type="text" name="con" placeholder="입력"> 
					<input style="height:35px" type="submit" class="btn btn-outline-secondary" value="검색">
					<input type="hidden" name="ntype" value=<%=ntype %>>
				</div>
			</form>
			<!--/검색-->

			<!--페이지-->
			<div style="margin-left: 40%; margin-top: 0px;">
				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<li class="page-item"><a
							onclick="location.href='<%= request.getContextPath()  %>/noticeList.nl?currentPage=1&type=<%=ntype %>'"
							class="page-link"><<</a> <%  if(currentPage <= 1){  %>
						<li class="page-item"><a class="page-link">Previous</a></li>
						<%  }else{ %>
						<li class="page-item"><a
							onclick="location.href='<%= request.getContextPath() %>/noticeList.nl?currentPage=<%=currentPage - 1 %>&type=<%=ntype %>'"
							class="page-link">Previous</a></li>
						<%  } %>

						<% for(int p = startPage; p <= endPage; p++){
									if(p == currentPage){ 
								%>
						<li class="page-item"><a class="page-link"
							style="background-color: lightblue;"><%= p %></a></li>
						<%  }else{ %>
						<li class="page-item"><a
							onclick="location.href='<%= request.getContextPath() %>/noticeList.nl?currentPage=<%= p %>&type=<%=ntype %>'"
							class="page-link"><%= p %></a></li>
						<%  } %>
						<% } %>


						<li class="page-item"><a
							onclick="location.href='<%= request.getContextPath() %>/noticeList.nl?currentPage=<%=currentPage + 1 %>&type=<%=ntype %>'"
							class="page-link">Next</a></li>
						<li class="page-item"><a
							onclick="location.href='<%= request.getContextPath()  %>/noticeList.nl?currentPage=<%=maxPage%>&type=<%=ntype %>'"
							class="page-link">>></a>
						<li>
							<div style="margin-left: 290px; margin-top: 0px;">
								<span class="card-footer"
									style="background-color: transparent !important; border-top: white;">
									<button type="submit" class="btn btn-info "
										style="border-color: #007bff; background-color: #007bff; position: absolute; left:1250px;"
										onclick="location.href='views/5_board/noticeWriter3.jsp?type=<%=ntype%>'">글작성</button>
									<!-- <button type="submit" class="btn btn-default">삭제</button> -->
								</span>
							</div>
						</li>
					</ul>
				</nav>
			</div>
			<!--/페이지-->
			<!-- 글작성 버튼 -->
			<!-- /글작성 버튼 -->
		</div>
		<!-- /버튼 묶음 -->
	</section>
	<!-- /.목록머리글 -->
	<script>
		$(function(){
			$("#example2 td").click(function(){
				var bno = $(this).parent().find("input").val();
				location.href="<%=request.getContextPath()%>/noticeDetail.nd?bno=" + bno;
			});
		});
</script>
<br>

	<%@include file="/common/footer.jsp"%>
</body>
</html>