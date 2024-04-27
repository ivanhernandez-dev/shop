package dev.ivanhernandez.inventory.category.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import dev.ivanhernandez.inventory.category.CategoriesModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.category.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryCategoryRepositoryShould extends CategoriesModuleInfrastructureTestCase {
	@Test
	void save_a_category() {
		Category category = CategoryMother.random();

		assertEquals(Optional.empty(), this.inMemoryRepository.search(category.id()));

		this.inMemoryRepository.save(category);

		assertEquals(Optional.of(category), this.inMemoryRepository.search(category.id()));
	}

	@Test
	void return_an_existing_category() {
		Category category = CategoryMother.random();

		this.inMemoryRepository.save(category);

		assertEquals(Optional.of(category), this.inMemoryRepository.search(category.id()));
	}

	@Test
	void not_return_a_non_existing_category() {
		CategoryId id = CategoryIdMother.random();

		assertFalse(this.inMemoryRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_category() {
		Category category = CategoryMother.random();

		this.inMemoryRepository.save(category);
		this.inMemoryRepository.delete(category.id());

		assertFalse(this.inMemoryRepository.search(category.id()).isPresent());
	}

	@Test
	void update_a_category() {
		Category category = CategoryMother.random();
		this.inMemoryRepository.save(category);

		Category updatedCategory = new Category(category.id(), CategoryNameMother.random());
		this.inMemoryRepository.update(updatedCategory);

		assertEquals(Optional.of(updatedCategory), this.inMemoryRepository.search(category.id()));
	}
}
