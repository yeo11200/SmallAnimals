<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>QnA 글 내용</h1>
  <p>제목 : ${vo.title }</p>
  <p>글쓴이 : ${vo.user_id }</p>
  <fmt:formatDate value="${ vo.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="reg_date"/>
  <p>등록일 : ${reg_date }</p>
  <p>내용 : ${vo.contents }</p>
  <hr>
  <p>답변 : ${vo.answer }</p>
  <br><br><br>
  <a href="list"><button>목록</button></a>
  <a href="list"><button>삭제</button></a>
              
</body>
</html>