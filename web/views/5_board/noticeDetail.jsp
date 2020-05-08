<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="semi.cf.jsp.board.model.vo.*,semi.cf.jsp.boardComment.model.vo.* ,java.util.*,semi.cf.jsp.board.model.vo.*"%>
<%
	Notice n = (Notice) request.getAttribute("notice");

	ArrayList<Comment> clist = (ArrayList<Comment>) request.getAttribute("clist");

	String ntype = n.getBtype();

	String noticeType = null;

	switch (ntype) {
	case "공지사항":
		noticeType = "a";
		break;
	case "인사게시판":
		noticeType = "b";
		break;
	case "일반게시판":
		noticeType = "c";
		break;
	case "경조사게시판":
		noticeType = "d";
		break;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항_세부내용</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap"
	rel="stylesheet">
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<style>
body {
	font-family: 'Do Hyeon', sans-serif;
}
</style>
</head>
<%@ include file="/common/header.jsp"%>

<div style="text-align: center; margin-top: 100px; margin-bottom: 50px;">
	<h1><%=n.getBtype()%></h1>
	<hr style="width: 50%;">
</div>


<!-- 세부내용 바디글 -->
<div class="container">
	<!-- right column -->
	<div class="row">
		<div class="card card-primary card-outline">
			<div class="card-header"
				style="padding-top:22px; padding-bottom:22px; background-color: rgb(240, 248, 255); font-family: 'Do Hyeon', sans-serif;">
				<h3 class="card-title" style="margin-bottom: 0px; font-size: 17px">
					<span style="float: left;">작성자: <%= n.getBwriter()%></span>
					<span style="float: right; padding-right: 80px;">조회수 : <%=n.getBcount()%></span><br><hr>
					<span style="float: left; margin-top: 10px; margin-bottom: 10px;">제목 : <%=n.getBtitle()%></span>
					<span style="float: right; padding-top:10px; padding-right: 18px;">작성일 : <%=n.getBdate()%></span><br><br><hr>
					<span style="float: left; width:1000px; margin-right: 810px;">첨부파일: <a href="/semi/nfdown.no?path=<%=n.getBoardfile()%>"><%=n.getBoardfile()%></a></span>
				</h3>
			</div>
			<div
				class="card-body; font-family: 'Gamja Flower', cursive; font-family: 'Sunflower', sans-serif; ">
				<div class="tab-content" id="custom-content-below-tabContent"
					style="margin-top: 20px; margin-left: 20px; font-size: 18px;">
					<%=n.getBcon()%>
				</div>
			</div>
			<hr style="margin-bottom: 0px;">
			<div>
				<div class="card-footer float-right"
					style="background-color: transparent !important; border-top: white;">
					<form action="<%=request.getContextPath()%>/updateView.ud"
						method="post">
						<input type="hidden" name="bno" value=<%=n.getBno()%>> <input
							type="hidden" name="btype" value=<%=noticeType%>>
						<%
							if (m != null && m.getUserName().equals(n.getBwriter())) {
						%>
						<button type="submit" class="btn btn-info "
							style="border-color: #007bff; background-color: #007bff;">수정</button>

						<%
							}
						%>
					</form>
					<button type="submit" class="btn btn-default" style=" border-color: #007bff;"
						onclick="location.href = '<%=request.getContextPath()%>/noticeList.nl?type=<%=noticeType%>'">목록</button>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>
<!--댓글-->
<div class="container" style="padding: 0">
	<div>
		<div class="card" style="font-family: 'Do Hyeon', sans-serif;">
			<div class="card-header"
				style="background-color: rgb(240, 248, 255);">
				<h6 style="margin-bottom: 0px;">댓글</h6>
			</div>
			<div class="card-body" style="padding-bottom: 0px;">
				<form action="<%=request.getContextPath()%>/commentInsert.cn"
					method="post">
					<input type="hidden" name="writer" value=<%=m.getUserName()%>>
					<input type="hidden" name="bno" value=<%=n.getBno()%>> <input
						type="hidden" name="ntype" value=<%=n.getBtype()%>>
					<div>
						<textarea id="textbox_comment_input" name="replyContent"
							class="form-control" rows="3" placeholder="Enter ..."></textarea>
						<button type="submit" id="btn_comment_save" class="btn btn-info "
							style="margin-top: 10px; float: right; border-color: #007bff; background-color: #007bff;"
							onclick="fn_comment_save()">작성</button>
					</div>
				</form>
			</div>



			<div id="textbox_comment_list" style="width: 100%;">

				<!--댓글 보여주기 부분  -->
				<%
					if (clist != null) {
				%>
				<%
					for (Comment co : clist) {
				%>

				<table id="replySelectTable" style="width: 1110px; margin-left: 40px;">
					<tr>
						<td style="width: 720px;"><%=co.getCcon()%></td>
						<hr style="border: solid 0.4px gray;">
						&nbsp
						<td style="float: right; margin-left: 30px; margin-right: 50px;"><%=co.getCwriter()%></td>
						<td style="float: right;"><%=co.getCdate()%></td>
						<td style="float: right;">
							<%
								if (m.getUserName().equals(co.getCwriter())) {
							%>
							<form action="<%=request.getContextPath()%>/cDelete.cd"
								method="post">
								<input type="hidden" name="cno" value="<%=co.getCno()%>">
								<input type="hidden" name="bno" value=<%=n.getBno()%>>
								<button class="btn btn-danger"
									style="font-size: 0.8em; margin-right: 20px;"
									onclick="location.href = '<%=request.getContextPath()%>/cDelete.cd?'">
									<i class="fas fa-trash"></i>
								</button>
							</form> <%
 	}
 %>

						</td>
					</tr>
				</table>
				<br>
				<%
					}
					}
				%>
			</div>
		</div>
	</div>
</div>

<hr>
<!-- /.세부내용 바디글 -->

<%@include file="/common/footer.jsp"%>
</body>
</html>



<%-- <script>
                function fn_comment_save() {
                    var textbox_text = $('#textbox_comment_input').val();
                    var date = new Date();
                    var nowdate = date.toDateString();
                    console.log(date.toDateString());
                    console.log(date.toTimeString());
                    var month = date.getMonth()+1;
                    var nowTime = ('   '+date.getFullYear()+'년 '+month+'월 '+ date.getDate()+'일 '+'       '+date.getHours()+'시:'+date.getMinutes()+'분');
					var writer = '<%=m.getUserName() %>';
					
					
                    if(textbox_text == ''){
                      alert("메세지를 입력해주세요.");
                      return
                    }

                    /* $('#textbox_comment_list').append('<div>'+textbox_text+nowdate+nowTime+'</div>');//댓글 화면에 입력
                    */ 
                    $('#textbox_comment_list').append('<div>'+textbox_text+'<br>'+nowTime+'</div>');//댓글 화면에 입력
                	
                    $('#textbox_comment_list').append(writer);
                    
                    $('#textbox_comment_list').append('<hr width="1080px">');
                    
                    $('#textbox_comment_input').val(''); //댓글 초기화  
                    }                
              </script> --%>
