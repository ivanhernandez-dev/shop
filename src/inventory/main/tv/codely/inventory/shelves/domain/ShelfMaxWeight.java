package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.MeasureValueObject;

public final class ShelfMaxWeight extends MeasureValueObject {
	public ShelfMaxWeight(Double value) {
		super(value);
	}

	private ShelfMaxWeight() {
		super(null);
	}
}
