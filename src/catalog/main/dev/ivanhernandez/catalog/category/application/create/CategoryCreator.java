package dev.ivanhernandez.catalog.category.application.create;

import dev.ivanhernandez.catalog.category.domain.CategoryRepository;
import dev.ivanhernandez.catalog.category.application.find.CategoryFinder;
import dev.ivanhernandez.catalog.category.domain.*;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public class CategoryCreator {
	private final CategoryRepository repository;
	private final CategoryFinder finder;

	public CategoryCreator(CategoryRepository repository, CategoryFinder finder) {
		this.repository = repository;
		this.finder = finder;
	}

	public void create(CategoryId id, CategoryName name) {
		try {
			finder.find(id);
			throw new CategoryAlreadyExist(id);
		} catch (CategoryNotExist e) {
			Category category = Category.create(id, name);

			repository.save(category);
		}
	}
}
