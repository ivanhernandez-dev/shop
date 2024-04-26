package tv.codely.inventory.products.domain;

import tv.codely.inventory.products.application.create.CreateProductRequest;

public final class ProductMother {
	public static Product create(ProductId id, ProductName name, ProductPrice price, ProductDescription description, ProductWeight weight, ProductColor color, ProductMaterial material) {
		return Product.create(id, name, description, price, weight, color, material);
	}

	public static Product random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random());
	}

	public static Product fromRequest(CreateProductRequest request) {
		return create(new ProductId(request.id()), new ProductName(request.name()), new ProductPrice(request.price()), new ProductDescription(request.description()), new ProductWeight(request.weight()), new ProductColor(request.color()), new ProductMaterial(request.material()));
	}
}
