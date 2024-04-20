package tv.codely.inventory.shelves.infrastructure.persistence.hibernate;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.shelves.ShelvesModuleInfrastructureTestCase;
import tv.codely.inventory.shelves.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MySqlShelfRepositoryShould extends ShelvesModuleInfrastructureTestCase {
	@Test
	void save_a_shelf() {
		Shelf shelf = ShelfMother.random();

        assertEquals(Optional.empty(), this.mySqlRepository.search(shelf.id()));

        this.mySqlRepository.save(shelf);

        assertEquals(Optional.of(shelf), this.mySqlRepository.search(shelf.id()));
    }

	@Test
	void return_an_existing_shelf() {
		Shelf shelf = ShelfMother.random();

		this.mySqlRepository.save(shelf);

		assertEquals(Optional.of(shelf), this.mySqlRepository.search(shelf.id()));
	}

	@Test
	void not_return_a_non_existing_shelf() {
		ShelfId id = ShelfIdMother.random();

		assertFalse(this.mySqlRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_shelf() {
		Shelf shelf = ShelfMother.random();

		this.mySqlRepository.save(shelf);
		this.mySqlRepository.delete(shelf.id());

		assertFalse(this.mySqlRepository.search(shelf.id()).isPresent());
	}

	@Test
	void update_a_shelf() {
		Shelf shelf = ShelfMother.random();
		this.mySqlRepository.save(shelf);

		Shelf updatedShelf = new Shelf(shelf.id(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random());
		this.mySqlRepository.update(updatedShelf);

		assertEquals(Optional.of(updatedShelf), this.mySqlRepository.search(shelf.id()));
	}
}
