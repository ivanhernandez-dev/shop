package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.UuidMother;

public final class ShelfIdMother {
	public static ShelfId create(String value) {
		return new ShelfId(value);
	}

	public static ShelfId random() {
		return create(UuidMother.random());
	}
}
