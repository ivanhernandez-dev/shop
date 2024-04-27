package dev.ivanhernandez.inventory.warehouse.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class WarehouseName extends StringValueObject {
	public WarehouseName(String value) {
		super(value);
	}

	private WarehouseName() {
		super("");
	}
}
