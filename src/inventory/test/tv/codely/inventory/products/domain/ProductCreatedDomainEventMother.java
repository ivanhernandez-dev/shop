package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.product.ProductCreatedDomainEvent;

public final class ProductCreatedDomainEventMother {
	public static ProductCreatedDomainEvent create(ProductId id, ProductName name, ProductPrice price) {
		return new ProductCreatedDomainEvent(id.value(), name.value(), price.value());
	}

	public static ProductCreatedDomainEvent fromProduct(Product product) {
		return create(product.id(), product.name(), product.price());
	}

	public static ProductCreatedDomainEvent random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random());
	}
}
