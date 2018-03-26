const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText)
		const categoriesContainer = document.querySelector('#categories-container')
		
		for (let category of res) {
			const categoryContainer = document.createElement('div');
			const categoryTitle = document.createElement('h2');
			categoryTitle.classList.add('category-name');
			const categoryLink = document.createElement('a');
			categoryLink.classList.add('category-link');
			categoryLink.setAttribute('href', '/catalog/category?id='+category.id);
			categoryLink.innerText = category.name;
			categoryTitle.appendChild(categoryLink);
			categoryContainer.appendChild(categoryTitle);
			categoriesContainer.appendChild(categoryContainer);
		}
	}
}

xhr.open('GET', '/api/categories', true);
xhr.send();
