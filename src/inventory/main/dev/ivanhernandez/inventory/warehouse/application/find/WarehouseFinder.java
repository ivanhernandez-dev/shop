package dev.ivanhernandez.inventory.warehouse.application.find;

import dev.ivanhernandez.inventory.shared.domain.WarehouseId;
import dev.ivanhernandez.inventory.warehouse.application.WarehouseResponse;
import dev.ivanhernandez.inventory.warehouse.domain.Warehouse;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseNotExist;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class WarehouseFinder {
	private final WarehouseRepository repository;

	public WarehouseFinder(WarehouseRepository repository) {
		this.repository = repository;
	}

	public WarehouseResponse find(WarehouseId id) {
		return repository.search(id).map(WarehouseResponse::fromAggregate).orElseThrow(() -> new WarehouseNotExist(id));
	}
}
