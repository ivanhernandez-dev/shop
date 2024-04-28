package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.inventory.products.application.create.CreateProductCommand;
import dev.ivanhernandez.inventory.products.application.create.CreateProductRequest;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;

public final class ProductMother {
	public static Product create(ProductId id, ProductName name, ProductPrice price, ProductDescription description, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		return Product.create(id, name, description, price, weight, color, material, categoryId);
	}

	public static Product random() {
		return create(
			ProductIdMother.random(),
			ProductNameMother.random(),
			ProductPriceMother.random(),
			ProductDescriptionMother.random(),
			ProductWeightMother.random(),
			ProductColorMother.random(),
			ProductMaterialMother.random(),
			CategoryIdMother.random()
		);
	}

	public static Product fromRequest(CreateProductCommand request) {
		return create(
			ProductIdMother.create(request.id()),
			ProductNameMother.create(request.name()),
			ProductPriceMother.create(request.price()),
			ProductDescriptionMother.create(request.description()),
			ProductWeightMother.create(request.weight()),
			ProductColorMother.create(request.color()),
			ProductMaterialMother.create(request.material()),
			CategoryIdMother.create(request.categoryId())
		);
	}
}
