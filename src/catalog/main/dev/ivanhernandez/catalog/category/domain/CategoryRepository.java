package dev.ivanhernandez.catalog.category.domain;

import dev.ivanhernandez.catalog.shared.domain.CategoryId;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
	void save(Category category);

	Optional<Category> search(CategoryId id);

	void update(Category category);

	void delete(CategoryId id);

	List<Category> searchAll();
}
