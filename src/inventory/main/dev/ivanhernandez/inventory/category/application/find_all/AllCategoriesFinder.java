package dev.ivanhernandez.inventory.category.application.find_all;

import dev.ivanhernandez.inventory.category.application.CategoriesResponse;
import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllCategoriesFinder {
	private final CategoryRepository repository;

	public AllCategoriesFinder(CategoryRepository repository) {
		this.repository = repository;
	}

	public CategoriesResponse find() {
		return new CategoriesResponse(
			repository.searchAll().stream().map(CategoryResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
