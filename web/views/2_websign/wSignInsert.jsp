<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>기안서작성</title>
    <!-- 부트스트랩4 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!-- /부트스트랩4 -->
    <!-- 글작성 에디터-->
    <!-- css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
    <!-- include summernote-ko-KR -->
    <script src="../../resources/js/summernote-ko-KR.js"></script>
    <!-- /글작성 에디터-->
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="../../common/header.jsp" %>

<div class="content-wrapper" style="width: 80%; margin: auto;">    
<div class="card">
    <!-- /.card-header -->
    <div class="card-body">
    <div class="card-body pad">
        <div class="form-group">
        <form action="<%= request.getContextPath() %>/wSignCon.sc" method="get">
            <table style="width: 100%">
                    <tr>
                        <td><label>일자</label></td>
                        <td>
                            <div class="input-group">
                                <input type="date" class="form-control float-right" id="reservation" name="wDate">
                            </div>
                        </td>
                    </tr>
                    
                     <tr>
                        <td><label>작성자</label></td>
                        <td>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="작성자" name="wWriter" value="<%= m.getUserName() %>">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td><label>제목</label></td>
                        <td>
                            <input type="text" class="form-control" placeholder="제목" name="wTitle">
                        </td>
                    </tr>
                    <tr>
                        <td><label>결재자</label></td>
                        <td>
                        	
                            <a onclick="window.open('wSigner.jsp', '_blank', 'width=600x,height=750px,left=500,top=0,toolbars=no,scrollbars=no'); return false;">
                                <input id="signer" name="signer" type="text" class="form-control" placeholder="결재자">
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td><label>구분</label></td>
                        <td><input name="wCls" type="text" class="form-control" placeholder="구분"></td>
                    </tr>
                    <tr>
                        <td><label>단계</label></td>
                        <td><input id="wStep" name="wStep" type="hidden" class="form-control" placeholder="단계" value="1"></td>
                    </tr>
            </table>
        </div>
        <textarea id="summernote" name="editordata">
        </textarea>
        <br>
        <div class="float-right">
            <button class="btn btn-default" onclick="list()"><i class="fas fa-times"></i> 취소 </button>
            <button type="submit" class="btn btn-success" onclick="text1(a)"><i class="fas fa-pencil-alt"></i>임시 저장</button>
            <button type="submit" class="btn btn-primary" onclick="document.getElementById('wStep').value = 2;"><i class="fas fa-pencil-alt"></i>작 성</button>
        </div>
        </form>
    </div>
    </div>
    <!-- /.card-body --> 
</div>
<!-- /.card -->
</div>

<!-- 글작성 에디터 -->
<script>
    $(document).ready(function() {
    });
    $('#summernote').summernote({
        height: 300,                 // set editor height
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true,
        lang: 'ko-KR' 		         // set focus to editable area after initializing summernote
    });
    
    function list() {
    	location.href = 'semi/signlist.sl'
    }
</script>

<%@ include file="../../common/footer.jsp" %>
<!-- /글작성 에디터 -->
</body>
</html>