<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="./js/header.js"></script>    
    
    
 
 <header>
	<img class="logo-img" src="./image/logo.png">
	
	<div>
	
	
		<%-- c:if test="${empty sessionScope.me}">
		
			<!-- 로그인 안됨 -->
			<span id="go-login-btn" class="hd-btn">로그인</span>
			<span id="go-add-user-btn" class="hd-btn">회원가입</span>
		
		
		
		</c:if>
		 --%>
		
		<c:choose>
	    	<c:when test="${not empty sessionScope.admin}">
	    		<span class="user-id-txt">관리자 님</span>
	        	<span id="logout-btn" class="hd-btn">로그아웃</span>
	    	</c:when>
	    	<c:when test="${not empty sessionScope.me}">
		    	<span id="go-admin-mypage-btn" class="user-id-txt">${sessionScope.me.id}님</span>
		        <span id="logout-btn" class="hd-btn">로그아웃</span>
	    	</c:when>
	   		<c:otherwise>
	     		<span id="go-login-btn" class="hd-btn">로그인</span>
				<span id="go-add-user-btn" class="hd-btn">회원가입</span>
	    	</c:otherwise>
		</c:choose>
		
		
		
		
		
		
		<%-- <c:if test="${not empty sessionScope.me}">
			
			<!-- 로그인 됨 -->
		
			<span id="go-admin-mypage-btn" class="user-id-txt">${sessionScope.me.id}님</span>
	        <span id="logout-btn" class="hd-btn">로그아웃</span>
		
		</c:if>
	 --%>
	
	
			
	</div>
</header>