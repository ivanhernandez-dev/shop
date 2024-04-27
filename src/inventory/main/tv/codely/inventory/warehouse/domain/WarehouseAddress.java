package tv.codely.inventory.warehouse.domain;

import tv.codely.shared.domain.StringValueObject;

public final class WarehouseAddress extends StringValueObject {
	public WarehouseAddress(String value) {
		super(value);
	}

	private WarehouseAddress() {
		super("");
	}
}
