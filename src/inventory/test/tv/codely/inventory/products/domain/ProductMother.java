package tv.codely.inventory.products.domain;

import tv.codely.inventory.products.application.create.CreateProductRequest;

public final class ProductMother {
	public static Product create(ProductId id, ProductName name, ProductPrice price) {
		return new Product(id, name, price);
	}

	public static Product random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random());
	}

	public static Product fromRequest(CreateProductRequest request) {
		return create(new ProductId(request.id()), new ProductName(request.name()), new ProductPrice(request.price()));
	}
}
