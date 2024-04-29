package dev.ivanhernandez.inventory.warehouse.application;

import dev.ivanhernandez.inventory.warehouse.domain.Warehouse;
import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.Objects;

public final class WarehouseResponse implements Response {
	private final String id;
	private final String name;
	private final String address;

	public WarehouseResponse(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String address() {
		return address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		WarehouseResponse that = (WarehouseResponse) o;
		return this.id.equals(that.id) && this.name.equals(that.name) && this.address.equals(that.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.address);
	}

	public static WarehouseResponse fromAggregate(Warehouse warehouse) {
		return new WarehouseResponse(warehouse.id().value(), warehouse.name().value(), warehouse.address().value());
	}
}
