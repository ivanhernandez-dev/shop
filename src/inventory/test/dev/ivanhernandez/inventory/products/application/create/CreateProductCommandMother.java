package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;

public final class CreateProductCommandMother {
	public static CreateProductCommand create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		return new CreateProductCommand(id.value(), name.value(), description.value(), price.value(), weight.value(), color.value(), material.value(), categoryId.value());
	}

	public static CreateProductCommand random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductDescriptionMother.random(), ProductPriceMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), CategoryIdMother.random());
	}
}

