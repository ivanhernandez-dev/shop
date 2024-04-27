package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.UuidMother;

public final class ShelfIdMother {
	public static ShelfId create(String value) {
		return new ShelfId(value);
	}

	public static ShelfId random() {
		return create(UuidMother.random());
	}
}
