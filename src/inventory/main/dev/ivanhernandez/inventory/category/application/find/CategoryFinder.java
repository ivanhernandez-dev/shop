package dev.ivanhernandez.inventory.category.application.find;

import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
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
