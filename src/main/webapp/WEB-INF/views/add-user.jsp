<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입하기</title>


<link rel="stylesheet" href="./css/index.css"/>
<%@ include file="/WEB-INF/views/lib/lib.jsp"%>
<script src="./js/add-user.js"></script>


</head>
<body>
	
	
	 <div class="center-body">
		<img style="width:200px;" src ="./image/logo.png"/>
		
		<span class="title">회원 가입하기</span>
		
		<div>
			<input style = "margin-left:70px;" id="id" placeholder ="회사 이메일" class="form-inp"/>
			<button id="send-mail-btn">메일 인증</button>
		</div>
		
		
		<input id="number6" style="display:none;margin-bottom:2px;" placeholder ="인증 번호 6자리" class="form-inp" type="number"/>
		<span id="num-txt" style="font-size:13px;margin-bottom:12px;"></span>
		
		<input id="pw" placeholder ="비밀번호" class="form-inp" type="password"/>
		<input id="pw-check" placeholder ="비밀번호 확인" class="form-inp" type="password"/>
		
		
		<button id="submit-btn"class="form-btn">회원 가입하기</button>
	
	</div>
	
		
	
</body>
</html>