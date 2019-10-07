window.addEventListener('load', function () {
		let view = document.getElementsByClassName('no')
		for(let i=0; i<view.length; i++) {
			view[i].addEventLintener('click', function () {
				alert(view[i].text);
			});
		}
})