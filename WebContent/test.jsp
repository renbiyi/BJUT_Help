<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<h1>萨芬撒东方闪电</h1>
<form action="/message/save/audio" method="post" enctype="multipart/form-data"> 
	<input type="file" name="audio"/>
	<input type="text" value="justtest" name="theme" /> 
	<input type="text" value="123" name="contact" /> 
    <input type="text" value="123" name="expire" />
    <input type="text" value="123" name="longitude" /> 
    <input type="text" value="123" name="latitude" /> 
	<input type="submit" value="upload"/> 
</form>

</body>
</html>