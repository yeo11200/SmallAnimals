<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>팁</h1>
  <p>제목 : ${vo.title }</p>
  <p>글쓴이 : ${vo.user_id }</p>
  <fmt:formatDate value="${ vo.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="reg_date"/>
  <p>등록일 : ${reg_date }</p>
  <p>조회수 : ${vo.viewcnt }</p>
  <p>내용 : ${vo.contents }</p>
  <hr>
  <a id="like"><button>추천</button></a>
  <a id="dislike"><button>비추천</button></a>
  <br><br><br>
  <a href="list"><button>목록</button></a>
  <a class="update" href="#"><button>수정</button></a>
  <a class="delete" href="#"><button>삭제</button></a>
    
  <form id="frm" style="display: none;">
  <sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal.username" var="user_id" />
    <input type="text" id="user_id" name="user_id" value="${user_id }">
  </sec:authorize>
  <input type="number" id="board_id" name="board_id" value="${vo.board_id }">
  </form>
  <br><br>
  <%@ include file="reply.jsp" %>
  
  <script type="text/javascript">
  $(document).ready(function () {
	  if('${result_up}' === 'success') {
			alert('업데이트 성공');
		} else if('${result_up}' === 'failed') {
			alert('업데이트 실패')
		}
	  
    $('.update').click(function () {
      event.preventDefault();
      var user_id = $('#user_id').val();
      if (user_id === '${vo.user_id}' ) {
      	var frm = $('#frm');
      	frm.attr('action', 'update');
      	frm.attr('method', 'get');
     	 frm.submit(); 
      } else {
    	  alert('작성자만 수정 가능합니다.')
      }
  });
    
    $('.delete').click(function () {
        event.preventDefault();
        var user_id = $('#user_id').val();
        if (user_id === '${vo.user_id}' ) {
        	var frm = $('#frm');
        	frm.attr('action', 'delete');
        	frm.attr('method', 'post');
        	frm.submit();
        } else {
      	  alert('작성자만 삭제 가능합니다.')
        }
    });
    
    $('#like').click(function() { /* 추천 버튼 */
        var user_id = $('#user_id').val();
    	var board_id = ${vo.board_id};
        if (user_id != null) {
          // Ajax 요청을 보냄
          $.ajax({
            type : 'post',
            url : '/myapp/tipboard/like',
            headers : {
              'Content-Type' : 'application/json',
              'X-HTTP-Method-Override' : 'POST'
              },
              data : JSON.stringify({
            	'user_id' : user_id,
                'board_id' : board_id
                }),
                success : function(result) {
                  if (result === 'insert_like') {
                    alert('추천 완료');
                    } else if (result === 'delete_like') {
                    	alert('추천 해제');
                    } else if (result === 'error') {
                    	alert('오류 발생. 다시 시도해주세요');
                    }
                } 
          });
        } else {
          alert("로그인이 필요합니다.")
        }
      }); 
    
    $('#dislike').click(function() { /* 비추천 버튼 */
        var user_id = $('#user_id').val();
    	var board_id = ${vo.board_id};
        if (user_id != null) {
          // Ajax 요청을 보냄
          $.ajax({
            type : 'post',
            url : '/myapp/tipboard/dislike',
            headers : {
              'Content-Type' : 'application/json',
              'X-HTTP-Method-Override' : 'POST'
              },
              data : JSON.stringify({
            	'user_id' : user_id,
                'board_id' : board_id
                }),
                success : function(result) {
                  if (result === 'insert_dislike') {
                    alert('비추천');
                    } else if (result === 'delete_dislike') {
                    	alert('비추천 해제');
                    } else if (result === 'error') {
                    	alert('오류 발생. 다시 시도해주세요');
                    }
                } 
          });
        } else {
          alert("로그인이 필요합니다.")
        }
      }); 
});
  </script>
              
</body>
</html>