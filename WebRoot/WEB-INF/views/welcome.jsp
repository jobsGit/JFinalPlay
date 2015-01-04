<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JFinal测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
function addTest(){
	var name = $("input[name='name']").val();
	var age =  $("input[name='age']").val();
	$.ajax({
	   type: "POST",
	   url: "addTest.do",
	   data: {"testModel.name":name,"testModel.age":age},
	   dataType: "json",
	   success: function(data){
	    	if(data.success){
	    		window.location.href="play.do";
	    	}else{
	    		alert("保存数据出错!");
	    	}
	   	}
	});
}
</script>
</head>
<body>
	WELCOME ${name }
	<a href="${pageContext.request.contextPath }/play.do">查看</a>
	<input type="text" name="name">
	<input type="text" name="age">
	<a href="javascript:void();" onclick="addTest();">添加</a>
</body>
</html>