package tv.codely.inventory.warehouse.domain;

import tv.codely.shared.domain.StringValueObject;

public final class WarehouseName extends StringValueObject {
	public WarehouseName(String value) {
		super(value);
	}

	private WarehouseName() {
		super("");
	}
}
