package dev.ivanhernandez.inventory.stocks.application.find;

import dev.ivanhernandez.shared.domain.bus.query.Query;

import java.util.Objects;

public final class FindStockQuery implements Query {
	private final String shelfId;
	private final String productId;

	public FindStockQuery(String shelfId, String productId) {
		this.shelfId = shelfId;
		this.productId = productId;
	}

	public String shelfId() {
		return shelfId;
	}

	public String productId() {
		return productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		FindStockQuery stock = (FindStockQuery) o;
		return this.shelfId.equals(stock.shelfId) && this.productId.equals(stock.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.shelfId, this.productId);
	}
}
