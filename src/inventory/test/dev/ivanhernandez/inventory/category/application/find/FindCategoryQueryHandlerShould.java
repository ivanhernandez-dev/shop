package dev.ivanhernandez.inventory.category.application.find;

import dev.ivanhernandez.inventory.category.CategoriesModuleUnitTestCase;
import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.application.CategoryResponseMother;
import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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

	@Test
	void find_an_existing_category() {
		Category category = CategoryMother.random();
		FindCategoryQuery query = new FindCategoryQuery(category.id().value());
		CategoryResponse response = CategoryResponseMother.create(category.id().value(), category.name().value());

		Mockito.when(repository.search(category.id())).thenReturn(Optional.of(category));

		assertEquals(response, handler.handle(query));
	}

	@Test
	void throw_an_exception_when_category_does_not_exists() {
		FindCategoryQuery query = new FindCategoryQuery(CategoryIdMother.random().value());

		Mockito.when(repository.search(Mockito.any())).thenReturn(Optional.empty());

		assertThrows(CategoryNotExist.class, () -> handler.handle(query));
	}

	@Test
	void call_repository_search_method() {
		Category category = CategoryMother.random();
		FindCategoryQuery query = new FindCategoryQuery(category.id().value());

		Mockito.when(repository.search(category.id())).thenReturn(Optional.of(category));

		handler.handle(query);

		Mockito.verify(repository, Mockito.atLeastOnce()).search(category.id());
	}
}
