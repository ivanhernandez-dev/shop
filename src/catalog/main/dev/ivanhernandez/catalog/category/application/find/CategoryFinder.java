package dev.ivanhernandez.catalog.category.application.find;

import dev.ivanhernandez.catalog.category.application.CategoryResponse;
import dev.ivanhernandez.catalog.category.domain.CategoryNotExist;
import dev.ivanhernandez.catalog.category.domain.CategoryRepository;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;

@Component
public class CategoryFinder {
	private final CategoryRepository repository;

	public CategoryFinder(CategoryRepository repository) {
		this.repository = repository;
	}

	public CategoryResponse find(CategoryId id) throws CategoryNotExist {
		return repository.search(id)
			.map(CategoryResponse::fromAggregate)
			.orElseThrow(() -> new CategoryNotExist(id));
	}
}
