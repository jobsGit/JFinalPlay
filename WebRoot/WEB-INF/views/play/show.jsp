<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JFinal测试</title>
<style type="text/css">
	table td{
		text-align:center;
		border-bottom:1px solid black;
		line-height: 25px;
	}
</style>
<script type="text/javascript" src="${contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
function delTest(obj){
	var id = $(obj).attr("id");
	$.ajax({
	   type: "POST",
	   url: "delTest",
	   data: {"id":id},
	   dataType: "json",
	   success: function(data){
	    	if(data.success){
	    		window.location.href="play";
	    	}else{
	    		alert("删除数据出错!");
	    	}
	   	}
	});
}


</script>
</head>
<body>

<table width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td>ID</td>
		<td>名称</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${modelList }" var="model">
		<tr>
			<td>${model.id }</td>
			<td>${model.name }</td>
			<td>${model.age }</td>
			<td><a id="${model.id }" href="javascript:void(0);" onclick="delTest(this);">删除</a> &#12288;<a href="toEditTest?id=${model.id }">更新</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>