<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<input name="title" value="${update.title }">
<input name="title" value="${update.writer }">
<textarea rows="10" cols="200">${update.content }</textarea>
<button type="submit">전송</button>
</form>
</body>
</html>