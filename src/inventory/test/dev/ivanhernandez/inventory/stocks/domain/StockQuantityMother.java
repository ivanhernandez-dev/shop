package dev.ivanhernandez.inventory.stocks.domain;

import dev.ivanhernandez.shared.domain.IntegerMother;

public final class StockQuantityMother {
	public static StockQuantity create(Integer value) {
		return new StockQuantity(value);
	}

	public static StockQuantity random() {
		return create(IntegerMother.random());
	}
}
