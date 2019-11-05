import { list } from './complaints.js';

let insert = new list;

function insertEvent() {
	console.log(insert);
	return insert.insertGo('1234');
}
window.addEventListener('load', function () {
	let insert = document.getElementById('insert')
	if(insert){
		insert.addEventListener('click', insertEvent);
	}
	let update = document.getElementById('update');
	if(update) {
		let no = document.getElementById('no').getAttribute('attr');
		update.addEventListener('click', function () {
			window.location.href = '/complaints/update/'+no;
		});
	}
})
