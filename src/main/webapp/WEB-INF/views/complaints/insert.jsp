<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<div>
<label>제목</label>
<input name="title">
</div>
<div>
<label>작성자</label>
<input name="writer">
</div>
<textarea id="summernote">

</textarea>
<button type="submit" id="submit">전송</button>
</form>

<script type="module" src='<c:out value="/resources/js/complaints/complaintsInsert.js"></c:out>'></script>
</body>
</html>