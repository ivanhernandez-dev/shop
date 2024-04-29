package dev.ivanhernandez.inventory.stocks.application.find_by_shelf_id;

import dev.ivanhernandez.shared.domain.bus.query.Query;

public final class FindByShelfIdStocksQuery implements Query {
	private final String shelfId;

	public FindByShelfIdStocksQuery(String shelfId) {
		this.shelfId = shelfId;
	}

	public String shelfId() {
		return shelfId;
	}
}
