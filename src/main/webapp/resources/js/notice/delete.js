function delete1() {
	let no = document.getElementById('no').value;
	let confirm1 = confirm('정말로 삭제하겠습니까?');
	
	if(confirm1) {
	let data = {'no': parseInt(no)};
//	alert(JSON.stringify(data));
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', '/notice/delete/'+no, true);
	xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
	xhr.send(JSON.stringify(data));
	xhr.onload = function () {
		alert('성공');
		location.href = xhr.responseText;
	};
	xhr.onerror = function () {
		alert('실패');
		location.href = "/error/error";
	};
	} else {
		event.preventDefault();
	}
	
}

class update1 {
//	constructor(a, b, ...c)
//	{
//		this.a = a;
//		this.b = b;
//		this.c = c;
//	}
	update (a, b, ...c) {
		alert(a+b+c);
	}
	
	list () {
		return location.href = "/notice/list";
	}
}

export {delete1, update1}