package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.shared.domain.MeasureValueObject;

public final class ShelfWidth extends MeasureValueObject {
	public ShelfWidth(Double value) {
		super(value);
	}

	private ShelfWidth() {
		super(null);
	}
}
