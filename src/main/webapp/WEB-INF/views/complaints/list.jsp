<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
		table {
			width: 100%;
		}
		table > thead > tr > th {
			text-align: center;
		}
		table > tbody > tr > td {
			text-align: center;
		}
		table > tbody > tr:hover {
			background: gray;
		}
		strong {
			color: red;
		}
</style>
</head>
<body>
<table>
<thead>
	<tr>
		<th>진행상태</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody>
<c:forEach var="list" items="${ list }">
    <tr class="tr" attr="${list.no }">
    	<td>${list.result }</td>
    	<td>${list.title }</td>
    	<td>${list.content }(<strong>${list.replycnt }</strong>)</td>
    	<td>${list.writer }</td>
    	<td>${list.writeDate }</td>
    </tr>
</c:forEach>
</tbody>
<tfoot>
	<tr><td colspan="3"><button id="insert">글쓰기</button></td></tr>
</tfoot>
</table>
<script type="text/javascript">
	let tr = document.getElementsByClassName('tr');
	
	for(let i=0; i < tr.length; i++) {
		tr[i].addEventListener('click', function() {
			let no = tr[i].getAttribute('attr');
			window.location.href = '/complaints/views/'+no;
		});
	}
</script>
<script type="module" src="<c:out value='/resources/js/complaints/complaintEvent.js' />"></script>
</body>
</html>