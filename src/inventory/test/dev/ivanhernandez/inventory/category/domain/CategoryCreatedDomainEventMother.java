package dev.ivanhernandez.inventory.category.domain;

import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.category.CategoryCreatedDomainEvent;

public final class CategoryCreatedDomainEventMother {
	public static CategoryCreatedDomainEvent create(CategoryId id, CategoryName name) {
		return new CategoryCreatedDomainEvent(id.value(), name.value());
	}

	public static CategoryCreatedDomainEvent fromCategory(Category category) {
		return create(category.id(), category.name());
	}
}
