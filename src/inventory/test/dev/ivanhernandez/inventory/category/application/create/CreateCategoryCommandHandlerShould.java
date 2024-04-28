package dev.ivanhernandez.inventory.category.application.create;

import dev.ivanhernandez.inventory.category.CategoriesModuleUnitTestCase;
import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.application.find.CategoryFinder;
import dev.ivanhernandez.inventory.category.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class CreateCategoryCommandHandlerShould extends CategoriesModuleUnitTestCase {
	CreateCategoryCommandHandler handler;
	CategoryFinder finder;

	void call_repository_save_method() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.verify(repository, Mockito.atLeastOnce()).save(category);
	}

	void call_event_bus_publish_method() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.verify(eventBus, Mockito.atLeastOnce()).publish(category.pullDomainEvents());
	}

	void call_category_finder() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.verify(finder, Mockito.atLeastOnce()).find(category.id());
	}

	void throw_exception_when_category_already_exists() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.when(finder.find(category.id())).thenReturn(new CategoryResponse(category.id().value(), category.name().value()));

		assertThrows(CategoryAlreadyExist.class, () -> handler.handle(command));
	}

	void not_throw_exception_when_category_does_not_exist() {
		CreateCategoryCommand command = CreateCategoryCommandMother.random();
		Category category = CategoryMother.create(CategoryIdMother.create(command.id()), CategoryNameMother.create(command.name()));

		Mockito.when(finder.find(category.id())).thenThrow(new CategoryNotExist(category.id()));

		assertDoesNotThrow(() -> handler.handle(command));
	}
}
