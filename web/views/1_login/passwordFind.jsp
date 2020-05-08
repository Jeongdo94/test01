<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="semi.cf.jsp.member.model.vo.*" %>
<%
	Member m = (Member)session.getAttribute("member");
	Member m1 = new Member();
%>
  

<!DOCTYPE html>
<html lang="en">
<head>
    <title>그러게 왜 비번을 까먹니 귀찮게 ㅎㅎ</title>
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

            <diV>
                <span style="font-size: 1.5em;">비밀번호 찾기</span><br>
                <span>사원번호와 주민등록번호를 통해 찾으실 수 있습니다.</span>

                <hr style="width: 25%;">
            </div>
			<form method="POST" id="findform" action="/semi/pwFind.pf">
            <div style="text-align: center; width: 300px; margin: auto;">
                <div style="margin: auto; float: left; padding-top: 10px;">
                    <label style="margin-right: 10px; margin-bottom: 0px;">사원번호</label><br><br>
                    <label type="hidden">&nbsp;</label>
                    <label style="margin-right: 10px; margin-bottom: 0px; padding-top: 10px;">주민등록번호</label>
                </div>
                <div style="margin: auto;float: right;">                    
                    <input name="userId" type="text" class="form-control" id="userId"><br>
                    <input name="userNo" type="text" class="form-control" id="userNo" placeholder="-포함 입력해주세요">
                </div>
            </div>
            	<div style="margin-top: 0px; margin-bottom: 30px; margin-left: 10px;">
                <input type="submit" class="btn btn-primary" type="button" style="width: 100px; margin-top:20px;" 
                onclick="return result()" value="찾기">
            </div>
            </form>
        </div>
    </div>
</body>

    <script>
    
      function result(){
         var userId = document.getElementById("userId").value;
         var userNo = document.getElementById("userNo").value;
         
         console.log(userId);
         console.log(userNo);
         console.log(userId.value);
         console.log(<%= m1.getUserNo()%>);
         
         if(userId == "" || userNo==""){
            alert("모든 정보를 입력해주세요");
            return false;
         }else if(userId != userId.value || userNo != userNo.value){
        	 alert("인증 실패");
        	return true;
         }
      }
    
    </script>

</html>