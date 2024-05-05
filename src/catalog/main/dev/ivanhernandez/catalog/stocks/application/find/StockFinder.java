package dev.ivanhernandez.catalog.stocks.application.find;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.catalog.stocks.application.StockResponse;
import dev.ivanhernandez.catalog.stocks.domain.StockNotExist;
import dev.ivanhernandez.catalog.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class StockFinder {
	private final StockRepository repository;

	public StockFinder(StockRepository repository) {
		this.repository = repository;
	}

	public StockResponse find(ShelfId shelfId, ProductId productId) {
		return repository.search(productId, shelfId).map(StockResponse::fromAggregate).orElseThrow(() -> new StockNotExist(shelfId, productId));
	}
}
