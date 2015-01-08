<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JFinal测试登录</title>
<style type="text/css">
	table td{
		text-align:center;
		border-bottom:1px solid black;
		border-top:1px solid black;
		line-height: 50px;
	}
</style>
<script type="text/javascript" src="${contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
function login(){
	var name = $("input[name='name']").val();
	var age =  $("input[name='age']").val();
	$.ajax({
	   type: "POST",
	   url: "play/addTest",
	   data: {"testModel.name":name,"testModel.age":age},
	   dataType: "json",
	   success: function(data){
	    	if(data.success){
	    		window.location.href="welcome";
	    	}else{
	    		alert("保存数据出错!");
	    	}
	   	}
	});
}
</script>
</head>
<body>
	<div align="center"><h4>WELCOME JFINAL</h4></div>
	<div align="center">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td> 名称 <input type="text" name="name"></td> 
				<td> 年龄 <input type="text" name="age"></td>
				<td><a href="javascript:void();" onclick="login();">进入</a></td>
			</tr>
		</table>
	</div>
</body>
</html>