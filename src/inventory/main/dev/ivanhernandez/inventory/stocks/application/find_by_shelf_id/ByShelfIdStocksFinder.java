package dev.ivanhernandez.inventory.stocks.application.find_by_shelf_id;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.application.find.ShelfFinder;
import dev.ivanhernandez.inventory.stocks.application.StockResponse;
import dev.ivanhernandez.inventory.stocks.application.StocksResponse;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class ByShelfIdStocksFinder {
	private final StockRepository repository;
	private final ShelfFinder shelfFinder;

	public ByShelfIdStocksFinder(StockRepository repository, ShelfFinder shelfFinder) {
		this.repository = repository;
		this.shelfFinder = shelfFinder;
	}

	public StocksResponse find(ShelfId shelfId) {
		shelfFinder.find(shelfId);
		return new StocksResponse(repository.searchByShelfId(shelfId).stream().map(StockResponse::fromAggregate).toList());
	}
}
