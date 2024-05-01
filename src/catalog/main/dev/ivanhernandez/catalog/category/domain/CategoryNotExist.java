package dev.ivanhernandez.catalog.category.domain;

import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class CategoryNotExist extends DomainError {
	public CategoryNotExist(CategoryId id) {
		super("category_not_exist", String.format("The category <%s> does not exist", id.value()));
	}
}
