<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 100%;
	}
	table > tbody > tr > td {
		text-align: center;
		width: 80%;
	}
	table > tbody > tr > th {
		text-align: center;
		width: 20%;
	}
	div {
		text-align: left;
	}
</style>
</head>
<body>
<table>
	<tbody>
		<tr>
			<th>상태</th>
			<td>${view.result }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${view.title }</td>
		</tr>
		<tr>
			<th>민원내용</th>
			<td>${view.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${view.writer }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${view.hit }</td>
		</tr>
	</tbody>
</table>
<div>
	<button>수정</button>
	<button>삭제</button>
</div>
</body>
</html>