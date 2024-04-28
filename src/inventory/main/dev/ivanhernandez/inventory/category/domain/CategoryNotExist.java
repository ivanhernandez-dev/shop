package dev.ivanhernandez.inventory.category.domain;

import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class CategoryNotExist extends DomainError {
	public CategoryNotExist(CategoryId id) {
		super("category_not_exist", String.format("The category <%s> does not exist", id.value()));
	}
}
