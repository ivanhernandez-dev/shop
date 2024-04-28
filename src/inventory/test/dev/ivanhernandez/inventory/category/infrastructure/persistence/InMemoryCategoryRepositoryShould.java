package dev.ivanhernandez.inventory.category.infrastructure.persistence;

import dev.ivanhernandez.inventory.category.CategoriesModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNameMother;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void return_all_categories() {
		Category category1 = CategoryMother.random();
		Category category2 = CategoryMother.random();
		Category category3 = CategoryMother.random();

		this.inMemoryRepository.save(category1);
		this.inMemoryRepository.save(category2);
		this.inMemoryRepository.save(category3);

		List<Category> categories = List.of(category1, category2, category3);
		List<Category> foundCategories = this.inMemoryRepository.searchAll();

		assertTrue(foundCategories.containsAll(categories));
	}
}
