package tv.codely.inventory.shelves.domain;

import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Shelf extends AggregateRoot {
	private final ShelfId id;
	private final ShelfLength length;
	private final ShelfWidth width;
	private final ShelfMaxWeight maxWeight;
	private final WarehouseId warehouseId;

	public Shelf(ShelfId id, ShelfLength length, ShelfWidth width, ShelfMaxWeight maxWeight, WarehouseId warehouseId) {
		this.id = id;
		this.length = length;
		this.width = width;
		this.maxWeight = maxWeight;
		this.warehouseId = warehouseId;
	}

	private Shelf() {
		id = null;
		length = null;
		width = null;
		maxWeight = null;
		warehouseId = null;
	}

	public ShelfId id() {
		return id;
	}

	public ShelfLength length() {
		return length;
	}

	public ShelfWidth width() {
		return width;
	}

	public ShelfMaxWeight maxWeight() {
		return maxWeight;
	}

	public WarehouseId warehouseId() {
		return warehouseId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Shelf shelf = (Shelf) o;
		return Objects.equals(this.id, shelf.id) && Objects.equals(this.length, shelf.length) && Objects.equals(this.width, shelf.width) && Objects.equals(this.maxWeight, shelf.maxWeight) && Objects.equals(this.warehouseId, shelf.warehouseId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.length, this.width, this.maxWeight, this.warehouseId);
	}
}
