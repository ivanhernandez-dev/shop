package tv.codely.inventory.stocks.domain;

import tv.codely.shared.domain.IntValueObject;

public final class StockQuantity extends IntValueObject {
	public StockQuantity(Integer value) {
		super(value);
	}

	private StockQuantity() {
		super(0);
	}
}
