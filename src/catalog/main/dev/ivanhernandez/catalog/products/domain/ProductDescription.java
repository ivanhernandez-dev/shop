package dev.ivanhernandez.catalog.products.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class ProductDescription extends StringValueObject {
	public ProductDescription(String value) {
		super(value);
	}

	private ProductDescription() {
		super("");
	}
}
