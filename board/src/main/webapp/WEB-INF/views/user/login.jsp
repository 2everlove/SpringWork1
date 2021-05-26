<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <script src="https://kit.fontawesome.com/e8e06f0e5f.js" crossorigin="anonymous"></script>
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
  <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#searchId').hide();
		$('#searchPwd').hide();
		$("#backArrow").hide();
		//$("#errorMsgArea").text('${msg}');
		$("a[href=idSearch]").click(function(e){
			e.preventDefault();
			$('#login').hide();
			$("#memberArea").hide();
			$('.panel-title').hide();
			$('#searchPwd').hide();
			$('#searchId').show();
			$("#backArrow").show();
			$('#searchPwdArea').show();
			$('#searchIdArea').hide();
		});
		$("a[href=pwdSearch]").click(function(e){
			e.preventDefault();
			$("#memberArea").hide();
			$('#login').hide();
			$('.panel-title').hide();
			$('#searchId').hide();
			$('#searchPwd').show();
			$("#backArrow").show();
			$('#searchPwdArea').hide();
			$('#searchIdArea').show();
		});
	});
	
	function loginFormatShow(){
		$('#login').show();
		$('.panel-title').show();
		$('#searchPwd').hide();
		$('#searchId').hide();
		$('#backArrow').hide();
		$('#memberArea').show();
		$('#searchPwdArea').show();
		$('#searchIdArea').show();
	}
	
	function ajaxSearchId(){
		if($('input[name=name]').val() == ""){
			$('input[name=name]').select();
			alert("이름을 입력하세요.");
			return false;
		}
		if($('input[name=email]').val() == ""){
			$('input[name=email]').select();
			alert("e-mail을 입력하세요.");
			return false;
		}
		let searchDate ={
				name: $('input[name=name]').val(),
				email: $('input[name=email]').val()
		};
		
		console.log(searchDate);
		console.log(JSON.stringify(searchDate));
		
		$.ajax({
			url: '/user/searchId',
			method: 'post',
			dataType:'json',
			data: JSON.stringify(searchDate),
			contentType:'application/json; charset=UTF-8',
			success: function(datas, status){
				console.log(datas);
				if(datas.result != 'error'){
					alert("회원님의 아이디는 [ "+datas.result+" ]입니다.");
					loginFormatShow();
					$('input[name=id]').val(datas.result);
					$('input[name=searchPwd_id]').val(datas.result);
				} else {
					alert("아이디가 틀렸습니다.");
				}
			},
			error : function(error){
				console.log(error);
			}
		});
	}
	
	function ajaxSearchPwd(){
		if($('input[name=searchPwd_id]').val() == ""){
			$('input[name=searchPwd_id]').select();
			alert("id를 입력하세요.");
			return false;
		}
		if($('input[name=searchPwd_email]').val() == ""){
			$('input[name=searchPwd_email]').select();
			alert("e-mail을 입력하세요.");
			return false;
		}
		let searchDate ={
				id: $('input[name=searchPwd_id]').val(),
				email: $('input[name=searchPwd_email]').val()
		};
		
		console.log(searchDate);
		console.log(JSON.stringify(searchDate));
		
		$.ajax({
			url: '/user/searchPwd',
			method: 'post',
			dataType:'json',
			data: JSON.stringify(searchDate),
			contentType:'application/json; charset=UTF-8',
			success: function(datas, status){
				console.log(datas);
				if(datas.result != 'error'){
					alert("회원님의 비밀번호는 [ "+datas.result+" ]입니다.");
					loginFormatShow();
					$('input[name=pwd]').val(datas.result);
				} else {
					alert("아이디가 틀렸습니다.");
				}
			},
			error : function(error){
				console.log(error);
			}
		});
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
                        <span id="backArrow" style="cursor: pointer;" onclick="loginFormatShow();"><i  class="fas fa-chevron-left"></i>&nbsp;뒤로가기</span>
                    </div>
                    <div class="panel-body">
                    	
                        <form role="form" action="/loginAction" method="post">
                           	<p id="errorMsgArea"></p>
                            <fieldset id="login">
                                <div class="form-group">
                                    <input class="form-control" placeholder="id" name="id" autofocus value="user01">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="pwd" type="password">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="useCookie" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                                
                            <br>
                            </fieldset>
                            <fieldset id="searchId">
                                <div class="form-group">
                                    <input class="form-control" placeholder="name" name="name" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="email" name="email" type="email">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="button" id="btnSearchId" class="btn btn-lg btn-success btn-block" onclick="ajaxSearchId();">아이디 찾기</button>
                                
                            <br>
                            </fieldset>
                            <fieldset id="searchPwd">
                                <div class="form-group">
                                    <input class="form-control" placeholder="id" name="searchPwd_id" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="email" name="searchPwd_email" type="email">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="button" id="btnSearchPwd" class="btn btn-lg btn-success btn-block" onclick="ajaxSearchPwd();">비밀번호 찾기</button>
                                
                            <br>
                            </fieldset>
                            <p><span id="memberArea"><a href="/member">회원가입</a> &nbsp;&nbsp;</span>
                            	<span id="searchIdArea"><a href="idSearch"">아이디 찾기</a>&nbsp;&nbsp;</span>
                            	<span id="searchPwdArea"><a href="pwdSearch">비밀번호 찾기</a></span></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>
