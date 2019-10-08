<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	@media (min-height:320px){
		tr:hover {
			background-color: gray;
		}
	}
</style>
</head>
<body>
<table>
	<tbody>
		<c:forEach items="${list }" var="list" varStatus="index">
			<tr class="views" attr="${list.no }">
				<td class="no">${count}</td>
				<td>${list.title }</td>
				<td>${list.content }</td>
				<td>${list.startDate }</td>
				<td>${list.endDate }</td>
			</tr>
			<!-- 글을 역순으로 출력하기 위해서 사용한다. -->
			<!-- c:set은 값을 변경해서 가지고 올 떄 사용을 한다. -->
			<c:set var="count" value="${count-1 }"></c:set>
		</c:forEach>
	</tbody>
	<tfoot>
	<tr>
		<td><button id="insert">글쓰기</button></td>
	</tr>
	</tfoot>
</table>
<script>
window.addEventListener('load', function () {
	view();	
})
function view() {
	let views = document.getElementsByClassName('views');
	for(let i=0; i < views.length; i++){
		document.getElementsByClassName('views')[i].addEventListener('click', function() {
			let no = views[i].getAttribute('attr');
			
			location.href = "/myapp/notice/views/"+no;
		});	
	}
}

document.getElementById('insert').addEventListener('click', function () {
	location.href = "/notice/insert";
});
</script>
</body>
</html>