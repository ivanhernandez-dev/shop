package dev.ivanhernandez.catalog.stocks.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

public final class IsThereStockResponse implements Response {
	private final boolean isThereStock;

	public IsThereStockResponse(boolean isThereStock) {
		this.isThereStock = isThereStock;
	}

	public boolean isThereStock() {
		return isThereStock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		IsThereStockResponse stock = (IsThereStockResponse) o;
		return this.isThereStock == stock.isThereStock;
	}

	@Override
	public int hashCode() {
		return Boolean.hashCode(isThereStock);
	}

	public static IsThereStockResponse fromBoolean(boolean isThereStock) {
		return new IsThereStockResponse(isThereStock);
	}
}
