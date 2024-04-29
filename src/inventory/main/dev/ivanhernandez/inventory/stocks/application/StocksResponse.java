package dev.ivanhernandez.inventory.stocks.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Objects;

public final class StocksResponse implements Response {
	private final List<StockResponse> stocks;

	public StocksResponse(List<StockResponse> stocks) {
		this.stocks = stocks;
	}

	public List<StockResponse> stocks() {
		return stocks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		StocksResponse stocks = (StocksResponse) o;
		return this.stocks.equals(stocks.stocks);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.stocks);
	}
}
