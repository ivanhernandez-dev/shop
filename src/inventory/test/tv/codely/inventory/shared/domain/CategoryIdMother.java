package tv.codely.inventory.shared.domain;

import tv.codely.shared.domain.UuidMother;

public final class CategoryIdMother {
	public static CategoryId create(String value) {
		return new CategoryId(value);
	}

	public static CategoryId random() {
		return create(UuidMother.random());
	}
}
