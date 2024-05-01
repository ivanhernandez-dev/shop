package dev.ivanhernandez.inventory.category.application.create;

import dev.ivanhernandez.inventory.category.CategoriesModuleUnitTestCase;
import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.application.find.CategoryFinder;
import dev.ivanhernandez.inventory.category.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import dev.ivanhernandez.shared.domain.category.CategoryCreatedDomainEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class CreateCategoryCommandHandlerShould extends CategoriesModuleUnitTestCase {
	CreateCategoryCommandHandler handler;
	CategoryFinder finder;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		finder = Mockito.mock(CategoryFinder.class);
		handler = new CreateCategoryCommandHandler(new CategoryCreator(repository, eventBus, finder));
	}

	@Test
	void call_repository_save_method() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.when(finder.find(category.id())).thenThrow(new CategoryNotExist(category.id()));

		handler.handle(command);

		Mockito.verify(repository, Mockito.atLeastOnce()).save(category);
	}

	@Test
	void call_event_bus_publish_method() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));
		CategoryCreatedDomainEvent domainEvent = CategoryCreatedDomainEventMother.fromCategory(category);

		Mockito.when(finder.find(category.id())).thenThrow(new CategoryNotExist(category.id()));

		handler.handle(command);

		Mockito.verify(eventBus, Mockito.atLeastOnce()).publish(List.of(domainEvent));
	}

	@Test
	void call_category_finder() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.when(finder.find(category.id())).thenThrow(new CategoryNotExist(category.id()));

		handler.handle(command);

		Mockito.verify(finder, Mockito.atLeastOnce()).find(category.id());
	}

	@Test
	void throw_exception_when_category_already_exists() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.when(finder.find(category.id())).thenReturn(new CategoryResponse(category.id().value(), category.name().value()));

		assertThrows(CategoryAlreadyExist.class, () -> handler.handle(command));
	}

	@Test
	void not_throw_exception_when_category_does_not_exist() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.when(finder.find(category.id())).thenThrow(new CategoryNotExist(category.id()));

		assertDoesNotThrow(() -> handler.handle(command));
	}
}
