package tv.codely.inventory.products.application.create;

import tv.codely.inventory.products.domain.*;

public final class CreateProductRequestMother {
	public static CreateProductRequest create(ProductId id, ProductName name, ProductPrice price) {
		return new CreateProductRequest(id.value(), name.value(), price.value());
	}

	public static CreateProductRequest random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random());
	}
}
