import { list, deleteApi } from './complaints.js';

let insert = new list;

function insertEvent() {
	console.log(insert);
	return insert.insertGo('1234');
}

function deleteGo() {
	let no = document.getElementById('no').getAttribute('attr');
	alert(no);
	let del = new deleteApi();
	return del.deleteApi1(no);
}

window.addEventListener('load', function () {
	let insert = document.getElementById('insert');
	let update = document.getElementById('update');
	let delete1 = document.getElementById('delete');
	if(insert){
		insert.addEventListener('click', insertEvent);
	}
	if(update) {
		let no = document.getElementById('no').getAttribute('attr');
		update.addEventListener('click', function () {
			window.location.href = '/complaints/update/'+no;
		});
	}
	if(delete1){
		delete1.addEventListener('click', deleteGo);
	}
})
