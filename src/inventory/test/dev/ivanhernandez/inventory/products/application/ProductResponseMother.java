package dev.ivanhernandez.inventory.products.application;

import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;

public final class ProductResponseMother {
	public static ProductResponse create(String id, String name, String description, String price, Double weight, String color, String material, String categoryId) {
		return new ProductResponse(id, name, description, price, weight, color, material, categoryId);
	}

	public static ProductResponse random() {
		return create(ProductIdMother.random().value(), ProductNameMother.random().value(), ProductDescriptionMother.random().value(), ProductPriceMother.random().value(), ProductWeightMother.random().value(), ProductColorMother.random().value(), ProductMaterialMother.random().value(), CategoryIdMother.random().value());
	}
}
