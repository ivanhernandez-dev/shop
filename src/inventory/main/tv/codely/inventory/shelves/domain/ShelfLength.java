package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.MeasureValueObject;

public final class ShelfLength extends MeasureValueObject {
	public ShelfLength(Double value) {
		super(value);
	}

	private ShelfLength() {
		super(null);
	}
}
