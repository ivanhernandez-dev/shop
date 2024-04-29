package dev.ivanhernandez.inventory.warehouse.application.find;

import dev.ivanhernandez.shared.domain.bus.query.Query;

public final class FindWarehouseQuery implements Query {
	private final String id;

	public FindWarehouseQuery(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
