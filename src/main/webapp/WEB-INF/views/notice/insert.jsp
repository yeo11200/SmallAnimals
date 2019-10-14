<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#startDate {
	z-index: 1;
}
#endDate {
	z-index: 1;
}
#summernote {
	z-index: 2;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
    $("#startDate").datepicker({
        dateFormat: 'yy-mm-dd' //Input Display Format 변경
            ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능                
            ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
            ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
            ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
            ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
    });
    $("#endDate").datepicker({
        dateFormat: 'yy-mm-dd' //Input Display Format 변경
            ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능                
            ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
            ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
            ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
            ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
    });
})
</script>
</head>
<body>
<form:form  name="form" method="post" action="/notice/insert">
	<input type="text" name="title" id="title">
	<label for="startDate">시작일</label>
	<input type="text" name="startDate" id="startDate" autocomplete="off">~
	<label for="endDate">종료일</label>
	<input type="text" name="endDate" id="endDate" autocomplete="off">
	<textarea id="summernote" name="content"></textarea>
	<input type="checkbox" name="emp" id="emp">중요공지
	<button id="insert">글쓰기</button>
</form:form>
<script type="text/javascript" src="<c:out value='/resources/js/notice/insert.js'></c:out>"></script>
<script>
// 	$(document).ready(function () {
// 		$('input#id').on('change', function () {
// 			var a = $('#id').val();
// 			$.ajax({
// 				type: 'get',
// 				url : "/notice/idcheck",
// 				data : {'id': a},
// 				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
// 				success : function (data) {
// 					alert(data);
// 				},
// 				error : function (request,status,error) {
// 					 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
// 				}
// 			});
// 		});
// 	});
function idcheck() {
		var a = $('#id').val();
		$.ajax({
			type: 'get',
			url : "/notice/idcheck",
			data : {'id': a},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success : function (data) {
				alert(data);
			},
			error : function (request,status,error) {
				 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
}
</script>
</body>
</html>