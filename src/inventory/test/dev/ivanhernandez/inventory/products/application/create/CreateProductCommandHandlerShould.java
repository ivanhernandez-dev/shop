package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.application.CategoryResponseMother;
import dev.ivanhernandez.inventory.category.application.find.CategoryFinder;
import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNameMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.product.ProductCreatedDomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


final class CreateProductCommandHandlerShould extends ProductsModuleUnitTestCase {
	private CreateProductCommandHandler handler;
	private ProductFinder finder;
	private CategoryFinder categoryFinder;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		finder = Mockito.mock(ProductFinder.class);
		categoryFinder = Mockito.mock(CategoryFinder.class);
		handler = new CreateProductCommandHandler(new ProductCreator(repository, eventBus, finder, categoryFinder));
	}

	@Test
	void call_repository_save_method() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Category category = CategoryMother.create(
			CategoryIdMother.create(command.categoryId()),
			CategoryNameMother.random()
		);

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		Mockito.when(finder.find(product.id())).thenThrow(new ProductNotExist(product.id()));
		Mockito.when(categoryFinder.find(product.categoryId())).thenReturn(CategoryResponse.fromAggregate(category));

		handler.handle(command);

		Mockito.verify(repository, Mockito.atLeastOnce()).save(product);
	}

	@Test
	void call_event_bus_publish_method() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Category category = CategoryMother.create(
			CategoryIdMother.create(command.categoryId()),
			CategoryNameMother.random()
		);

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		ProductCreatedDomainEvent domainEvent = ProductCreatedDomainEventMother.fromProduct(product);

		Mockito.when(finder.find(product.id())).thenThrow(new ProductNotExist(product.id()));
		Mockito.when(categoryFinder.find(product.categoryId())).thenReturn(CategoryResponse.fromAggregate(category));

		handler.handle(command);

		Mockito.verify(eventBus, Mockito.atLeastOnce()).publish(List.of(domainEvent));
	}

	@Test
	void call_product_finder() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Category category = CategoryMother.create(
			CategoryIdMother.create(command.categoryId()),
			CategoryNameMother.random()
		);

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		Mockito.when(finder.find(product.id())).thenThrow(new ProductNotExist(product.id()));
		Mockito.when(categoryFinder.find(product.categoryId())).thenReturn(CategoryResponse.fromAggregate(category));

		handler.handle(command);

		Mockito.verify(finder, Mockito.atLeastOnce()).find(product.id());
	}

	@Test
	void throw_exception_when_product_already_exists() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Category category = CategoryMother.create(
			CategoryIdMother.create(command.categoryId()),
			CategoryNameMother.random()
		);

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		Mockito.when(finder.find(product.id())).thenReturn(ProductResponse.fromAggregate(product));
		Mockito.when(categoryFinder.find(product.categoryId())).thenReturn(CategoryResponse.fromAggregate(category));

		assertThrows(ProductAlreadyExist.class, () -> handler.handle(command));
	}

	@Test
	void throw_exception_when_category_not_exists() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		Mockito.when(finder.find(product.id())).thenThrow(new ProductNotExist(product.id()));
		Mockito.when(categoryFinder.find(product.categoryId())).thenThrow(new CategoryNotExist(product.categoryId()));

		assertThrows(CategoryNotExist.class, () -> handler.handle(command));
	}

	@Test
	void call_category_finder() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Category category = CategoryMother.create(
			CategoryIdMother.create(command.categoryId()),
			CategoryNameMother.random()
		);

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		Mockito.when(finder.find(product.id())).thenThrow(new ProductNotExist(product.id()));
		Mockito.when(categoryFinder.find(product.categoryId())).thenReturn(CategoryResponse.fromAggregate(category));

		handler.handle(command);

		Mockito.verify(categoryFinder, Mockito.atLeastOnce()).find(product.categoryId());
	}

	@Test
	void not_throw_exception_when_product_does_not_exist() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Category category = CategoryMother.create(
			CategoryIdMother.create(command.categoryId()),
			CategoryNameMother.random()
		);

		Product product = ProductMother.create(
			ProductIdMother.create(command.id()),
			ProductNameMother.create(command.name()),
			ProductPriceMother.create(command.price()),
			ProductDescriptionMother.create(command.description()),
			ProductWeightMother.create(command.weight()),
			ProductColorMother.create(command.color()),
			ProductMaterialMother.create(command.material()),
			CategoryIdMother.create(command.categoryId())
		);

		Mockito.when(finder.find(product.id())).thenThrow(new ProductNotExist(product.id()));
		Mockito.when(categoryFinder.find(product.categoryId())).thenReturn(CategoryResponse.fromAggregate(category));

		assertDoesNotThrow(() -> handler.handle(command));
	}
}
