
$(document).ready(function(){
	
	
	
	$('#logout-btn').on('click',function(){
		var con = confirm('정말 로그아웃 하시겠습니까?');
		
		if(!con){
			return;
		}
		
		$.ajax({
			url:'./user/logout',
			type:'post',
			data:{},
			success:function(response){
				location.replace('http://127.0.0.1:8080/tsc_pjc3_00/');
			},
			error:function(err){}
		});
	})
	
	
	
});