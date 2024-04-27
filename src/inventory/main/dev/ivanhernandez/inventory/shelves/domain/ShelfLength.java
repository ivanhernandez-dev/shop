package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.shared.domain.MeasureValueObject;

public final class ShelfLength extends MeasureValueObject {
	public ShelfLength(Double value) {
		super(value);
	}

	private ShelfLength() {
		super(null);
	}
}
