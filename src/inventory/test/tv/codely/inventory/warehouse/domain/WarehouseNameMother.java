package tv.codely.inventory.warehouse.domain;

import tv.codely.shared.domain.WordMother;

public final class WarehouseNameMother {
	public static WarehouseName create(String value) {
		return new WarehouseName(value);
	}

	public static WarehouseName random() {
		return create(WordMother.random());
	}
}
