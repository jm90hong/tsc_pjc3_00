

$(document).ready(function(){
	
	
	if (!firebase.apps.length) {
		firebase.initializeApp(firebaseConfig);
	}
	var storage = firebase.storage();
	var uploadFile;
	
	
	
	//미리보기 이미지 클릭
	$('#preview-img').on('click',function(){
		$('#file').trigger('click');
	});
	
	
	//파일 변경 감지 이벤트
	$('#file').on('change',async function(){
		uploadFile = $(this)[0].files[0];
		var b64 = await getBase64(uploadFile);
		$('#preview-img').attr('src',b64);
	});
	
	
	
	$('#submit-btn').on('click',async function(){
		
		var code = $('#code').val();
		var name = $('#name').val();
		var type = $('#type').val();
		var process = $('#process').val();
		var content = $('#content').val();
		
		
		if(code.length==0){
			alert('코드를 입력하세요');
			return;
		}
		
		if(name.length==0){
			alert('제품명를 입력하세요');
			return;
		}
		
		if(type.length==0){
			alert('종류를 입력하세요');
			return;
		}
		
		if(process.length==0){
			alert('공정을 입력하세요');
			return;
		}
		
		$('#submit-btn').css('pointer-events','none');
		$('.loader').css('display','inline-block');
		
		//이미지 업로드
		var imgUrl = await uploadFileGetUrl(storage, uploadFile);
		
		
		
		console.log(
			{
				item_name:name,
				item_code:code,
				item_img:imgUrl,
				item_type:type,
				item_process:process,
				item_content:content
			}
		);
		$.ajax({
			url:'./item/save',
			type:'post',
			data:{
				item_name:name,
				item_code:code,
				item_img:imgUrl,
				item_type:type,
				item_process:process,
				item_content:content
			},
			success:function(response){
				if(response=='ok'){
					alert('상품 등록 완료');
					location.replace('./item-list');
				}
			},
			error:function(error){
				$('#submit-btn').css('pointer-events','auto');
			},
		});
		
		
		
	});
	
	
	
});


//img -> base64
function getBase64(file) {
   return new Promise(function(resolve, reject){
	   var reader = new FileReader();
	   reader.readAsDataURL(file);
	   reader.onload = function () {
		   resolve(reader.result);
	   };
	   reader.onerror = function (error) {
		   reject('Error: ', error);
	   };
   });
}


//img 업로드 후 url 가져오기
function uploadFileGetUrl(storage, file){
	return  new Promise((resolve, reject)=>{
				
		var ref = storage.ref('item').child(Date.now()+'');
		ref.put(file).then(function(snapshot){
			//업로드 완료
			ref.getDownloadURL().then(function(url){
				//다운로드 주소 url -> 여기서 ajax로 DB 에 insert 하기
				resolve(url);
				
			}).catch(function(err){
				//에러
			});
			
			
		}).catch(function(err){
			//업로드 실패
		});
		
		
	});
}





