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

    <script defer type="text/javascript" charset="UTF-8">
    $(document).ready(function(){
    	
    	const pathName = window.location.pathname;
    	
    	console.log(pathName);
    	
    	$("#emailWrapper");
    	
    	if(pathName == "/getId"){
	    	$("#idWrapper").remove();
    		$("#pwdWrapper").remove();
    		$("button[type=button]").html("아이디 찾기");
    		$("button[type=button]").click(function(){
		    	const name = $("input[name=name]").val();
		    	const email = $("input[name=email]").val();
    			if(name==""){
            		$("input[name=name]").select();
            		return false;
            	}
        		if(email==""){
            		$("input[name=email]").select();
            		return false;
            	}
        		$("button[type=button]").attr('type', 'submit');
    		});
    		
    	} else {
    		$("#pwdWrapper").remove();
    		$("#nameWrapper").remove();
    		$("button[type=button]").html("비밀번호 찾기");
    		$("button[type=button]").click(function(){
				const id = $("input[name=id]").val();
		    	const email = $("input[name=email]").val();
	    		if(id==""){
	        		$("input[name=id]").select();
	        		return false;
	        	}
	    		if(email==""){
	        		$("input[name=email]").select();
	        		return false;
	        	}
	    		$("button[type=button]").attr('type', 'submit');
    		});
    	}
    	
    	
    });
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
                        <form id="joinForm" role="form" action="/checkInfo" method="post">
                            <fieldset>
                                <div id="idWrapper" class="form-group">
                                	<label>ID</label>
                                    <input class="form-control" placeholder="id" name="id" type="text" maxlength="12" pattern="[0-9A-Za-z]{5,12}" autofocus>
                                </div>
                                <div id="pwdWrapper" class="form-group">
                                	<label>PASSWORD</label>
                                    <input class="form-control" placeholder="Password" name="pwd" maxlength="12" pattern="[0-9A-Za-z]{5,12}" type="password">
                                </div>
                                <div id="nameWrapper" class="form-group">
                                	<label>이름</label>
                                    <input class="form-control" placeholder="name" name="name" type="text" maxlength="8">
                                </div>
                                <div id="emailWrapper" class="form-group">
                                	<label>E-mail</label>
                                    <input class="form-control" placeholder="email" name="email" type="email" maxlength="30">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="button" class="btn btn-lg btn-success btn-block">회원가입</button>
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
