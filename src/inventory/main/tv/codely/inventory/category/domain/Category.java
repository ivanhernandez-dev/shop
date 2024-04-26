package tv.codely.inventory.category.domain;

import tv.codely.inventory.shared.domain.CategoryId;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Category extends AggregateRoot {
	private final CategoryId id;
	private final CategoryName name;

	public Category(CategoryId id, CategoryName name) {
		this.id = id;
		this.name = name;
	}

	private Category() {
		this.id = null;
		this.name = null;
	}

	public CategoryId id() {
		return this.id;
	}

	public CategoryName name() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Category category = (Category) o;
		return Objects.equals(this.id, category.id) && Objects.equals(this.name, category.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}
}
