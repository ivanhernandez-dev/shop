package dev.ivanhernandez.inventory.products.application.find;

import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public class FindProductQueryHandler implements QueryHandler<FindProductQuery, ProductResponse> {
	private final ProductFinder finder;

	public FindProductQueryHandler(ProductFinder finder) {
		this.finder = finder;
	}

	@Override
	public ProductResponse handle(FindProductQuery query) {
		return finder.find(new ProductId(query.id()));
	}
}
