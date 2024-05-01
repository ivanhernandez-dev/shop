package dev.ivanhernandez.catalog.category.application.find;

import dev.ivanhernandez.catalog.category.application.CategoryResponse;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class FindCategoryQueryHandler implements QueryHandler<FindCategoryQuery, CategoryResponse> {
	private final CategoryFinder finder;

	public FindCategoryQueryHandler(CategoryFinder finder) {
		this.finder = finder;
	}

	public CategoryResponse handle(FindCategoryQuery query) {
		return finder.find(new CategoryId(query.id()));
	}
}
