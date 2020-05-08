<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="semi.cf.jsp.member.model.vo.*"%>
    
<% 
   Member m = (Member)session.getAttribute("member"); 
%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CANDY FACTORY</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">
    
  
    <style>
        #con{
            font-family:'Do Hyeon', sans-serif;
            width: 80%;
            margin-left: 9%;
            /* margin-right; */
            margin-top: 10%;
        }
    </style>
</head>
<body>
    <div id="con">
       <form id="loginForm" action="/semi/login.lo" method="post">
        <div style="text-align: center;">
            <div style="font-family: 'Tenor Sans', sans-serif; font-family: 'Bungee Shade', cursive; font-size: 5em;">
                <span style="color: indianred">CANDY</span><br>
                <span style="color: lightseagreen">FACTORY</span>
            </div>
            <hr style="width: 80%;">
            <div style="text-align: center; width: 300px; margin: auto;">
                <div style="margin: auto; float: left; padding-top: 10px;">
                    <label style="margin-right: 10px; margin-bottom: 0px;">사번</label><br><br>
                    <label type="hidden">&nbsp;</label>
                    <label style="margin-right: 10px; margin-bottom: 0px; padding-top: 10px;">비밀번호 </label>
                </div>
                <div style="margin: auto;float: right;">                    
                    <input type="text" class="form-control" name="userId"><br>
                    <input type="text" class="form-control" name="userPwd">
                </div>
            </div>
            <div style="margin: auto; width: 280px; padding-top: 120px;">
                <div style="float: center;">
                    <label style="margin-bottom: 0px;"><a href="/semi/views/1_login/passwordFind.jsp">비밀번호 찾기</a></label>
                </div>
            </div>
        </form>
            <div style="margin-top: 20px; margin-bottom: 30px; margin-left: 10px;">
                <input class="btn btn-primary" type="button" style="width: 295px;" value="로그인" onclick='login()'>
            </div>
        </div>
    </div>
    
    <script>
      function login(){
         $('#loginForm').submit();
      }      
   </script>
</body>
</html>