window.addEventListener('load', function () {
	document.getElementById('insert').addEventListener('click', insert);
});
 
function insert() {
	let form = document.form;
	let xhr = new XMLHttpRequest();
	xhr.open('post', '/notice/insertApi');
}