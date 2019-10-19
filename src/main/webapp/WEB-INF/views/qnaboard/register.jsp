<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 등록</title>
</head>
<body>
  <form action="register" method="post">
	<input type = "text" name="title" placeholder="제목"><br>
    <input type= "text" name="user_id" placeholder="임시로 아이디 입력" <%-- value=${로그인아이디... } --%>>
	<textarea rows="3" cols="4" id="summernote" name="contents"></textarea>
	
	<input type= "submit" value="등록">
  </form>
  
 
</body>
</html>