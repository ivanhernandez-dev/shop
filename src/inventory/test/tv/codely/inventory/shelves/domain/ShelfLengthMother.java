package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.DoubleMother;

public final class ShelfLengthMother {
	public static ShelfLength create(Double value) {
		return new ShelfLength(value);
	}

	public static ShelfLength random() {
		return create(DoubleMother.random());
	}
}
