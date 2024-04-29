package dev.ivanhernandez.inventory.stocks.application.find_by_product_id;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.stocks.application.StocksResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public class FindByProductIdStocksQueryHandler implements QueryHandler<FindByProductIdStocksQuery, StocksResponse> {
	private ByProductIdStocksFinder finder;

	public FindByProductIdStocksQueryHandler(ByProductIdStocksFinder finder) {
		this.finder = finder;
	}

	@Override
	public StocksResponse handle(FindByProductIdStocksQuery query) {
		return finder.find(new ProductId(query.productId()));
	}
}
