package tv.codely.inventory.shelves.infrastructure.persistence.hibernate;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.shelves.ShelvesModuleInfrastructureTestCase;
import tv.codely.inventory.shelves.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

		Shelf updatedShelf = new Shelf(shelf.id(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random());
		this.inMemoryRepository.update(updatedShelf);

		assertEquals(Optional.of(updatedShelf), this.inMemoryRepository.search(shelf.id()));
	}
}
