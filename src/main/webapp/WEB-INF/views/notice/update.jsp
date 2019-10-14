<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="put" action="/notice/update" name="form">
<label for="title"> 제목</label>
<input value="${update.title }">
<label for="date">공지날짜</label>
<input value="${update.startDate }" name="startDate" id="startDate">~
<input value="${update.endDate }" name="endDate" id="endDate">
<textarea id="summernote" name="content" id="content">${update.content }</textarea>
<input type="checkbox" name="emp" id="emp" <c:if test="${update.emp > 0}">checked="checked"</c:if>>중요공지
<button id="update" type="submit" >수정</button><button id="reset">이전</button>
</form:form>
<script type="text/javascript">
$(function() {
	alert('1234');
	
	$("#startDate").datepicker({
		
	});
});
</script>
</body>
</html>