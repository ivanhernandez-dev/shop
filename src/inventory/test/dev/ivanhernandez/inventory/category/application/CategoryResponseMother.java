package dev.ivanhernandez.inventory.category.application;

import dev.ivanhernandez.inventory.category.domain.CategoryNameMother;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;

public final class CategoryResponseMother {
	public static CategoryResponse create(String id, String name) {
		return new CategoryResponse(id, name);
	}

	public static CategoryResponse random() {
		return create(CategoryIdMother.random().value(), CategoryNameMother.random().value());
	}
}
