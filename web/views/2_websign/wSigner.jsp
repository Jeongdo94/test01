<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, semi.cf.jsp.member.model.vo.*"%>

<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<!-- 부트스트랩4 -->
<!--  <link  rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> -->
<script type="text/css" src="/semi/resources/css/bootstrapDev.min.css"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- /부트스트랩4 -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">

<style>
.searchbar {
	margin-bottom: auto;
	margin-top: auto;
	height: 60px;
	background-color: #353b48;
	border-radius: 30px;
	padding: 10px;
}

.search_input {
	color: white;
	border: 0;
	outline: 0;
	background: none;
	width: 0;
	caret-color: transparent;
	line-height: 40px;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_input {
	padding: 0 10px;
	width: 450px;
	caret-color: red;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_icon {
	background: white;
	color: #e74c3c;
}

.search_icon {
	height: 40px;
	width: 40px;
	float: right;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 50%;
	color: white;
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-12 border-bottom-0"
			style="border: 1px solid gainsboro; height: 400px;">
			<div>
				<ul class="nav nav-pills nav-justified" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="one-tab"
						data-toggle="tab" href="#one" role="tab" aria-controls="one"
						aria-selected="true">이름</a></li>
					<li class="nav-item"><a class="nav-link" id="two-tab"
						data-toggle="tab" href="#one" role="tab" aria-controls="two"
						aria-selected="false">연락처</a></li>
					<li class="nav-item"><a class="nav-link" id="three-tab"
						data-toggle="tab" href="#one" role="tab" aria-controls="three"
						aria-selected="false">부서명</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<!-- one -->
					<div class="tab-pane fade show active" id="one" role="tabpanel"
						aria-labelledby="one-tab" style="text-align: center;">
					</div>
					<!-- /one -->
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-12"
			style="border-bottom: 1px solid gainsboro; height: 100px;">
			<div class="container h-100">
				<div class="d-flex justify-content-center h-100">
					<div class="searchbar">
						<input class="search_input" type="text" id="keyword"
							placeholder="Search..."> <a href="javascript:click();"
							class="search_icon"><i class="fas fa-search"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-4" style="text-align: center;">
			<div class="media text-muted pt-3 number" id=test1
				style="display: inline-block; margin-left: 10px;">
				<p>담당</p>
			</div>
		</div>
		<div class="col-4" style="text-align: center;">
			<div class="media text-muted pt-3 number" id=test2
				style="display: inline-block; margin-left: 10px;">
				<p>검토</p>
			</div>
		</div>
		<div class="col-4" style="text-align: center;">
			<div class="media text-muted pt-3 number" id=test3
				style="display: inline-block; margin-left: 10px;">
				<p>승인</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-4 border-top-0 alert alert-success"
			style="text-align: center;" id="div10">
			<div class="media text-muted pt-3"
				style="display: inline-block; margin-left: 10px;"></div>
		</div>
		<div class="col-4 border-top-0 alert alert-success"
			style="text-align: center;" id="div11">
			<div class="media text-muted pt-3"
				style="display: inline-block; margin-left: 10px;"></div>
		</div>
		<div class="col-4 border-top-0 alert alert-success"
			style="text-align: center;" id="div12">
			<div class="media text-muted pt-3"
				style="display: inline-block; margin-left: 10px;"></div>
		</div>
	</div>

	<div class="row">
		<div class="col-12" style="text-align: center; margin-bottom: 30px;">
			<select class="btn btn-primary" id="select" onchange="select()"
				style="text-align: center;">
				<option selected>선택</option>
				<option value="div10">담당</option>
				<option value="div11">검토</option>
				<option value="div12">결재</option>
			</select>
			<button class="btn btn-primary" onclick="sinsert()">추가하기</button>
		</div>
	</div>

	<script>

      var T = 0;
      var id_check;
      var text;

      function select(){
        id_check = document.getElementById("select");
        text = id_check.options[id_check.selectedIndex].value;

        console.log(text);
      }
	
      function button1(obj){
        var img = obj.children[0].src
        var name = obj.children[2].innerText
        var id = obj.children[3].innerText
        var posit = obj.children[4].innerText
        var dept = obj.children[5].innerText

    	console.log(obj); 
        document.getElementById(text).innerHTML +=
            "<div class='media text-muted pt-3 test' style='display: inline-block; margin-left: 10px; id=test"+T+"' onclick='delete2(this);'>"
          + "<img src="+img+" style='width: 50px;' id='simg' class='rounded-circle'>"
          + "<p class='media-body pb-3 mb-0 small lh-125'>"
          + "<strong class='d-block text-gray-dark' name='sName'>"+name+"</strong><strong class='d-block text-gray-dark' id='sId'>"+id+"</strong><label id='sPosit'>"+posit+"</label>&nbsp;"
          + "<label id='sDept'>"+dept+"</label>"
          + "</p>"
          + "</div>"
          T++;
        }
        function delete2(A){
          A.remove();
        }
        
        function click() {
        	<%-- location.href="<%=request.getContextPath()%>/wSearch.ws?con="+$('ul li a[aria-selected=true]').text()+"&keyword="+$('#keyword').val(); --%>
        	
        	$.ajax({
        		url : "/semi/wSearch.ws",
        		type : "get",
        		data : {
        			con : $('ul li a[aria-selected=true]').text(), 
        			keyword : $('#keyword').val()
        		},
        		success : function(result){
        			console.log(result);
        			
        			$('#one > div').remove();
        			$.each(result,function(index, value){
						var $div2 = $('<div class="media text-muted pt-3" id="member1" style="display: inline-block; margin-left: 20px;" onclick="button1(this)">');
						var $user_img = $('<img src="../../resources/images/pro.jpg" style="width: 50px;" class="rounded-circle" id="send1">').text(value.user_img);
						var $p = $('<p class="media-body pb-3 mb-0 small lh-125">');
						var $username = $('<strong class="d-block text-gray-dark" style="font-size=1px" id="send2">').text(value.userName);
						var $userId= $('<strong class="d-block text-gray-dark" style="font-size=1px" id="send2">').text(value.userId);
						var $posit = $('<label id="send3">').text(value.posit)
						var $dept = $('<label id="send4">').text(value.dept)
						
						$div2.append($user_img);
						$div2.append($p);
						$div2.append($username);
						$div2.append($userId);
						$div2.append($posit);
						$div2.append($dept);
						
						$('#one').append($div2);
					});		
        		},error:function(data){
        			console.log(data);
        		}
        	});
  
        } 
        
       	function sinsert() {
       		<%-- location.href="<%=request.getContextPath()%>/wSignerInsert.si?"; --%>
       		location.href = "<%=request.getContextPath()%>/wSignerInsert.si?rName="+$('.test')[0].innerText.substring(0,3)+"&rUserId="+$('.test')[0].innerText.substring(4,11)+"&gName="+$('.test')[1].innerText.substring(0,3)+"&gUserId="+$('.test')[1].innerText.substring(4,11)+"&bName="+$('.test')[2].innerText.substring(0,3)+"&bUserId="+$('.test')[2].innerText.substring(4,11);
       		$("#signer",opener.document).val($('.test')[0].innerText.substring(0,3)+" "+$('.test')[1].innerText.substring(0,3)+" "+$('.test')[2].innerText.substring(0,3));
       		window.close();
       	}
    </script>
</body>
</html>