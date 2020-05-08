<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="semi.cf.jsp.login.model.vo.*"%>
 <% Join j = (Join)request.getAttribute("Join");%>     
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    
    <title>직원추가화면</title>

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
</head>
<body>
   <%@ include file="../../common/header.jsp" %>

    <div style="text-align: center; margin-top: 100px; margin-bottom: 100px;">
        <h1>직원생성</h1>
        <hr style="width: 50%;">
      </div>

    
     <form id="selectForm" action="${pageContext.request.contextPath}/update.me" method="post">
     <div class="container">
     

     <div class="container">
   
        <div class="row">
            <div class="col-md-4 mb-3">
              <label for="userid">USERID</label>
              <input type="text" class="form-control" name="userid" value="<%=j.getUserid() %>" required >
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
              <label for="userpwd">USERPWD</label>
              <input type="text" class="form-control" name="userpwd" placeholder="" value="<%=j.getUserpwd() %>" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>
          </div>
        
        
      <form class="needs-validation" novalidate>
        <div class="row">
          <div class="col-md-4 mb-3">
            <label for="username">USERNAME</label>
            <input type="text" class="form-control" name="username" placeholder="" value="<%=j.getUsername() %>" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
        </div>
          
        <div class="row">
         <div class="col-md-5 mb-3">
            <label for="userno">USERNO</label>
            <input type="text" class="form-control" name="userno" placeholder="" value="<%=j.getUserno() %>" >
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>
      
          <div class="row">
        <div class="col-md-6">
          <label for="email">EMAIL</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" name="email" placeholder="" value="<%=j.getEmail() %>" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your username is required.
            </div>
          </div>
        </div>
      </div>

      <br><br>

        <div>
          <div class="row">
            <div class="col-2" style="display: -webkit-inline-box;">
                <label for="phone">PHONE</label> &nbsp;
                    <input type="text" name="tel1" class="form-control" size='4'/>
                    <div style="padding: 7px;"> - </div> 
                    <input type="text" name="tel2" class="form-control" size='4'/>
                    <div style="padding: 7px;"> - </div> 
                    <input type="text" name="tel3" class="form-control" size='4'/>
                <div class="invalid-feedback">
                Valid last name is required.
                </div>
            </div>
          </div>
        </div>
        
      <br><br>
     
        
       <div class="row">
         <div class="col-md-4 mb-3">
            <label for="dept">DEPARTMENT</label>
            <select class="custom-select d-block w-100" name="dept" value="<%=j.getDept() %>" required>
              <option value="">Choose</option>
              <option>경영지원본부</option>
              <option>영업추진본부</option>
              <option>생산본부</option>
              <option>해외생산본부</option>
            </select>
            <div class="invalid-feedback">
              Please select a valid country.
            </div>
          </div>
        </div>

          <div class="row">
            <div class="col-md-4 mb-3">
               <label for="text">POSIT</label>
               <input type="text" class="form-control" name="posit" placeholder="" value="<%=j.getPosit() %>" required>
               <div class="invalid-feedback">
                 Valid last name is required.
               </div>
             </div>
           </div>

           <div class="row">
            <div class="col-md-6 mb-3">
               <label for="text">HIRE_DATE</label>
               <input type="date" class="form-control" name="hire_date" placeholder="" value="<%=j.getHire_date() %>" required>
               <div class="invalid-feedback">
                 Valid last name is required.
               </div>
             </div>
           </div>
        
           <div class="row">
             <div class="col-md-4 mb-3">
              <label for="text">ENT_YN</label>
              <select class="custom-select d-block w-100" name="ent_yn" value="<%=j.getEnt_yn()  %>" required>
                <option value="">Choose</option>
                <option>N</option>
                <option>Y</option>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
             </div>
           </div>
           
           <hr>
           
           <div style="text-align: center;">
           <button class="btn btn-outline-warning btn-lg" type="submit">수정하기</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <button class="btn btn-outline-danger btn-lg" type="button" onclick="deleteMember();">삭제하기</button>
           </div>
          
       
       
      </form>
      
      
       <script>
           $(function(){
             var phoneArr = '<%= j.getPhone() %>'.split('-');
			
			  $('input[name*="tel"]').each(function(index){
				$(this).val(phoneArr[index]);
			  });
           });  
			 
           
           function deleteMember() {
					location.href = "/semi/mDelete.me?userid=<%=j.getUserid()%>";
				};
          	
			  
		</script> 
    </div>
  </div>
</form>
<%@ include file="../../common/footer.jsp" %>
</body>
</html>
