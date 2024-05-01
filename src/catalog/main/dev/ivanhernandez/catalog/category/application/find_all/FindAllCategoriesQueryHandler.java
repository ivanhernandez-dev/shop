package dev.ivanhernandez.catalog.category.application.find_all;

import dev.ivanhernandez.catalog.category.application.CategoriesResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public class FindAllCategoriesQueryHandler implements QueryHandler<FindAllCategoriesQuery, CategoriesResponse> {

	private final AllCategoriesFinder finder;

	public FindAllCategoriesQueryHandler(AllCategoriesFinder finder) {
		this.finder = finder;
	}

	@Override
	public CategoriesResponse handle(FindAllCategoriesQuery query) {
		return finder.find();
	}
}
