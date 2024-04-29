package dev.ivanhernandez.inventory.stocks.application.find;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.application.StockResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class FindStockQueryHandler implements QueryHandler<FindStockQuery, StockResponse> {
	private StockFinder finder;

	public FindStockQueryHandler(StockFinder finder) {
		this.finder = finder;
	}

	@Override
	public StockResponse handle(FindStockQuery query) {
		return finder.find(new ShelfId(query.shelfId()), new ProductId(query.productId()));
	}
}
