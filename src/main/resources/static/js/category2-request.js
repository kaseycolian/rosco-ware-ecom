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
xhr.open('GET', '/api/categories/2', true);
xhr.send();

const xhr2 = new XMLHttpRequest();
xhr2.onreadystatechange = function() {
	if (xhr2.readyState === 4 && xhr2.status === 200) {
		const res = JSON.parse(xhr2.responseText);
		const shoppingCartContainer=document.querySelector('#shopping-cart-container');
		const cartItems = res._embedded.cartItems;
		for (let cartItem of cartItems){
			populateShoppingCartContainer(cartItem, shoppingCartContainer);
		}
		let cartGrandTotal = 0.0;
		for (let cartItem of cartItems){
			cartGrandTotal += cartItem.lineItemTotal;
		}
		const cartGrandTotalContainer = document.createElement('div');
		cartGrandTotalContainer.classList.add('cart-grand-total');
		cartGrandTotalAmount=document.createElement('p');
		cartGrandTotalAmount.innerText="You're cart total is: $" + cartGrandTotal;
		cartGrandTotalContainer.appendChild(cartGrandTotalAmount);
		shoppingCartContainer.appendChild(cartGrandTotalContainer);

	}
}
xhr2.open('GET','/shoppingCarts/1/cartItems', true);
xhr2.send();



const populateShoppingCartContainer = (cartItem, container) =>{
	const shoppingCartItem = document.createElement('div');
	shoppingCartItem.classList.add('shopping-cart-item');
	const cartItemName = document.createElement('div');
	cartItemName.classList.add('cart-item-name');
	const cartItemNameText = document.createElement('h4');
	cartItemNameText.innerText=cartItem.productName;
	cartItemName.appendChild(cartItemNameText);
	shoppingCartItem.appendChild(cartItemName);
	cartItemQuantity= document.createElement('div');
	cartItemQuantity.classList.add('cart-item-quantity');
	cartItemQuantityAmount=document.createElement('p');
	cartItemQuantityAmount.innerText=cartItem.quantityOfIndividualProduct;
	cartItemQuantity.appendChild(cartItemQuantityAmount);
	shoppingCartItem.appendChild(cartItemQuantity);
	cartItemTotal = document.createElement('div');
	cartItemTotal.classList.add('cart-item-total');
	cartItemTotalAmount = document.createElement('p');
	cartItemTotalAmount.innerText=cartItem.lineItemTotal;
	cartItemTotal.appendChild(cartItemTotalAmount);
	shoppingCartItem.appendChild(cartItemTotal);
	container.appendChild(shoppingCartItem);
}

	
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