<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	@media (min-height:320px){
		tbody > tr:hover {
			background-color: gray;
		}
		thead > tr > th {
			text-align: center;
		}
		#searchGroup {
			margin-top: 10px;
			width: 60px;
			height: 27px;
		}
	}
</style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.3/fetch.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.min.js"></script>
</head>
<body>
<!-- 여기는 관리자만 볼수 있는 곳이다 -->
<form method="get">
<button name="date" value="pre" class="notice1" id="pre">현재공지</button>
<button name="date" value="end" class="notice1" id="end">예약공지</button>
<button name="date" value="start" class="notice1" id="start">지난공지</button>
</form>

<table>
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>공지일</th>
		<th>공지종료일</th>
	</tr>
</thead>
	<tbody>
	<c:choose>
	   <c:when test="${fn:length(list) > 0}">
		<c:forEach items="${list }" var="list" varStatus="index">
		<c:if test="${list.emp == 'on'}">
				<tr class="views" attr="${list.no }">
					<td>공지</td>
					<td>${list.title }</td>
					<td>${fn:substring(list.content, 0, 10) }</td>
					<td>${list.startDate }</td>
					<td>${list.endDate }</td>
				</tr> 
		</c:if>
		<c:if test="${list.emp == 'off' }">
			<tr class="views" attr="${list.no }">
				<td class="no">${count}</td>
				<td>${list.title }</td>
				<td>${fn:substring(list.content, 0, 10) }</td>
				<td>${list.startDate }</td>
				<td>${list.endDate }</td>
			</tr>
			<!-- 글을 역순으로 출력하기 위해서 사용한다. -->
			<!-- c:set은 값을 변경해서 가지고 올 떄 사용을 한다. -->
			<c:set var="count" value="${count-1 }"></c:set>
		</c:if>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td><h2>데이터가 없어요</h2></td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	<tfoot>
	<tr>
		<td><button id="insert">글쓰기</button></td>
	</tr>
	</tfoot>
</table>

<div>
	<select name="searchGroup" id="searchGroup">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="emp">중요공지</option>
	</select>
	<input id="search" name="search">
	<button id="search1">검색</button>
</div>
<script>
window.addEventListener('load', function () {
	view();	
	document.getElementById('search1').onclick = function () {
		var a = document.getElementById('searchGroup').value;
		alert(a);
	};
})
function view() {
	let views = document.getElementsByClassName('views');
	for(let i=0; i < views.length; i++){
		document.getElementsByClassName('views')[i].addEventListener('click', function() {
			let no = views[i].getAttribute('attr');
			
			location.href = "/notice/views/"+no;
		});	
	}
}

// function notice1() {
// 	let date1 = document.getElementsByClassName('notice1');
// 	for(let i=0; i < date1.length; i++){
// 		document.getElementsByClassName('notice1')[i].addEventListener('click', function() {
// 			let date2 = date1[i].value;
// 			let data = {'date' : date2};
			
// 			$.ajax({
// 				url: '/notice/lists',
// 				data : data,
// 				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
// 				type: 'get',
// 				success : function(data){
// 					console.log(data.list.list[0]);
// 				},
// 				error : function(err) {
// 					console.log(err);
// 				}
// 			})
// 		});
// 	}
// }

document.getElementById('insert').addEventListener('click', function () {
	location.href = "/notice/insert";
});

</script>
</body>
</html>