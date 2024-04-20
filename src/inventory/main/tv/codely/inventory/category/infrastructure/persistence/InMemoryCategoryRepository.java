package tv.codely.inventory.category.infrastructure.persistence;

import tv.codely.inventory.category.domain.Category;
import tv.codely.inventory.category.domain.CategoryId;
import tv.codely.inventory.category.domain.CategoryRepository;
import tv.codely.shared.domain.Component;

import java.util.HashMap;
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
}
