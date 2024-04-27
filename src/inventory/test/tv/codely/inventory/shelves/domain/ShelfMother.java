package tv.codely.inventory.shelves.domain;

import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.inventory.warehouse.domain.WarehouseIdMother;

public final class ShelfMother {
	public static Shelf create(ShelfId id, ShelfLength length, ShelfWidth width, ShelfMaxWeight maxWeight, WarehouseId warehouseId) {
		return new Shelf(id, length, width, maxWeight, warehouseId);
	}

	public static Shelf random() {
		return create(ShelfIdMother.random(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random(), WarehouseIdMother.random());
	}
}
