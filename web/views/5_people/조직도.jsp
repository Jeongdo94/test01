<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>회사 조직도</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap"
	rel="stylesheet">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="header.css">
</head>

<style>
body {
	font-family: 'Do Hyeon', sans-serif;
}

.t1 {
	text-align: center;
	margin-left: 3px !important;
}
</style>
</head>
<body>
<%@ include file="../../common/header.jsp"%>
      <div id="test" style="margin-top: 70px;">

	<div class="container">
		<div class="col" style="text-align: center;">
			<img src="/semi/resources/images/dept/빙봉.GIF" class="rounded-circle"
				style="width: 150px;">
			<h2>대표 이사</h2>


		</div>
	</div>

	<br>
	<br>
	<br>

	<div class="container">
		<div class="row" style="text-align: center;">
			<div class="col">
				<img src="/semi/resources/images/dept/2.jpg" class="rounded-circle"
					style="width: 150px;">
				<h5 class="t1" id="k1" onclick="method1()">경영지원본부</h5>
			</div>
			<!-- /.col-lg-4 -->
			<script>
        	function method1() {
        		location.href="<%=request.getContextPath()%>/selectOne.de?dept="+$('#k1').text();
        		
        	}
        </script>
			<div class="col">
				<img src="/semi/resources/images/dept/3.jpg" class="rounded-circle"
					style="width: 150px;">
				<h5 class="t1" id="k2" onclick="method2()">영업추진본부</h5>
			</div>
			<!-- /.col-lg-4 -->
			<script>
        	function method2() {
        		location.href="<%=request.getContextPath()%>/selectOne.de?dept="+$('#k2').text();
        		
        	}
        </script>

			<div class="col">
				<img src="/semi/resources/images/dept/4.jpg" class="rounded-circle"
					style="width: 150px;">
				<h5 class="t1" id="k3" onclick="method3()">생산본부</h5>
			</div>
			<script>
        	function method3() {
        		location.href="<%=request.getContextPath()%>/selectOne.de?dept="+$('#k3').text();
        		
        	}
        </script>

			<div class="col">
				<img src="/semi/resources/images/dept/5.jpg" class="rounded-circle"
					style="width: 150px;">
				<h5 class="t1" id="k4" onclick="method4()">해외생산본부</h5>
			</div>
			<script>
        	function method4() {
        		location.href="<%=request.getContextPath()%>/selectOne.de?dept="+$('#k4').text();
        		
        	}
        </script>

			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->
	</div>
</div>
<br>
<br>
<br>
<%@ include file="../../common/footer.jsp"%>
</body>
</html>