package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.UuidMother;

public final class ProductIdMother {
	public static ProductId create(String value) {
		return new ProductId(value);
	}

	public static ProductId random() {
		return create(UuidMother.random());
	}
}
