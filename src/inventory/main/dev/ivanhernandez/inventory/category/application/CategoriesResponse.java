package dev.ivanhernandez.inventory.category.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;

public final class CategoriesResponse implements Response {
	private final List<CategoryResponse> categories;

	public CategoriesResponse(List<CategoryResponse> categories) {
		this.categories = categories;
	}

	public List<CategoryResponse> categories() {
		return categories;
	}
}
