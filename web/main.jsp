<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>메인화면 입니다.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">

	<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
    <style>
    body{
      font-family:'Do Hyeon', sans-serif;
    }

    /* .row{
        display: grid;
        grid-template-columns: 200px 1fr 200px;
    } */

/* 	p{
		margin-left:180px;
	} */
	
	#mainsearch{
	 width: 100px;
   	 height: 40px;
   	 border: 1px solid gray ;
   	 border-radius: 10px;
	
	}
	
    </style>
</head>
<body>
      <%@ include file="common/header.jsp"  %>

	 <!-- 메인 화면 bingbong  -->
	 <br>
	 
	 <div  style="margin-left:250px;">
	    <div style="width:45%; height:100%; display: inline-block; margin:20px; text-align: center;">
	   		<img src="resources/images/bingbong.gif"> 
		</div>
		<div style=" height:100%; display: inline-block; margin:50px; ">
			<div>
          		<label><%= m.getUserName() %> </label> <%= m.getPosit() %>님 반갑습니다.<br>
           		<a class="btn btn-sm btn-outline-secondary" href="#">My Page</a>
           		<a class="btn btn-sm btn-outline-secondary" onclick="location.href='/semi/logout.lo'">Logout</a>
          	</div>
			
			<div style="margin-top: 50px;">
			 <button class="btn btn" style="font-size: 1.7em; padding-right:55px"
											onclick="location.href ='<%=request.getContextPath()%>/main.jsp'" >
			 <i class="fas fa-home"></i>
			 </button>
			 
			 <button class="btn btn" style="font-size: 1.7em; padding-right:55px "
											onclick="location.href = ">
			 <i class="fas fa-clipboard-check"></i>
			 </button>
			 
			  <button class="btn btn" style="font-size: 1.7em; padding-right:55px"
											onclick="location.href = '<%=request.getContextPath()%>/noticeList.nl?type=a' ">
			 <i class="fas fa-list-ol"></i>
			 </button>
			 
			 <button class="btn btn" style="font-size: 1.7em; padding-right:55px"
											onclick="location.href = '<%=request.getContextPath()%>/meetingroomList.me?type=g ">
			 <i class="fas fa-clock"></i>
			 </button>
			 
			 <button class="btn btn" style="font-size: 1.7em; padding-right:55px"
											onclick="location.href = ">
			 <i class="fas fa-address-card"></i>
			 </button>
			 <br>
			</div>
		
		</div>
	
	 </div>
	 

	
	 
	 
	<div> 
	 
	 </div>
	 
      <%@ include file="common/footer.jsp" %>
</body>
</html>