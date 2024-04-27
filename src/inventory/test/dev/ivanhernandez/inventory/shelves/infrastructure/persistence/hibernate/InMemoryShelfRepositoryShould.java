package dev.ivanhernandez.inventory.shelves.infrastructure.persistence.hibernate;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.ShelvesModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.shelves.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class InMemoryShelfRepositoryShould extends ShelvesModuleInfrastructureTestCase {
	@Test
	void save_a_shelf() {
		Shelf shelf = ShelfMother.random();

		assertEquals(Optional.empty(), this.inMemoryRepository.search(shelf.id()));

		this.inMemoryRepository.save(shelf);

		assertEquals(Optional.of(shelf), this.inMemoryRepository.search(shelf.id()));
	}

	@Test
	void return_an_existing_shelf() {
		Shelf shelf = ShelfMother.random();

		this.inMemoryRepository.save(shelf);

		assertEquals(Optional.of(shelf), this.inMemoryRepository.search(shelf.id()));
	}

	@Test
	void not_return_a_non_existing_shelf() {
		ShelfId id = ShelfIdMother.random();

		assertFalse(this.inMemoryRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_shelf() {
		Shelf shelf = ShelfMother.random();

		this.inMemoryRepository.save(shelf);
		this.inMemoryRepository.delete(shelf.id());

		assertFalse(this.inMemoryRepository.search(shelf.id()).isPresent());
	}

	@Test
	void update_a_shelf() {
		Shelf shelf = ShelfMother.random();
		this.inMemoryRepository.save(shelf);

		Shelf updatedShelf = ShelfMother.create(shelf.id(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random(), shelf.warehouseId());
		this.inMemoryRepository.update(updatedShelf);

		assertEquals(Optional.of(updatedShelf), this.inMemoryRepository.search(shelf.id()));
	}
}
