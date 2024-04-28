package dev.ivanhernandez.inventory.category.infrastructure.persistence;

import dev.ivanhernandez.inventory.category.CategoriesModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNameMother;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class MysqlCategoryRepositoryShould extends CategoriesModuleInfrastructureTestCase {
	@Test
	void save_a_category() {
		Category category = CategoryMother.random();

		assertEquals(Optional.empty(), this.mySqlRepository.search(category.id()));

		this.mySqlRepository.save(category);

		assertEquals(Optional.of(category), this.mySqlRepository.search(category.id()));
	}

	@Test
	void return_an_existing_category() {
		Category category = CategoryMother.random();

		this.mySqlRepository.save(category);

		assertEquals(Optional.of(category), this.mySqlRepository.search(category.id()));
	}

	@Test
	void not_return_a_non_existing_category() {
		CategoryId id = CategoryIdMother.random();

		assertFalse(this.mySqlRepository.search(id).isPresent());
	}

	@Test
	void delete_an_existing_category() {
		Category category = CategoryMother.random();

		this.mySqlRepository.save(category);
		this.mySqlRepository.delete(category.id());

		assertFalse(this.mySqlRepository.search(category.id()).isPresent());
	}

	@Test
	void update_a_category() {
		Category category = CategoryMother.random();
		this.mySqlRepository.save(category);

		Category updatedCategory = new Category(category.id(), CategoryNameMother.random());
		this.mySqlRepository.update(updatedCategory);

		assertEquals(Optional.of(updatedCategory), this.mySqlRepository.search(category.id()));
	}

	@Test
	void return_all_categories() {
		Category category1 = CategoryMother.random();
		Category category2 = CategoryMother.random();
		Category category3 = CategoryMother.random();

		this.mySqlRepository.save(category1);
		this.mySqlRepository.save(category2);
		this.mySqlRepository.save(category3);

		List<Category> categories = List.of(category1, category2, category3);
		List<Category> foundCategories = this.mySqlRepository.searchAll();

		assertTrue(foundCategories.containsAll(categories));
	}
}
