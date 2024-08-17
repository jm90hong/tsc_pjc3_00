$(document).ready(function(){
	
	
	var totalCount=0;
	var countPerPage=7;
	
	
	
	$(document).on('click','.item-box',function(){
		var itemIdx = $(this).data('item-idx');
		location.href='./detail-item?item_idx='+itemIdx;
	})
	
	
	
	//클릭시 자재 등록
	$('#go-add-item-btn').click(function(){
		location.href='./add-item';
	});
	
	
	$.ajax({
		url:'./item/count',
		type:'get',
		data:{},
		async:false,
		success:function(c){
			totalCount=c;
		},
		error:function(err){}
	})
	
	
	
	
	//페이지 네이션
	$('#pagination-demo').twbsPagination({
        totalPages: Math.ceil(totalCount/countPerPage),
        visiblePages: 10,
        first:'처음',
        prev:'이전',
        next:'다음',
        last:'마지막',
        onPageClick: function (event, page) {
			
		   var start = (page-1)*countPerPage;
           fetchItems(start, countPerPage);
        }
    });
});


function fetchItems(s,c){
	//아이템 리스트 요청 후 UI 보여주기
	$.ajax({
		url:'./item/all',
		type:'get',
		data:{
			start:s,
			count:c
		},
		success:function(items){
			
			
			$('#item-list').empty();
			
			$.each(items, function(index, item){
				$('#item-list').append(`
					<tr class="board-box item-box" data-item-idx="${item.item_idx}" style="vertical-align: middle;background:red;">
				      <td>${item.item_idx}</td>
				      <th scope="row">
				      	<img style="width:70px;height:70px;object-fit:cover;" src=${item.item_img}/>
				      </th>
				      <td>${item.item_code}</td>
				      <td>${item.item_name}</td>
				      <td>${item.item_type}</td>
				      <td>${item.item_process}</td>
				      <td>${item.item_created_date}</td>
				    </tr>
				
				`);
			});
			
		},
		error:function(err){}
	});
	
	
}