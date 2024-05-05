package dev.ivanhernandez.catalog.stocks.domain;

import dev.ivanhernandez.shared.domain.IntValueObject;

public final class StockQuantity extends IntValueObject {
	public StockQuantity(Integer value) {
		super(value);
	}

	private StockQuantity() {
		super(0);
	}
}
