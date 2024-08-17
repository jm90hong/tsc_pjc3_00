<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재 검색 게시판 로그인</title>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-index.css"/>
<%@ include file="/WEB-INF/views/lib/lib.jsp"%>



</head>
<body>

		<div class ="center-body">
			<img style ="width:135px;" src="${pageContext.request.contextPath}/image/logo.png"/>
		
			<span class ="title">관리자 로그인</span>
			<input id="id" placeholder ="아이디" class="form-inp"/>
			<input id ="pw" type="password" placeholder="비밀번호" class="form-inp"/>
		
			<button id="submit-btn" class="form-btn">관리자 로그인</button>
			
		</div>


</body>
<script src="${pageContext.request.contextPath}/js/admin/admin-login.js"></script>
</html>