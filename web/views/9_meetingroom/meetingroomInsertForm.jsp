<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%     	
		String mtype = request.getParameter("type"); 
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
<title>예약 화면 작성</title>
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

<style>
#writer {
	margin: auto;
	width: 30%;
}
</style>
</head>

<body>
	<%@ include file="../../common/header.jsp" %>
	<form id="insertform" action="/semi/meetingroomInsert.me" method="post">

		<input type='hidden' name='newtype' value='<%= mtype %>'>

		<div
			style="text-align: center; margin-top: 100px; margin-bottom: 50px">
			<h1 id="mselect"><%= showTitle %>
				예약
			</h1>
			<input type='hidden' name='mselect' value='<%= showTitle %>'>
			<hr style="width: 50%;">
		</div>

		<div id="big">
			<!--글씨가 표시되어있는 div-->
			<div id="writer">
				<table>
					<tr>
						<label style="margin-top: 10px; margin-bottom: 0px;">시작 시간
							: </label>
						<input type="Time" class="form-control" id="StartTime"
							name="stime">
					</tr>
					<tr>
						<label style="margin-top: 10px; margin-bottom: 0px;">종료 시간
							: </label>
						<input type="Time" class="form-control" id="FinishTime"
							name="ftime" value="00:00">
					</tr>
					<tr>
						<label style="margin-top: 10px; margin-bottom: 0px;">회 의 명
							: </label>
						<input type="Text" class="form-control" id="Mname" name="mname">
					</tr>
					<tr>
						<label style="margin-top: 10px; margin-bottom: 0px;">부 서 명
							: </label>
						<input type="Text" class="form-control" id="TeamName"
							name="TeamName" value="<%= m.getDept()%>">
					</tr>
					<tr>
						<label style="margin-top: 10px; margin-bottom: 0px;">신 청 자
							: </label>
						<input type="Text" class="form-control" id="People" name="People" value="<%= m.getUserName()%>">
					</tr>
				</table>
			</div>
			<!--   </form> -->
			<div id="resultBtn" style="text-align: center; margin-top: 25px;">
				<button type="submit" class="btn btn-primary" id="one();"
					onclick="location.href='/semi/meetingroomInsert.me?type='+'<%= mtype %>'">예 약</button>
				<input type="button" class="btn btn-primary" onsubmit="return false"
					onclick="location.href='/semi/meetingroomList.me?type='+'<%= mtype %>'"
					value="목 록">
				<!-- 정도가 원하는것 
      		1. 확인을 눌렀을때 목록으로 돌아가고 싶다.
      		2. 게시판 구분 글자 스크립트로 하던거 ㅠㅎㄱ윻ㄱ휵휴고		
      -->
			</div>

			<hr>
	</form>
	<!-- //---------------------------------------------------- -->
	<%@ include file="/common/footer.jsp" %>
	<Script>
	function one(){
		
		var varFrom = document.getElementById("one");
		var beginTm = varFrom.StartTime.value;
		var endTm   = varFrom.FinishTime.value;
		
		if((endTm-beginTm) > 0){
			var arrParam = new Array(1);
			arrParam[0] = window;
		    sTempValue = "sTmResveDe="+varFrom.resveDe.value+"&sTmResveBeginTm="+varFrom.resveBeginTm.value+"&sTmResveEndTm="+varFrom.resveEndTm.value+"&sTmMtgPlaceId="+varFrom.mtgPlaceId.value+"&sTmResveId="
		 	window.showModalDialog("/semi/meetingroomDup.me?"+sTempValue, arrParam,"dialogWidth=450px;dialogHeight=150px;resizable=yes;center=yes");
	   }
	   else alert("예약시작시간이  예약종료시간보다 작거나 같습니다. 예약시간을 확인해  주세요.");
	}
	/* $('#one').click(function(){
		$.ajax({
			url:"/semi/meetingroomDup.me",
			type:"post",
			data:{StartTime: $('#StartTime').val(),
				FinishTime: $('#FinishTime').val()},
			success:function(data){
				console.log(data);
				
				if(data=='ok'){
					alert("예약 가능");
				}else{
					alert('예약 불가');
					$('#StartTime').select();
				}
			},error:function(){
				console.log("Error 입니다.");
			}
			
		});
	}); */
	
	</Script>
</body>
</html>