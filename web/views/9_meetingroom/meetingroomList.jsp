<%@page import="semi.cf.jsp.meetingroom.controller.MeetingRoomListServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, semi.cf.jsp.meetingroom.model.vo.*"%>
    
    <% 
    	ArrayList<MeetingRoom> list = (ArrayList<MeetingRoom>)request.getAttribute("list");
  		MeetingRoomListServlet ms = new MeetingRoomListServlet();
    	String mtype = request.getParameter("type");
    	System.out.println(mtype);
    	String showTitle ="";
    	switch(mtype){
    	case "g": showTitle="일반회의실";
    			  break;
    	case "b": showTitle ="대회의실";
    			  break;
    	case "c": showTitle="고객접견실";
    			break;
    	default :showTitle="일반회의실";
		  break;
    	}
    %>
<!DOCTYPE html>
<html>

<head>
    <title>회의실 예약입니다.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">
    
  
      <style>
      body{
        font-family:'Do Hyeon', sans-serif;
      }
      </style>

    <style>
        #big{
            margin: auto ;
            /* border: 1px solid red; */
            width: 80%;
        }

        .col-sm-3{
            margin: auto;
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
   <%@ include file="../../common/header.jsp" %>
    
      <div style="text-align: center; margin-top: 100px; margin-bottom: 50px">
        <h1><%= showTitle %> 예약</h1>
        <label id="title"></label><!-- 스크립트로 하기 -->
        <hr style="width: 50%;">
      </div>

    <div id="big">
    
        <div class="tab-content" id="myTabContent">
            <!-- 일반회의실 입니다. 그리드 이용해서 버튼이랑 크기 바꿔주기-->
            <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
                <table class="table table-hover table-bordered table-sm" id="listArea">
                    <thead>
                        <tr style="text-align: center;">
                            <th style="width: 10%;">날짜</th>
                            <th style="width: 10%;">사용 시간</th>
                            <th style="width: 60%;">회의명</th>
                            <th style="width: 10%;">신청자</th>
                            <th style="width: 10%;">부서명</th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center;">
                    <% for(MeetingRoom m1 : list){ %>
                        <tr>
                        <input type="hidden" value="<%= m1.getMno() %>"/>
                            <td><%= m1.getMdate() %></td>
                            <td><%= m1.getStime() %> ~ <%= m1.getFtime() %></td>
                            <td><%= m1.getMname() %></td>
                            <td><%= m1.getUserid() %></td>
                            <td><%= m1.getDept() %></td>
                        </tr>
                    	<% } %>
                    </tbody>
                </table>
                <div class="col-sm-3" style="text-align:center;"><button class="btn btn-primary" 
                onclick="location.href='views/9_meetingroom/meetingroomInsertForm.jsp?type='+'<%= mtype %>'">예약하기</button></div>
            </div>
           
            <!-- 인사발령 끝 -->
        </div>
    </div>     
    
    <hr>
    
    <script>
    	$(function(){
    		
    		$('#listArea td').click(function(){
    			var mno =$(this).parent().find("input[type=hidden]").val();
    			location.href="<%=request.getContextPath()%>/meetingroomSelectOne.me?type=<%=mtype%>"+"&mno=" + mno;
    		});
    	});
    </script>

<%@ include file="/common/footer.jsp" %>
</body>

</html>