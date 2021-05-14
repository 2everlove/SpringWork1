<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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
    <script defer type="text/javascript" charset="UTF-8">
    $(document).ready(function(){
    	const resMsg = '${resMsg}';
    	if(resMsg != ''){
	    	if(resMsg=='fail'){
    		console.log(resMsg);
	    		$('#errorMsgArea').text('아이디와 비밀번호가 틀렸습니다.');
	    	} else if(resMsg=="notFound"){
	    		alert("등록된 User가 없습니다");
	    	} else if(resMsg=="success"){
	    		
	    	} else {
	    		alert(resMsg);
	    	}
    	}

	$("#id, #pwd").on("change", function(){
		$('#idError').hide();
		$('#pwdError').hide();
		});
    });
    
    function checkForm(){
    	event.preventDefault();
    	if($("#id").val()==""){
			$("#id").select();
			$('#idError').show();
			return false;
		}
		if($("#pwd").val()==""){
			$("#pwd").select();
			$('#pwdError').show();
			return false;
		}
		$("#loginForm").submit();
    }
    </script>

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                    	<p id="errorMsgArea" style="color: red; font-size: 20px;"></p>
                        <form id="loginForm" role="form" action="/loginAction" method="post">
                            <fieldset>
                                <div class="form-group">
                                	<p id="idError" style="display: none; color: red;">아이디를 입력해주세요.</p>
                                    <input class="form-control" id="id" placeholder="id" name="id" type="text" autofocus>
                                </div>
                                <div class="form-group">
                               	 <p id="pwdError" style="display: none; color: red;">비밀번호를 입력해주세요.</p>
                                    <input class="form-control" id="pwd" placeholder="Password" name="pwd" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="useCookie" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a type="button" class="btn btn-lg btn-success btn-block" onclick="checkForm();">Login</a>
                                <br>
                                	<span style="display: inline-block;"><a href="/getId">아이디</a>ㆍ<a href="/getPwd">비밀번호찾기</a></span>
                                	&nbsp;&nbsp;<span style="display:inline-block; text-align: right;"><a href="/member">회원가입</a></span>
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
