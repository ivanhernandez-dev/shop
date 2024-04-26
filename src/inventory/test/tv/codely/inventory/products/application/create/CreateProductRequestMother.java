package tv.codely.inventory.products.application.create;

import tv.codely.inventory.products.domain.*;

public final class CreateProductRequestMother {
	public static CreateProductRequest create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight, ProductColor color, ProductMaterial material) {
		return new CreateProductRequest(id.value(), name.value(), description.value(), price.value(), weight.value(), color.value(), material.value());
	}

	public static CreateProductRequest random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductDescriptionMother.random(), ProductPriceMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random());
	}
}
