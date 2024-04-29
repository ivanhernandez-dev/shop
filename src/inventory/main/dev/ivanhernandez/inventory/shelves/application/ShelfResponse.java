package dev.ivanhernandez.inventory.shelves.application;

import dev.ivanhernandez.inventory.shelves.domain.Shelf;
import dev.ivanhernandez.shared.domain.bus.query.Response;

public final class ShelfResponse implements Response {
	private final String id;
	private final Double length;
	private final Double width;
	private final Double maxWeight;
	private final String warehouseId;

	public ShelfResponse(String id, Double length, Double width, Double maxWeight, String warehouseId) {
		this.id = id;
		this.length = length;
		this.width = width;
		this.maxWeight = maxWeight;
		this.warehouseId = warehouseId;
	}

	public String id() {
		return id;
	}

	public Double length() {
		return length;
	}

	public Double width() {
		return width;
	}

	public Double maxWeight() {
		return maxWeight;
	}

	public String warehouseId() {
		return warehouseId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ShelfResponse shelf = (ShelfResponse) o;
		return this.id.equals(shelf.id) && this.length.equals(shelf.length) && this.width.equals(shelf.width) && this.maxWeight.equals(shelf.maxWeight) && this.warehouseId.equals(shelf.warehouseId);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public static ShelfResponse fromAggregate(Shelf shelf) {
		return new ShelfResponse(shelf.id().value(), shelf.length().value(), shelf.width().value(), shelf.maxWeight().value(), shelf.warehouseId().value());
	}
}
