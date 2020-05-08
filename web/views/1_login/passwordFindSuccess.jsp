<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String userId = (String)request.getAttribute("userId");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>비밀번호 인증 성공 새 비번을 입력해쥬쇼</title>
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
        <div style="text-align: center;">
            <div style="font-family: 'Tenor Sans', sans-serif; font-family: 'Bungee Shade', cursive; font-size: 5em;">
                <span style="color: indianred">CANDY</span>
                <span style="color: lightseagreen">FACTORY</span>
            </div>
            <hr style="width: 80%;">
			<form id="newPw" action="/semi/pwUpdate.pu" method="post">
            <diV>
                <span style="font-size: 1.5em;">비밀번호 변경</span><br>
                <span>새 비밀번호를 입력하세요</span>

                <hr style="width: 25%;">
            </div>

            <div style="text-align: center; width: 300px; margin: auto;">
                <div style="margin: auto; float: left; padding-top: 10px;">
                    <label style="margin-right: 10px; margin-bottom: 0px;">새 비밀번호</label><br><br>
                    <label style="margin-right: 10px; margin-bottom: 0px; padding-top: 10px;">새 비밀번호 재입력</label>
                </div>
                <div style="margin: auto;float: right;">
                	<input type="hidden" name="userId" value="<%=userId%>">
                    <input type="text" class="form-control" id="userPwd" name="userPwd1"><br>
                    <input type="text" class="form-control" id="userPwd" name="userPwd2">
                </div>
            </div>
            </form>
            <div style="margin-top: 150px; margin-bottom: 30px; margin-left: 10px;">
                <input class="btn btn-primary" type="button" style="width: 100px;" onclick="updatepw()" value="확인">
            </div>
        </div>
    </div>
    <script>
	function updatepw() {
		 $('#newPw').submit();
	}
	
    </script>
</body>
</html>