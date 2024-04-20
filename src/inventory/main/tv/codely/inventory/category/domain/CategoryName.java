package tv.codely.inventory.category.domain;

import tv.codely.shared.domain.StringValueObject;

public final class CategoryName extends StringValueObject {
	public CategoryName(String value) {
		super(value);
	}

	private CategoryName() {
		super("");
	}
}
