package tv.codely.inventory.warehouse.domain;

import tv.codely.inventory.shared.domain.WarehouseId;

public final class WarehouseMother {
	public static Warehouse create(WarehouseId id, WarehouseName name, WarehouseAddress address) {
		return new Warehouse(id, name, address);
	}

	public static Warehouse random() {
		return create(WarehouseIdMother.random(), WarehouseNameMother.random(), WarehouseAddressMother.random());
	}
}
