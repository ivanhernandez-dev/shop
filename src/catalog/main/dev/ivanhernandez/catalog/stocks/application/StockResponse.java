package dev.ivanhernandez.catalog.stocks.application;

import dev.ivanhernandez.catalog.stocks.domain.Stock;
import dev.ivanhernandez.shared.domain.bus.query.Response;

public final class StockResponse implements Response {
	private final String shelfId;
	private final Integer quantity;
	private final String productId;

	public StockResponse(String shelfId, Integer quantity, String productId) {
		this.shelfId = shelfId;
		this.quantity = quantity;
		this.productId = productId;
	}

	public String shelfId() {
		return shelfId;
	}

	public Integer quantity() {
		return quantity;
	}

	public String productId() {
		return productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		StockResponse stock = (StockResponse) o;
		return this.shelfId.equals(stock.shelfId) && this.quantity.equals(stock.quantity) && this.productId.equals(stock.productId);
	}

	@Override
	public int hashCode() {
		return shelfId.hashCode();
	}

	public static StockResponse fromAggregate(Stock stock) {
		return new StockResponse(stock.shelfId().value(), stock.quantity().value(), stock.productId().value());
	}
}
