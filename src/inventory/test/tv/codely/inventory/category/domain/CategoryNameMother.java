package tv.codely.inventory.category.domain;

import tv.codely.shared.domain.WordMother;

public final class CategoryNameMother {
	public static CategoryName create(String value) {
		return new CategoryName(value);
	}

	public static CategoryName random() {
		return create(WordMother.random());
	}
}
