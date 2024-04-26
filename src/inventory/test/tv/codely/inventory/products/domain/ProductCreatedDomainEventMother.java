package tv.codely.inventory.products.domain;

import tv.codely.inventory.products.application.create.ProductCreator;
import tv.codely.shared.domain.product.ProductCreatedDomainEvent;

public final class ProductCreatedDomainEventMother {
	public static ProductCreatedDomainEvent create(ProductId id, ProductName name, ProductPrice price, ProductDescription description, ProductWeight weight, ProductColor color, ProductMaterial material) {
		return new ProductCreatedDomainEvent(id.value(), name.value(), price.value(), description.value(), weight.value(), color.value(), material.value());
	}

	public static ProductCreatedDomainEvent fromProduct(Product product) {
		return create(product.id(), product.name(), product.price(), product.description(), product.weight(), product.color(), product.material());
	}

	public static ProductCreatedDomainEvent random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random());
	}
}
