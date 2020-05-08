<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="semi.cf.jsp.meetingroom.model.vo.*"%>
    
<%  
	MeetingRoom m1 = (MeetingRoom)request.getAttribute("meetingroom");
	/* MeetingRoom m = (MeetingRoom)request.getAttribute("meetingroom"); */	

 	String mtype = request.getParameter("type"); 
	String showTitle ="";
	switch(mtype){
	case "g": showTitle="일반회의실";
			  break;
	case "b": showTitle ="대회의실";
			  break;
	case "c": showTitle="고객접견실";
			break;
	default :showTitle="일반d회의실";
	  break;
	} 
	
	int mno = 0;
	if(request.getParameter("mno") != null){
		mno = Integer.parseInt(request.getParameter("mno"));
	}
	if(mno == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다.')");
		script.println("lacation.herf = 'meetingroomList.jsp'");
		script.println("/<script>");
	}

%>
<!DOCTYPE html>
<html>

<head>
  <title>예약 화면 상세보기</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">

  <style>
    #writer{
      margin: auto;
      width: 30%;
    }
  </style>
</head>

<body>
 <%@ include file="../../common/header.jsp" %>

    <!-- <form id="DeleteFrom" method="post"> -->
	<input type='hidden' name='newtype' value='<%= mtype %>'>
	
  <div style="text-align: center; margin-top: 100px; margin-bottom: 50px">
    <h1 id="mselect"><%= showTitle %> 예약</h1>
    <input type='hidden' name='mselect' value='<%= showTitle %>'>
    <hr style="width: 50%;">
  </div>

  <div id="big">
    <!--글씨가 표시되어있는 div-->
    <div id="writer" >
      <table>
      	<tr>
          <label style="margin-top: 10px; margin-bottom: 0px;" id="mno">글 번호 : </label>
          <%= m1.getMno()%><br>
        </tr>
     	<tr>
          <label style="margin-top: 10px; margin-bottom: 0px;">날 짜 : </label>
          <%= m1.getMdate() %><br>
        </tr>
        <tr>
          <label style="margin-top: 10px; margin-bottom: 0px;">시작 시간 : </label>
          <%= m1.getStime() %><br>
        </tr>
        <tr>
          <label style="margin-top: 10px; margin-bottom: 0px;">종료 시간 : </label>
          <%= m1.getFtime() %><br>
        </tr>
        <tr>
          <label style="margin-top: 10px; margin-bottom: 0px;">회 의 명 : </label>
          <%= m1.getMname() %><br>
        </tr>
        <tr>
          <label style="margin-top: 10px; margin-bottom: 0px;">부 서 명 : </label>
          <%= m1.getDept() %><br>
        </tr>
        <tr>
          <label style="margin-top: 10px; margin-bottom: 0px;">신 청 자 : </label>
          <%= m1.getUserid() %>
        </tr>
      </table>
    </div>
  <!--   </form> -->

    <div id="resultBtn" style="text-align:center; margin-top: 25px;">
      <input type="button" class="btn btn-primary" 
      onclick="location.href='/semi/meetingroomList.me?type='+'<%= mtype %>'" value="확 인">
      <input type="button" class="btn btn-primary"
      onclick="location.href='/semi/meetingroomDelete.me?mno='+'<%= m1.getMno()%>'+'&type='+'<%= mtype %>'" value="삭 제">
    </div> 
<%@ include file="/common/footer.jsp" %>
</body>
</html>