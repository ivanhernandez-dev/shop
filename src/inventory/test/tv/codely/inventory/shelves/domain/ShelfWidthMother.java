package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.DoubleMother;

public final class ShelfWidthMother {
	public static ShelfWidth create(Double value) {
		return new ShelfWidth(value);
	}

	public static ShelfWidth random() {
		return create(DoubleMother.random());
	}
}
