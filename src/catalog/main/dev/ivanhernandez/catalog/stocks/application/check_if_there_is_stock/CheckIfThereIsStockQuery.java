package dev.ivanhernandez.catalog.stocks.application.check_if_there_is_stock;

import dev.ivanhernandez.shared.domain.bus.query.Query;

import java.util.Objects;

public final class CheckIfThereIsStockQuery implements Query {
	private final String productId;

	public CheckIfThereIsStockQuery(String productId) {
		this.productId = productId;
	}

	public String productId() {
		return productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		CheckIfThereIsStockQuery stock = (CheckIfThereIsStockQuery) o;
		return this.productId.equals(stock.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.productId);
	}
}
