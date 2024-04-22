package tv.codely.inventory.stocks.domain;

import tv.codely.shared.domain.IntegerMother;

public final class StockAmountMother {
	public static StockAmount create(Integer value) {
		return new StockAmount(value);
	}

	public static StockAmount random() {
		return create(IntegerMother.random());
	}
}
