package dev.ivanhernandez.inventory.category.application.find;

import dev.ivanhernandez.shared.domain.bus.query.Query;

public final class FindCategoryQuery implements Query {
	private final String id;

	public FindCategoryQuery(String id) {
		this.id = id;
	}

	public String id() {
		return id;
	}
}
