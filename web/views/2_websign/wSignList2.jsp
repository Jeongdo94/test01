<!-- 각 탭마다 for문으로 여러 게시판 출력해보기 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, semi.cf.jsp.websign.model.vo.*"%>
    
<%
	ArrayList<wSign> list = (ArrayList<wSign>)request.getAttribute("list");
	ArrayList<wSign_Psn> list2 = (ArrayList<wSign_Psn>)request.getAttribute("psn");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>기안서작성</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="../../common/header.jsp"%>

    <!-- 목록 머리글 -->
    <section class="content" style="width:80%; margin:auto;">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <!-- /.목록 머리글-->
              <!-- 목록 바디글-->
              <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="all-tab" data-toggle="tab" href="#all" role="tab" aria-controls="all" aria-selected="true">전체</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="draft-tab" data-toggle="tab" href="#draft" role="tab" aria-controls="draft" aria-selected="false">기안</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="ing-tab" data-toggle="tab" href="#ing" role="tab" aria-controls="ing" aria-selected="false">진행</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="return-tab" data-toggle="tab" href="#return" role="tab" aria-controls="return" aria-selected="false">반려</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="sign-tab" data-toggle="tab" href="#sign" role="tab" aria-controls="sign" aria-selected="false">결재</a>
                </li>
              </ul>
              <div class="tab-content" id="myTabContent">
                <!-- 전체 -->
                <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
                    <table class="table table-bordered">
                        <thead style="text-align: center;">                  
                            <tr>
                                <th style="width: 12%;">기안일자</th>
                                <th style="width: 34%;">제목</th>
                                <th style="width: 14%;">구분</th>
                                <th style="width: 8%;">기안자</th>
                                <th style="width: 14%;">결재자</th>
                                <th style="width: 8%;">진행상태</th>
                                <th style="width: 10%;">결재상태</th>
                            </tr>
                        </thead>
                        <tbody style="text-align: center;">
                        
                            <% for(wSign w : list){ %>
                            <tr>
                            	<td hidden><%= w.getwNo() %></td>
                                <td><%= w.getwDate() %></td>
                                <td><%= w.getwTitle() %></td>
                                <td><%= w.getwCls() %></td>
                                <td><%= w.getwWriter() %></td>
                                <td><%= w.getSigner() %></td>
                                <td><% if(w.getsStep() == 2) {%> 결재요청
                                	<% }else if(w.getsStep() == 3) {%> 기안 
                                	<% }else if(w.getsStep() == 4) {%> 검토승인 
                                	<% }else if(w.getsStep() == 5) {%> 결재완료
                                	<% }else if(w.getsStep() == 6) {%> 반려 <% } %></td>
                                <td><a href="<%=request.getContextPath()%>/selectOne.ws?wno=<%= w.getwNo() %>&step=<%= w.getsStep() %>&id=<%= m.getUserId() %>">보기</a></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <!-- /전체 -->
                <!-- 기안중 -->
                <div class="tab-pane fade" id="draft" role="tabpanel" aria-labelledby="draft-tab">
                    <table class="table table-bordered">
                        <thead style="text-align: center;">                  
                            <tr>
                                <th style="width: 12%;">기안일자</th>
                                <th style="width: 34%;">제목</th>
                                <th style="width: 14%;">구분</th>
                                <th style="width: 8%;">기안자</th>
                                <th style="width: 14%;">결재자</th>
                                <th style="width: 8%;">진행상태</th>
                                <th style="width: 10%;">결재상태</th>
                            </tr>
                        </thead>
                        <tbody style="text-align: center;">
                        	
                            <% for(wSign w : list){ %>
                            <% if(w.getsStep() == 3) {%>
                            <tr>
                            	<td hidden><%= w.getwNo() %></td>
                                <td><%= w.getwDate() %></td>
                                <td><%= w.getwTitle() %></td>
                                <td><%= w.getwCls() %></td>
                                <td><%= w.getwWriter() %></td>
                                <td><%= w.getSigner() %></td>
                                <td><% if(w.getsStep() == 2) {%> 결재요청
                                	<% }else if(w.getsStep() == 3) {%> 기안 
                                	<% }else if(w.getsStep() == 4) {%> 검토승인 
                                	<% }else if(w.getsStep() == 5) {%> 결재완료
                                	<% }else if(w.getsStep() == 6) {%> 반려 <% } %></td>
                                <td><a href="<%=request.getContextPath()%>/selectOne.ws?wno=<%= w.getwNo() %>&step=<%= w.getsStep() %>&id=<%= m.getUserId() %>">보기</a></td>
                            </tr>
                            <% } %>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <!-- /기안중 -->
                <!-- 진행중 -->
                <div class="tab-pane fade" id="ing" role="tabpanel" aria-labelledby="ing-tab">
                    <table class="table table-bordered">
                        <thead style="text-align: center;">                  
                            <tr>
                                <th style="width: 12%;">기안일자</th>
                                <th style="width: 34%;">제목</th>
                                <th style="width: 14%;">구분</th>
                                <th style="width: 8%;">기안자</th>
                                <th style="width: 14%;">결재자</th>
                                <th style="width: 8%;">진행상태</th>
                                <th style="width: 10%;">결재상태</th>
                            </tr>
                        </thead>
                        <tbody style="text-align: center;">
                        
                            <% for(wSign w : list){ %>
                            <% if(w.getsStep() == 4) {%>
                            <tr>
                            	<td hidden><%= w.getwNo() %></td>
                                <td><%= w.getwDate() %></td>
                                <td><%= w.getwTitle() %></td>
                                <td><%= w.getwCls() %></td>
                                <td><%= w.getwWriter() %></td>
                                <td><%= w.getSigner() %></td>
                                <td><% if(w.getsStep() == 2) {%> 결재요청
                                	<% }else if(w.getsStep() == 3) {%> 기안 
                                	<% }else if(w.getsStep() == 4) {%> 검토승인 
                                	<% }else if(w.getsStep() == 5) {%> 결재완료
                                	<% }else if(w.getsStep() == 6) {%> 반려 <% } %></td>
                                <td><a href="<%=request.getContextPath()%>/selectOne.ws?wno=<%= w.getwNo() %>&step=<%= w.getsStep() %>&id=<%= m.getUserId() %>">보기</a></td>
                            </tr>
                            <% } %>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <!-- /진행중 -->
                <!-- 반려 -->
                <div class="tab-pane fade" id="return" role="tabpanel" aria-labelledby="return-tab">
                    <table class="table table-bordered">
                        <thead style="text-align: center;">                  
                            <tr>
                                <th style="width: 12%;">기안일자</th>
                                <th style="width: 34%;">제목</th>
                                <th style="width: 14%;">구분</th>
                                <th style="width: 8%;">기안자</th>
                                <th style="width: 14%;">결재자</th>
                                <th style="width: 8%;">진행상태</th>
                                <th style="width: 10%;">결재상태</th>
                            </tr>
                        </thead>
                        <tbody style="text-align: center;">
                        
                            <% for(wSign w : list){ %>
                            <% if(w.getsStep() == 6) {%>
                            <tr>
                            	<td hidden><%= w.getwNo() %></td>
                                <td><%= w.getwDate() %></td>
                                <td><%= w.getwTitle() %></td>
                                <td><%= w.getwCls() %></td>
                                <td><%= w.getwWriter() %></td>
                                <td><%= w.getSigner() %></td>
                                <td><% if(w.getsStep() == 2) {%> 결재요청
                                	<% }else if(w.getsStep() == 3) {%> 기안 
                                	<% }else if(w.getsStep() == 4) {%> 검토승인 
                                	<% }else if(w.getsStep() == 5) {%> 결재완료
                                	<% }else if(w.getsStep() == 6) {%> 반려 <% } %></td>
                                <td><a href="<%=request.getContextPath()%>/selectOne.ws?wno=<%= w.getwNo() %>&step=<%= w.getsStep() %>&id=<%= m.getUserId() %>">보기</a></td>
                            </tr>
                            <% } %>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <!-- /반려 -->
                <!-- 결제 -->
                <div class="tab-pane fade" id="sign" role="tabpanel" aria-labelledby="sign-tab">
                    <table class="table table-bordered">
                        <thead style="text-align: center;">                  
                            <tr>
                                <th style="width: 12%;">기안일자</th>
                                <th style="width: 34%;">제목</th>
                                <th style="width: 14%;">구분</th>
                                <th style="width: 8%;">기안자</th>
                                <th style="width: 14%;">결재자</th>
                                <th style="width: 8%;">진행상태</th>
                                <th style="width: 10%;">결재상태</th>
                            </tr>
                        </thead>
                        <tbody style="text-align: center;">
                        
                            <% for(wSign w : list){ %>
                            <% if(w.getsStep() == 5) {%>
                            <tr>
                            	<td hidden><%= w.getwNo() %></td>
                                <td><%= w.getwDate() %></td>
                                <td><%= w.getwTitle() %></td>
                                <td><%= w.getwCls() %></td>
                                <td><%= w.getwWriter() %></td>
                                <td><%= w.getSigner() %></td>
                                <td><% if(w.getsStep() == 2) {%> 결재요청
                                	<% }else if(w.getsStep() == 3) {%> 기안 
                                	<% }else if(w.getsStep() == 4) {%> 검토승인 
                                	<% }else if(w.getsStep() == 5) {%> 결재완료
                                	<% }else if(w.getsStep() == 6) {%> 반려 <% } %></td>
                                <td><a href="<%=request.getContextPath()%>/selectOne.ws?wno=<%= w.getwNo() %>&step=<%= w.getsStep() %>&id=<%= m.getUserId() %>">보기</a></td>
                            </tr>
                            <% } %>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <!-- /결제 -->
              </div>
              <!-- /.목록 바디글 -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
    
    <script>
	    function select() {
	    	location.href="<%=request.getContextPath()%>/selectOne.no?wno=" + $('#wno').innerText;
	    }
    </script>
</body>
</html>