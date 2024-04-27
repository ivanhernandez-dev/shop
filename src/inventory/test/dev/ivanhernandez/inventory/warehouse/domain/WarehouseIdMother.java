package dev.ivanhernandez.inventory.warehouse.domain;

import dev.ivanhernandez.inventory.shared.domain.WarehouseId;
import dev.ivanhernandez.shared.domain.UuidMother;

public final class WarehouseIdMother {
	public static WarehouseId create(String value) {
		return new WarehouseId(value);
	}

	public static WarehouseId random() {
		return create(UuidMother.random());
	}
}
