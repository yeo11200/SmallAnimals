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
/* 	table { */
/* 		width: 100%; */
/* 	} */
/* 	table > tbody > tr > td { */
/* 		text-align: center; */
/* 		width: 80%; */
/* 	} */
/* 	table > tbody > tr > th { */
/* 		text-align: center; */
/* 		width: 20%; */
/* 	} */
/* 	div { */
/* 		text-align: left; */
/* 	} */
	[v-cloak] {
		display: none;
	}
	.replyUpdate {
		color: blue;
	}
	.replyDelete {
		color: red;
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
<p>${param.no }</p>
	<button id="update">수정</button>
	<button id="delete">삭제</button>
</div>
<!-- v-cloak을 사용하면 로딩되는 동안 방지를 해준다. -->
<div id="viewList" v-cloak>
 {{ message }}
 <table>
 	<thead>
 		<tr>
 			<th>제목</th>
 			<th>내용</th>
 			<th>작성자</th>
 			<th>조회수</th>
 		</tr>
 	</thead>
 	<tbody>
 		<tr v-for="list in lists" @click="views(list.no)" v-if="list1">
 			<td>{{ list.title }}</td>
 			<td>{{ list.content }}</td>
 			<td>{{ list.writer }}</td>
 			<td>{{ list.hit }}</td>
 		</tr>
 	</tbody>
 </table>
</div>

<div id="replyList" v-cloak>
<input value="${view.no}" v-model="no1" hidden="hidden">
 <h2>{{ message }}</h2>
 <table>
 	<thead>
 	</thead>
 	<tbody>
 		<tr v-for="list in replyList">
 			<td><div v-if="list12 === true">{{ list.replyNo }}</div><input v-if="list12 === false" v-bind:value="list.replyNo"></td>
 			<td><div v-if="list12 === true">{{ list.boardNo }}</div><input v-if="list12 === false" v-bind:value="list.boardNo"></td>
 			<td><div v-if="list12 === true">{{ list.replyContent }}</div><input v-if="list12 === false" v-bind:value="list.replyContent"></td>
 			<td><div v-if="list12 === true">{{ list.replyWriter }}</div><input v-if="list12 === false" v-bind:value="list.replyWriter"></td>
<%--  			<c:if test=""> --%>
 			<td><button v-if="list12 === true" class="replyUpdate" @click="replyUpdate">수정</button></td>
 			<td><button v-if="list12 === true" class="replyDelete">삭제</button></td>
<%--  			</c:if> --%>
		</tr>
 	</tbody>
 </table>
</div>
<script type="module" src="<c:url value='/resources/js/complaints/complaintEvent.js'></c:url>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.3/fetch.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">
window.onload = function () {
	list();
	replyList();
}

function list() {
	new Vue({ 
		el: '#viewList',
		data () {
			return {
				lists : [],
				message : 'test',
				list1 : true
			}
		},
		created: function() {
			fetch('/complaints/viewlist').then((data) => {
				data.text().then((text) => {
					// 이렇게 불러오는 데이터는 string 형식이기 떄문에 받아올때 JSON.parse로 json형식인 key value로 만들어서 사용해주면 js에서 사용가능
					let a = JSON.parse(text);
					this.lists = a.list;
					console.log(this.lists);
					
				});
			}).catch(function(error) {
				console.log(error);
			});
		},
	})
}

function replyList() {
	new Vue({
		el:'#replyList',
		data () {
			return {
			replyList : [],
			message : '여기는 댓글',
			no1 : '${view.no}',
			list12 : true
			}
		},
		created: function () {
			// get이거나 head일 떄 body를 사용하지 못한다 -> Uncaught (in promise) TypeError: Failed to execute 'fetch' on 'Window': Request with GET/HEAD method cannot have body 에러 발생
			
			fetch('/complaints/replyList/'+this.no1, { method: 'GET' }).then((data) => {
				 if(data.status === 200) {
					data.text().then(text => {
						let a = JSON.parse(text);
						console.log(a);
						this.replyList = a.list;
						
						return this.replyList;
					}).catch(error => {
						console.log(error);
					});
				 }
			});
		},
		methods: {
			replyUpdate: function () {
				this.list12 = false;
				alert('replyUpdateClick');
			},
			replyDelete: function () {
				this.list12 = false;
			}
		}
	})
}
</script>
</body>
</html>