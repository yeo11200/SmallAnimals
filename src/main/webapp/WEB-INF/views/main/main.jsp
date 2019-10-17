<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메인입니다</h2>

<button id="modal">모달창 열기</button>
<div id="modalshow"></div>
<script>
document.getElementById('modal').onclick = function () {
	var xhr = new XMLHttpRequest();
	
	xhr.open('get', '/modal/modal');
	xhr.send();
	xhr.onload = function () {
		console.log(xhr.responseText);
		document.getElementById('modalshow').innerHTML = xhr.responseText;
		
		document.getElementById('close').addEventListener('click', function () {
			document.getElementById('noticeModal').style.display = 'none';
		});
	}
}

</script>
</body>
</html>