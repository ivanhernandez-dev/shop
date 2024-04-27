package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class ProductName extends StringValueObject {
	public ProductName(String value) {
		super(value);
	}

	private ProductName() {
		super("");
	}
}
