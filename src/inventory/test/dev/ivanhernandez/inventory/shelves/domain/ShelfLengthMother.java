package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.shared.domain.DoubleMother;

public final class ShelfLengthMother {
	public static ShelfLength create(Double value) {
		return new ShelfLength(value);
	}

	public static ShelfLength random() {
		return create(DoubleMother.random());
	}
}
