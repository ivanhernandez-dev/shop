package dev.ivanhernandez.inventory.category.application.find;

import dev.ivanhernandez.inventory.category.CategoriesModuleUnitTestCase;
import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class FindCategoryQueryHandlerShould extends CategoriesModuleUnitTestCase {
	FindCategoryQueryHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		handler = new FindCategoryQueryHandler(new CategoryFinder(repository));
	}

	void it_should_find_an_existing_category() {
		Category category = CategoryMother.random();
		FindCategoryQuery query = new FindCategoryQuery(category.id().value());
		CategoryResponse response = CategoryResponse.fromAggregate(category);

		Mockito.when(repository.search(category.id())).thenReturn(Optional.of(category));

		assertEquals(response, handler.handle(query));
	}

	void it_should_throw_an_exception_when_category_does_not_exists() {
		FindCategoryQuery query = new FindCategoryQuery(CategoryIdMother.random().value());

		Mockito.when(repository.search(Mockito.any())).thenReturn(Optional.empty());

		assertThrows(CategoryNotExist.class, () -> handler.handle(query));
	}
}
