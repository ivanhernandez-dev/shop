package dev.ivanhernandez.catalog.category.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Objects;

public final class CategoriesResponse implements Response {
	private final List<CategoryResponse> categories;

	public CategoriesResponse(List<CategoryResponse> categories) {
		this.categories = categories;
	}

	public List<CategoryResponse> categories() {
		return categories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		CategoriesResponse that = (CategoriesResponse) o;
		return Objects.equals(this.categories, that.categories);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.categories);
	}
}
