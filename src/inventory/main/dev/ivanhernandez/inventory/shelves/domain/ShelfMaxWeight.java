package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.shared.domain.MeasureValueObject;

public final class ShelfMaxWeight extends MeasureValueObject {
	public ShelfMaxWeight(Double value) {
		super(value);
	}

	private ShelfMaxWeight() {
		super(null);
	}
}
