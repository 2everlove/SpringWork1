<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#registerBtn").on("click", function(){
			
			let id = $("input[name=id]").val();
			if($.isEmptyObject(id)){
				alert("id를 입력해주세요");
				return;
			}
			if(!$("input[name=id]").prop("dataValue")){
				alert("id 중복검사를 해주세요");
				return false;
			}
			if(checkPassword()){
				return false;
			};
			
			$("#registerForm").submit();
		});
		
		$("input[name=id]").change(function(){
			$("input[name=id]").prop("dataValue",false);
		});
		
		$("#idCheck").on("click", function(){
			
			let id = $("input[name=id]").val();
			if($.isEmptyObject(id)){
				alert("id를 입력해주세요");
				return;
			}
			
			$("input[name=id]").prop("dataValue",false);
			
			$.ajax({
				url : '/idCheck/' + id,
				method : 'get',
				dataType : 'json',
				success : function(result){
					if(result){
						console.log(result);
						// 중복체크가 성공 처리 -> 회원가입 버튼 클릭시 dataValue값 확인
						$("input[name=id]").prop("dataValue",true);
						alert("사용 가능한 아이디 입니다");
					} else{
						alert("id가 중복되었습니다");
					}
				}
			});
		});	
		
		
	});

	function checkPassword(){
		if(!($("input[name=pwd]").val() === $("input[name=pwdCheck]").val())){
			 alert("비밀번호가 일치하지 않습니다.");
		} 
	}
</script>

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">회원가입</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" id="registerForm" action="/registerMember" method="post">
                            <fieldset>
                                <div class="form-group">
                                	<p id="errorMsgArea"></p>
                                	<label>ID</label><br>
                                    <input class="form-control" placeholder="id" name="id" id="id"
                                    pattern="[0-9A-Za-z]{6,20}"
                                    autofocus required>
                                    <button class="form-control" id="idCheck" type="button" >중복 확인</button>
                                </div>
                                <div class="form-group">
                                	<label>PASSWORD</label>
                                    <input class="form-control" placeholder="Password" name="pwd" type="password" required minlength="12" 
                                    pattern = "[0-9A-Za-z!@#$%^&*()]{12,}">
                                    <input class="form-control" placeholder="PasswordCheck" name="pwdCheck" type="password" required minlength="12" onchange="checkPassword()">
                                </div>
                                <div class="form-group">
                                	<label>이름</label>
                                    <input class="form-control" placeholder="name" name="name" required maxlength="5">
                                </div>
                                <div class="form-group">
                                	<label>EMAIL</label>
                                    <input class="form-control" placeholder="email" name="email" type="email" required>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" id="registerBtn" class="btn btn-lg btn-success btn-block">회원가입</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
