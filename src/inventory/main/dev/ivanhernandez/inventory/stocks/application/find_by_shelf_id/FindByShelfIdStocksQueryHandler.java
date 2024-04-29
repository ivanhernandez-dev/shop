package dev.ivanhernandez.inventory.stocks.application.find_by_shelf_id;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.application.StocksResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class FindByShelfIdStocksQueryHandler implements QueryHandler<FindByShelfIdStocksQuery, StocksResponse> {
	private ByShelfIdStocksFinder finder;

	public FindByShelfIdStocksQueryHandler(ByShelfIdStocksFinder finder) {
		this.finder = finder;
	}

	@Override
	public StocksResponse handle(FindByShelfIdStocksQuery query) {
		return finder.find(new ShelfId(query.shelfId()));
	}
}
