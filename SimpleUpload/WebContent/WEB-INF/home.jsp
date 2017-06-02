<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
    href="<%=request.getContextPath()%>/dropzone/dropzone.min.css">
<script src="<%=request.getContextPath()%>/dropzone/dropzone.min.js"></script>
<script>
Dropzone.options.myAwesomeDropzone = {
		dictDefaultMessage: "拖拽上传即可上传图片",
		dictFallbackMessage:"你的浏览器不支持此类上传模式"
		};
</script>
<style>
.dropzone {
    border: 2px dashed #0087F7;
    border-radius: 5px;
    background: white;
}
#dropzone{
    max-width: 720px;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>
<body>
<div id="dropzone">
<form action="<%=request.getContextPath()%>/upload" class="dropzone">
  <div class="fallback">
    <input name="file" type="file" multiple />
  </div>
 </div>
</form>
</body>
</html>