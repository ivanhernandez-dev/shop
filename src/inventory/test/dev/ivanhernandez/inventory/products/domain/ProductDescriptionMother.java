package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.shared.domain.WordMother;

public final class ProductDescriptionMother {
	public static ProductDescription create(String value) {
		return new ProductDescription(value);
	}

	public static ProductDescription random() {
		return create(WordMother.random());
	}
}
