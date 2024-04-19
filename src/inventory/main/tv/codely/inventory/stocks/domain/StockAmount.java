package tv.codely.inventory.stocks.domain;

import tv.codely.shared.domain.IntValueObject;

public class StockAmount extends IntValueObject {
	public StockAmount(Integer value) {
		super(value);
	}

	public StockAmount() {
		super(null);
	}
}
