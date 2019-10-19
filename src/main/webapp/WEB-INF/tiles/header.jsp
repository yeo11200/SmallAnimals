<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>Top 메뉴</h1>
<style>
#summernote {
  z-index: auto;
}
</style>
<script type="text/javascript">
$(function() {
	  $('#summernote').summernote({
	    height: 300,
	    lang: 'ko-KR', // 언어 세팅
	    placeholder: '내용을 입력해주세요',
	  });
	});
</script>
