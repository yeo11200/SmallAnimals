<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>QnA list</h1>
  <script type="text/javascript">
  	$(document).ready(function () {
		if('${result_reg}' === 'success') {
			alert('새 글 작성 성공');
		} else if('${result_reg}' === '') {
			alert('등록 실패')
		}
	});
  </script>
</body>
</html>