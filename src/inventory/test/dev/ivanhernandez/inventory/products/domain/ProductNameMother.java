package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.shared.domain.WordMother;

public final class ProductNameMother {
	public static ProductName create(String value) {
		return new ProductName(value);
	}

	public static ProductName random() {
		return create(WordMother.random());
	}
}
