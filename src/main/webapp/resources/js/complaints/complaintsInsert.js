import { list } from './complaints.js';

let insert = new list;

function insertEvent() {
	console.log(insert);
	return insert.insertGo('1234');
}

document.getElementById('submit').addEventListener('click', function () {
	alert(123);
//	event.preventDefault();
});