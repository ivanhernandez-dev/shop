package dev.ivanhernandez.catalog.category.domain;

import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class CategoryAlreadyExist extends DomainError {
	public CategoryAlreadyExist(CategoryId id) {
		super("category_already_exist", String.format("The category <%s> already exists", id.value()));
	}
}
