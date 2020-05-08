<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, semi.cf.jsp.websign.model.vo.*"%>
<%
	wSign ws = (wSign)request.getAttribute("wSign");
	ArrayList<wSign_Psn> list2 = (ArrayList<wSign_Psn>)request.getAttribute("wSign_Psn");
/* 	wSign_Psn wp2 = (wSign_Psn)request.getAttribute("wSign_Psn2");
	wSign_Psn wp3 = (wSign_Psn)request.getAttribute("wSign_Psn3"); */
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>기안서작성</title>
<!-- 부트스트랩4 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- /부트스트랩4 -->
<!-- 글작성 에디터-->
<!-- css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<!-- include summernote-ko-KR -->
<script src="../../resources/js/summernote-ko-KR.js"></script>
<!-- /글작성 에디터-->
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp"%>

	<div class="content-wrapper" style="width: 80%; margin: auto;">
		<div class="card">
			<!-- /.card-header -->
			<div class="card-body">
				<div class="card-body pad">
					<div class="form-group">
						<form action="<%= request.getContextPath() %>/wSignCon.sc"
							method="post">
							<table style="width: 100%">
								<tr>
									<td><label>일자</label></td>
									<td>
										<div class="input-group">
											<input type="date" class="form-control float-right"
												id="reservation" name="wDate" value="<%= ws.getwDate() %>" disabled>
										</div>
									</td>
								</tr>

								<tr>
									<td><label>작성자</label></td>
									<td>
										<div class="input-group">
											<input type="text" class="form-control" placeholder="작성자"
												name="wWriter" value="<%= ws.getwWriter() %>" disabled>
										</div>
									</td>
								</tr>

								<tr>
									<td><label>제목</label></td>
									<td><input type="text" class="form-control"
										placeholder="제목" name="wTitle" value="<%= ws.getwTitle() %>" disabled></td>
								</tr>
								<tr>
									<td><label>결재자</label></td>
									<td><input id="signer" name="signer" type="text"
										class="form-control" placeholder="결재자" value="<%= ws.getSigner() %>" disabled> </a></td>
								</tr>
								<tr>
									<td><label>구분</label></td>
									<td><input name="wCls" type="text" class="form-control"
										placeholder="구분" value="<%= ws.getwCls() %>" disabled></td>
								</tr>
							</table>
					</div>
					<div class="row float-right"
						style="margin: auto; text-align: center; margin-bottom: 50px;">
						<div class=""
							style="border: 1px solid black; width: 30px; margin-left: 71.5%; padding: 7px;">
							결<br>
							<br>재
						</div>
						<%
							String[] m2 = {"담당", "검토", "결재"};
							
							 for(int i=0; i < list2.size(); i++) {
						%>
						<div class="col-1"
							style="border: 1px solid black; width: 300px; padding: 0px;">
							<%=m2[i]%>
							<hr
								style="background-color: black; margin-top: 0px; margin-bottom: 0px;">
								<% if(list2.get(i).getAppr_Yn().equals("Y")) { %>
								<img src="<%= list2.get(i).getSign()%>" style="width: 4em;">
								<% } %>
						</div>
						<% } %>
						<%-- <div class="col-1"
							style="border: 1px solid black; width: 300px; padding: 0px;">
							검 토
							<hr
								style="background-color: black; margin-top: 0px; margin-bottom: 0px;">
							<% if(wp.getApprOrder() == 3 && wp.getAppr_Yn().equals("Y")) { %>
								<img src="<%= wp.getSign()%>" style="width: 4em;">
								<% } %>
						</div>
						<div class="col-1"
							style="border: 1px solid black; width: 300px; padding: 0px;">
							결 재
							<hr
								style="background-color: black; margin-top: 0px; margin-bottom: 0px;">
							<% if(wp.getApprOrder() == 4 && wp.getAppr_Yn().equals("Y")) { %>
								<img src="<%= wp.getSign()%>" style="width: 4em;">
								<% } %>
						</div> --%>
					</div>
					<br>
					<br>
					<br>
					<br>
					<div id="summernote" name="editordata" style="margin-top: 50px;">
					<%= ws.getwCon() %>
					</div>
					</form>
						<br>
						<div class="float-right">
							<button type="reset" class="btn btn-default"
								onclick="location.href = 'signlist.sl'";>
								<i class="fas fa-times"></i> 목 록 
							</button>
							
							<%
								String[] m3 = {"담당", "검토", "결재자"};
								 for(int i=0; i < list2.size(); i++) {
							%>
							
							<% if(m != null && m.getUserId().equals(list2.get(i).getUserId()) && list2.get(i).getAppr_Yn().equals("N")) { %>
							<button class="btn btn-primary" onclick="location.href='<%= request.getContextPath() %>/wSignYnServlet.sy?wno=<%=ws.getwNo()%>&id=<%= m.getUserId()%>'">
								<i class="fas fa-pencil-alt"></i><%= m3[i] %> 결재
							</button>
							<% } %>
							
							
							<% if(m != null && m.getUserId().equals(list2.get(i).getUserId()) && list2.get(i).getAppr_Yn().equals("N")) { %>
							<% if(i == 0) continue;%>
							<button class="btn btn-danger" onclick="location.href='<%= request.getContextPath() %>/wSignYnServlet2.sy?wno=<%=ws.getwNo()%>&id=<%= m.getUserId()%>'">
								<i class="fas fa-pencil-alt"></i>반려
							</button>
							<% } %>
							<% } %>

							<%-- <% if(m != null && wp.getApprOrder() == 2  && wp.getAppr_Yn().equals("N")) { %>
							<button class="btn btn-primary" onclick="location.href='<%= request.getContextPath() %>/wSignYnServlet.sy?wno=<%=ws.getwNo()%>'">
								<i class="fas fa-pencil-alt"></i>검토자 결재
							</button>
							<% } %>
							
							<% if(m != null && wp.getApprOrder() == 3  && wp.getAppr_Yn().equals("N")) { %>
							<button class="btn btn-primary" onclick="location.href='<%= request.getContextPath() %>/wSignYnServlet.sy?wno=<%=ws.getwNo()%>'">
								<i class="fas fa-pencil-alt"></i>결재자 결재 
							</button>
							<% } %> --%>
						</div>
					</div>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->
		</div>
		</div>

		<%@ include file="../../common/footer.jsp"%>
		<!-- /글작성 에디터 -->
</body>
</html>