package dev.ivanhernandez.inventory.category.application.create;

import dev.ivanhernandez.inventory.category.application.find.CategoryFinder;
import dev.ivanhernandez.inventory.category.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public class CategoryCreator {
	private final CategoryRepository repository;
	private final EventBus eventBus;
	private final CategoryFinder finder;

	public CategoryCreator(CategoryRepository repository, EventBus eventBus, CategoryFinder finder) {
		this.repository = repository;
		this.eventBus = eventBus;
		this.finder = finder;
	}

	public void create(CategoryId id, CategoryName name) {
		try {
			finder.find(id);
			throw new CategoryAlreadyExist(id);
		} catch (CategoryNotExist e) {
			Category category = Category.create(id, name);

			repository.save(category);
			eventBus.publish(category.pullDomainEvents());
		}
	}
}
