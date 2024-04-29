package dev.ivanhernandez.inventory.stocks.application.find;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.application.StockResponse;
import dev.ivanhernandez.inventory.stocks.domain.StockNotExist;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
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
