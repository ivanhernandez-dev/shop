package dev.ivanhernandez.catalog.products.application.find_all;

import dev.ivanhernandez.catalog.products.application.ProductsResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class FindAllProductsQueryHandler implements QueryHandler<FindAllProductsQuery, ProductsResponse> {

	private final AllProductsFinder finder;

	public FindAllProductsQueryHandler(AllProductsFinder finder) {
		this.finder = finder;
	}

	@Override
	public ProductsResponse handle(FindAllProductsQuery query) {
		return finder.find();
	}
}
