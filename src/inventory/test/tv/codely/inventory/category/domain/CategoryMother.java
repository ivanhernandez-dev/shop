package tv.codely.inventory.category.domain;

import tv.codely.inventory.shared.domain.CategoryId;
import tv.codely.inventory.shared.domain.CategoryIdMother;

public final class CategoryMother {
	public static Category create(CategoryId id, CategoryName name) {
		return new Category(id, name);
	}

	public static Category random() {
		return create(CategoryIdMother.random(), CategoryNameMother.random());
	}
}
