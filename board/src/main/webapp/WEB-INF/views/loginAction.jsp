<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>방명록</title>
    
	<link rel="shortcut icon" href="#">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

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
	<script type="text/javascript">
	$(document).ready(function(){
    	const resMsg = '${resMsg}';
    	if(resMsg != ''){
	    	if(resMsg=='fail'){
    		console.log(resMsg);
	    		$('#errorMsgArea').text('아이디와 비밀번호가 틀렸습니다.');
	    	} else if(resMsg=="notFound"){
	    		alert("등록된 User가 없습니다");
	    	} else if(resMsg=="success"){
	    		
	    	} else if(resMsg=="modify") {
	    		alert("수정되었습니다.");
	    	} else {
	    		alert(resMsg);
	    	}
    	}
    });
	</script>

</head>

<body>
<p>${resMsg}
<p>${sessionScope.user}
<form method="get" action="/logout">
	<button type="submit">logout</button>
</form>
<a href="/myPage">myPage</a>
</body>
</html>
