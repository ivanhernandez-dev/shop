package tv.codely.inventory.warehouse.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.inventory.warehouse.WarehousesModuleInfrastructureTestCase;
import tv.codely.inventory.warehouse.domain.Warehouse;
import tv.codely.inventory.warehouse.domain.WarehouseIdMother;
import tv.codely.inventory.warehouse.domain.WarehouseMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryWarehouseRepositoryShould extends WarehousesModuleInfrastructureTestCase {
	@Test
	void save_a_warehouse() {
		Warehouse warehouse = WarehouseMother.random();

		assertEquals(Optional.empty(), this.inMemoryRepository.search(warehouse.id()));

		this.inMemoryRepository.save(warehouse);

		assertEquals(Optional.of(warehouse), this.inMemoryRepository.search(warehouse.id()));
	}

	@Test
	void return_an_existing_warehouse() {
		Warehouse warehouse = WarehouseMother.random();

		this.inMemoryRepository.save(warehouse);

		assertEquals(Optional.of(warehouse), this.inMemoryRepository.search(warehouse.id()));
	}

	@Test
	void not_return_a_non_existing_warehouse() {
		WarehouseId id = WarehouseIdMother.random();

		assertFalse(this.inMemoryRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_warehouse() {
		Warehouse warehouse = WarehouseMother.random();

		this.inMemoryRepository.save(warehouse);
		this.inMemoryRepository.delete(warehouse.id());

		assertFalse(this.inMemoryRepository.search(warehouse.id()).isPresent());
	}

	@Test
	void update_a_warehouse() {
		Warehouse warehouse = WarehouseMother.random();
		this.inMemoryRepository.save(warehouse);

		Warehouse updatedWarehouse = WarehouseMother.create(warehouse.id(), warehouse.name(), warehouse.address());
		this.inMemoryRepository.update(updatedWarehouse);

		assertEquals(Optional.of(updatedWarehouse), this.inMemoryRepository.search(warehouse.id()));
	}
}
