package dev.ivanhernandez.inventory.category.application.find_all;

import dev.ivanhernandez.inventory.category.CategoriesModuleUnitTestCase;
import dev.ivanhernandez.inventory.category.application.CategoriesResponse;
import dev.ivanhernandez.inventory.category.application.CategoriesResponseMother;
import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class FindAllCategoriesQueryHandlerShould extends CategoriesModuleUnitTestCase {
	FindAllCategoriesQueryHandler handler;

	protected void setUp() {
		super.setUp();

		handler = new FindAllCategoriesQueryHandler(new AllCategoriesFinder(repository));
	}

	void find_all_categories() {
		FindAllCategoriesQuery query = FindAllCategoriesQueryMother.random();

		Category category1 = CategoryMother.random();
		Category category2 = CategoryMother.random();
		Category category3 = CategoryMother.random();

		List<Category> categories = Arrays.asList(category1, category2, category3);

		List<CategoryResponse> categoryResponses = Arrays.asList(
			CategoryResponse.fromAggregate(category1),
			CategoryResponse.fromAggregate(category2),
			CategoryResponse.fromAggregate(category3)
		);

		CategoriesResponse response = CategoriesResponseMother.create(categoryResponses);

		Mockito.when(repository.searchAll()).thenReturn(categories);

		assertEquals(response, handler.handle(query));
	}

	void call_repository_search_all_method() {
		FindAllCategoriesQuery query = FindAllCategoriesQueryMother.random();

		handler.handle(query);

		Mockito.verify(repository, Mockito.atLeastOnce()).searchAll();
	}
}
