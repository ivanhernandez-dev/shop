package dev.ivanhernandez.inventory.warehouse.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class WarehouseAddress extends StringValueObject {
	public WarehouseAddress(String value) {
		super(value);
	}

	private WarehouseAddress() {
		super("");
	}
}
