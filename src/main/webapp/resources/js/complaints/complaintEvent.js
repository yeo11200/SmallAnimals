import { list } from './complaints.js';

function insertEvent() {
	let insert = new list;
	console.log(insert);
	return insert.insertGo();
}

document.getElementById('insert').addEventListener('click', insertEvent);