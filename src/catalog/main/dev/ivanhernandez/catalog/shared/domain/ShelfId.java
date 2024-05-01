package dev.ivanhernandez.catalog.shared.domain;

import dev.ivanhernandez.shared.domain.IdentifierValueObject;

public final class ShelfId extends IdentifierValueObject {
	public ShelfId(String value) {
		super(value);
	}

	private ShelfId() {
	}
}
