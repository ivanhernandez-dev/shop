package tv.codely.inventory.warehouse.domain;

import tv.codely.shared.domain.WordMother;

public final class WarehouseAddressMother {
	public static WarehouseAddress create(String value) {
		return new WarehouseAddress(value);
	}

	public static WarehouseAddress random() {
		return create(WordMother.random());
	}
}
