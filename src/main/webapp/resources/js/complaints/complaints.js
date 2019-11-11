class list {
	viewGo() {
		
	}
	
	insertGo(app) {
		alert(app);
		location.href = '/complaints/insert';
	}
	
}

class deleteApi {
	
	deleteApi1(no) {
		let xhr = new XMLHttpRequest();
		// 비동기를 통신할 건지 안핡건지를 정해준다. true, false
		xhr.open('delete', '/complaints/delete/'+no, true);
		xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
		xhr.send();
		xhr.onload = function () {
			alert('성공');
			location.href = xhr.responseText;
		};
		xhr.onerror = function () {
			alert('실패');
			location.href = "/error/error";
		};
	}
}
export {list, deleteApi};