package dev.ivanhernandez.inventory.category.application.find;

import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;

public final class FindCategoryQueryMother {
	public static FindCategoryQuery create(String id) {
		return new FindCategoryQuery(id);
	}

	public static FindCategoryQuery random() {
		return create(CategoryIdMother.random().value());
	}
}
