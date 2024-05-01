package dev.ivanhernandez.catalog.category.infrastructure.persistence;

import dev.ivanhernandez.catalog.category.domain.Category;
import dev.ivanhernandez.catalog.category.domain.CategoryRepository;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryCategoryRepository implements CategoryRepository {
	private final Map<String, Category> categories = new HashMap<>();

	@Override
	public void save(Category category) {
		this.categories.put(category.id().value(), category);
	}

	@Override
	public Optional<Category> search(CategoryId id) {
		return Optional.ofNullable(this.categories.get(id.value()));
	}

	@Override
	public void update(Category category) {
		if (this.categories.containsKey(category.id().value())) {
			this.categories.put(category.id().value(), category);
		}
	}

	@Override
	public void delete(CategoryId id) {
		this.categories.remove(id.value());
	}

	@Override
	public List<Category> searchAll() {
		return List.copyOf(this.categories.values());
	}
}
