$(document).ready(function(){
	
	$('#submit-btn1').on('click',function(){
		
		var id = $('#id').val();
		var pw = $('#pw').val();
		
		$.ajax({
			url:'./user/login',
			type:'post',
			data:{
				'id': id,
				'pw': pw
			},
			success:function(response){
				if(response != ''){
					alert('로그인 완료');
					location.replace('./item-list')
				}else{
					
					alert('일치하는 회원 정보가 없습니다.')
				}
			},
			error:function(err){}
		});
	});
	
	
	
	$('#submit-btn2').on('click',function(){
		location.href='./add-user';
	});
	
});