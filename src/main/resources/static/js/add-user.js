$(document).ready(function(){
	
	
	var answerNumber;
	var isValidEmail=false;
	
	
	
	$('#submit-btn').on('click',function(){
		
		var id = $('#id').val();
		var pw = $('#pw').val();
		var pwCheck = $('#pw-check').val();
		
		
		
		
		
		if(id.length==0){
			alert('아이디를 기입해주세요');
			return;
		};
		
		
		if(!isValidEmail){
			alert('이메일 인증을 해주세요');
			return;
		}

				
		if(pw.length==0){
			alert('비밀번호를 기입해주세요');
			return;
		};
		
		
		if(pwCheck != pw){
			alert('비밀번호가 일치 하지 않습니다.');
			return;
		}
		
		
		
		//회원가입 요청하기
		$.ajax({
			url:'./user/save',
			type:'post',
			data:{
				id:id,
				pw:pw
			},
			success:function(response){
				if(response == RESPONSE.OK ){
					alert('회원가입 완료. 로그인 해주세요');
					location.replace('./');
				}else if(response=='email'){
					alert('가입된 이메일이 존재합니다.');
				}
				
			},
			error:function(err){
				alert(MSG.NETWORK_ERROR);
			}
			
		});	
	});
	
	
	
	//인증번호 비교 로직
	$('#number6').on('keyup',function(){
		var num = $(this).val();
		
		
		//???
		if(num==answerNumber){
			$('#num-txt').html('메일이 인증 되었습니다.');
			$(this).css('background','#f2f2f2');
			$(this).attr("readonly",true); 
			isValidEmail=true;
			alert('메일이 인증되었습니다.');
		}
		
	});
	
	
	$('#send-mail-btn').on('click',function(){
		var id = $('#id').val();
		
		var isUnique=false;
		
		
		
		//ajax로 아이디로 회원 조회
		
		$.ajax({
			url:'./user/findById',
			type:'get',
			data:{
				id:id
			},
			async:false,
			success:function(response){
				
				
				
				if(response==''){
					isUnique=true;
				}
			},
			error:function(error){}
		});
		
		
		if(isUnique==false){
			alert('이미 가입된 아이디가 존재 합니다.');
			return;
		}
		
		
		$.ajax({
			url:'./mail/sendMailWithNumbers',
			type:'get',
			data:{
				to:id
			},
			success:function(correctNumber){
				
				
				if(correctNumber!='fail'){
					answerNumber=correctNumber;
					
					$('#number6').show();
						
					alert('인증코드 메일 발송 완료');
					
				}else{
					alert('메일전송 에러, 관리자에게 문의 하세요.')
				}
				
			},
			error:function(err){}
		});
		
	});
	
	
});