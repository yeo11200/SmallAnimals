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
  <p>조회수 : ${vo.viewcnt }</p>
  <p>내용 : ${vo.contents }</p>
  <hr>
  <p>답변 : ${vo.answer }</p>
  <br><br><br>
  <a href="list"><button>목록</button></a>
  <a class="update" href="${vo.board_id }"><button>수정</button></a>
  <a class="delete" href="${vo.board_id }"><button>삭제</button></a>
  
  <form id="frm" style="display: none;">
    <input type="number" name="board_id" >
  </form>
  
  <script type="text/javascript">
  $(document).ready(function () {
	  if('${result_up}' === 'success') {
			alert('업데이트 성공');
		} else if('${result_up}' === 'failed') {
			alert('업데이트 실패')
		}
	  
    $('.update').click(function () {
      event.preventDefault();
      var board_id = $(this).attr('href');
      var frm = $('#frm');
      frm.attr('action', 'update');
      frm.attr('method', 'get');
      frm.find('[name="board_id"]').val(board_id);
      frm.submit();
  });
    
    $('.delete').click(function () {
        event.preventDefault();
        var board_id = $(this).attr('href');
        var frm = $('#frm');
        frm.attr('action', 'delete');
        frm.attr('method', 'post');
        frm.find('[name="board_id"]').val(board_id);
        frm.submit();
    });
});
  </script>
              
</body>
</html>