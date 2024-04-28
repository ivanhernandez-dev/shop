package dev.ivanhernandez.inventory.category.application.create;

import dev.ivanhernandez.inventory.category.domain.CategoryNameMother;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;

public final class CreateCategoryCommandMother {
	public static CreateCategoryCommand create(String id, String name) {
		return new CreateCategoryCommand(id, name);
	}

	public static CreateCategoryCommand random() {
		return create(CategoryIdMother.random().value(), CategoryNameMother.random().value());
	}
}
