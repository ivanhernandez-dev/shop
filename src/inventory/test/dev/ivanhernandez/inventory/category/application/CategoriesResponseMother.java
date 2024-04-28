package dev.ivanhernandez.inventory.category.application;

import dev.ivanhernandez.shared.domain.ListMother;

import java.util.List;

public final class CategoriesResponseMother {
	public static CategoriesResponse create(List<CategoryResponse> categories) {
		return new CategoriesResponse(categories);
	}

	public static CategoriesResponse random() {
		return create(ListMother.random(CategoryResponseMother::random));
	}

	public static CategoriesResponse times(int times) {
		return create(ListMother.create(times, CategoryResponseMother::random));
	}

	public static CategoriesResponse empty() {
		return create(List.of());
	}
}
