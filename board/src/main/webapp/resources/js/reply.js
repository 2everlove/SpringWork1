/**
 * 리플 Ajax
 */
function ajaxList(pageMaker, bno, callback, error){
	$.ajax({
		url:'/reply/list/'+$('#bno').val()+'/'+$('#pageNum').val(),
		method:'get',
		dataType:'json',
		success:function(datas, status, jqXHR){
			let replyLine = "";
			if(0 == datas.list.length){
				replyLine += "<li class='replyList' class='left clearfix'><div><p>등록된 댓글이 없습니다.</p></div></li>";
			} else {
				$.each(datas.list, function(i, data){
					console.log(datas.list.length);
						console.log(data)
						replyLine += "<li class='replyList' onclick=replyDetail('"+data.rno+"'); class='left clearfix' data-rno='"+data.rno+
						"'><div><div class='header'><strong class='primary-font'>["+data.rno+"]"+data.replyer+
						"</strong><small class='pull-right text-muted'>"+data.updateDate+"</small>"+
						"</div><p>"+data.reply+"</p></div></li>";
						
				});
				//리스트 보여주기
				$('.chat').html(replyLine);
				
				// 페이지 처리
				console.log(datas.pageNum);
				replyPaging(datas.pageNum);
			}
		},
		error : function(jqXHR, status, error){
			console.log("error", error);
			console.log("status", status);
			console.log("jqXHR", jqXHR);
			
			// 콜백함수가 있으면 콜백함수 실행
			if(error){
				error(errorThrown);
			}
		
		}
	
	});
}//ajaxList

//1건의 리플 삽입
function ajaxInsert(){
	
	//js의 object
	let replyData = {
			bno:$('#bno').val(),
			reply: $('#reply').val(),
			replyer: $('#replyer').val()
	};
	
	console.log(replyData);
	console.log(JSON.stringify(replyData));
	
	$.ajax({
		
		url : '/reply/insert',
		method : 'post',
		//java에서 return값이 xml형태로 들어오므로 json으로 형태를 맞춰줌
		dataType:'json',
		//JSON 형식으로 변환
		data : JSON.stringify(replyData),
		contentType:'application/json; charset=UTF-8',
		success: function(datas, status){
			console.log(datas);
			
			if(datas.result=='success'){
				//모달창 닫기
				console.log('success');
				ajaxList();
				$('#myModal').modal('hide');
				
				//리스트 조회
			} else {
				alert('입력 중 오류가 발생했습니다.');				
			}
			
		},
		error : function(xhr, status, error){
			console.log(error);
		}
	});
}//ajaxInsert

//삭제
function deleteAjax(){
	console.log("deleteAjax");
	$.ajax({
		url:'/reply/delete/'+$('#rno').val(),
		method:'get',
		dataType:'json',
		success: function(datas, status){
			console.log(datas);
			if(datas.result=='fail'){
				alert("오류가 발생했습니다. 다시 시도해주세요.");
			} else{
				alert("삭제되었습니다.");
			}
			ajaxList();
		},
		error: function(xhr, status, errorThrown){
			console.log(errorThrown);
		}
	});
}//

//리플 업데이트
function updateAjax(){
	
	let replyData = {
			bno:$('#bno').val(),
			rno:$('#rno').val(),
			reply: $('#reply').val(),
			replyer: $('#replyer').val()
	};
	console.log(replyData);
	console.log(JSON.stringify(replyData));
	
	console.log("updateAjax().....");
	
	$.ajax({
		url:'/reply/update',
		method:'post',
		dataType:'json',
		data:JSON.stringify(replyData),
		contentType:'application/json; charset=UTF-8',
		success: function(datas, status){
			console.log(datas);
			
			if(datas.result=='success'){
				//모달창 닫기
				console.log('success');
				ajaxList();
				$('#myModal').modal('hide');
				
				//리스트 조회
			} else {
				alert('입력 중 오류가 발생했습니다.');				
			}
			
		},
		error : function(xhr, status, error){
			console.log(error);
		}
		
	});
}//


//1건의 리플을 조회
function getAjax(){
	$.ajax({
		url:'/reply/get/'+$('#rno').val(),
		method:'get',
		dataType:'json',
		success: function(datas, status){
			console.log($('#rno').val());
			$('#reply').val(datas.reply);
			$('#replyer').val(datas.replyer);
		},
		error: function(xhr, status, errorThrown){
			console.log(errorThrown);
		}
	})
}

function commAjax(url, method, data, callback, error){
$.ajax({
		
		url : url,
		method : method,
		//java에서 return값이 xml형태로 들어오므로 json으로 형태를 맞춰줌
		dataType:'json',
		//JSON 형식으로 변환
		data : JSON.stringify(data),
		contentType:'application/json; charset=UTF-8',
		success: function(datas, status){
			if(callback){
				callback(datas);			
			}
		},
		error : function(xhr, status, errorThrown){
			console.log(errorTh);
			if(error){
				error(errorThrown);
			}
		}
	});
}//commAjax