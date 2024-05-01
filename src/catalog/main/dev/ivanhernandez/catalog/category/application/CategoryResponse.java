package dev.ivanhernandez.catalog.category.application;

import dev.ivanhernandez.catalog.category.domain.Category;
import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.Objects;

public final class CategoryResponse implements Response {
	private final String id;
	private final String name;

	public CategoryResponse(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static CategoryResponse fromAggregate(Category category) {
		return new CategoryResponse(category.id().value(), category.name().value());
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		CategoryResponse that = (CategoryResponse) o;
		return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}
}
