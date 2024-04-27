package tv.codely.inventory.warehouse.domain;

import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.shared.domain.UuidMother;

public final class WarehouseIdMother {
	public static WarehouseId create(String value) {
		return new WarehouseId(value);
	}

	public static WarehouseId random() {
		return create(UuidMother.random());
	}
}
