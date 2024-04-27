package dev.ivanhernandez.inventory.warehouse.infrastructure.persistence;

import dev.ivanhernandez.inventory.shared.domain.WarehouseId;
import dev.ivanhernandez.inventory.warehouse.WarehousesModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.warehouse.domain.Warehouse;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseIdMother;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseMother;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class MysqlWarehouseRepositoryShould extends WarehousesModuleInfrastructureTestCase {
	@Test
	void save_a_warehouse() {
		Warehouse warehouse = WarehouseMother.random();

		assertEquals(Optional.empty(), this.mySqlRepository.search(warehouse.id()));

		this.mySqlRepository.save(warehouse);

		assertEquals(Optional.of(warehouse), this.mySqlRepository.search(warehouse.id()));
	}

	@Test
	void return_an_existing_warehouse() {
		Warehouse warehouse = WarehouseMother.random();

		this.mySqlRepository.save(warehouse);

		assertEquals(Optional.of(warehouse), this.mySqlRepository.search(warehouse.id()));
	}

	@Test
	void not_return_a_non_existing_warehouse() {
		WarehouseId id = WarehouseIdMother.random();

		assertFalse(this.mySqlRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_warehouse() {
		Warehouse warehouse = WarehouseMother.random();

		this.mySqlRepository.save(warehouse);
		this.mySqlRepository.delete(warehouse.id());

		assertFalse(this.mySqlRepository.search(warehouse.id()).isPresent());
	}

	@Test
	void update_a_warehouse() {
		Warehouse warehouse = WarehouseMother.random();
		this.mySqlRepository.save(warehouse);

		Warehouse updatedWarehouse = WarehouseMother.create(warehouse.id(), warehouse.name(), warehouse.address());
		this.mySqlRepository.update(updatedWarehouse);

		assertEquals(Optional.of(updatedWarehouse), this.mySqlRepository.search(warehouse.id()));
	}
}
