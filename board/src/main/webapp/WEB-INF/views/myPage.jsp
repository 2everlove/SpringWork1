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
    	$("button[type=button]").click(function(){
    		const id = $("input[name=id]").val();
        	const pwd = $("input[name=pwd]").val();
        	const email = $("input[name=email]").val();
        	const name = $("input[name=name]").val();
        	const newPwd = $("input[name=newPwd]").val();
        	const pwdChk = $("input[name=pwdChk]").val();
        	
	        	if(id==""){
	        		$("input[name=id]").select();
	        		return false;
	        	}
	        	if(pwd==""){
	        		$("input[name=pwd]").select();
	        		return false;
	        	}
	        	if(name==""){
	        		$("input[name=name]").select();
	        		return false;
	        	}
	        	if(email==""){
	        		$("input[name=email]").select();
	        		return false;
	        	}
	        	if(newPwd != pwdChk || pwdChk==""){
	        		alert("password??? ????????????.");
	        		$("input[name=newPwd]").select();
	        		$("input[name=pwdChk]").val("");
	        		return false;
	        	}
        		$("button[type=button]").attr('type', 'submit');
        	});
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
                        <form id="joinForm" role="form" action="/updateMember" method="post">
                            <fieldset>
                                <div class="form-group">
                                	<label>ID</label>
                                    <input class="form-control" placeholder="id" name="id" type="hidden" maxlength="12" pattern="[0-9A-Za-z]{5,12}" value="${sessionScope.user.id}">
                                    <input class="form-control" placeholder="id" name="id" type="text" maxlength="12" pattern="[0-9A-Za-z]{5,12}" disabled="disabled" value="${sessionScope.user.id}">
                                </div>
                                <div class="form-group">
                                	<label>?????? ????????????</label>
                                    <input class="form-control" placeholder="Password" name="pwd" maxlength="12" pattern="[0-9A-Za-z]{5,12}" type="password">
                                </div>
                                <div class="form-group">
                                	<label>PASSWORD</label>
                                    <input class="form-control" placeholder="Password" name="newPwd" maxlength="12" pattern="[0-9A-Za-z]{5,12}" type="password">
                                </div>
                                <div class="form-group">
                                	<label>PASSWORD ??????</label>
                                    <input class="form-control" placeholder="Password" name="pwdChk" maxlength="12" pattern="[0-9A-Za-z]{5,12}" type="password">
                                </div>
                                <div class="form-group">
                                	<label>??????</label>
                                    <input class="form-control" placeholder="name" name="name" type="hidden" maxlength="8" value="${sessionScope.user.name}">
                                    <input class="form-control" placeholder="name" name="name" type="text" maxlength="8" disabled="disabled" value="${sessionScope.user.name}">
                                </div>
                                <div class="form-group">
                                	<label>E-mail</label>
                                    <input class="form-control" placeholder="email" name="email" type="email" maxlength="30" value="${sessionScope.user.email}">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="button" class="btn btn-lg btn-success btn-block">????????????</button>
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
