package dev.ivanhernandez.inventory.category.application;

import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.shared.domain.bus.query.Response;

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
}
