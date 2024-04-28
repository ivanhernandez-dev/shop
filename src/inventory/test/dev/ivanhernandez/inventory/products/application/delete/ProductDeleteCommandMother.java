package dev.ivanhernandez.inventory.products.application.delete;

import dev.ivanhernandez.inventory.products.domain.ProductIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;

public final class ProductDeleteCommandMother {
	public static ProductDeleteCommand create(ProductId id) {
		return new ProductDeleteCommand(id.value());
	}

	public static ProductDeleteCommand random() {
		return create(ProductIdMother.random());
	}
}
