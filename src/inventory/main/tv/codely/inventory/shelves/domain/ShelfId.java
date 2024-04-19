package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.IdentifierValueObject;

public final class ShelfId extends IdentifierValueObject {
	public ShelfId(String value) {
		super(value);
	}

	private ShelfId() {
	}

	@Override
	public String toString() {
		return value;
	}
}
