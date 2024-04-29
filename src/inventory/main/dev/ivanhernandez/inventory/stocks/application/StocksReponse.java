package dev.ivanhernandez.inventory.stocks.application;

import java.util.List;
import java.util.Objects;

public final class StocksReponse {
	private final List<StockResponse> stocks;

	public StocksReponse(List<StockResponse> stocks) {
		this.stocks = stocks;
	}

	public List<StockResponse> stocks() {
		return stocks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		StocksReponse stocks = (StocksReponse) o;
		return this.stocks.equals(stocks.stocks);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.stocks);
	}
}
