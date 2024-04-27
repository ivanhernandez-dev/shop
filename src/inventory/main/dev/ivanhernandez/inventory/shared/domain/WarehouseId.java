package dev.ivanhernandez.inventory.shared.domain;

import dev.ivanhernandez.shared.domain.IdentifierValueObject;

public final class WarehouseId extends IdentifierValueObject {
	public WarehouseId(String value) {
		super(value);
	}

	private WarehouseId() {
	}
}
