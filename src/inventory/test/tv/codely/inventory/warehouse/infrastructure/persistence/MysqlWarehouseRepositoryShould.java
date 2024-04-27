package tv.codely.inventory.warehouse.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.inventory.warehouse.WarehousesModuleInfrastructureTestCase;
import tv.codely.inventory.warehouse.domain.Warehouse;
import tv.codely.inventory.warehouse.domain.WarehouseIdMother;
import tv.codely.inventory.warehouse.domain.WarehouseMother;

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
