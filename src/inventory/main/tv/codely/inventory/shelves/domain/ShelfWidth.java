package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.MeasureValueObject;

public final class ShelfWidth extends MeasureValueObject {
	public ShelfWidth(Double value) {
		super(value);
	}

	private ShelfWidth() {
		super(null);
	}
}
