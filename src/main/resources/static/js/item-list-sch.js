

$(document).ready(function(){
	
	var totalCount=0;
	var countPerPage=7;
	
	
	
	$('#sch-btn').on('click',function(){
		
		var type = $('#sch-type').val();
		var word = $('#sch-word').val();
		
		// 전체 개수
		$.ajax({
			url:'./item/findBySearchCount',
			type:'get',
			data:{
				type:type,
				word:word,
			},
			async:false,
			success:function(c){
				alert('c : '+c);
				totalCount=c;
			},
			error:function(err){
				console.error(err);
			}
		})
		
		
	});
	
}); 