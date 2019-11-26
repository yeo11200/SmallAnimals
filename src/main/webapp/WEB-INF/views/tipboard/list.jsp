<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
</head>
<body>
	<h1>팁 게시판</h1>
  <table style="width: 100%; border: 1px solid gray;">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="vo" items="${Tip }">
        <tr>
          <td style="width: 100px;">${vo.board_id }</td>
          <td style="width: 800px;"><a class="goToDetail" href="${vo.board_id }">${vo.title }</a></td>
          <td>${vo.user_id }</td>
          <fmt:formatDate value="${vo.reg_date }"
              pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
          <td>${regdate }</td>
          <td>${vo.viewcnt }</td>
        </tr>
      </c:forEach>
    </tbody>
    
  </table>
  
  <a href="register"><button>글 작성</button></a>
  
  <form id="frm" style="display: none;">
    <input type="number" name="board_id">
  </form>
  
  <script type="text/javascript">
  	$(document).ready(function () {
		if('${rst_reg}' === 'success') {
			alert('새 글 작성 성공');
		} else if('${rst_reg}' === 'failed') {
			alert('등록 실패')
		} else if('${rst_del}' === 'success') {
			alert('삭제 성공');
		} else if('${rst_del}' === 'failed') {
			alert('삭제 실패')
		} 
		
		$('.goToDetail').click(function() {
			event.preventDefault(); 
			var board_id = $(this).attr('href');
			var frm = $('#frm');
			frm.attr('action', 'detail');
			frm.attr('method', 'get');
			frm.find('[name="board_id"]').val(board_id);
			frm.submit();
		}); // end goToDetail click()
	});
  </script>
</body>
</html>