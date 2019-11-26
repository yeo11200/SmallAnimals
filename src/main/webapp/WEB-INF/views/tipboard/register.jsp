<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팁 등록</title>
</head>
<body>

  <form action="register" method="post">
    <sec:authorize access="isAuthenticated()">
      <sec:authentication property="principal.username" var="user_id" />
      <input type="text" name="user_id" value="${user_id }" hidden="hidden">
    </sec:authorize>
    <input type="text" name="title" placeholder="제목"><br>
    <textarea rows="3" cols="4" id="summernote" name="contents"></textarea>

    <input type="submit" value="등록">
  </form>


</body>
</html>