package tv.codely.inventory.category.domain;

import tv.codely.inventory.shared.domain.CategoryId;

import java.util.Optional;

public interface CategoryRepository {
	void save(Category category);

	Optional<Category> search(CategoryId id);

	void update(Category category);

	void delete(CategoryId id);
}
