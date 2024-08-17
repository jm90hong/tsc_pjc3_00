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
	
	tr:hover > *{
		background: #f2f2f2;
		cursor: pointer;
	}
	
	
	
</style>

<body>
	
	<%@ include file="./include/header.jsp" %>
	
	
	<main>
		<%@ include file="./include/left-side.jsp" %>
		<section class="right-body">
		
		
		<div style = "width:1000px;">
			<div align ="right">
				<button id="go-add-item-btn" class="outline-btn">자재 등록</button>
			
			</div>
			
			
			<table class="table" style = "width:1000px">
				  <thead>
				    <tr>
				      <th scope="col">NO</th>
				      <th scope="col">사진</th>
				      <th scope="col">코드</th>
				      <th scope="col">품명</th>
				      <th scope="col">종류</th>
				      <th scope="col">사용공정</th>
				      <th scope="col">등록날짜</th>
				    </tr>
				  </thead>
				  
				  <tbody id="item-list">
				   <%-- <tr class="board-box" data-board-idx="${item.board_idx}" style="vertical-align: middle;background:red;">
				      <td>1</td>
				      <th scope="row">
				      	<img style="width:70px;height:70px;object-fit:cover;" src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FlNsfd%2FbtqzzmuZVKG%2FskHfVdsKDiPzsWiR7bv99K%2Fimg.jpg"/>
				      </th>
				      <td>ASD-FS2-12412</td>
				      <td>기계볼트</td>
				      <td>원자재</td>
				      <td>기본공정</td>
				      <td>2024-06-16</td>
				    </tr> --%>
				    
				    
				  
				  </tbody>
				</table>
				
				
				
				
				<div>
				
					<div align="center" style="margin-bottom:20px;">
						<input placeholder="코드 혹은 품명"/>
						<select>
							<option value="원자재">원자재</option>
							<option value="상품">상품</option>
							<option value="부자재">부자재</option>
						</select>
						<button>검색하기</button>
					</div>
				
				
					
					<ul id="pagination-demo" class="pagination-sm" style="display: flex;justify-content: center;"></ul>
					
				</div>
				
				
				
				
				
				
		
			</div>
	
		</section>
	</main>
	
	
	

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js" integrity="sha512-frFP3ZxLshB4CErXkPVEXnd5ingvYYtYhE5qllGdZmcOlRKNEPbufyupfdSTNmoF5ICaQNO6SenXzOZvoGkiIA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="./js/item-list.js"></script>
<script src="./js/item-list-sch.js"></script>
</html>