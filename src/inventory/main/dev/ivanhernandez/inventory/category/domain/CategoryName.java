package dev.ivanhernandez.inventory.category.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class CategoryName extends StringValueObject {
	public CategoryName(String value) {
		super(value);
	}

	private CategoryName() {
		super("");
	}
}
