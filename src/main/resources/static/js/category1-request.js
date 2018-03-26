const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);
		const productsContainer = document.querySelector('#products-container');
		for (let product of res.products){
			createProductContainer(product, productsContainer);

		}
	}
}
xhr.open('GET', '/api/categories/1', true);
xhr.send();

const xhr2 = new XMLHttpRequest();
xhr2.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);
		const shoppingCartContainer=document.querySelector('#shopping-cart-container');
		const cartItems = res._embedded.cartItems
		for (let cartItem of cartItems){
			createShoppingCartContainer(cartItem, shoppingCartContainer);
		}
	}
}
xhr2.open('GET','/shoppingCarts/1/cartItems', true);
xhr2.send();



const createShoppingCartContainer = (cart, container) =>{}

	
const createProductContainer = (product, container) => {
	const productContainer = document.createElement('div');
	productContainer.classList.add('product-container');
	const productName= document.createElement('div');
	productName.classList.add('product-name');
	const productNameText=document.createElement('h3');
	productNameText.innerText = product.name;
	productName.appendChild(productNameText);
	productContainer.appendChild(productName);
	const productPrice=document.createElement('div');
	productPrice.classList.add('product-price');
	const productPriceText=document.createElement('p');
	productPriceText.innerText = product.price;
	productPrice.appendChild(productPriceText);
	productContainer.appendChild(productPrice);
	const productDescription=document.createElement('div');
	productDescription.classList.add('product-description');
	const productDescriptionText=document.createElement('p');
	productDescriptionText.innerText = product.description;
	productDescription.appendChild(productDescriptionText);
	productContainer.appendChild(productDescription);
	const productImage=document.createElement('div');
	productImage.classList.add('product-image');
	const productImageImg=document.createElement('img');
	productImageImg.setAttribute('src', product.imageUrl);
	productImage.appendChild(productImageImg);
	productContainer.appendChild(productImage);
	const productOrderFormContainer=document.createElement('div');
	productOrderFormContainer.classList.add('product-order-form-container');
	const productOrderForm=document.createElement('form');
	productOrderForm.classList.add('product-order-form');
	productOrderForm.innerText='Amount to order:'
	const productOrderFormInput=document.createElement('input');
	productOrderFormInput.setAttribute('type', 'number');
	productOrderFormInput.setAttribute('name', 'quantity');
	productOrderFormInput.setAttribute('min', '1');
	productOrderFormInput.setAttribute('max', '99');
	productOrderForm.appendChild(productOrderFormInput);
	const productOrderFormButton=document.createElement('button');
	productOrderFormButton.setAttribute('type', 'button');
	productOrderFormButton.innerText='Submit';
	productOrderForm.appendChild(productOrderFormButton);
	productOrderFormContainer.appendChild(productOrderForm);
	productContainer.appendChild(productOrderFormContainer);
	container.appendChild(productContainer);
}