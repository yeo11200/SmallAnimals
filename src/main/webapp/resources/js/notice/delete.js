function delete1() {
	let no = document.getElementById('no').value;
	
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', '/notice/delete');
	xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
	xhr.send(no);
	xhr.onload = function () {
		alert('성공');
		location.href = "/notice/list";
	}
}

export {delete1}