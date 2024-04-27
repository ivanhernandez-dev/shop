package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.shared.domain.DoubleMother;

public final class ShelfWidthMother {
	public static ShelfWidth create(Double value) {
		return new ShelfWidth(value);
	}

	public static ShelfWidth random() {
		return create(DoubleMother.random());
	}
}
