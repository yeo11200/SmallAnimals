<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
list
<table>
	<tbody>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.no }</td>
				<td>${list.title }</td>
				<td>${list.content }</td>
				<td>${list.startDate }</td>
				<td>${list.endDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>