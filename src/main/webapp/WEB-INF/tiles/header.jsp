<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<li>
	<ol data-source="notice" class="ol">공지사항</ol>
	<ol data-source="complaints" class="ol">민원</ol>
</li>
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
	
let ols = document.getElementsByClassName('ol');
for(let i = 0; i < ols.length; i++) {
	ols[i].addEventListener('click', function () {
		let views = ols[i].getAttribute('data-source');
		location.href = '/'+views+'/list';
	});
}
</script>
