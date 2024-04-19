package tv.codely.inventory.products.domain;

import tv.codely.inventory.products.application.create.CreateProductRequest;

public final class ProductMother {
	public static Product create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight) {
		return Product.create(id, name, description, price, weight);
	}

	public static Product random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductDescriptionMother.random(), ProductPriceMother.random(), ProductWeightMother.random());
	}

	public static Product fromRequest(CreateProductRequest request) {
		return create(new ProductId(request.id()), new ProductName(request.name()), new ProductDescription(request.description()), new ProductPrice(request.price()), new ProductWeight(request.weight()));
	}
}
