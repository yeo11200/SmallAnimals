import {delete1, update1} from './delete.js'

document.getElementById('delete').addEventListener('click', delete1);

document.getElementById('update').addEventListener('click', update);

function update() {
	let no = document.getElementById('no').value;
	let a = new update1(no);
	a.update();
}