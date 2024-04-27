package dev.ivanhernandez.inventory.shared.domain;

import dev.ivanhernandez.shared.domain.UuidMother;

public final class CategoryIdMother {
	public static CategoryId create(String value) {
		return new CategoryId(value);
	}

	public static CategoryId random() {
		return create(UuidMother.random());
	}
}
