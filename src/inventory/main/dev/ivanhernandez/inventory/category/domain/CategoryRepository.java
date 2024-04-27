package dev.ivanhernandez.inventory.category.domain;

import dev.ivanhernandez.inventory.shared.domain.CategoryId;

import java.util.Optional;

public interface CategoryRepository {
	void save(Category category);

	Optional<Category> search(CategoryId id);

	void update(Category category);

	void delete(CategoryId id);
}
