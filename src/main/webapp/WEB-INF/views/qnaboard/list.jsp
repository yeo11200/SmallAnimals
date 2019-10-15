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
	<h1>QnA list</h1>
  <table style="width: 100%; border: 1px solid gray;">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
        <th>답변</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="vo" items="${QnA }">
        <tr>
          <td>${vo.board_id }</td>
          <td><a class="goToDetail" href="${vo.board_id }">${vo.title }</a></td>
          <td>${vo.contents }</td>
          <td>${vo.user_id }</td>
          <fmt:formatDate value="${vo.reg_date }"
              pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
          <td>${regdate }</td>
          <td>${vo.viewcnt }</td>
          <c:choose>
            <c:when test="${empty vo.answer }">
              <td>N</td>
            </c:when>
            <c:otherwise>
              <td>Y</td>
            </c:otherwise>
          </c:choose>
          
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
		if('${result_reg}' === 'success') {
			alert('새 글 작성 성공');
		} else if('${result_reg}' === 'failed') {
			alert('등록 실패')
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