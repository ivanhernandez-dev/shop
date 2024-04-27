package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.shared.domain.PriceMother;

public final class ProductPriceMother {
	public static ProductPrice create(String value) {
		return new ProductPrice(value);
	}

	public static ProductPrice random() {
		return create(PriceMother.random());
	}
}
