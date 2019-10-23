<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 도움되는 콘솔 경고를 포함한 개발 버전 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style type="text/css">
	[v-cloak] {
		display: none;
	}
</style>
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

<!-- v-cloak은 로드되자마자 이벤트시 렌더링되는 것을 보여주지않는 효과가 있다. -->
<div id="vuelist" v-cloak>
 	<table>
 	<thead>
 		<tr>
 			<th>제목</th>
 			<th>내용</th>
 			<th>시작일</th>
 			<th>종료일</th>
 		</tr>
 	</thead>
 	<tbody>
 		<tr v-for="list in lists" @click="views(list.no)">
 			<td>{{ list.title }}</td>
 			<td>{{ list.content }}</td>
 			<td>{{ list.startDate }}</td>
 			<td>{{ list.endDate }}</td>
 		</tr>
 	</tbody>
 	</table>
</div>
<script type="module" src="<c:out value="/resources/js/notice/import.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.3/fetch.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.min.js"></script>
<script type="text/javascript">
window.onload = function () {
	list();
}
function list() {
	new Vue({
		el: '#vuelist',
		data: {
			message : 'vuestart',
			lists: []
		},
		created: function () {
			fetch('/notice/lists').then((data) => {
					data.text().then((text) => {
						// 이렇게 불러오는 데이터는 string 형식이기 떄문에 받아올때 JSON.parse로 json형식인 key value로 만들어서 사용해주면 js에서 사용가능
						let a = JSON.parse(text);
						this.lists = a.list.list;
						console.log(this.lists);
					});
			}).catch((err) => {
				console.log('에러입니다만?');
			});
		},
		methods : {
			views : function (no) {
				alert(no);
			}
		}
	});
}
</script>
</body>
</html>