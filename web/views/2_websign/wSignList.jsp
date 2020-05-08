<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, semi.cf.jsp.websign.model.vo.*"%>

<% 
	ArrayList<wSign> list = (ArrayList<wSign>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>기안서작성</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>

	<!-- 목록 머리글 -->
	<div class="content">
		<div style="width: 80%; margin: auto;">
			<!-- 목록 바디글-->
			<div class="card-body"
				style="padding-left: 50px; padding-right: 50px;">
				<table id="example2" class="table table-bordered table-hover">
					<thead style="background-color: rgb(240, 248, 255);">
						<tr>
							<th style="width: 10%;">정렬순서</th>
							<th style="width: 75%;">양식명</th>
							<th style="width: 15%;">구분</th>
						</tr>
					</thead>
					<tbody>
						<%  int count = 0;
							for(wSign w : list){ 
						%>
						<tr>
							<td><%= count++ %></td>
							<td><%= w.getwTitle() %></td>
							<td><%= w.getwCls()%></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
		<div style="padding-left: 35%;">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link"
						onclick="location.href='<%= request.getContextPath() %>/signlist.sl?currentPage=1'"><<</a></li>
					<%  if(currentPage <= 1){  %>
					<li class="page-item"><a class="page-link" onclick=""><</a></li>
					<%  }else{ %>
					<li class="page-item"><a class="page-link"
						onclick="location.href='<%= request.getContextPath() %>/signlist.sl?currentPage=<%=currentPage - 1 %>'"><</a></li>
					<%  } %>

					<% for(int p = startPage; p <= endPage; p++){
						  if(p == currentPage){	
				 %>
					<li class="page-item"><a class="page-link" href="#" )><%= p %></a></li>
					<%      }else{ %>
					<li class="page-item"><a class="page-link"
						onclick="location.href='<%= request.getContextPath() %>/signlist.sl?currentPage=<%= p %>'"><%= p %></a></li>
					<%      } %>

					<% } %>

					<%  if(currentPage >= maxPage){  %>
					<li class="page-item"><a class="page-link" onclick=""></a></li>
					<%  }else{ %>
					<li class="page-item"><a class="page-link"
						onclick="location.href='<%= request.getContextPath() %>/signlist.sl?currentPage=<%=currentPage + 1 %>'">></a></li>
					<%  } %>
					<li class="page-item"><a class="page-link"
						onclick="location.href='<%= request.getContextPath() %>/signlist.sl?currentPage=<%= maxPage %>'">>></a></li>
					<li style="margin-left: 238px">
						<div class="float-right">
							<button type="submit" class="btn btn-primary" onclick="location.href='views/2_websign/wSignInsert.jsp'">
								<i class="fas fa-pencil-alt"></i>문서작성
							</button>
						</div>
					</li>
				</ul>
			</nav>

		</div>
	</div>

	<%@ include file="../../common/footer.jsp"%>
</body>
</html>