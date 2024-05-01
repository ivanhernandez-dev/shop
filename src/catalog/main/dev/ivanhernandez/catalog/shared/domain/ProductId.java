package dev.ivanhernandez.catalog.shared.domain;

import dev.ivanhernandez.shared.domain.IdentifierValueObject;

public final class ProductId extends IdentifierValueObject {
	public ProductId(String value) {
		super(value);
	}

	private ProductId() {
	}

	@Override
	public String toString() {
		return value;
	}
}
