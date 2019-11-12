<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부에서 링크로 걸어줄 떄는 rel="stylesheet" 까지 적어줘야 스타일 시트가 먹힘 -->
<link href="/resources/css/complaints/update.css" rel="stylesheet">
</head>
<body>
<form method="post">
<input name="title" value="${update.title }" id="title">
<input name="writer" value="${update.writer }">
<textarea rows="10" cols="200">${update.content }</textarea><br>
<button type="submit">전송</button>
</form>
<script type="module" src="/resources/complaints/js/complaintEvent.js"></script>
</body>
</html>