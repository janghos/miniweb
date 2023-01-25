<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>회원가입</title>
</head>

<body>
	<section id="container">
		<form action="/member/joingo" method="post">
			<div class="form-group has-feedback">
				<label class="control-label" for="me_id">아이디</label> <input
					class="form-control" type="text" id="me_id" name="me_id" />
			</div>
			<input type="button" id="checkId" value="중복검사"><br />
			<div>
				<span id="result_checkId" style="font-size: 12px;"></span>
			</div>

			<div class="form-group has-feedback">
				<label class="control-label" for="me_pw">패스워드</label> <input
					class="form-control" type="password" id="me_pw" name="me_pw" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="me_name">이름</label> <input
					class="form-control" type="text" id="me_name" name="me_name" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="user_email">이메일</label> 
				<input type="text" id="user_email" required>
				<span id="middle">@</span>
				<input type="text" id="email_address" list="user_email_address">
				<datalist id="user_email_address">
					<option value="naver.com"></option>
					<option value="daum.com"></option>
					<option value="google.com"></option>
					<option value="radcns.com"></option>
					<option value="직접입력"></option>
				</datalist>
				<input type="hidden" id="me_email" name="me_email" value="">
				<input type="button" id="checkEmail" value="메일 중복검사"><br />
				<div>
					<span id="result_checkEmail" style="font-size: 12px;"></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="me_phone">연락처</label> <input
					class="form-control" type="text" id="me_phone" name="me_phone" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="me_adnum">주소</label> <input
					class="form-control" type="text" id="me_adnum" name="me_adnum"
					placeholder="우편주소" /> <input class="form-control" type="text"
					id="me_ad" name="me_ad" placeholder="기본주소" /> <input
					class="form-control" type="text" id="me_addt" name="me_addt"
					placeholder="상세주소" />

			</div>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="submit"
					disabled='true'>회원가입</button>
				<button class="cencle btn btn-danger" type="button">취소</button>
			</div>

		</form>
	</section>
	<script type="text/javascript" src="/js/joinJS.js"></script>
</body>

</html>