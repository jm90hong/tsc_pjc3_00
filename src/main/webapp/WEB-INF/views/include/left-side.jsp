<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<section class="left-side">
	<div class="btn-group">
		<label>자재관련</label>
		<nav class="<c:if test="${menu eq 'itemlist'}">active</c:if>">자재리스트</nav>
		<nav class="<c:if test="${menu eq 'js'}">active</c:if>">자바스크립트</nav>
	</div>
	
	<div class="btn-group">
		<label>기타 메뉴</label>
		<nav class="<c:if test="${menu eq 'user'}">active</c:if>">직원</nav>
		<nav class="<c:if test="${menu eq 'service'}">active</c:if>">고객센터</nav>
	</div>
	
	
	<c:if test = "${not empty sessionScope.admin}">
		<div class="btn-group">
			<label>관리자 메뉴</label>
			<nav>직원 관리</nav>
			<nav>자재 관리</nav>
		</div>
	</c:if>
	
	
	<div class="btn-group">
		<label>부가 메뉴</label>
		<nav>개발자연동</nav>
		<nav>쇼핑몰 관리</nav>
		<nav>직원 관리</nav>
		<nav>배송조회</nav>
		<nav>포인트 관리</nav>
		<nav>상품등록하기</nav>
		<nav>매출결산</nav>
	</div>
</section>