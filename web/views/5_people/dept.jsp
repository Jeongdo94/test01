<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="semi.cf.jsp.people.model.vo.*, java.util.*"%>

<%
	ArrayList<Department> list = (ArrayList<Department>) request.getAttribute("list");
	Department d1 = (Department)request.getAttribute("dept");
	String deptName = request.getParameter("dept");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

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
	<%@ include file="../../common/header.jsp"%>

	<div class="container">

		<div
			style="text-align: center; margin-top: 100px; margin-bottom: 100px;">
			<h1>
			<%-- 	<%
					de.getDept();
				%> --%>
				<%= deptName %>
			</h1>
			<hr style="width: 50%;">
		</div>

		<!-- 1번째줄 프로필 -->
		<div class="row">
			<!-- 프로필 1 -->
			<%
				for (Department d : list) {
			%>
			<div class="col-md-6">
				<div
					class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
						<strong class="d-inline-block mb-2 text-primary"><%=d.getDept()%></strong>
						<div id="<%=d.getUserid()%>" onclick="updateMember(this.id);">
							<h3 class="mb-0"><%=d.getUsername()%></h3>
						</div>
						<div class="mb-1 text-muted">
							<label><%=d.getPosit()%></label>&nbsp;<label><%=d.getUserid()%></label><br>
							<label><%=d.getEmail()%></label><br> <label><%=d.getPhone()%></label>
						</div>
						<p>
							안녕하세요 저는
							<%=d.getDept()%>의
							<%=d.getUsername()%>
							입니다.
						</p>
					</div>
					<div class="col-auto d-none d-lg-block">
						<img src="/semi/resources/images/dept/하마.png" alt="프로필 이미지"
							style="width: 120px">
					</div>
				</div>
			</div>
			<%
				}
			%>

			<script>
           function updateMember(aguments) {
        	   var userid = aguments;
        	   
        	   location.href="<%=request.getContextPath()%>/select.me?userid="+ userid;
				}
			</script>
			<!-- /.content -->
		</div>
	</div>

	<%@ include file="../../common/footer.jsp"%>
</body>
</html>
