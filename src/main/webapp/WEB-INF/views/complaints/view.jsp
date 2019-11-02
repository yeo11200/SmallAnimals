<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tbody>
		<tr>
			<td>진행상태</td>
			<td>${view.result }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${view.title }</td>
		</tr>
		<tr>
			<td>민원내용</td>
			<td>${view.content }</td>
		</tr>
		<tr>
			<td>민원내용</td>
			<td>${view.content }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${view.writer }</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td><button>수정</button></td>
			<td><button>삭제</button></td>
		</tr>
	</tfoot>
</table>
</body>
</html>