<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>views</h2>
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
<button>삭제하기</button>

<script type="module" src="<c:out valeu="/resouces/js/notice/update.js" />"></script>
</body>
</html>