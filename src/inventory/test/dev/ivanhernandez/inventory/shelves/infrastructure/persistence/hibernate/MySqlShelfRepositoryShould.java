package dev.ivanhernandez.inventory.shelves.infrastructure.persistence.hibernate;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.ShelvesModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.shelves.domain.*;
import dev.ivanhernandez.inventory.warehouse.domain.Warehouse;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseMother;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlShelfRepositoryShould extends ShelvesModuleInfrastructureTestCase {

	private Shelf createAndSaveRandomShelf() {
		Warehouse warehouse = WarehouseMother.random();
		this.warehouseRepository.save(warehouse);

		Shelf shelf = ShelfMother.create(ShelfIdMother.random(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random(), warehouse.id());
		this.mySqlRepository.save(shelf);

		return shelf;
	}

	@Test
	void save_a_shelf() {
		Warehouse warehouse = WarehouseMother.random();
		this.warehouseRepository.save(warehouse);

		Shelf shelf = ShelfMother.create(ShelfIdMother.random(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random(), warehouse.id());

		assertEquals(Optional.empty(), this.mySqlRepository.search(shelf.id()));

		this.mySqlRepository.save(shelf);

		assertEquals(Optional.of(shelf), this.mySqlRepository.search(shelf.id()));
	}

	@Test
	void return_an_existing_shelf() {
		Shelf shelf = this.createAndSaveRandomShelf();

		assertEquals(Optional.of(shelf), this.mySqlRepository.search(shelf.id()));
	}

	@Test
	void not_return_a_non_existing_shelf() {
		ShelfId id = ShelfIdMother.random();

		assertFalse(this.mySqlRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_shelf() {
		Shelf shelf = this.createAndSaveRandomShelf();

		this.mySqlRepository.delete(shelf.id());

		assertFalse(this.mySqlRepository.search(shelf.id()).isPresent());
	}

	@Test
	void update_a_shelf() {
		Shelf shelf = this.createAndSaveRandomShelf();

		Warehouse warehouse = WarehouseMother.random();
		this.warehouseRepository.save(warehouse);

		Shelf updatedShelf = ShelfMother.create(shelf.id(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random(), warehouse.id());
		this.mySqlRepository.update(updatedShelf);

		assertEquals(Optional.of(updatedShelf), this.mySqlRepository.search(shelf.id()));
	}
}
