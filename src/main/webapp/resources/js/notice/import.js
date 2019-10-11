import {delete1, update1} from './delete.js'

document.getElementById('delete').addEventListener('click', delete1);


document.getElementById('update').addEventListener('click', update);

function update() {
	let a = new update1();
	
	a.update('a',1,'2','4','5');
}