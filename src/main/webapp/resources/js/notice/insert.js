window.addEventListener('load', function () {
	document.getElementById('insert').addEventListener('click', insert);
});
 
function insert() {
	let form = document.form;
	if(form.title.value == '' && form.title.value.length <= 0) {
		event.preventDefault();
		form.title.focus();
	}else if(form.content.value == '' && form.content.value.length <= 0) {
		event.preventDefault();
		form.content.focus();
	}else if(form.startDate.value == '' && form.startDate.value.length <= 0) {
		event.preventDefault();
	}else if(form.endDate.value == '' && form.endDate.value.length <= 0) {
		event.preventDefault();
	}else if(form.startDate.value > form.endDate.value) {
		alert('시작일이 끝나는 날 보다 클수 없어요');
		event.preventDefault();
	}else {
		let emp = document.getElementById('emp');
		if(emp.checked == true){
			emp.value = 'on';
		}else {
			emp.value = 'off';
		}
		return true;
	}
}