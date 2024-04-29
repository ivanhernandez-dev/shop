package dev.ivanhernandez.inventory.stocks.application.find_by_product_id;

import dev.ivanhernandez.shared.domain.bus.query.Query;

public final class FindByProductIdStocksQuery implements Query {
	private final String productId;

	public FindByProductIdStocksQuery(String productId) {
		this.productId = productId;
	}

	public String productId() {
		return productId;
	}
}
