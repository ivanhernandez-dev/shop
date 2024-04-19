package tv.codely.inventory.products.application.create;

import tv.codely.inventory.products.domain.*;

public final class CreateProductRequestMother {
	public static CreateProductRequest create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight) {
		return new CreateProductRequest(id.value(), name.value(), description.value(), price.value(), weight.value());
	}

	public static CreateProductRequest random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductDescriptionMother.random(), ProductPriceMother.random(), ProductWeightMother.random());
	}
}
