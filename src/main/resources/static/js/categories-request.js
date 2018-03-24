const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText)
		const categoriesContainer = document.querySelector('#categories-container')
		
		for (let category of res) {
			const categoryContainer = document.createElement('div')
			const categoryLink = document.createElement('a')
			categoryLink.setAttribute('href', '/catalog/category.html');
			categoryLink.innerText = product.name
			categoryContainer.appendChild(productLink)
			categoriesContainer.appendChild(productContainer)
		}
	}
}

xhr.open('GET', '/categories', true);
xhr.send();
