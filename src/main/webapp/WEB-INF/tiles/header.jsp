<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="menu_bar">
	<li data-source="notice" class="ol">공지사항</li>
	<li data-source="complaints" class="ol">민원</li>
</ul>
<style>
#summernote {
  z-index: auto;
}

.menu_bar > li {
	display: inline;
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
