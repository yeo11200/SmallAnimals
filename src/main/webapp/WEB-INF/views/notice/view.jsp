<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input value="${views.no }" type="hidden" id="no">
<table>
	<tbody>
		<tr>
			<td>제목</td>
			<td>${views.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${views.content }</td>
		</tr>
		<tr>
			<td>시작일</td>
			<td>${views.startDate }</td>
		</tr>
		<tr>
			<td>종료일</td>
			<td>${views.endDate }</td>
		</tr>
	</tbody>
</table>
<button id="update">수정하기</button>
<button id="delete">삭제하기</button>

<script type="module" src="<c:out value="/resources/js/notice/import.js"/>"></script>
</body>
</html>