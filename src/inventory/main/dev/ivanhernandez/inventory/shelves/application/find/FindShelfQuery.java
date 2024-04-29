package dev.ivanhernandez.inventory.shelves.application.find;

import dev.ivanhernandez.shared.domain.bus.query.Query;

public final class FindShelfQuery implements Query {
	private final String id;

	public FindShelfQuery(String id) {
		this.id = id;
	}

	public String id() {
		return id;
	}
}
