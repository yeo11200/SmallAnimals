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
	[v-cloak] {
		display: none;
	}
</style>
</head>
<body>
<table>
	<tbody>
		<tr id="no" attr="${view.no }">
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
	<button id="update">수정</button>
	<button id="delete">삭제</button>
</div>

<div id="replyComplaint">

</div>

<!-- v-cloak을 사용하면 로딩되는 동안 방지를 해준다. -->
<div id="viewList" v-cloak>
 {{ message }}
</div>
<script type="module" src="<c:url value='/resources/js/complaints/complaintEvent.js'></c:url>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.3/fetch.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">
	new Vue({ 
		el: '#viewList',
		data () {
			return {
				lists : [],
				message : 'test',
			}
		},
		created : function() {
			fetch('/complaints/viewlist').then( function (data) {
				data.text().then( function (list) {
					console.log(JSON.parse(list));
				}).catch(function (error) {
					console.log(error);
				});
			}).catch( function (error) {
				console.log(error);
			});
		}
	})
</script>
</body>
</html>