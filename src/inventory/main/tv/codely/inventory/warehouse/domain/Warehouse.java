package tv.codely.inventory.warehouse.domain;

import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Warehouse extends AggregateRoot {
	private final WarehouseId id;
	private final WarehouseName name;
	private final WarehouseAddress address;

	public Warehouse(WarehouseId id, WarehouseName name, WarehouseAddress address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	private Warehouse() {
		id = null;
		name = null;
		address = null;
	}

	public WarehouseId id() {
		return id;
	}

	public WarehouseName name() {
		return name;
	}

	public WarehouseAddress address() {
		return address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Warehouse warehouse = (Warehouse) o;
		return Objects.equals(this.id, warehouse.id) && Objects.equals(this.name, warehouse.name) && Objects.equals(this.address, warehouse.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.address);
	}
}
