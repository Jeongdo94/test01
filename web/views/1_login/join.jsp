<!-- 회원추가화면 *경로지정 어드민 일때 할 수 있게끔 하기  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>직원추가화면</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gamja+Flower|Nanum+Gothic|Sunflower:300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Tenor+Sans&display=swap"
	rel="stylesheet">


<style>
body {
	font-family: 'Do Hyeon', sans-serif;
}
</style>

</head>
<body>
	<%@ include file="../../common/header.jsp"%>

	<div
		style="text-align: center; margin-top: 100px; margin-bottom: 100px;">
		<h1>직원생성</h1>
		<hr style="width: 50%;">
	</div>


	<form id="joinForm" action="${pageContext.request.contextPath}/join.me"
		method="post">
		<div class="container">


			<div class="container">

				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="userid">USERID</label> <input type="text"
							class="form-control" name="userid" placeholder="" value=""
							required>
						<div class="invalid-feedback">Valid first name is required.
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-5 mb-3">
						<label for="userpwd">USERPWD</label> <input type="text"
							class="form-control" name="userpwd" placeholder="" value=""
							required>
						<div class="invalid-feedback">Valid last name is required.</div>
					</div>
				</div>


				<form class="needs-validation" novalidate>
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="username">USERNAME</label> <input type="text"
								class="form-control" name="username" placeholder="" value=""
								required>
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-5 mb-3">
							<label for="userno">USERNO</label> <input type="text"
								class="form-control" name="userno" placeholder="" value=""
								required>
							<div class="invalid-feedback">Valid last name is required.
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<label for="username">EMAIL</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">@</span>
								</div>
								<input type="text" class="form-control" name="email"
									placeholder="" required>
								<div class="invalid-feedback" style="width: 100%;">Your
									username is required.</div>
							</div>
						</div>
					</div>

					<br> <br>

					<div>
						<div class="row">
							<div class="col-2" style="display: -webkit-inline-box;">
								<label for="phone">PHONE</label> &nbsp; <select
									class="form-control" name="tel1">
									<option value="010">010
									<option value="011">011
									<option value="016">016
									<option value="019">019
								</select>
								<div style="padding: 7px;">-</div>
								<input type="text" name="tel2" class="form-control" size='4' />
								<div style="padding: 7px;">-</div>
								<input type="text" name="tel3" class="form-control" size='4' />
								<div class="invalid-feedback">Valid last name is required.
								</div>
							</div>
						</div>
					</div>

					<br> <br>


					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="dept">DEPARTMENT</label> <select
								class="custom-select d-block w-100" name="dept" required>
								<option value="">Choose</option>
								<option>경영지원본부</option>
								<option>영업추진본부</option>
								<option>생산본부</option>
								<option>해외생산본부</option>
							</select>
							<div class="invalid-feedback">Please select a valid
								country.</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="text">POSIT</label> <input type="text"
								class="form-control" name="posit" placeholder="" value=""
								required>
							<div class="invalid-feedback">Valid last name is required.
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="text">HIRE_DATE</label> <input type="text"
								class="form-control" name="hire_date" placeholder="" value=""
								required>
							<div class="invalid-feedback">Valid last name is required.
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="">ENT_YN</label> <select
								class="custom-select d-block w-100" name="ent_yn" required>
								<option value="">Choose</option>
								<option>N</option>
								<option>Y</option>
							</select>
							<div class="invalid-feedback">Please select a valid
								country.</div>
						</div>
					</div>

					<hr class="mb-1">
					<button class="btn btn-primary btn-block" type="submit">저장하기</button>
				</form>
			</div>
		</div>
	</form>

	<%@ include file="../../common/footer.jsp"%>

</body>
</html>
