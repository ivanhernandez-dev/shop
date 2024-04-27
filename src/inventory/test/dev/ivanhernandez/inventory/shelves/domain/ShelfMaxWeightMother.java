package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.shared.domain.DoubleMother;

public class ShelfMaxWeightMother {
	public static ShelfMaxWeight create(Double value) {
		return new ShelfMaxWeight(value);
	}

	public static ShelfMaxWeight random() {
		return create(DoubleMother.random());
	}
}
