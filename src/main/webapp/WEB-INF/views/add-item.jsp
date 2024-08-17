<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재 검색 게시판</title>


<%@ include file="/WEB-INF/views/lib/lib.jsp"%>

<link rel="stylesheet "href="./css/form.css"/>


</head>

<style>
   .outline-btn{
      padding:4px 14px;
      background: transparent;
      color:#222;
      border:1px solid #222;
      font-weight:700;
      border-radius: 4px;
      cursor: pointer;
   }
   
   .outline-btn:hover{
      background: #f2f2f2;
   }
   
   h3.title{
   	font-size:20px;
   	font-weight: 700;
   }
   
   
</style>
<body>
   
   <%@ include file="/WEB-INF/views/include/header.jsp"%>
   
   
   <main>
      <%@ include file="/WEB-INF/views/include/left-side.jsp"%>
      <section class="right-body">
            
         
         
         <h3 class ="title">자재등록</h3>
         
         
         <!--  사진, 코드(input), 품명, 종류(select) 사용공정(select)-->
       
         <div class="form-box">
         	<label>코드</label>
         	<input id="code" placeholder="코드를 입력하세요"/>
         </div>   
         
           <div class="form-box">
         	<label>사진</label>
         	<input id="file" type="file" style="display: none;"/>
         	<img id="preview-img" src ="./image/default.png"/>
         </div>   
         
          <div class="form-box">
         	<label>품명</label>
         	<input id="name" placeholder="품명을 입력하세요"/>
         </div>   
         
         
         <div class="form-box">
         	<label>설명</label>
         	<textarea id="content" placeholder="내용을 입력하세요."></textarea>
         </div> 
         
         
         
		<div class="form-box">
			<label>종류</label>
			<select id="type">
				<option value="원자재">원자재</option>
				<option value="상품">상품</option>
				<option value="부자재">부자재</option>
			</select>
		</div>   
         
		<div class="form-box">
			<label>사용 공정</label>
			<select id="process">
				<option value="투입">투입</option>
				<option value="기계/손재단">기계/손재단</option>
				<option value="미싱">미싱</option>
				<option value="열선재봉">열선재봉</option>
				<option value="바이메탈">바이메탈</option>
				<option value="단열재 재단">단열재 재단</option>
				<option value="손바느질">손바느질</option>
				<option value="컨넥터">컨넥터</option>
				<option value="세정/포장">세정/포장</option>
				<option value="기타">기타</option>			
			</select>
		</div>   
         
           
        <div class="form-box">
         
        <button id="submit-btn" class="submit-btn">
       		<span class="loader" style="display:none;"></span>
       		등록하기 
        </button>
     	</div>
      </section>
   </main>


</body>

<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/6.2.0/firebase-storage.js"></script>
<script src="${pageContext.request.contextPath}/js/add-item.js"></script>
</html>