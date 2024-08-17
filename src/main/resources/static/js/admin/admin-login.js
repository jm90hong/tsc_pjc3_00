

$(document).ready(function(){
	
	$('#submit-btn').on('click',function(){
		
		
		
		var id = $('#id').val();
		var pw = $('#pw').val();
		
		
		
		
		$.ajax({
			url:'http://127.0.0.1:8080/tsc_pjc3_00/api/au/login',
			type:'get',
			data:{
				id:id,
				pw:pw
			},
			success:function(response){
				if(response != ''){
					location.replace('http://127.0.0.1:8080/tsc_pjc3_00/item-list');
				}else{
					alert('가입된 관리자가 아닙니다.')
				}
			},
			error:function(err){}
		})
	});
})