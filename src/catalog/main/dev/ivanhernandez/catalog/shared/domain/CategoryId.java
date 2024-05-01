package dev.ivanhernandez.catalog.shared.domain;

import dev.ivanhernandez.shared.domain.IdentifierValueObject;

public final class CategoryId extends IdentifierValueObject {
	public CategoryId(String value) {
		super(value);
	}

	public CategoryId() {
		super();
	}
}
