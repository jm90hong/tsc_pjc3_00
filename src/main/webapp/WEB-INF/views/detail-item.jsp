<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재 검색 게시판</title>

<%@ include file="/WEB-INF/views/lib/lib.jsp"%>

</head>
<style>
	.outline-btn{
		pading:4px 14px;
		background: transparent;
		color:#222;
		border: 1px solide #222;
		font-wight:700;
		border-radius: 4px;
		cursor: pointer;
	}
	
	.detail-box{
		margin-top:20px;
	}
	
	
	.detail-box > div{
		color:#999;
		font-size:14px;
		font-weight: 700;
	}
	
	.detail-box > p{
		color:#000;
		font-size:15px;
		font-weight: 700;
	}
	
	
</style>

<body>
	
	<%@ include file="./include/header.jsp" %>
	
	
	<main>
		<%@ include file="./include/left-side.jsp" %>
		<section class="right-body">
			
			<label style="font-weight:700;font-size:20px;">자재 상세보기</label>
			<div>
				
				
				<img style="width:300px;height:300px;object-fit:cover;border-radius:10px;" src="${item.item_img}"/>
				<div class="detail-box">
					<div>코드</div>
					<p>${item.item_code}</p>
				</div>`
				
				<div class="detail-box">
					<div>품명</div>
					<p>${item.item_name}</p>
				</div>
				
				<div class="detail-box">
					<div>종류</div>
					<p>${item.item_type}</p>
				</div>
				
				
				<div class="detail-box">
					<div>사용공정</div>
					<p>${item.item_process}</p>
				</div>
				
				<div class="detail-box">
					<div>부가설명</div>
					
					<c:if test="${empty item.item_content}">
						<p>-</p>
					</c:if>
					<c:if test="${not empty item.item_content}">
						<p>${item.item_content}</p>
					</c:if>
					
				</div>
				
				<div class="detail-box">
					<div>등록날짜</div>
					<p>${item.item_created_date}</p>
				</div>
			</div>
		
	
		</section>
	</main>
	
	
	

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js" integrity="sha512-frFP3ZxLshB4CErXkPVEXnd5ingvYYtYhE5qllGdZmcOlRKNEPbufyupfdSTNmoF5ICaQNO6SenXzOZvoGkiIA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="./js/item-list.js"></script>

</html>