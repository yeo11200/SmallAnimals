import { list } from './complaints.js';

let insert = new list;

function insertEvent() {
	console.log(insert);
	return insert.insertGo();
}

document.getElementById('submit').addEventListener('click', function () {
//	event.preventDefault();
});