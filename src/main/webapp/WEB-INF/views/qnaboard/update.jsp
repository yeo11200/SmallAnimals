<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 수정</title>
</head>
<body>
  <h1>QnA 글 수정</h1>
  <form id="frm">
  <input type="number" name="board_id" value="${vo.board_id }" hidden="hidden"> 
  <input type="number" name="edit_num" value="${vo.edit_num }" hidden="hidden">
  <p> 제목 : <input type="text" name="title" value="${vo.title }"></p>
  <p>글쓴이 : ${vo.user_id }</p>
  <fmt:formatDate value="${ vo.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="reg_date"/>
  <p>등록일 : ${reg_date }</p>
  <textarea rows="3" cols="4" id="summernote" name="contents">${vo.contents }</textarea>
  </form>
  <hr>
  <p>답변 : ${vo.answer }</p>
  <br><br><br>
  <a href="list"><button>목록</button></a>
  <a class="update" href="${vo.board_id }"><button>수정</button></a>
  
  <script type="text/javascript">
  $(document).ready(function () {
	  $('.update').click(function () {
			event.preventDefault();
			var frm = $('#frm');
			frm.attr('action', 'update');
			frm.attr('method', 'post');
			frm.submit();
	});
});
  </script>

</body>
</html>