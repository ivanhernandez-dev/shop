package dev.ivanhernandez.inventory.products.application.update;

import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.application.CategoryResponseMother;
import dev.ivanhernandez.inventory.category.application.find.CategoryFinder;
import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.application.ProductResponseMother;
import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.products.domain.ProductDescriptionMother;
import dev.ivanhernandez.inventory.products.domain.ProductIdMother;
import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

final class UpdateProductCommandHandlerShould extends ProductsModuleUnitTestCase {
	private UpdateProductCommandHandler handler;
	private ProductFinder finder;
	private CategoryFinder categoryFinder;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		finder = Mockito.mock(ProductFinder.class);
		categoryFinder = Mockito.mock(CategoryFinder.class);
		handler = new UpdateProductCommandHandler(new ProductUpdater(repository, eventBus, finder, categoryFinder));
	}

	@Test
	void call_product_finder_find_method() {
		UpdateProductCommand command = UpdateProductCommandMother.random();

		ProductResponse response = ProductResponseMother.create(command.id(), command.name(), ProductDescriptionMother.random().value(), command.price(), command.weight(), command.color(), command.material(), command.categoryId());
		Mockito.when(finder.find(ProductIdMother.create(command.id()))).thenReturn(response);

		handler.handle(command);

		Mockito.verify(finder, Mockito.atLeastOnce()).find(ProductIdMother.create(command.id()));
	}

	@Test
	void call_category_finder_find_method_when_category_id_is_different() {
		UpdateProductCommand command = UpdateProductCommandMother.random();

		ProductResponse response = ProductResponseMother.create(command.id(), command.name(), ProductDescriptionMother.random().value(), command.price(), command.weight(), command.color(), command.material(), CategoryIdMother.random().value());
		Mockito.when(finder.find(ProductIdMother.create(command.id()))).thenReturn(response);

		CategoryResponse categoryResponse = CategoryResponseMother.create(command.categoryId(), "Category Name");
		Mockito.when(categoryFinder.find(CategoryIdMother.create(command.categoryId()))).thenReturn(categoryResponse);

		handler.handle(command);

		Mockito.verify(categoryFinder, Mockito.atLeastOnce()).find(CategoryIdMother.create(command.categoryId()));
	}

	@Test
	void throw_an_exception_when_product_does_not_exist() {
		UpdateProductCommand command = UpdateProductCommandMother.random();

		Mockito.when(finder.find(ProductIdMother.create(command.id()))).thenThrow(ProductNotExist.class);

		assertThrows(ProductNotExist.class, () -> handler.handle(command));
	}

	@Test
	void throw_an_exception_when_category_does_not_exist() {
		UpdateProductCommand command = UpdateProductCommandMother.random();

		ProductResponse response = ProductResponseMother.create(command.id(), command.name(), ProductDescriptionMother.random().value(), command.price(), command.weight(), command.color(), command.material(), CategoryIdMother.random().value());
		Mockito.when(finder.find(ProductIdMother.create(command.id()))).thenReturn(response);

		Mockito.when(categoryFinder.find(CategoryIdMother.create(command.categoryId()))).thenThrow(CategoryNotExist.class);

		assertThrows(CategoryNotExist.class, () -> handler.handle(command));
	}

	@Test
	void call_repository_update_method() {
		UpdateProductCommand command = UpdateProductCommandMother.random();

		ProductResponse response = ProductResponseMother.create(command.id(), command.name(), ProductDescriptionMother.random().value(), command.price(), command.weight(), command.color(), command.material(), command.categoryId());
		Mockito.when(finder.find(ProductIdMother.create(command.id()))).thenReturn(response);

		handler.handle(command);

		Mockito.verify(repository, Mockito.atLeastOnce()).update(Mockito.any());
	}
}
