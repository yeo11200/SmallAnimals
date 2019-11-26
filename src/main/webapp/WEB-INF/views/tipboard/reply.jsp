<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal.username" var="user_id" />
  <c:if test="${empty user_id}">
    <p> 댓글 입력은 로그인 후 가능합니다 </p>
  </c:if>
  <c:if test="${not empty user_id}">
    <input id="re_contents" style="width: 1146px;" placeholder=" 댓글 입력" required="required">
    <input type="hidden" id="user_id" name="user_id" value="${user_id }" disabled="disabled">
    <button type="button" id="btn_add">등록</button>
    <br><br>
  </c:if>
  </sec:authorize>

  <div id="replies"></div>

  <script type="text/javascript">
    $(document).ready(function() { /* 댓글 리스트 출력 */
      var board_id = $('#board_id').val();
      getAllFreplies();
      
      function getAllFreplies() {
        var url = '/myapp/tipboard/reply/all/' + board_id;
        $.getJSON(
            url,
            function(jsonData) {
              console.log(jsonData.length);
              var list = '';
             /*  var i; */
              $(jsonData).each(function() {
                var date = new Date(this.reg_date);
                var dateString = date.toLocaleString();
                list += '<div class="reply_item">'
                + '<input type="hidden" class="reply_id" value="'
                + this.reply_id + '" />&nbsp'
                + '<span style="display: inline-block; width: 785px;">'
                + this.contents + '</span>&nbsp'
                + '<input type="hidden" id="reply_writer" value="'
                + this.user_id + '" disabled />&nbsp'
                + '<span style="display: inline-block; width: 170px;" >'
                + this.user_id + '</span>&nbsp'
                + '<span style="display: inline-block; width : 200px;">'
                + dateString + '</span>&nbsp'
                + '&nbsp'
                + '<button class="btn_delete" type="button">X</button>'
                + '</div>';
              }); // end each()
              $('#replies').html(list);
            });// end getJSON
      } // end getAllFreplies()
      
      $('#btn_add').click(function() { /* 댓글 등록 버튼 */
        var re_contents = $('#re_contents').val();
        var user_id = $('#user_id').val();
        if (re_contents != "") {
          // Ajax 요청을 보냄
          $.ajax({
            type : 'post',
            url : '/myapp/tipboard/reply',
            headers : {
              'Content-Type' : 'application/json',
              'X-HTTP-Method-Override' : 'POST'
              },
              data : JSON.stringify({
                'board_id' : board_id,
                'contents' : re_contents,
                'user_id' : user_id
                }),
                success : function(result) {
                  if (result == 1) {
                    alert('댓글 입력 성공');
                    $('#re_contents').val('');
                    getAllFreplies();
                    } 
                } 
          });
        } else {
          alert("댓글을 입력해주세요.")
        }
      }); 
      
      $('#replies').on('click', '.reply_item .btn_delete', /* 댓글 삭제 버튼 */
          function() {
    	  	var reply_id = $(this).prevAll('.reply_id').val();
            var reply_writer = $(this).prevAll('.reply_writer').val();
            var user_id = $(this).prevAll('#user_id').val();
            if (reply_writer === user_id ) {
              var ret = confirm('정말로 삭제하시겠습니까?');
              if (ret === true) {
                // Ajax 요청을 보냄
                $.ajax({type : 'delete',
                    url : '/myapp/tipboard/reply/'+ reply_id,
                    headers : {
                      'Content-Type' : 'application/json',
                      'X-HTTP-Method-Override' : 'DELETE'
                      },
                      success : function(result) {
                        if (result === 'success') {
                          alert('댓글 삭제 성공');
                          getAllFreplies();
                        } 
                      } 
                }); // end ajax
              } 
            } else {
              alert('본인 댓글만 삭제 가능합니다.');
            }
          }); 
      
      }); 
  </script>
</body>
</html>