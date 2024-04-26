package tv.codely.inventory.category.infrastructure.persistence;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import tv.codely.inventory.category.CategoriesModuleInfrastructureTestCase;
import tv.codely.inventory.category.domain.*;
import tv.codely.inventory.shared.domain.CategoryId;
import tv.codely.inventory.shared.domain.CategoryIdMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
