<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tbody>
	<c:if test="${fn:length(list) > 0 }">
	<c:forEach var="list" items="${list }">
		<tr class="tr" attr="${list.no }">
			<td>${list.result }</td>
			<td>${list.title }</td>
			<td>${fn:substring(list.content,0, 5) }(${list.replycnt})</td>
			<td>${list.writer }</td>
			<td>${list.writeDate }</td>
			<td>${list.title }</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${fn:length(list) <= 0 }">
	<tr>
		<td><strong>데이터가 없습니다.</strong></td>
	</tr>
	</c:if>
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